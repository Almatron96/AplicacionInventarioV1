drop table if exists Rol;
drop table if exists TipoArticulo;
drop table if exists Usuario;
drop table if exists Articulos;
drop table if exists Historial;


CREATE TABLE Rol(
    idRol SERIAL PRIMARY KEY,
    rol character varying(50) NOT NULL,
	estado boolean NOT NULL default true
);

CREATE TABLE TipoArticulo(
    idTipoArticulo SERIAL PRIMARY KEY,
    TipoArticulo character varying(50) NOT NULL,
	estado boolean NOT NULL default true
);

CREATE TABLE Usuario(
    idUsuario SERIAL PRIMARY KEY,
    nombres character varying(50),
    apellidos character varying(50),
    correo character varying(50),
    nombreDeUsuario character varying(50),
    contrasenia character varying(250),
    idRol integer NOT NULL,
	estado boolean NOT NULL default true
);

CREATE TABLE Articulos(
    idArticulo SERIAL PRIMARY KEY,
	idPersonaEncargada integer NOT NULL,
	idTipoArticulo integer,
    marca character varying(50),
    numeroSerie character varying(50),
    modelo character varying(50),
    condicionArticulo character varying(50),
	descripcion character varying(150),
	estado boolean NOT NULL default true
);

CREATE TABLE Historial(
	idHistorial SERIAL PRIMARY KEY,
	idUsuario integer NOT NULL,
	tabla character varying(50) NOT NULL,
        idItem integer NOT NULL,
	operacion character varying(50) NOT NULL,
	fechamodificacion TIMESTAMP NOT NULL
);

ALTER TABLE Usuario ADD CONSTRAINT fk_usuario_rol FOREIGN KEY (idRol) REFERENCES Rol(idRol);

ALTER TABLE Articulos ADD CONSTRAINT fk_articulos_usuario FOREIGN KEY (idPersonaEncargada) REFERENCES Usuario(idUsuario);

ALTER TABLE Articulos ADD CONSTRAINT fk_articulos_tipo_articulo FOREIGN KEY (idTipoArticulo) REFERENCES TipoArticulo(idTipoArticulo);

--ALTER TABLE Articulos ADD CONSTRAINT fk_articulos_condicion_articulo FOREIGN KEY (idCondicionArticulo) REFERENCES CondicionArticulo(idCondicionArticulo);

ALTER TABLE Historial ADD CONSTRAINT fk_historial_usuario FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario);

--ALTER TABLE Historial ADD CONSTRAINT fk_historial_articulos FOREIGN KEY (idArticulo) REFERENCES Articulos(idArticulo);
	
	
	
	
	
	
	