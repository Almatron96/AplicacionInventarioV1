drop table if exists CondicionArticulo;
drop table if exists Rol;
drop table if exists TipoArticulo;
drop table if exists Usuario;
drop table if exists Articulos;
drop table if exists Historial;

CREATE TABLE CondicionArticulo(
    idCondicionArticulo SERIAL PRIMARY KEY,
    condicionArticulo character(50) NOT NULL
	estado boolean NOT NULL default true
);

CREATE TABLE Rol(
    idRol SERIAL PRIMARY KEY,
    rol character(50) NOT NULL
	estado boolean NOT NULL default true
);

CREATE TABLE TipoArticulo(
    idTipoArticulo SERIAL PRIMARY KEY,
    TipoArticulo character(50) NOT NULL
	estado boolean NOT NULL default true
);

CREATE TABLE Usuario(
    idUsuario SERIAL PRIMARY KEY,
    nombres character(50),
    apellidos character(50),
    correo character(50),
    nombreDeUsuario character(50),
    contrasenia character(250),
    idRol integer NOT NULL
	estado boolean NOT NULL default true
);

CREATE TABLE Articulos(
    idArticulo SERIAL PRIMARY KEY,
	idPersonaEncargada integer NOT NULL,
	idTipoArticulo integer,
    marca character(50),
    numeroSerie character(50),
    modelo character(50),
    idCondicionArticulo integer,
	descripcion character(150),
	estado boolean NOT NULL default true
);

CREATE TABLE Historial(
	idHistorial SERIAL PRIMARY KEY,
	idUsuario integer NOT NULL,
	idArticulo integer NOT NULL,
	tabla character(50) NOT NULL,
	fecha_modificacion TIMESTAMP NOT NULL
);

ALTER TABLE Usuario ADD CONSTRAINT fk_usuario_rol FOREIGN KEY (idRol) REFERENCES Rol(idRol);

ALTER TABLE Articulos ADD CONSTRAINT fk_articulos_usuario FOREIGN KEY (idPersonaEncargada) REFERENCES Usuario(idUsuario);

ALTER TABLE Articulos ADD CONSTRAINT fk_articulos_tipo_articulo FOREIGN KEY (idTipoArticulo) REFERENCES TipoArticulo(idTipoArticulo);

ALTER TABLE Articulos ADD CONSTRAINT fk_articulos_condicion_articulo FOREIGN KEY (idCondicionArticulo) REFERENCES CondicionArticulo(idCondicionArticulo);

ALTER TABLE Historial ADD CONSTRAINT fk_historial_usuario FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario);

ALTER TABLE Historial ADD CONSTRAINT fk_historial_articulos FOREIGN KEY (idArticulo) REFERENCES Articulos(idArticulo);
	
	
	
	
	
	
	