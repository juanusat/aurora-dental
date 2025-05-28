--- Ajustar los pagos
CREATE OR REPLACE PROCEDURE ajustar_pagos_por_cita(cita_a_ajustar integer)
LANGUAGE plpgsql
AS $$
DECLARE
    costo_total numeric(10,2);
    pagos RECORD;
    total_monto numeric(10,2);
    monto_acumulado numeric(10,2) := 0;
    pago_count integer;
    i integer := 0;
BEGIN
    -- Obtener el costo total de la cita
    SELECT costo INTO costo_total FROM cita WHERE cita_id = cita_a_ajustar;

    -- Contar cantidad de pagos para la cita
    SELECT COUNT(*) INTO pago_count FROM pago WHERE cita_id = cita_a_ajustar;

    IF pago_count = 0 THEN
        RAISE NOTICE 'No hay pagos para la cita %', cita_a_ajustar;
        RETURN;
    END IF;

    IF pago_count = 1 THEN
        -- Si solo hay un pago, actualizar monto a costo total
        UPDATE pago
        SET monto = costo_total
        WHERE cita_id = cita_a_ajustar;
    ELSE
        -- Si hay varios pagos, calcular suma actual de pagos
        SELECT SUM(monto) INTO total_monto FROM pago WHERE cita_id = cita_a_ajustar;

        -- Ajustar proporcionalmente cada pago para que sumen costo_total
        FOR pagos IN SELECT pago_id, monto FROM pago WHERE cita_id = cita_a_ajustar ORDER BY pago_id LOOP
            i := i + 1;

            -- Calcular nuevo monto proporcional
            IF i < pago_count THEN
                -- Para todos menos el último pago, calcular proporcional
                UPDATE pago SET monto = ROUND(pagos.monto * costo_total / total_monto, 2)
                WHERE pago_id = pagos.pago_id;

                -- Acumular el monto asignado para ajustar último pago
                SELECT monto INTO monto_acumulado FROM pago WHERE pago_id = pagos.pago_id;
                monto_acumulado := monto_acumulado + 0; -- solo para claridad
            ELSE
                -- Para último pago, asignar la diferencia para evitar errores de redondeo
                UPDATE pago SET monto = costo_total - (SELECT SUM(monto) FROM pago WHERE cita_id = cita_a_ajustar AND pago_id <> pagos.pago_id)
                WHERE pago_id = pagos.pago_id;
            END IF;
        END LOOP;
    END IF;

    RAISE NOTICE 'Pagos ajustados para cita %', cita_a_ajustar;
END;
$$;



--PROCEDIMIENTO PARA LAS FECHAS DE PAGO--
CREATE OR REPLACE PROCEDURE asignar_fecha_pago_aleatoria()
LANGUAGE plpgsql
AS $$
DECLARE
    r_pago RECORD;
    nueva_fecha timestamp;
    dias_antes integer;
BEGIN
    FOR r_pago IN
        SELECT p.pago_id, c.fecha_hora AS fecha_cita
        FROM pago p
        JOIN cita c ON p.cita_id = c.cita_id
    LOOP
        -- Generar número aleatorio entre 2 y 9
        dias_antes := trunc(random() * 8) + 2;

        -- Calcular la nueva fecha_hora
        nueva_fecha := r_pago.fecha_cita - (dias_antes || ' days')::interval;

        -- Actualizar el pago con la nueva fecha
        UPDATE pago
        SET fecha_hora = nueva_fecha
        WHERE pago_id = r_pago.pago_id;
    END LOOP;

    RAISE NOTICE 'Fechas de pagos actualizadas con un rango de 2 a 9 días antes de la cita.';
END;
$$;

CALL asignar_fecha_pago_aleatoria();

--Consulta detallada de citas con información del médico, cliente y pagos asociados--
SELECT
    c.cita_id,
    c.fecha_hora AS fecha_cita,
    c.estado AS estado_cita,

    -- Información del médico
    medico_trabajador.trabajador_id AS medico_id,
    medico_persona.nombre || ' ' || medico_persona.apellido AS medico_nombre_completo,
    medico_trabajador.numero_licencia,
    medico_trabajador.especialidad,

    -- Información del cliente
    cliente_trabajador.cliente_id AS cliente_id,
    cliente_persona.nombre || ' ' || cliente_persona.apellido AS cliente_nombre_completo,
    cliente_persona.telefono AS cliente_telefono,
    cliente_persona.email AS cliente_email,

    -- Información del pago
    p.pago_id,
    p.monto AS pago_monto,
    p.fecha_hora AS pago_fecha,
    p.metodo AS pago_metodo,
    p.estado AS pago_estado

FROM cita c
	-- Pago relacionado
LEFT JOIN pago p ON p.cita_id = c.cita_id

	-- Médico relacionado
JOIN trabajador medico_trabajador ON medico_trabajador.trabajador_id = c.medico_id
JOIN persona medico_persona ON medico_persona.persona_id = medico_trabajador.persona_id

	-- Cliente relacionado
JOIN cliente cliente_trabajador ON cliente_trabajador.cliente_id = c.cliente_id
JOIN persona cliente_persona ON cliente_persona.persona_id = cliente_trabajador.persona_id

ORDER BY c.fecha_hora;


-------Consulta de pagos con fechas de pago y cita, mostrando el cliente y diferencia en días entre ambos--
SELECT
    pa.pago_id,
    pa.fecha_hora AS fecha_pago,
    ci.fecha_hora AS fecha_cita,
    pe.nombre || ' ' || pe.apellido AS cliente,
    (pa.fecha_hora::date - ci.fecha_hora::date) AS diferencia_dias
FROM
    Pago AS pa
JOIN
    Cita AS ci ON pa.cita_id = ci.cita_id
JOIN
    Cliente AS cli ON ci.cliente_id = cli.cliente_id
JOIN
    Persona AS pe ON cli.persona_id = pe.persona_id;
----------------------------
SELECT
    p.persona_id,
    p.nombre,
    p.apellido,
    cli.cliente_id,
    COUNT(ci.cita_id) AS total_citas
FROM
    Persona AS p
JOIN
    Cliente AS cli ON p.persona_id = cli.persona_id
LEFT JOIN
    Cita AS ci ON cli.cliente_id = ci.cliente_id
GROUP BY
    p.persona_id,
    p.nombre,
    p.apellido,
    cli.cliente_id
ORDER BY
    cli.cliente_id, p.apellido, p.nombre;

-- select*from cita
-- select*from trabajador	
-- select*from persona
-- select *from pago
-- select*from tratamiento


--------Listado de clientes sin citas registradas--
SELECT
    p.persona_id,
    p.nombre,
    p.apellido,
    c.cliente_id
FROM
    Cliente AS c
JOIN
    Persona AS p ON c.persona_id = p.persona_id
LEFT JOIN
    Cita AS ci ON c.cliente_id = ci.cliente_id
WHERE
    ci.cita_id IS NULL;


--select * from persona where persona.sexo='f'
--select * from persona where persona.sexo='m'
--select*from persona


------Listado de pagos con detalles del cliente y tratamiento asociado-----
select pa.pago_id, pa.cita_id, pa.emisor, pe.nombre||' '||pe.apellido as CLIENTE, pe.persona_id, cli.cliente_id ,tra.nombre from pago pa 
	left join cita ci on pa.cita_id = ci.cita_id
	inner join cliente cli on cli.cliente_id = ci.cliente_id
	left join persona pe on pe.persona_id = cli.persona_id
	inner join tratamiento tra on tra.tratamiento_id = ci.tratamiento_id
	group by pa.pago_id, pa.cita_id, pa.emisor, pe.nombre, pe.apellido, pe.persona_id,cli.cliente_id, tra.nombre  order by 6


----Listado de clientes con sus citas programadas---
SELECT
    pe.nombre,
    pe.apellido,
    pe.persona_id,
    cli.cliente_id,
    ci.cita_id,
    ci.fecha_hora AS fecha_cita
FROM
    Persona AS pe
JOIN
    Cliente AS cli ON pe.persona_id = cli.persona_id
JOIN
    Cita AS ci ON cli.cliente_id = ci.cliente_id;


----Detalle completo de pagos con información del cliente y tratamiento-----
SELECT
    pa.pago_id,
    pa.cita_id,
    pa.emisor,
    pe.nombre || ' ' || pe.apellido AS CLIENTE,
    pe.persona_id,
    cli.cliente_id,
    trat.nombre AS tratamiento
FROM
    Pago AS pa
JOIN
    Cita AS ci ON pa.cita_id = ci.cita_id
JOIN
    Cliente AS cli ON ci.cliente_id = cli.cliente_id
JOIN
    Persona AS pe ON cli.persona_id = pe.persona_id
JOIN
    Tratamiento AS trat ON ci.tratamiento_id = trat.tratamiento_id;
----------------------


-----Citas de un Médico en un Día Específico----
SELECT
    c.cita_id,
    p.nombre || ' ' || p.apellido AS nombre_cliente,
    t.nombre AS nombre_tratamiento,
    c.fecha_hora,
    c.duracion,
    c.costo,
    c.estado
FROM
    cita c
JOIN
    cliente cl ON c.cliente_id = cl.cliente_id
JOIN
    persona p ON cl.persona_id = p.persona_id
JOIN
    tratamiento t ON c.tratamiento_id = t.tratamiento_id
WHERE
    c.medico_id = 4 -- ID del médico (ej: Martin Salazar)
    AND c.fecha_hora::date = '2025-01-01' -- Fecha específica
ORDER BY
    c.fecha_hora;

	
-------Citas Múltiples a la Misma Hora (con Médicos Diferentes)----
SELECT
    c1.cita_id AS cita1_id,
    per1.nombre || ' ' || per1.apellido AS cliente1_nombre,
    c1.fecha_hora,
    tra1.nombre_cargo AS medico1_cargo,
    permed1.nombre || ' ' || permed1.apellido AS medico1_nombre,
    c2.cita_id AS cita2_id,
    per2.nombre || ' ' || per2.apellido AS cliente2_nombre,
    c2.fecha_hora,
    tra2.nombre_cargo AS medico2_cargo,
    permed2.nombre || ' ' || permed2.apellido AS medico2_nombre
FROM
    cita c1
JOIN
    cita c2 ON c1.fecha_hora = c2.fecha_hora AND c1.cita_id < c2.cita_id
JOIN
    cliente cl1 ON c1.cliente_id = cl1.cliente_id
JOIN
    persona per1 ON cl1.persona_id = per1.persona_id
JOIN
    trabajador tmed1 ON c1.medico_id = tmed1.trabajador_id
JOIN
    persona permed1 ON tmed1.persona_id = permed1.persona_id
JOIN
    cargo tra1 ON tmed1.cargo_id = tra1.cargo_id
JOIN
    cliente cl2 ON c2.cliente_id = cl2.cliente_id
JOIN
    persona per2 ON cl2.persona_id = per2.persona_id
JOIN
    trabajador tmed2 ON c2.medico_id = tmed2.trabajador_id
JOIN
    persona permed2 ON tmed2.persona_id = permed2.persona_id
JOIN
    cargo tra2 ON tmed2.cargo_id = tra2.cargo_id
WHERE
    c1.medico_id <> c2.medico_id
    AND c1.fecha_hora::date = '2025-05-03'; -- Puedes cambiar la fecha

---------------------------
--Información Completa de Citas, Pacientes y Tratamientos
SELECT
    c.cita_id,
    p_cliente.nombre || ' ' || p_cliente.apellido AS nombre_cliente,
    p_cliente.documento AS documento_cliente,
    EXTRACT(YEAR FROM AGE(CURRENT_DATE, p_cliente.fecha_nacimiento)) AS edad_cliente,
    p_cliente.sexo AS sexo_cliente,
    tr.nombre AS nombre_tratamiento,
    tr.duracion_estimada,
    tr.costo AS costo_tratamiento_base,
    p_medico.nombre || ' ' || p_medico.apellido AS nombre_medico,
    c.fecha_hora,
    c.reagendada,
    c.duracion AS duracion_real_cita,
    c.costo AS costo_cita,
    c.estado,
    p_agendador.nombre || ' ' || p_agendador.apellido AS nombre_agendador
FROM
    cita c
JOIN
    cliente cl ON c.cliente_id = cl.cliente_id
JOIN
    persona p_cliente ON cl.persona_id = p_cliente.persona_id
JOIN
    tratamiento tr ON c.tratamiento_id = tr.tratamiento_id
JOIN
    trabajador t_medico ON c.medico_id = t_medico.trabajador_id
JOIN
    persona p_medico ON t_medico.persona_id = p_medico.persona_id
JOIN
    trabajador t_agendador ON c.agendador_id = t_agendador.trabajador_id
JOIN
    persona p_agendador ON t_agendador.persona_id = p_agendador.persona_id
ORDER BY c.fecha_hora DESC;
-----------------------
-- Citas con sus Pagos Asociados y Consistencia de Montos
SELECT
    c.cita_id,
    p_cliente.nombre || ' ' || p_cliente.apellido AS nombre_cliente,
    t.nombre AS tratamiento,
    c.fecha_hora AS fecha_cita,
    c.costo AS costo_cita,
    SUM(pa.monto) AS total_pagado,
    c.estado AS estado_cita,
    pa.estado AS estado_pago -- Estado de un pago individual, no de la cita
FROM
    cita c
JOIN
    cliente cl ON c.cliente_id = cl.cliente_id
JOIN
    persona p_cliente ON cl.persona_id = p_cliente.persona_id
JOIN
    tratamiento t ON c.tratamiento_id = t.tratamiento_id
LEFT JOIN -- Usamos LEFT JOIN para ver citas sin pagos si los hubiera (útil para detectar inconsistencias)
    pago pa ON c.cita_id = pa.cita_id
GROUP BY
    c.cita_id, p_cliente.nombre, p_cliente.apellido, t.nombre, c.fecha_hora, c.costo, c.estado, pa.estado -- Agregamos pa.estado al GROUP BY
ORDER BY
    c.fecha_hora DESC;
	
------Citas con sus Actos Médicos y Consistencia de Fechas
SELECT
    c.cita_id,
    p_cliente.nombre || ' ' || p_cliente.apellido AS nombre_cliente,
    t.nombre AS tratamiento,
    c.fecha_hora AS fecha_cita,
    c.estado AS estado_cita,
    am.observaciones,
    am.fecha_realizacion AS fecha_acto_medico,
    am.modificado_en AS modificado_acto_medico
FROM
    cita c
JOIN
    cliente cl ON c.cliente_id = cl.cliente_id
JOIN
    persona p_cliente ON cl.persona_id = p_cliente.persona_id
JOIN
    tratamiento t ON c.tratamiento_id = t.tratamiento_id
LEFT JOIN -- Usamos LEFT JOIN para ver citas sin acto médico si los hubiera
    acto_medico am ON c.cita_id = am.cita_id
WHERE
    c.estado IN ('realizada', 'reagendada') OR am.acto_medico_id IS NOT NULL
ORDER BY
    c.fecha_hora DESC;

-----Detección de fechas con múltiples citas asignadas por médico----
SELECT
    COALESCE(c.reagendada, c.fecha_hora) AS fecha_cita_final,
    c.medico_id,
    COUNT(*) AS cantidad_citas
FROM
    cita c
WHERE
    c.estado IN ('agendada', 'reagendada', 'realizada') -- Puedes ajustar los estados que te interesan
GROUP BY
    fecha_cita_final,
    c.medico_id
HAVING
    COUNT(*) != 1
ORDER BY
    fecha_cita_final,
    c.medico_id;


---Resumen de pagos por cita con comparación entre costo y suma de pagos
SELECT
    c.cita_id,
    c.costo AS costo_cita,
    COALESCE(SUM(p.monto), 0) AS suma_pagos,
    c.costo - COALESCE(SUM(p.monto), 0) AS diferencia,
    COUNT(p.pago_id) AS cantidad_pagos
FROM
    cita c
LEFT JOIN
    pago p ON c.cita_id = p.cita_id
GROUP BY
    c.cita_id, c.costo
ORDER BY
    c.cita_id;

---Reporte de Tratamientos más Solicitados
SELECT
    t.tratamiento_id,
    t.nombre,
    COUNT(c.cita_id) AS total_citas_realizadas,
    SUM(t.costo) AS ingreso_total_estimado
FROM
    Tratamiento t
LEFT JOIN
    Cita c ON t.tratamiento_id = c.tratamiento_id AND c.estado = 'realizada'
GROUP BY
    t.tratamiento_id, t.nombre
ORDER BY
    total_citas_realizadas DESC;
	
---Reporte de medicos con su cantidad de citas
SELECT 
    t.trabajador_id AS medico_id,
    p.nombre || ' ' || p.apellido AS medico_nombre_completo,
    COUNT(c.cita_id) AS total_citas
FROM 
    trabajador t
JOIN 
    persona p ON t.persona_id = p.persona_id
LEFT JOIN 
    cita c ON c.medico_id = t.trabajador_id
GROUP BY 
    t.trabajador_id, p.nombre, p.apellido
ORDER BY 
    total_citas DESC;

--ENCONTRAR POR CITA ESPECIFICA
SELECT c.cita_id, per.nombre || ' ' || per.apellido AS nombre_cliente, cli.cliente_id, per.persona_id,
    EXTRACT(YEAR FROM AGE(CURRENT_DATE, per.fecha_nacimiento)) AS edad,
    c.duracion, c.costo, p.pago_id, p.emisor, p.monto AS pago_monto, p.metodo AS pago_metodo, p.fecha_hora AS pago_fecha,p.estado AS pago_estado
FROM cita c
INNER JOIN cliente cli ON cli.cliente_id = c.cliente_id
INNER JOIN persona per ON per.persona_id = cli.persona_id
LEFT JOIN pago p ON p.cita_id = c.cita_id
WHERE c.cita_id <= 69 AND c.cita_id <= 229;



-----Evaluacion de edad de las personas--
SELECT 
    p.persona_id, 
    p.nombre || ' ' || p.apellido AS persona, 
    p.fecha_nacimiento,
    FLOOR(EXTRACT(year FROM AGE(CURRENT_DATE, p.fecha_nacimiento))) AS edad,
    CASE
        WHEN AGE(CURRENT_DATE, p.fecha_nacimiento) >= INTERVAL '18 years'
        THEN 'Mayor de edad'
        ELSE 'Menor de edad'
    END AS estado_edad
FROM Persona AS p;

---CANTIDAD DE CITAS POR MES PARA 2024 y 2025---
SELECT
    EXTRACT(YEAR FROM fecha_hora) AS anio,
    EXTRACT(MONTH FROM fecha_hora) AS mes,
    COUNT(*) AS cantidad_citas
FROM
    cita
WHERE
    EXTRACT(YEAR FROM fecha_hora) IN (2024, 2025)
GROUP BY
    anio,
    mes
ORDER BY
    anio,
    mes;


---DETECTAR LAS CITAS CANCELADAS Y SI ESTAN TIENEN PAGOS(NO DEBERIAN TENER)-
SELECT
    c.cita_id,
    c.estado AS estado_cita,
    per.nombre || ' ' || per.apellido AS nombre_cliente,
    p.pago_id,
    p.emisor,
    p.monto,
    p.metodo,
    p.fecha_hora AS fecha_pago,
    p.estado AS estado_pago
FROM
    cita c
INNER JOIN cliente cli ON cli.cliente_id = c.cliente_id
INNER JOIN persona per ON per.persona_id = cli.persona_id
LEFT JOIN pago p ON p.cita_id = c.cita_id
WHERE
    c.estado = 'cancelada'
ORDER BY
    c.cita_id;

----SELECT PARA VER LAS CITAS CON ACTO MEDICO(REALIZADAS)
SELECT 
    c.cita_id,
    c.fecha_hora,
    c.estado
FROM 
    cita c
INNER JOIN 
    acto_medico am ON c.cita_id = am.cita_id
ORDER BY
    c.fecha_hora;