# source  C:/Users/gladi/Documents/GitHub/gestionBibliotecaISO/baseDeDatos/insertTestData.sql;

use DBbiblioteca;

INSERT INTO Usuario(nombre,dni,sexo,fecha_nacimiento,direccion,telefono,email) VALUES
('Pepe','12312312A',1,'1990-01-01','Avda de mi casa N 123','698789865','miEmail@ole.com'),
('Jose','12312312B',1,'1990-01-01','Avda de mi casa N 123','698789865','miEmail@ole.com'),
('Juan','12312312C',1,'1990-01-01','Avda de mi casa N 123','698789865','miEmail@ole.com'),
('Antonio','12312312D',1,'1990-01-01','Avda de mi casa N 123','698789865','miEmail@ole.com'),
('Bruguera','12312312E',1,'1990-01-01','Avda de mi casa N 123','698789865','miEmail@ole.com'),
('Tahoces','12312312F',1,'1990-01-01','Avda de mi casa N 123','698789865','miEmail@ole.com'),
('Jose Varela','12312312G',1,'1990-01-01','Avda de mi casa N 123','698789865','miEmail@ole.com'),
('Mosquera','12312312H',1,'1990-01-01','Avda de mi casa N 123','698789865','miEmail@ole.com');

INSERT INTO Fondo(titulo,fecha_compra) VALUES
('Quijote: Parte 1','1990-02-03'),
('Quijote: Parte 2','1990-03-03'),
('Quijote: Parte 3','1990-03-03'),
('Quijote: Parte 4','1990-03-03'),
('Quijote: Parte 4','1990-04-03'),
('Quijote: Parte 5','1990-04-03'),
('Orilla: Parte 1','1990-04-03'),
('Orilla: Parte 2','1990-04-03');

INSERT INTO Libro(isbn,id,ano_edicion,editorial) VALUES
('987-7-78-789789-9',1,'2000-01-01','Anaya'),
('987-7-78-789789-8',2,'2000-01-01','Anaya'),
('987-7-78-789789-7',3,'2000-01-01','Anaya'),
('987-7-78-789789-6',4,'2000-01-01','Anaya'),
('987-7-78-789789-5',5,'2000-01-01','Anaya'),
('987-7-78-789789-4',6,'2000-01-01','Anaya');

INSERT INTO Autores(isbn,id,autor) VALUES
('987-7-78-789789-9',1,'Cervantes'),
('987-7-78-789789-9',1,'Jefe de Cervantes'),
('987-7-78-789789-8',2,'Hermano de cervantes'),
('987-7-78-789789-7',3,'Primo de cervantes'),
('987-7-78-789789-6',4,'Padre de cervantes'),
('987-7-78-789789-5',5,'Abuela de cervantes'),
('987-7-78-789789-4',6,'Cervantes');

INSERT INTO Prestamo(fecha_inicio,fecha_fin,id_usuario,id_fondo) VALUES
('2000-01-02','2000-01-06',1,1),
('2000-02-02','2000-02-06',1,2),
('2000-03-02',NULL,1,3),
('2000-03-02',NULL,2,1),
('2000-04-02','2000-01-06',2,2);