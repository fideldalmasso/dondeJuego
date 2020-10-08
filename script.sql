create schema dj;
create type dj.tipoDocumento as enum('DNI','LC','LI','LE');
create type dj.estadoCompetencia as enum('CREADA','PLANIFICADA','ENDISPUTA','FINALIZADA');

create table dj.pais(
	id serial primary key,
	nombre varchar(256)
);

create table dj.provincia(
	id serial primary key,
	idPais integer references dj.pais(id),
	nombre varchar(256)
);

create table dj.localidad(
	id serial primary key,
	idProvincia integer references dj.provincia(id),
	nombre varchar(256)
);

create table dj.usuario(
	id serial primary key,
	idLocalidad integer references dj.localidad(id),
	dni varchar(256),
	nombre varchar(256) unique,
	apellido varchar(256),
	contrasenia varchar(256),
	tipoDocumento dj.estadoCompetencia
);

create table dj.registroSesion(
	id serial primary key,
	documentoUsuario integer references dj.usuario(id),
	horaInicio timestamp
);

create table dj.deporte(
	id serial primary key,
	nombre varchar(256) unique
);

create table dj.lugarRealizacion(
	id serial primary key,
	idUsuario integer references dj.usuario(id),
	nombre varchar(256),
	descripcion varchar(1024)
);

create table dj.deporteLugar(
	idDeporte integer references dj.deporte(id),
	idLugar integer references dj.lugarRealizacion(id),
	primary key(idDeporte,idLugar)
);

create table dj.sistemaPuntuacion(
	id serial primary key
);

create table dj.sistemaPuntuacionPorResultadoFinal(
	idCompetencia integer references dj.sistemaPuntuacion(id),
	primary key(idCompetencia)
);

create table dj.sistemaPuntuacionPorPuntuacion(
	idCompetencia integer references dj.sistemaPuntuacion(id),
	puntosPorAbandono integer,
	primary key(idCompetencia)
);

create table dj.sistemaPuntuacionPorSets(
	idCompetencia integer references dj.sistemaPuntuacion(id),
	cantidadMaximaDeSets integer,
	primary key(idCompetencia)
);

create table dj.modalidad(
	id serial primary key,
	permiteEmpate boolean,
	puntosPorPresentar integer,
	puntosPorEmpate integer,
	puntosPorGanar integer
);

create table dj.modalidadEliminatoriaDoble(
	idCompetencia integer references dj.modalidad(id),
	primary key(idCompetencia)
);

create table dj.modalidadEliminatoriaSimple(
	idCompetencia integer references dj.modalidad(id),
	primary key(idCompetencia)
);

create table dj.modalidadLiga(
	idCompetencia integer references dj.modalidad(id),
	permiteEmpate boolean,
	puntosPorPresentarse integer,
	puntosPorEmpate integer,
	puntosPorGanar integer,
	primary key(idCompetencia)
);

create table dj.competencia(
	id serial primary key,
	idUsuario integer references dj.usuario(id),
	idDeporte integer references dj.deporte(id),
	idModalidad integer references dj.modalidad(id),
	idSistemaPuntuacion integer references dj.sistemaPuntuacion(id),
	fechaFin timestamp,
	reglamento varchar(1024),
	estado dj.estadoCompetencia,
	nombre varchar(256) unique,
	fechaHoraBajaLogica timestamp,
	fechaInicio timestamp
);

create table dj.competenciaLugar(
	idCompetencia integer references dj.competencia(id),
	idLugar integer references dj.lugarRealizacion(id),
	primary key (idCompetencia,idLugar)
);

create table dj.fixture(
	id serial primary key,
	idCompetencia integer references dj.competencia(id),
	fechaCreacion timestamp
);

create table dj.fecha(
	id serial primary key,
	idFixture integer references dj.fixture(id),
	tipoRonda integer
);

create table dj.participante(
	id serial primary key,
	idCompetencia integer references dj.competencia(id),
	nombre varchar(256),
	email varchar(256)
);

create table dj.renglonTabla(
	idParticipante integer references dj.participante(id),
	partidosEmpatados integer,
	partidosGanados integer,
	tantosAFavor integer,
	tantosEnContra integer,
	partidosPerdidos integer,
	primary key(idParticipante)
);

create table dj.resultado(
	id serial primary key,
	idEncuentro integer,
	fechaRegistro timestamp
);

create table dj.resultadoFinal(
	id integer references dj.resultado(id),
	empate boolean,
	ganaA boolean,
	ganaB boolean,
	primary key (id)
);

create table dj.resultadoPorSets(
	id integer references dj.resultado(id),
	puntosPorAbandono integer,
	primary key(id)
);

create table dj.resultadoPorPuntuacion(
	id integer references dj.resultado(id),
	puntajeFinalA integer,
	puntajeFinalB integer,
	primary key (id)
);

create table dj.sett(
	idResultado integer references dj.resultadoPorSets(id),
	puntajeA integer,
	puntajeB integer,
	primary key (idResultado)
);

create table dj.encuentro(
	id serial primary key,
	idResultadoActual integer references dj.resultado(id),
	idFecha integer references dj.fecha(id),
	idParticipanteA integer references dj.participante(id),
	idParticipanteB integer references dj.participante(id),
	sePresentaA boolean,
	sePresentaB boolean,
	fechaEncuentro timestamp
);

create table dj.encuentroLiga(
	idEncuentro integer references dj.encuentro(id),
	primary key(idEncuentro)
);

create table dj.encuentroEliminatoriaDoble(
	idEncuentro integer references dj.encuentro(id),
	destinoPerdedor integer,
	destinoGanador integer,
	primary key(idEncuentro)
);

create table dj.encuentroEliminatoriaSimple(
	idEncuentro integer references dj.encuentro(id),
	destinoGanador integer,
	primary key(idEncuentro)
);

alter table dj.encuentroEliminatoriaDoble add foreign key (destinoPerdedor) references dj.encuentroEliminatoriaDoble(idEncuentro);
alter table dj.encuentroEliminatoriaDoble add  foreign key (destinoGanador) references dj.encuentroEliminatoriaDoble(idEncuentro);
alter table dj.encuentroEliminatoriaSimple add  foreign key (destinoGanador) references dj.encuentroEliminatoriaSimple(idEncuentro);
alter table dj.resultado add foreign key (idEncuentro) references dj.encuentro(id);