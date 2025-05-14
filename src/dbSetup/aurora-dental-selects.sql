-- Estandar para los alias
/*
persona per,
cargo car,
usuario usu,
trabajador tb,
tratamiento tr,
cliente cli,
cita cit,
acto_medico am,
pago pa,
*/


-- C01. Próximas citas agendadas
SELECT cit.cita_id,
    per.nombre || ' ' || per.apellido AS cliente,
    tr.nombre AS tratamiento,
    cit.fecha_hora,
    cit.estado
FROM cita cit
JOIN cliente cli ON cit.cliente_id = cli.cliente_id
JOIN persona per ON cli.persona_id = per.persona_id
JOIN tratamiento tr ON cit.tratamiento_id = tr.tratamiento_id
WHERE cit.fecha_hora > CURRENT_TIMESTAMP AND cit.estado = 'agendada'
ORDER BY cit.fecha_hora;


-- C02. Cantidad de citas por médico en el último mes
SELECT per.nombre || ' ' || per.apellido AS medico,
    COUNT(*) AS cantidad_citas
FROM cita cit
JOIN trabajador tb ON cit.medico_id = tb.trabajador_id
JOIN persona per ON tb.persona_id = per.persona_id
WHERE cit.fecha_hora >= date_trunc('month', CURRENT_DATE)
GROUP BY medico
ORDER BY cantidad_citas DESC;


-- C03. Total recaudado por tratamientos en un período
SELECT tr.nombre AS tratamiento,
    SUM(pa.monto) AS total_recaudado
FROM pago pa
JOIN cita cit ON pa.cita_id = cit.cita_id
JOIN tratamiento tr ON cit.tratamiento_id = tr.tratamiento_id
WHERE pa.fecha_hora BETWEEN '2025-04-01' AND '2025-04-30'
  AND pa.estado = 'correcto'
GROUP BY tr.nombre
ORDER BY total_recaudado DESC;


-- C04. Estados de las citas (estadística)
SELECT cit.estado,
    COUNT(*) AS cantidad
FROM cita cit
GROUP BY cit.estado;


-- C05. Lista de trabajadores con su cargo y especialidad
SELECT per.nombre || ' ' || per.apellido AS trabajador,
    car.nombre_cargo,
    tb.especialidad,
    tb.estado
FROM trabajador tb
JOIN persona per ON tb.persona_id = per.persona_id
JOIN cargo car ON tb.cargo_id = car.cargo_id
ORDER BY trabajador;


-- C06. Citas sin pago registrado
SELECT cit.cita_id,
    per.nombre || ' ' || per.apellido AS cliente,
    cit.fecha_hora,
    cit.estado
FROM cita cit
JOIN cliente cli ON cit.cliente_id = cli.cliente_id
JOIN persona per ON cli.persona_id = per.persona_id
LEFT JOIN pago pa ON cit.cita_id = pa.cita_id
WHERE pa.pago_id IS NULL
  AND cit.estado IN ('realizada', 'reagendada');


-- C07. Historial de citas de un cliente específico
SELECT cit.cita_id,
    cit.fecha_hora,
    tr.nombre AS tratamiento,
    cit.estado,
    am.observaciones
FROM cita cit
JOIN tratamiento tr ON cit.tratamiento_id = tr.tratamiento_id
JOIN cliente cli ON cit.cliente_id = cli.cliente_id
JOIN persona per ON cli.persona_id = per.persona_id
LEFT JOIN acto_medico am ON cit.cita_id = am.cita_id
WHERE per.documento = '73011108'
ORDER BY cit.fecha_hora DESC;


-- C08. Citas reagendadas
SELECT cit.cita_id,
    per.nombre || ' ' || per.apellido AS cliente,
    cit.fecha_hora,
    cit.reagendada
FROM cita cit
JOIN cliente cli ON cit.cliente_id = cli.cliente_id
JOIN persona per ON cli.persona_id = per.persona_id
WHERE cit.reagendada IS NOT NULL;


-- C09. Cantidad de citas por estado (realizada, agendada, reagendada) por cada paciente
SELECT 
    per.documento,
    per.nombre || ' ' || per.apellido AS paciente,
    COUNT(CASE WHEN cit.estado = 'realizada' THEN 1 END) AS realizadas,
    COUNT(CASE WHEN cit.estado = 'agendada' THEN 1 END) AS agendadas,
    COUNT(CASE WHEN cit.estado = 'reagendada' THEN 1 END) AS reagendadas
FROM cita cit
JOIN cliente cli ON cit.cliente_id = cli.cliente_id
JOIN persona per ON cli.persona_id = per.persona_id
GROUP BY per.documento, paciente
ORDER BY paciente;