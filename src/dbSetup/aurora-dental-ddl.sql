create table persona (
    persona_id serial primary key,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    documento varchar(20) not null unique,
    email varchar(100) not null unique,
    telefono varchar(20),
    fecha_nacimiento date not null,
    direccion varchar(200) not null,
    creado_en timestamp without time zone default current_timestamp not null,
    sexo char(1) not null,
    check (sexo in ('m', 'f'))
);
create table cargo (
    cargo_id serial primary key,
    nombre_cargo varchar(50) not null unique,
    descripcion varchar(90)
);
create table usuario (
    usuario_id serial primary key,
    username varchar(50) not null unique,
    password_hash varchar(64) not null,
    ultimo_acceso timestamp without time zone
);
create table trabajador (
    trabajador_id serial primary key,
    persona_id integer not null unique,
    cargo_id integer not null,
    usuario_id integer not null unique,
    numero_licencia varchar(20),
    especialidad varchar(50),
    estado boolean default true,
    creado_en timestamp without time zone default current_timestamp,
    foreign key (persona_id) references persona(persona_id),
    foreign key (cargo_id) references cargo(cargo_id),
    foreign key (usuario_id) references usuario(usuario_id)
);
create table tratamiento (
    tratamiento_id serial primary key,
    nombre varchar(100) not null,
    descripcion varchar(100),
    duracion_estimada smallint,
    costo numeric(10,2)
);
create table cliente (
    cliente_id serial primary key,
    persona_id integer not null unique,
    creado_en timestamp without time zone default current_timestamp,
    foreign key (persona_id) references persona(persona_id)
);
create table cita (
    cita_id serial primary key,
    cliente_id integer not null,
    tratamiento_id integer not null,
    medico_id integer not null,
    agendador_id integer not null,
    fecha_hora timestamp not null,
    reagendada timestamp,
    duracion smallint,
    costo numeric(10,2) not null,
    estado varchar(20) default 'agendada',
    check (estado in ('agendada', 'realizada', 'cancelada', 'reagendada')),
    foreign key (cliente_id) references cliente(cliente_id),
    foreign key (tratamiento_id) references tratamiento(tratamiento_id),
    foreign key (medico_id) references trabajador(trabajador_id),
    foreign key (agendador_id) references trabajador(trabajador_id)
);
create table acto_medico (
    acto_medico_id serial primary key,
    cita_id integer unique not null,
    observaciones varchar(255),
    fecha_realizacion timestamp without time zone default current_timestamp,
    modificado_en timestamp without time zone default current_timestamp,
    foreign key (cita_id) references cita(cita_id)
);
create table pago (
    pago_id serial primary key,
    cita_id integer not null,
    emisor varchar(80),
    fecha_hora timestamp without time zone not null default current_timestamp,
    monto numeric(10,2) not null,
    metodo varchar(50) not null,
    estado varchar(20) default 'correcto',
    check (monto > 0),
    check (estado in ('correcto', 'incorrecto')),
    check (metodo in ('credito', 'debito', 'transferencia', 'efectivo')),
    foreign key (cita_id) references cita(cita_id)
);