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
select*from relacion_reporte_encargado;

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
call altaReporte("si sirve xd",3);

-- PROCESO ALMACENADO DE DAR ALTA UN REPORTE DE MANTENIMIENTO

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
(id_reporteSop, @id_reporte);

UPDATE relacion_reporte_estatus
SET id_estatus = 3
WHERE id_reporte = id_reporteSop;

END &&
delimiter ;

select*from reporte;

DROP PROCEDURE IF EXISTS iniciarSesion;
delimiter &&
CREATE PROCEDURE iniciarSesion(
correoUsu nvarchar(60),
contraUsu nvarchar(20)
)
BEGIN

SELECT id_tipo
FROM relacion_usuario_tipo
INNER JOIN usuario ON usuario.id_usuario = relacion_usuario_tipo.id_usuario
WHERE usuario.correo = correoUsu AND usuario.contrasena = contraUsu;

END &&
delimiter ;

CALL iniciarSesion("luscont@workwide.com", "LUICONWW-123");



-- PROCESO ALMACENADO QUE HACE CERRAR UN REPORTE


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

-- PROCESO ALACENADO QUE NOS DA LA CONSULTA DEL IS DE LOS REPORTES QUE ESTAN EN ESTATUS "CERRADO O MANTENIMIENTO"

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
usuario.id_usuario,
estatus.estatus
FROM reporte
INNER JOIN relacion_reporte_encargado ON relacion_reporte_encargado.id_reporte = reporte.id_reporte
INNER JOIN usuario ON usuario.id_usuario = relacion_reporte_encargado.id_usuario
INNER JOIN relacion_reporte_estatus ON relacion_reporte_estatus.id_reporte = reporte.id_reporte
INNER JOIN estatus ON estatus.id_estatus = relacion_reporte_estatus.id_estatus
WHERE usuario.id_usuario = idUsuario AND estatus.id_estatus>=3;

END
&& delimiter ;


DROP PROCEDURE IF EXISTS listar2Reporte;
delimiter &&
CREATE PROCEDURE listar2Reporte(    
idReporte int
)
BEGIN
SELECT 
reporte.id_reporte,
relacion_reporte_mantenimiento.id_reporte_soporte,
reporte.fecha_inicio,
reporte.fecha_fin,
reporte.descripcion,
usuario.nombre,
usuario.apellido,
estatus.estatus
FROM reporte
INNER JOIN relacion_reporte_mantenimiento ON relacion_reporte_mantenimiento.id_reporte_mantenimiento = reporte.id_reporte
INNER JOIN relacion_reporte_encargado ON relacion_reporte_encargado.id_reporte = reporte.id_reporte
INNER JOIN usuario ON usuario.id_usuario = relacion_reporte_encargado.id_usuario
INNER JOIN relacion_reporte_estatus ON relacion_reporte_estatus.id_reporte = reporte.id_reporte
INNER JOIN estatus ON estatus.id_estatus = relacion_reporte_estatus.id_estatus
WHERE reporte.id_reporte = idReporte;

END
&& delimiter ;

-- PROCESO ALMACENADO QUE HACE UNA CONSULTA DE UN SOLO REPORTE

DROP PROCEDURE IF EXISTS listarReporte;
delimiter &&
CREATE PROCEDURE listarReporte(    
idReporte int
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
WHERE reporte.id_reporte = idReporte;

END
&& delimiter ;



-- PROCESO ALMACENADO QUE NOS DA LA CONSULTA DE LOS REPORTES EN ESTATUS "PROCESO"
DROP PROCEDURE IF EXISTS listarReportesP;
delimiter &&
CREATE PROCEDURE listarReportesP(    
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
WHERE usuario.id_usuario = idUsuario AND estatus.id_estatus = 2;

END
&& delimiter ;

-- PROCESO ALACENADO QUE NOS DA LA CONSULTA DEL IS DE LOS REPORTES QUE ESTAN EN ESTATUS "CERRADO"

DROP PROCEDURE IF EXISTS listarReportesC;
delimiter &&
CREATE PROCEDURE listarReportesC(
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
usuario.id_usuario,
estatus.estatus
FROM reporte
INNER JOIN relacion_reporte_encargado ON relacion_reporte_encargado.id_reporte = reporte.id_reporte
INNER JOIN usuario ON usuario.id_usuario = relacion_reporte_encargado.id_usuario
INNER JOIN relacion_reporte_estatus ON relacion_reporte_estatus.id_reporte = reporte.id_reporte
INNER JOIN estatus ON estatus.id_estatus = relacion_reporte_estatus.id_estatus
WHERE usuario.id_usuario = idUsuario AND estatus.id_estatus=4;

END
&& delimiter ;

-- PROCESO ALACENADO QUE NOS DA LA CONSULTA DEL IS DE LOS REPORTES QUE ESTAN EN ESTATUS "Mantenimiento"

DROP PROCEDURE IF EXISTS listarReportesM;
delimiter &&
CREATE PROCEDURE listarReportesM(
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
usuario.id_usuario,
estatus.estatus
FROM reporte
INNER JOIN relacion_reporte_encargado ON relacion_reporte_encargado.id_reporte = reporte.id_reporte
INNER JOIN usuario ON usuario.id_usuario = relacion_reporte_encargado.id_usuario
INNER JOIN relacion_reporte_estatus ON relacion_reporte_estatus.id_reporte = reporte.id_reporte
INNER JOIN estatus ON estatus.id_estatus = relacion_reporte_estatus.id_estatus
WHERE usuario.id_usuario = idUsuario AND estatus.id_estatus=3;

END
&& delimiter ;

DROP PROCEDURE IF EXISTS cerrarReporteM4;
delimiter &&
CREATE PROCEDURE cerrarReporteM4(
idReporte int,
descripcionN nvarchar(1000),
idReporteZ int
)
BEGIN

UPDATE reporte
SET descripcion = descripcionN
WHERE id_reporte = idReporte;

UPDATE relacion_reporte_estatus
SET id_estatus = 4
WHERE id_reporte = idReporte;

UPDATE relacion_reporte_estatus
SET id_estatus = 4
WHERE id_reporte = idReporteZ;

UPDATE reporte
SET descripcion = descripcionN
WHERE id_reporte = idReporteZ;

END &&
delimiter ;

SELECT * FROM reporte;
call relacion_reporte_estatus;
call altaReporteMantenimiento(1,"tabien1",4);
call listarReportesM(4);
call altaReporte("Ya acabamos",3);
call listarReportesP(3);
SELECT * FROM relacion_reporte_estatus;

