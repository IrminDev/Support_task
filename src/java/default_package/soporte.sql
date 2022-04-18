drop database if exists soporte;
create database soporte default character set utf8mb4;
use soporte;

-- TABLAS DE ENTIDADES
CREATE TABLE usuario(
id_usuario int primary key not null auto_increment,
nombre nvarchar(20),
apellido nvarchar(20),
correo nvarchar(60),
contrasena nvarchar(20)
);

CREATE TABLE reporte(
id_reporte int primary key not null auto_increment,
descripcion nvarchar(1000),
fecha_inicio date,
fecha_fin date
);

-- TABLAS SIN LLAVES FORÁNEAS
CREATE TABLE estatus(
id_estatus int primary key not null auto_increment,
estatus nvarchar(20)
);

CREATE TABLE tipo_usuario(
id_tipo int primary key not null auto_increment,
tipo nvarchar(30)
);

CREATE TABLE tipo_reporte(
id_tipo int primary key not null auto_increment,
tipo nvarchar(20)
);

-- TABLAS DE RELACIÓN
CREAtE TABLE relacion_reporte_encargado(
id_usuario int,
id_reporte int,
foreign key (id_usuario) references usuario(id_usuario),
foreign key (id_reporte) references reporte(id_reporte)
);

CREAtE TABLE relacion_usuario_tipo(
id_usuario int,
id_tipo int,
foreign key (id_usuario) references usuario(id_usuario),
foreign key (id_tipo) references tipo_usuario(id_tipo)
);

CREAtE TABLE relacion_reporte_tipo(
id_reporte int,
id_tipo int,
foreign key (id_reporte) references reporte(id_reporte),
foreign key (id_tipo) references tipo_reporte(id_tipo)
);

CREAtE TABLE relacion_reporte_estatus(
id_reporte int,
id_estatus int,
foreign key (id_reporte) references reporte(id_reporte),
foreign key (id_estatus) references estatus(id_estatus)
);

CREATE TABLE relacion_reporte_mantenimiento(
id_reporte_soporte int,
id_reporte_mantenimiento int,
foreign key (id_reporte_soporte) references reporte(id_reporte),
foreign key (id_reporte_mantenimiento) references reporte(id_reporte)
);

-- DATOS NECESARIOS
INSERT INTO estatus VALUES
(default,  "Abierto"),
(default, "En proceso"),
(default, "En mantenimiento"),
(default, "Cerrado");

INSERT INTO tipo_usuario VALUES 
(default, "Asesor de soporte"),
(default, "Ingeniero de soporte"),
(default, "Ingeniero de mantenimiento");

INSERT INTO tipo_reporte VALUES
(default, "Soporte"),
(default, "Mantenimiento");


-- PROCEDIMIENTOS ALMACENADOS BÁSICOS
DROP PROCEDURE IF EXISTS altaUsuario;
delimiter &&
CREATE PROCEDURE altaUsuario(
nombreN nvarchar(20),
apellidoN nvarchar(20),
correoN nvarchar(60),
contraN nvarchar(20),
tipoN int
)
BEGIN

INSERT INTO usuario VALUES
(default, nombreN, apellidoN, correoN, contraN);

SET @id_user = last_insert_id();

INSERT INTO relacion_usuario_tipo VALUES
(@id_user, tipoN);

END &&
delimiter ;

CALL altaUsuario("Irmin", "Hernández", "irminhdz@workwide.com", "IRHERWW-013", 1);
CALL altaUsuario("Montserrat", "Rivas", "monirivas@workwide.com", "MONRIWW-895", 1);
CALL altaUsuario("Daniela", "Sosa", "danisos@workwide.com", "DANSOSWW-120", 2);
CALL altaUsuario("Luis", "Contreras", "luscont@workwide.com", "LUICONWW-123", 3);




DROP PROCEDURE IF EXISTS altaReporte;
delimiter &&
CREATE PROCEDURE altaReporte(
descripcionN nvarchar(1000),
encargadoN int
)
BEGIN

INSERT INTO reporte VALUES
(default, descripcionN, CURDATE(), null);
SET @id_reporte = last_insert_id();

INSERT INTO relacion_reporte_encargado VALUES
(encargadoN, @id_reporte);

INSERT INTO relacion_reporte_tipo VALUES
(@id_reporte, 1);

INSERT INTO relacion_reporte_estatus VALUES
(@id_reporte, 2);

END &&
delimiter ;

call altaReporte("holamaidnd",3);
call altaReporte("pruebadequesisirve",4);


DROP PROCEDURE IF EXISTS altaReporteMantenimiento;
delimiter &&
CREATE PROCEDURE altaReporteMantenimiento(
id_reporteSop int,
descripcionN nvarchar(1000),
encargadoN int
)
BEGIN

INSERT INTO reporte VALUES
(default, descripcionN, CURDATE(), null);
SET @id_reporte = last_insert_id();

INSERT INTO relacion_reporte_encargado VALUES
(encargadoN, @id_reporte);

INSERT INTO relacion_reporte_tipo VALUES
(@id_reporte, 2);

INSERT INTO relacion_reporte_estatus VALUES
(@id_reporte, 3);

INSERT INTO relacion_reporte_mantenimiento VALUES
(id_reporteSop, id_reporte);

END &&
delimiter ;

CALL altaReporteMantenimiento(1, "olaamigos",4);


DROP PROCEDURE IF EXISTS cerrarReporte;
delimiter &&
CREATE PROCEDURE cerrarReporte(
idReporte int,
descripcionN nvarchar(1000)
)
BEGIN

UPDATE reporte
SET descripcion = descripcionN
WHERE id_reporte = idReporte;

UPDATE relacion_reporte_estatus
SET id_estatus = 4
WHERE id_reporte = idReporte;

END &&
delimiter ;




DROP PROCEDURE IF EXISTS cambiarEstatusReporte;
delimiter &&
CREATE PROCEDURE cambiarEstatusReporte(
estatusN int,
idReporte int
)
BEGIN

UPDATE relacion_reporte_estatus
SET id_estatus = estatusN
WHERE id_reporte = idReporte;

END &&
delimiter ; 

/*Consulta general*/

DROP PROCEDURE IF EXISTS listarReportes;
delimiter &&
CREATE PROCEDURE listarReportes(    
idUsuario int
)

BEGIN

SELECT 
reporte.id_reporte,
reporte.fecha_inicio,
reporte.fecha_fin,
reporte.descripcion,
usuario.nombre,
usuario.apellido,
estatus.estatus
FROM reporte
INNER JOIN relacion_reporte_encargado ON relacion_reporte_encargado.id_reporte = reporte.id_reporte
INNER JOIN usuario ON usuario.id_usuario = relacion_reporte_encargado.id_usuario
INNER JOIN relacion_reporte_estatus ON relacion_reporte_estatus.id_reporte = reporte.id_reporte
INNER JOIN estatus ON estatus.id_estatus = relacion_reporte_estatus.id_estatus
WHERE usuario.id_usuario = idUsuario;

END
&& delimiter ;

CALL listarReportes(4);