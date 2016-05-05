# source  C:/Users/gladi/Documents/GitHub/gestionBibliotecaISO/baseDeDatos/createDatabase.sql;


DROP DATABASE DBbiblioteca;

CREATE DATABASE DBbiblioteca;

use DBbiblioteca;

CREATE TABLE Usuario(
	id INT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(30) NOT NULL,
	dni CHAR(9) NOT NULL UNIQUE,
	sexo BOOLEAN,
	fecha_nacimiento DATE NOT NULL,
	direccion VARCHAR(120) NOT NULL,
	telefono VARCHAR(13) NOT NULL,
	email VARCHAR(40) NOT NULL UNIQUE,
	PRIMARY KEY (id)
);

CREATE TABLE Fondo(
	id INT NOT NULL AUTO_INCREMENT,
	titulo VARCHAR(60) NOT NULL,
	fecha_compra DATE NOT NULL,
	#Cada uno de los fondos aqui registrados representa un ejemplar
	#Por error insertamos el campo "ejemplares en esta tabla".
	PRIMARY KEY (id)
);

CREATE TABLE Libro(
	isbn CHAR(17) NOT NULL,
	id INT NOT NULL,
	#autores VARCHAR(60) NOT NULL,
	ano_edicion DATE NOT NULL,
	editorial VARCHAR(40) NOT NULL,
	PRIMARY KEY (id,isbn),
	FOREIGN KEY (id) REFERENCES Fondo(id)
		ON DELETE CASCADE
		ON UPDATE CASCADE
);

CREATE TABLE Autores(
	isbn CHAR(17) NOT NULL,
	id INT NOT NULL,
	autor VARCHAR(60),
	PRIMARY KEY(isbn,id,autor),
	FOREIGN KEY (id,isbn) REFERENCES Libro(id,isbn)
		ON DELETE CASCADE
		ON UPDATE CASCADE	
);

CREATE TABLE Prestamo(
	id INT NOT NULL AUTO_INCREMENT,
	fecha_inicio DATE NOT NULL,
	fecha_fin DATE,
	id_usuario INT NOT NULL,
	id_fondo INT NOT NULL,
	PRIMARY KEY(id,id_usuario,id_fondo),
	FOREIGN KEY (id_usuario) REFERENCES Usuario(id)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
	FOREIGN KEY (id_fondo) REFERENCES Fondo(id)
		ON DELETE CASCADE
		ON UPDATE CASCADE	
);

