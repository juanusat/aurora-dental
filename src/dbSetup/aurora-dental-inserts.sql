
    INSERT INTO Cargo (cargo_id, nombre_cargo, descripcion) VALUES
    (1, 'Odontologo', 'Responsable de los tratamientos dentales'),
    (2, 'Recepcionista', 'Encargado de agendar citas y atencion al cliente'),
    (3, 'Gerente', 'Supervision general de la clinica dental');

    -- Recepcionistas
    INSERT INTO Persona (persona_id, nombre, apellido, documento, email, telefono, fecha_nacimiento, direccion, creado_en, sexo) VALUES
    (1, 'Sofia', 'Reyes', '72111111', 'sofia.reyes1@clinicadental.com', '987111111', '1993-02-15', 'Av. Las Flores 100, Lima', '2023-02-03', 'f'),
    (2, 'Lucas', 'Cardenas', '72111112', 'lucas.cardenas@clinicadental.com', '987111112', '1990-08-25', 'Jr. Amazonas 234, Lima', '2023-01-20', 'm');

    -- Gerente
    INSERT INTO Persona VALUES
    (3, 'Carla', 'Villanueva', '72111113', 'carla.villanueva@clinicadental.com', '987111113', '1982-06-10', 'Av. Universitaria 123, Lima', '2023-01-23', 'f');

    -- Odontologos
    INSERT INTO Persona VALUES
    (4, 'Martin', 'Salazar', '72111114', 'martin.salazar@clinicadental.com', '987111114', '1980-11-05', 'Calle Los alamos 234, Lima', '2023-01-10', 'm'),
    (5, 'Valentina', 'Paredes', '72111115', 'valentina.paredes@clinicadental.com', '987111115', '1985-03-12', 'Av. Colonial 456, Lima', '2023-01-07', 'f'),
    (6, 'Diego', 'Ramirez', '72111116', 'diego.ramirez@clinicadental.com', '987111116', '1979-09-09', 'Jr. El Sol 876, Lima', '2023-01-18', 'm'),
    (7, 'Camila', 'Espinoza', '72111117', 'camila.espinoza@clinicadental.com', '987111117', '1991-05-30', 'Av. San Luis 700, Lima', '2023-02-25', 'f'),
    (8, 'Andres', 'Mendoza', '72111118', 'andres.mendoza@clinicadental.com', '987111118', '1987-01-18', 'Calle Junin 321, Lima', '2023-03-30', 'm'),
    (9, 'Renata', 'Quispe', '72111119', 'renata.quispe@clinicadental.com', '987111119', '1994-12-03', 'Av. La Marina 222, Lima', '2023-02-08', 'f'),
    (10, 'Gabriel', 'Suarez', '72111120', 'gabriel.suarez@clinicadental.com', '987111120', '1983-10-22', 'Av. Santa Rosa 645, Lima', '2023-05-12', 'm'),
    (11, 'Isabela', 'Lozano', '72111121', 'isabela.lozano@clinicadental.com', '987111121', '1990-04-14', 'Jr. Huanuco 103, Lima', '2023-01-14', 'f'),
    (12, 'Tomas', 'Silva', '72111122', 'tomas.silva@clinicadental.com', '987111122', '1986-07-19', 'Calle Grau 222, Lima', '2023-05-23', 'm');

    INSERT INTO Usuario (usuario_id, username, password_hash, ultimo_acceso) VALUES
    (1, 'sreyes', 'hash_sreyes', '2025-07-19'),
    (2, 'lcardenas', 'hash_lcardenas', '2025-07-08'),
    (3, 'cvillanueva', 'hash_cvillanueva', '2025-05-13'),
    (4, 'msalazar', 'hash_msalazar', '2025-03-18'),
    (5, 'vparedes', 'hash_vparedes', '2025-02-02'),
    (6, 'dramirez', 'hash_dramirez', '2025-05-18'),
    (7, 'cespinoza', 'hash_cespinoza', '2025-06-19'),
    (8, 'amendoza', 'hash_amendoza', '2025-02-25'),
    (9, 'rquispe', 'hash_rquispe', '2025-01-18'),
    (10, 'gsuarez', 'hash_gsuarez', '2025-03-09'),
    (11, 'ilozano', 'hash_ilozano', '2025-05-20'),
    (12, 'tsilva', 'hash_tsilva', '2025-06-17');

    -- Recepcionistas
    INSERT INTO Trabajador VALUES
    (1, 1, 2, 1, NULL, NULL, TRUE, '2023-06-28'),
    (2, 2, 2, 2, NULL, NULL, TRUE, '2023-07-16');

    -- Gerente
    INSERT INTO Trabajador VALUES
    (3, 3, 3, 3, NULL, 'Gestion administrativa', TRUE, '2023-05-14');

    -- Odontologos
    INSERT INTO Trabajador VALUES
    (4, 4, 1, 4, 'LIC-ODONT-1001', 'Endodoncia', TRUE, '2023-04-13'),
    (5, 5, 1, 5, 'LIC-ODONT-1002', 'Ortodoncia', TRUE, '2023-03-20'),
    (6, 6, 1, 6, 'LIC-ODONT-1003', 'Implantologia', TRUE, '2023-03-10'),
    (7, 7, 1, 7, 'LIC-ODONT-1004', 'Periodoncia', TRUE, '2023-01-10'),
    (8, 8, 1, 8, 'LIC-ODONT-1005', 'Odontopediatria', TRUE, '2023-04-23'),
    (9, 9, 1, 9, 'LIC-ODONT-1006', 'Estetica dental', TRUE, '2023-06-24'),
    (10, 10, 1, 10, 'LIC-ODONT-1007', 'Rehabilitacion oral', TRUE, '2023-03-17'),
    (11, 11, 1, 11, 'LIC-ODONT-1008', 'Cirugia bucal', TRUE, '2023-02-13'),
    (12, 12, 1, 12, 'LIC-ODONT-1009', 'Diagnostico clinico', TRUE, '2023-07-19');

    INSERT INTO Tratamiento (tratamiento_id, nombre, descripcion, duracion_estimada, costo) VALUES
    (1, 'Limpieza dental', 'Eliminacion de placa y sarro dental', 45, 80.00),
    (2, 'Extraccion dental', 'Extraccion de diente por caries o fractura', 60, 150.00),
    (3, 'Endodoncia', 'Tratamiento de conducto radicular', 90, 350.00),
    (4, 'Ortodoncia (evaluacion)', 'Evaluacion para tratamiento de ortodoncia', 30, 100.00),
    (5, 'Ortodoncia mensual', 'Ajuste mensual de brackets', 20, 120.00),
    (6, 'Blanqueamiento dental', 'Blanqueamiento con gel y lampara LED', 60, 250.00),
    (7, 'Implante dental', 'Colocacion de tornillo e implante dental', 120, 900.00),
    (8, 'Profilaxis en niños', 'Limpieza basica para niños', 30, 60.00),
    (9, 'Sellantes dentales', 'Aplicacion de sellantes para prevenir caries', 30, 70.00),
    (10, 'Rehabilitacion oral', 'Tratamiento integral de piezas dentales', 120, 750.00);

    -- Clientes 1 al 15
    INSERT INTO Persona (persona_id, nombre, apellido, documento, email, telefono, fecha_nacimiento, direccion, creado_en, sexo) VALUES
    (13, 'Andrea', 'Rojas', '73011101', 'andrea.rojas@gmail.com', '989111101', '1995-06-12', 'Av. Arequipa 1010, Lima', '2023-02-14', 'f'),
    (14, 'Luis', 'Fernandez', '73011102', 'luis.fernandez@gmail.com', '989111102', '1990-08-22', 'Jr. Piura 234, Lima', '2024-11-03', 'm'),
    (15, 'Maria', 'Guzman', '73011103', 'maria.guzman@gmail.com', '989111103', '1987-04-30', 'Calle Colon 456, Lima', '2023-05-30', 'f'),
    (16, 'Carlos', 'Nuñez', '73011104', 'carlos.nunez@gmail.com', '989111104', '1992-11-18', 'Av. Brasil 789, Lima', '2024-08-19', 'm'),
    (17, 'Lucia', 'Mendoza', '73011105', 'lucia.mendoza@gmail.com', '989111105', '1998-02-25', 'Jr. Trujillo 101, Lima', '2023-09-07', 'f'),
    (18, 'Jorge', 'Salinas', '73011106', 'jorge.salinas@gmail.com', '989111106', '1985-07-15', 'Av. Javier Prado 150, Lima', '2024-01-25', 'm'),
    (19, 'Natalia', 'Reategui', '73011107', 'natalia.reategui@gmail.com', '989111107', '1996-12-05', 'Calle Lima 302, Lima', '2023-12-11', 'f'),
    (20, 'Hector', 'Benavides', '73011108', 'hector.benavides@gmail.com', '989111108', '1989-03-10', 'Av. San Martin 111, Lima', '2024-04-02', 'm'),
    (21, 'Sandra', 'Lopez', '73011109', 'sandra.lopez@gmail.com', '989111109', '1993-10-19', 'Jr. Tacna 345, Lima', '2023-07-28', 'f'),
    (22, 'Ricardo', 'Mejia', '73011110', 'ricardo.mejia@gmail.com', '989111110', '1988-01-01', 'Calle Moquegua 222, Lima', '2024-10-15', 'm'),
    (23, 'Ana', 'Zegarra', '73011111', 'ana.zegarra@gmail.com', '989111111', '1997-06-20', 'Av. Bolivar 400, Lima', '2023-03-21', 'f'),
    (24, 'Marco', 'Ortega', '73011112', 'marco.ortega@gmail.com', '989111112', '1994-09-09', 'Jr. Bolognesi 544, Lima', '2024-06-09', 'm'),
    (25, 'Pamela', 'Campos', '73011113', 'pamela.campos@gmail.com', '989111113', '1991-02-28', 'Calle Zepita 777, Lima', '2023-11-18', 'f'),
    (26, 'Sebastian', 'Delgado', '73011114', 'sebastian.delgado@gmail.com', '989111114', '1986-05-16', 'Av. Grau 1111, Lima', '2024-02-07', 'm'),
    (27, 'Veronica', 'Chavez', '73011115', 'veronica.chavez@gmail.com', '989111115', '1999-07-03', 'Jr. San Felipe 100, Lima', '2023-08-04', 'f');

    -- Clientes 1 al 15
    INSERT INTO Cliente (cliente_id, persona_id, creado_en) VALUES
    (1, 13, '2025-01-01'),
    (2, 14, '2025-01-01'),
    (3, 15, '2025-01-01'),
    (4, 16, '2025-01-01'),
    (5, 17, '2025-01-01'),
    (6, 18, '2025-01-01'),
    (7, 19, '2025-01-01'),
    (8, 20, '2025-01-04'),
    (9, 21, '2025-01-04'),
    (10, 22, '2025-01-05'),
    (11, 23, '2025-01-07'),
    (12, 24, '2025-01-08'),
    (13, 25, '2025-01-07'),
    (14, 26, '2025-01-08'),
    (15, 27, '2025-01-09');

    -- Clientes 16 al 50
    INSERT INTO Persona (persona_id, nombre, apellido, documento, email, telefono, fecha_nacimiento, direccion, creado_en, sexo) VALUES
    (28, 'Gabriela', 'Espinoza', '73011116', 'gabriela.espinoza@gmail.com', '989111116', '1992-09-14', 'Av. Grau 233, Lima', '2024-11-30', 'f'),
    (29, 'Diego', 'Carranza', '73011117', 'diego.carranza@gmail.com', '989111117', '1989-12-23', 'Calle Junin 400, Lima', '2023-02-11', 'm'),
    (30, 'Monica', 'Vera', '73011118', 'monica.vera@gmail.com', '989111118', '1995-03-08', 'Jr. Ica 122, Lima', '2024-08-24', 'f'),
    (31, 'Raul', 'Valverde', '73011119', 'raul.valverde@gmail.com', '989111119', '1987-10-03', 'Av. El Sol 650, Lima', '2023-12-29', 'm'),
    (32, 'Jimena', 'Rios', '73011120', 'jimena.rios@gmail.com', '989111120', '1993-11-25', 'Calle Cusco 90, Lima', '2024-02-13', 'f'),
    (33, 'Bruno', 'Ticona', '73011121', 'bruno.ticona@gmail.com', '989111121', '1990-01-15', 'Jr. Arica 405, Lima', '2023-06-01', 'm'),
    (34, 'Daniela', 'Alvarado', '73011122', 'daniela.alvarado@gmail.com', '989111122', '1996-04-11', 'Av. Colonial 2323, Lima', '2024-09-19', 'f'),
    (35, 'Esteban', 'Ramos', '73011123', 'esteban.ramos@gmail.com', '989111123', '1991-07-20', 'Jr. Huaraz 101, Lima', '2023-04-25', 'm'),
    (36, 'Rosa', 'Castañeda', '73011124', 'rosa.castaneda@gmail.com', '989111124', '1985-05-29', 'Av. Angamos 343, Lima', '2024-07-09', 'f'),
    (37, 'Victor', 'Montalvo', '73011125', 'victor.montalvo@gmail.com', '989111125', '1988-02-02', 'Calle Nazca 544, Lima', '2023-10-17', 'm'),
    (38, 'Ariana', 'Quispe', '73011126', 'ariana.quispe@gmail.com', '989111126', '1994-08-18', 'Jr. Camana 222, Lima', '2024-05-20', 'f'),
    (39, 'Pedro', 'Caceres', '73011127', 'pedro.caceres@gmail.com', '989111127', '1992-10-10', 'Av. La Marina 660, Lima', '2023-08-05', 'm'),
    (40, 'Tatiana', 'Chavez', '73011128', 'tatiana.chavez@gmail.com', '989111128', '1999-12-01', 'Calle Ayacucho 33, Lima', '2024-12-09', 'f'),
    (41, 'Joel', 'Durand', '73011129', 'joel.durand@gmail.com', '989111129', '1991-03-03', 'Jr. Zepita 909, Lima', '2023-04-01', 'm'),
    (42, 'Melissa', 'Romero', '73011130', 'melissa.romero@gmail.com', '989111130', '1986-06-07', 'Av. Benavides 1122, Lima', '2023-09-11', 'f'),
    (43, 'Renato', 'Vargas', '73011131', 'renato.vargas@gmail.com', '989111131', '1997-01-17', 'Jr. Union 400, Lima', '2024-10-06', 'm'),
    (44, 'Carmen', 'Salazar', '73011132', 'carmen.salazar@gmail.com', '989111132', '1984-09-25', 'Av. Sucre 299, Lima', '2023-05-17', 'f'),
    (45, 'Julio', 'Reyes', '73011133', 'julio.reyes@gmail.com', '989111133', '1990-05-13', 'Jr. Puno 201, Lima', '2024-11-23', 'm'),
    (46, 'Diana', 'Muñoz', '73011134', 'diana.munoz@gmail.com', '989111134', '1995-02-16', 'Calle Libertad 789, Lima', '2023-02-04', 'f'),
    (47, 'Martin', 'Vega', '73011135', 'martin.vega@gmail.com', '989111135', '1998-07-11', 'Jr. Arequipa 88, Lima', '2024-08-13', 'm'),
    (48, 'Lorena', 'Caballero', '73011136', 'lorena.caballero@gmail.com', '989111136', '1993-10-01', 'Av. Canada 345, Lima', '2023-12-23', 'f'),
    (49, 'Oscar', 'Gomez', '73011137', 'oscar.gomez@gmail.com', '989111137', '1987-04-19', 'Jr. Callao 1010, Lima', '2024-02-09', 'm'),
    (50, 'Liliana', 'Aguilar', '73011138', 'liliana.aguilar@gmail.com', '989111138', '1990-08-30', 'Calle Tacna 100, Lima', '2023-06-12', 'f'),
    (51, 'Gonzalo', 'Zapata', '73011139', 'gonzalo.zapata@gmail.com', '989111139', '1989-03-27', 'Av. San Felipe 213, Lima', '2024-09-03', 'm'),
    (52, 'Paola', 'Sanchez', '73011140', 'paola.sanchez@gmail.com', '989111140', '1996-11-04', 'Jr. Quilca 111, Lima', '2023-04-19', 'f'),
    (53, 'Rodrigo', 'Alfaro', '73011141', 'rodrigo.alfaro@gmail.com', '989111141', '1991-06-30', 'Av. La Paz 432, Lima', '2023-04-19', 'm'),
    (54, 'Isabel', 'Miranda', '73011142', 'isabel.miranda@gmail.com', '989111142', '1994-01-09', 'Calle Montevideo 67, Lima', '2023-10-22', 'f'),
    (55, 'Erick', 'Jimenez', '73011143', 'erick.jimenez@gmail.com', '989111143', '1986-12-18', 'Jr. Olaya 203, Lima', '2024-05-27', 'm'),
    (56, 'Alicia', 'Rosales', '73011144', 'alicia.rosales@gmail.com', '989111144', '1999-02-03', 'Av. Salaverry 709, Lima', '2023-08-02', 'f'),
    (57, 'Frank', 'Requena', '73011145', 'frank.requena@gmail.com', '989111145', '1988-09-12', 'Calle Lima 303, Lima', '2024-12-03', 'm'),
    (58, 'Claudia', 'Infante', '73011146', 'claudia.infante@gmail.com', '989111146', '1997-03-22', 'Jr. Pachacutec 101, Lima', '2023-04-12', 'f'),
    (59, 'Tomas', 'Paredes', '73011147', 'tomas.paredes@gmail.com', '989111147', '1992-12-10', 'Av. Republica 222, Lima', '2024-06-16', 'm'),
    (60, 'Luisa', 'Silva', '73011148', 'luisa.silva@gmail.com', '989111148', '1993-05-08', 'Jr. Panama 345, Lima', '2023-11-03', 'f'),
    (61, 'Alan', 'Morales', '73011149', 'alan.morales@gmail.com', '989111149', '1995-07-27', 'Av. Arequipa 900, Lima', '2024-04-09', 'm'),
    (62, 'Fiorella', 'Barrenechea', '73011150', 'fiorella.barrenechea@gmail.com', '989111150', '1996-08-14', 'Jr. Carabaya 500, Lima', '2023-07-17', 'f');

    -- Clientes 16 al 50
    INSERT INTO Cliente (cliente_id, persona_id, creado_en) VALUES
    (16, 28, '2025-01-09'),
    (17, 29, '2025-01-09'),
    (18, 30, '2025-01-09'),
    (19, 31, '2025-01-10'),
    (20, 32, '2025-01-10'),
    (21, 33, '2025-01-10'),
    (22, 34, '2025-01-10'),
    (23, 35, '2025-01-11'),
    (24, 36, '2025-01-11'),
    (25, 37, '2025-01-11'),
    (26, 38, '2025-01-11'),
    (27, 39, '2025-01-12'),
    (28, 40, '2025-01-12'),
    (29, 41, '2025-01-12'),
    (30, 42, '2025-01-12'),
    (31, 43, '2025-01-13'),
    (32, 44, '2025-01-14'),
    (33, 45, '2025-01-14'),
    (34, 46, '2025-01-15'),
    (35, 47, '2025-01-15'),
    (36, 48, '2025-01-16'),
    (37, 49, '2025-01-16'),
    (38, 50, '2025-01-16'),
    (39, 51, '2025-01-16'),
    (40, 52, '2025-01-17'),
    (41, 53, '2025-01-17'),
    (42, 54, '2025-01-17'),
    (43, 55, '2025-01-18'),
    (44, 56, '2025-01-19'),
    (45, 57, '2025-01-19'),
    (46, 58, '2025-01-19'),
    (47, 59, '2025-01-20'),
    (48, 60, '2025-01-20'),
    (49, 61, '2025-01-20'),
    (50, 62, '2025-01-21');
    -- Cliente CLI3001 con 4 citas realizadas
    -- Cliente 1 (CLI3001) with 4 appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES
    (1, 1, 1, 3, 1, '2024-12-01 09:00', '2024-12-08 09:00', 30, 100.00, 'reagendada'),
    (2, 1, 2, 4, 2, '2025-01-10 10:00', '2025-01-18 10:00', 45, 150.00, 'reagendada'),
    (3, 1, 3, 5, 1, '2025-02-05 08:30', '2025-02-06 08:30', 60, 200.00, 'reagendada'),
    (4, 1, 4, 6, 2, '2025-03-15 11:00', null, 50, 180.00, 'realizada');

    -- Cliente 2 (CLI3002) with 4 appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES
    (5, 2, 5, 7, 1, '2024-11-20 14:00', null, 40, 300.00, 'realizada'),
    (6, 2, 6, 8, 2, '2025-01-12 16:00', '2025-01-18 16:00', 90, 800.00, 'reagendada'),
    (7, 2, 1, 9, 1, '2025-02-20 09:30', null, 30, 100.00, 'cancelada'),
    (8, 2, 2, 10, 2, '2025-03-10 10:00', null, 45, 150.00, 'realizada');

    -- Cliente 3 (CLI3003) with 4 appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES
    (9, 3, 3, 3, 2, '2025-01-08 08:00', '2025-01-10 08:00', 60, 200.00, 'reagendada'),
    (10, 3, 4, 4, 1, '2025-01-25 09:00', null, 50, 180.00, 'realizada'),
    (11, 3, 7, 5, 2, '2025-02-12 10:30', null, 60, 600.00, 'cancelada'),
    (12, 3, 8, 6, 1, '2025-03-01 12:00', null, 70, 700.00, 'realizada');

    -- Cliente 4 (CLI3004) with 4 appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES
    (13, 4, 9, 7, 1, '2025-01-05 15:00', '2025-01-09 15:00', 80, 400.00, 'reagendada'),
    (14, 4, 10, 8, 2, '2025-01-20 16:00', null, 20, 90.00, 'realizada'),
    (15, 4, 1, 9, 1, '2025-02-03 09:30', null, 30, 100.00, 'realizada'),
    (16, 4, 3, 10, 2, '2025-03-10 11:00', '2025-03-10 11:00', 60, 200.00, 'reagendada');

    -- Cliente 5 (CLI3005) with 4 appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES
    (17, 5, 2, 3, 1, '2024-12-11 10:30', null, 45, 150.00, 'realizada'),
    (18, 5, 5, 4, 2, '2025-01-10 15:00', null, 40, 300.00, 'realizada'),
    (19, 5, 6, 5, 1, '2025-02-18 08:30', null, 90, 800.00, 'realizada'),
    (20, 5, 8, 6, 2, '2025-03-12 10:00', null, 70, 700.00, 'realizada');

    -- Cliente 6 (CLI3006) with 5 appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES
    (21, 6, 1, 3, 1, '2025-01-05 09:00', null, 30, 100.00, 'realizada'),
    (22, 6, 3, 4, 2, '2025-01-20 10:00', null, 60, 200.00, 'realizada'),
    (23, 6, 4, 5, 1, '2025-02-03 11:00', null, 50, 180.00, 'realizada'),
    (24, 6, 7, 6, 2, '2025-03-12 09:30', null, 60, 600.00, 'cancelada'),
    (25, 6, 9, 7, 1, '2025-04-10 10:00', null, 80, 400.00, 'realizada');

    -- Cliente 7 (CLI3007) with 6 appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES
    (26, 7, 2, 8, 2, '2025-01-10 08:30', null, 45, 150.00, 'realizada'),
    (27, 7, 3, 9, 1, '2025-01-25 10:30', null, 60, 200.00, 'cancelada'),
    (28, 7, 5, 10, 2, '2025-02-05 09:00', '2025-02-08 09:00', 40, 300.00, 'reagendada'),
    (29, 7, 8, 3, 1, '2025-03-15 11:00', null, 70, 700.00, 'realizada'),
    (30, 7, 6, 4, 2, '2025-04-02 14:00', '2025-04-05 14:00', 90, 800.00, 'reagendada'),
    (31, 7, 10, 5, 1, '2025-04-18 10:00', null, 20, 90.00, 'realizada');

    -- Cliente 8 (CLI3008) with 6 appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES
    (32, 8, 1, 6, 2, '2025-01-12 09:30', null, 30, 100.00, 'realizada'),
    (33, 8, 2, 7, 1, '2025-01-28 11:00', null, 45, 150.00, 'cancelada'),
    (34, 8, 4, 8, 2, '2025-02-14 10:00', null, 50, 180.00, 'realizada'),
    (35, 8, 5, 9, 1, '2025-03-03 14:00', '2025-03-07 14:00', 40, 300.00, 'reagendada'),
    (36, 8, 7, 10, 2, '2025-03-20 10:30', '2025-03-22 10:30', 60, 600.00, 'reagendada'),
    (37, 8, 9, 3, 1, '2025-04-08 09:00', null, 80, 400.00, 'realizada');

    -- Cliente 9 (CLI3009) with 7 appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES
    (38, 9, 1, 4, 2, '2025-01-10 11:00', null, 30, 100.00, 'realizada'),
    (39, 9, 3, 5, 1, '2025-01-22 09:00', null, 60, 200.00, 'realizada'),
    (40, 9, 4, 6, 2, '2025-02-10 10:30', '2025-02-15 10:30', 50, 180.00, 'reagendada'),
    (41, 9, 5, 7, 1, '2025-03-01 11:00', null, 40, 300.00, 'realizada'),
    (42, 9, 6, 8, 2, '2025-03-25 10:00', '2025-03-30 10:00', 90, 800.00, 'reagendada'),
    (43, 9, 8, 9, 1, '2025-04-12 10:00', null, 70, 700.00, 'realizada'),
    (44, 9, 10, 10, 2, '2025-04-25 09:00', null, 20, 90.00, 'realizada');

    -- Cliente 10 (CLI3010) with 8 appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES
    (45, 10, 2, 3, 1, '2025-01-03 08:00', null, 45, 150.00, 'realizada'),
    (46, 10, 3, 4, 2, '2025-01-17 09:30', null, 60, 200.00, 'cancelada'),
    (47, 10, 4, 5, 1, '2025-02-01 11:00', '2025-02-09 11:00', 50, 180.00, 'reagendada'),
    (48, 10, 6, 6, 2, '2025-02-18 14:00', null, 90, 800.00, 'realizada'),
    (49, 10, 7, 7, 1, '2025-03-05 10:00', '2025-03-09 10:00', 60, 600.00, 'reagendada'),
    (50, 10, 9, 8, 2, '2025-03-22 09:00', null, 80, 400.00, 'realizada'),
    (51, 10, 10, 9, 1, '2025-04-02 10:00', null, 20, 90.00, 'realizada'),
    (52, 10, 5, 10, 2, '2025-04-20 11:00', null, 40, 300.00, 'realizada');

    -- Pending appointments for clients 11-20
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES 
    (53, 11, 2, 3, 1, '2025-06-01 09:00', null, 45, 150.00, 'agendada'),
    (54, 12, 4, 4, 2, '2025-06-03 10:00', null, 50, 180.00, 'agendada'),
    (55, 13, 7, 5, 1, '2025-06-05 11:30', null, 60, 600.00, 'cancelada'),
    (56, 14, 3, 6, 2, '2025-06-06 09:30', null, 60, 200.00, 'agendada'),
    (57, 15, 1, 7, 1, '2025-06-07 08:00', '2025-06-10 08:00', 30, 100.00, 'reagendada'),
    (58, 16, 5, 8, 2, '2025-06-10 10:00', null, 40, 300.00, 'agendada'),
    (59, 17, 8, 9, 1, '2025-06-12 11:00', null, 70, 700.00, 'agendada'),
    (60, 18, 6, 10, 2, '2025-06-15 10:30', '2025-06-20 10:30', 90, 800.00, 'reagendada'),
    (61, 19, 10, 3, 1, '2025-06-17 09:00', null, 20, 90.00, 'cancelada'),
    (62, 20, 9, 4, 2, '2025-06-18 08:30', null, 80, 400.00, 'agendada');

    -- Client 21 (CLI3021) with appointments
    INSERT INTO cita (cita_id, cliente_id, tratamiento_id, medico_id, agendador_id, fecha_hora, reagendada, duracion, costo, estado)
    VALUES 
    (63, 21, 9, 4, 1, '2025-02-17 00:00', null, 90, 159.5, 'realizada'),
    (64, 21, 4, 8, 1, '2025-02-25 00:00', null, 90, 375.14, 'realizada'),
    (65, 21, 2, 10, 2, '2025-03-04 00:00', '2025-03-08 00:00', 45, 333.61, 'reagendada'),
    (66, 21, 1, 3, 1, '2025-01-25 00:00', null, 60, 643.77, 'realizada'),
    (67, 21, 6, 6, 1, '2024-11-30 00:00', null, 75, 268.22, 'cancelada');

    -- Medical acts for client 21 (CLI3021)
    INSERT INTO acto_medico (acto_medico_id, cita_id, observaciones, fecha_realizacion, modificado_en)
    VALUES
    (1, 63, 'Revision de encias y limpieza general.', '2025-02-17', '2025-03-04'),
    (2, 64, 'Revision de ortodoncia, ajustes y controles necesarios.', '2025-02-25', '2025-03-05'),
    (3, 65, 'Blanqueo dental, revision de posibles caries.', '2025-03-04', '2025-03-05'),
    (4, 66, 'Extraccion de muela del juicio, control postoperatorio.', '2025-01-25', '2025-03-06'),
    (5, 67, 'Revision general, limpieza profunda y fluoruro.', '2024-11-30', '2025-03-10');

    -- Medical acts for other clients (sample - you would continue this pattern)
    INSERT INTO acto_medico (acto_medico_id, cita_id, observaciones, fecha_realizacion, modificado_en)
    VALUES
    (6, 26, 'Implante dental, seguimiento de recuperacion.', '2025-02-18', '2025-03-12'),
    (7, 27, 'Revision y limpieza general de dientes.', '2025-03-02', '2025-03-13'),
    (8, 28, 'Revision de ortodoncia, revision de brackets.', '2025-03-10', '2025-03-13'),
    (9, 29, 'Revision de dientes y tratamiento de encias.', '2025-01-15', '2025-03-14'),
    (10, 30, 'Limpieza profunda, sellado de dientes.', '2025-01-25', '2025-03-18'),
    (11, 31, 'Revision general, tratamiento de encias.', '2025-01-22', '2025-03-19'),
    (12, 32, 'Revision de ortodoncia, ajuste de brackets.', '2025-02-01', '2025-03-19'),
    (13, 33, 'Limpieza profunda, revision general de dientes.', '2025-03-10', '2025-03-21'),
    (14, 34, 'Revision de dientes, control de caries.', '2025-02-05', '2025-03-21'),
    (15, 35, 'Limpieza y aplicacion de fluoruro.', '2025-02-20', '2025-03-25'),
    (16, 36, 'Revision general, sellado de dientes.', '2025-01-30', '2025-03-25'),
    (17, 37, 'Tratamiento de ortodoncia, revision de brackets.', '2025-02-10', '2025-03-28'),
    (18, 38, 'Revision de muelas, revision de encias.', '2025-01-19', '2025-03-31'),
    (19, 39, 'Limpieza profunda, revision de caries.', '2025-02-12', '2025-04-02'),
    (20, 40, 'Revision de encias, tratamiento postoperatorio.', '2025-03-05', '2025-04-03'),
    (21, 41, 'Revision de ortodoncia, ajustes de brackets.', '2025-03-10', '2025-04-04'),
    (22, 42, 'Revision general, limpieza de dientes.', '2025-02-03', '2025-04-08'),
    (23, 43, 'Tratamiento de encias, fluoruro.', '2025-02-15', '2025-04-08'),
    (24, 44, 'Extraccion dental, seguimiento de recuperacion.', '2025-01-10', '2025-04-08'),
    (25, 45, 'Limpieza general, revision de ortodoncia.', '2025-03-01', '2025-04-08');
    -- Cliente CLI3001
    -- Client 1 (CLI3001) payments
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (1, 1, 'Carlos Lopez', '2025-01-10 09:00:00', 80.00, 'credito', 'correcto'),
    (2, 2, 'Carlos Lopez', '2025-01-25 10:00:00', 50.00, 'efectivo', 'correcto'),
    (3, 3, 'Carlos Lopez', '2025-02-05 11:00:00', 60.00, 'credito', 'correcto');

    -- Client 2 (CLI3002) payments (installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (4, 4, 'Luis Ramos', '2025-01-15 08:30:00', 100.00, 'transferencia', 'correcto'),
    (5, 4, 'Luis Ramos', '2025-02-01 08:45:00', 100.00, 'credito', 'correcto');

    -- Client 3 (CLI3003) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (6, 5, 'Maria Torres', '2025-02-02 10:15:00', 90.00, 'efectivo', 'correcto');

    -- Client 4 (CLI3004) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (7, 6, 'Ana Gutierrez', '2025-01-18 14:00:00', 150.00, 'debito', 'correcto');

    -- Client 5 (CLI3005) payments (installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (8, 7, 'Pedro Salazar', '2025-02-20 09:45:00', 70.00, 'credito', 'correcto'),
    (9, 7, 'Pedro Salazar', '2025-03-05 09:40:00', 70.00, 'credito', 'correcto');

    -- Client 6 (CLI3006) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (10, 8, 'Julia Leon', '2025-02-28 16:30:00', 60.00, 'debito', 'correcto');

    -- Client 7 (CLI3007) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (11, 9, 'Ricardo Diaz', '2025-03-03 13:00:00', 90.00, 'transferencia', 'correcto');

    -- Client 8 (CLI3008) payment (single installment with delay)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (12, 10, 'Carla Mejia', '2025-03-15 11:30:00', 80.00, 'efectivo', 'correcto');

    -- Client 9 (CLI3009) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (13, 11, 'Jose Andrade', '2025-02-10 09:30:00', 85.00, 'efectivo', 'correcto');

    -- Client 10 (CLI3010) payments (installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (14, 12, 'Paula Romero', '2025-02-12 10:45:00', 75.00, 'debito', 'correcto'),
    (15, 12, 'Paula Romero', '2025-02-27 10:50:00', 75.00, 'debito', 'correcto');

    -- Client 11 (CLI3011) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (16, 13, 'Fabiola Vega', '2025-02-20 11:15:00', 95.00, 'debito', 'correcto');

    -- Client 12 (CLI3012) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (17, 14, 'Mario Valdez', '2025-02-24 14:20:00', 60.00, 'transferencia', 'correcto');

    -- Client 13 (CLI3013) payments (3 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (18, 15, 'Natalia Ruiz', '2025-01-18 13:00:00', 50.00, 'efectivo', 'correcto'),
    (19, 15, 'Natalia Ruiz', '2025-01-28 13:15:00', 50.00, 'efectivo', 'correcto'),
    (20, 15, 'Natalia Ruiz', '2025-02-05 13:30:00', 50.00, 'efectivo', 'correcto');

    -- Client 14 (CLI3014) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (21, 16, 'Raul Herrera', '2025-02-27 08:45:00', 100.00, 'credito', 'correcto');

    -- Client 15 (CLI3015) payments (2 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (22, 17, 'Beatriz Salinas', '2025-03-01 09:00:00', 80.00, 'transferencia', 'correcto'),
    (23, 17, 'Beatriz Salinas', '2025-03-15 09:00:00', 80.00, 'transferencia', 'correcto');

    -- Client 16 (CLI3016) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (24, 18, 'Cesar Medina', '2025-03-04 10:00:00', 70.00, 'debito', 'correcto');

    -- Client 17 (CLI3017) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (25, 19, 'Liliana Ramos', '2025-03-06 10:10:00', 90.00, 'credito', 'correcto');

    -- Client 18 (CLI3018) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (26, 20, 'Felipe Rios', '2025-03-08 10:20:00', 85.00, 'debito', 'correcto');

    -- Client 19 (CLI3019) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (27, 21, 'Jazmin Delgado', '2025-03-10 09:30:00', 65.00, 'efectivo', 'correcto');

    -- Client 20 (CLI3020) payments (2 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (28, 22, 'Luis Camacho', '2025-03-12 10:00:00', 50.00, 'debito', 'correcto'),
    (29, 22, 'Luis Camacho', '2025-03-19 10:00:00', 50.00, 'debito', 'correcto');

    -- Client 21 (CLI3021) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (30, 23, 'Daniela Infante', '2025-03-13 11:15:00', 95.00, 'credito', 'correcto');

    -- Client 22 (CLI3022) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (31, 24, 'Andres Palacios', '2025-03-15 13:30:00', 120.00, 'transferencia', 'correcto');

    -- Client 23 (CLI3023) payments (3 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (32, 25, 'Fiorella Quispe', '2025-03-18 08:30:00', 40.00, 'efectivo', 'correcto'),
    (33, 25, 'Fiorella Quispe', '2025-03-25 08:30:00', 40.00, 'efectivo', 'correcto'),
    (34, 25, 'Fiorella Quispe', '2025-04-01 08:30:00', 40.00, 'efectivo', 'correcto');

    -- Client 24 (CLI3024) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (35, 26, 'Kevin Yovera', '2025-03-19 14:00:00', 90.00, 'debito', 'correcto');

    -- Client 25 (CLI3025) payments (2 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (36, 27, 'Maria Alegria', '2025-03-20 09:00:00', 55.00, 'credito', 'correcto'),
    (37, 27, 'Maria Alegria', '2025-03-27 09:00:00', 55.00, 'credito', 'correcto');

    -- Client 26 (CLI3026) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (38, 28, 'Oscar Barrena', '2025-03-21 10:45:00', 80.00, 'transferencia', 'correcto');

    -- Client 27 (CLI3027) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (39, 29, 'Jimena Torres', '2025-03-23 11:00:00', 100.00, 'efectivo', 'correcto');

    -- Client 28 (CLI3028) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (40, 30, 'Walter Ramirez', '2025-03-25 11:30:00', 110.00, 'credito', 'correcto');

    -- Client 29 (CLI3029) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (41, 31, 'Luciana Bravo', '2025-03-26 09:00:00', 95.00, 'credito', 'correcto');

    -- Client 30 (CLI3030) payments (2 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (42, 32, 'Esteban Gutierrez', '2025-03-27 10:00:00', 60.00, 'efectivo', 'correcto'),
    (43, 32, 'Esteban Gutierrez', '2025-04-03 10:00:00', 60.00, 'efectivo', 'correcto');

    -- Client 31 (CLI3031) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (44, 33, 'Thalia Rios', '2025-03-28 11:00:00', 85.00, 'transferencia', 'correcto');

    -- Client 32 (CLI3032) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (45, 34, 'Ivan Leon', '2025-03-30 12:30:00', 100.00, 'credito', 'correcto');

    -- Client 33 (CLI3033) payments (3 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (46, 35, 'Rosario Velez', '2025-04-01 08:00:00', 40.00, 'debito', 'correcto'),
    (47, 35, 'Rosario Velez', '2025-04-08 08:00:00', 40.00, 'debito', 'correcto'),
    (48, 35, 'Rosario Velez', '2025-04-15 08:00:00', 40.00, 'debito', 'correcto');

    -- Client 34 (CLI3034) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (49, 36, 'Beto Mendoza', '2025-04-02 09:15:00', 70.00, 'efectivo', 'correcto');

    -- Client 35 (CLI3035) payments (2 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (50, 37, 'Andrea Olivos', '2025-04-04 09:00:00', 60.00, 'credito', 'correcto'),
    (51, 37, 'Andrea Olivos', '2025-04-11 09:00:00', 60.00, 'credito', 'correcto');

    -- Client 36 (CLI3036) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (52, 38, 'Rodrigo Silva', '2025-04-06 10:45:00', 90.00, 'credito', 'correcto');

    -- Client 37 (CLI3037) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (53, 39, 'Milagros Cordova', '2025-04-08 11:30:00', 105.00, 'efectivo', 'correcto');

    -- Client 38 (CLI3038) payment
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (54, 40, 'Gerardo Tello', '2025-04-09 14:00:00', 110.00, 'transferencia', 'correcto');

    -- Client 39 (CLI3039) payment (1 installment)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (55, 41, 'Martina Paredes', '2025-04-10 09:30:00', 100.00, 'credito', 'correcto');

    -- Client 40 (CLI3040) payments (2 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (56, 42, 'Franco Aguirre', '2025-04-12 10:00:00', 70.00, 'efectivo', 'correcto'),
    (57, 42, 'Franco Aguirre', '2025-04-19 10:00:00', 70.00, 'efectivo', 'correcto');

    -- Client 41 (CLI3041) payment (1 installment)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (58, 43, 'Emilia Torres', '2025-04-13 11:15:00', 85.00, 'transferencia', 'correcto');

    -- Client 42 (CLI3042) payment (1 installment)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (59, 44, 'Nicolas Escalante', '2025-04-14 12:00:00', 105.00, 'credito', 'correcto');

    -- Client 43 (CLI3043) payments (3 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (60, 45, 'Roxana Fernandez', '2025-04-16 09:00:00', 50.00, 'debito', 'correcto'),
    (61, 45, 'Roxana Fernandez', '2025-04-23 09:00:00', 50.00, 'debito', 'correcto'),
    (62, 45, 'Roxana Fernandez', '2025-04-30 09:00:00', 50.00, 'debito', 'correcto');

    -- Client 44 (CLI3044) payment (1 installment)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (63, 46, 'Tomas Rivas', '2025-04-17 10:30:00', 95.00, 'transferencia', 'correcto');

    -- Client 45 (CLI3045) payments (2 installments)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (64, 47, 'Julieta Navarro', '2025-04-18 11:00:00', 60.00, 'efectivo', 'correcto'),
    (65, 47, 'Julieta Navarro', '2025-04-25 11:00:00', 60.00, 'efectivo', 'correcto');

    -- Client 46 (CLI3046) payment (1 installment)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (66, 48, 'Cesar Quinteros', '2025-04-19 08:30:00', 110.00, 'credito', 'correcto');

    -- Client 47 (CLI3047) payment (1 installment)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (67, 49, 'Isabel Caceres', '2025-04-20 09:45:00', 70.00, 'credito', 'correcto');

    -- Client 48 (CLI3048) payment (1 installment)
    INSERT INTO pago (pago_id, cita_id, emisor, fecha_hora, monto, metodo, estado)
    VALUES 
    (68, 50, 'Renato Campos', '2025-04-20 11:30:00', 90.00, 'transferencia', 'correcto');