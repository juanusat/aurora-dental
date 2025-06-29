CREATE EXTENSION IF NOT EXISTS pgcrypto;

UPDATE usuario
SET password_hash = encode(
    digest(usuario.username || '1' || 'DENTAL', 'sha256'),
    'hex'
);

DO $$
DECLARE
  rec RECORD;
  inc INTEGER;
  nueva_duracion INTEGER;
  base_ts TIMESTAMP;
  umbral NUMERIC;
  nueva_fecha_realizacion TIMESTAMP;
  modificado TIMESTAMP;
BEGIN
  FOR rec IN
    SELECT
      c.cita_id,
      tr.duracion_estimada,
      c.reagendada,
      c.fecha_hora,
      p.nombre
    FROM cita c
    JOIN tratamiento tr   ON c.tratamiento_id = tr.tratamiento_id
    JOIN trabajador t     ON c.medico_id       = t.trabajador_id
    JOIN persona p        ON t.persona_id      = p.persona_id
    WHERE c.duracion IS NOT NULL
  LOOP
    -- 1) Determinar umbral de probabilidades según paridad de longitud del nombre
    IF length(rec.nombre) % 2 = 0 THEN
      umbral := 0.8;   -- 80% de probabilidad de demorar más
    ELSE
      umbral := 0.2;   -- 20% de probabilidad de demorar más
    END IF;

    -- 2) Generar incremento aleatorio entre 2 y 25 (inclusive)
    inc := floor(random() * 24)::INTEGER + 2;

    -- 3) Decidir si se alarga (más tiempo) o acorta (menos tiempo)
    IF random() < umbral THEN
      nueva_duracion := rec.duracion_estimada + inc;
    ELSE
      nueva_duracion := rec.duracion_estimada - inc;
    END IF;

    -- 4) Obtener la fecha de referencia: 'reagendada' si existe, si no 'fecha_hora'
    IF rec.reagendada IS NOT NULL THEN
      base_ts := rec.reagendada;
    ELSE
      base_ts := rec.fecha_hora;
    END IF;

    -- 5) Calcular la nueva fecha de realizacion
    nueva_fecha_realizacion := base_ts + (nueva_duracion * INTERVAL '1 minute');

    -- 6) Determinar la fecha de modificacion
    IF random() < 0.85 THEN
      -- 85% de las veces la misma fecha y hora
      modificado := nueva_fecha_realizacion;
    ELSE
      -- 15% de las veces entre 2 y 4 horas después
      modificado := nueva_fecha_realizacion + ( (floor(random() * 3)::INTEGER + 2) * INTERVAL '1 hour' );
    END IF;

    -- 7) Actualizar la duración en cita
    UPDATE cita
      SET duracion = nueva_duracion
      WHERE cita_id = rec.cita_id;
      
    -- 8) Actualizar la fecha_realizacion y modificado_en en acto_medico
    UPDATE acto_medico
      SET
        fecha_realizacion = nueva_fecha_realizacion,
        modificado_en     = modificado
      WHERE cita_id = rec.cita_id;
  END LOOP;
END;
$$ LANGUAGE plpgsql;
