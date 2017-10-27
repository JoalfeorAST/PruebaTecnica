Create database PruebaTecnica;
Use PruebaTecnica;

Create table cliente (
id_cli int auto_increment,
doc_cli int not null,
nom_cli varchar (40) not null,
ape_cli varchar (40) not null,
dir_cli varchar (50) not null,
tel_cli varchar (20) not null,

Primary key (id_cli)
);

Create table contacto (
id_cont int auto_increment,
nom_cont varchar (40) not null,
tel_cont varchar (30) not null,
ema_cont varchar (50) not null,
asu_cont varchar (30) not null,
men_cont nvarchar (500) not null,

Primary key (id_cont)
);

Insert into cliente
Values 
(null,111,'Monica Andrea','Villamizar Merchan','Oficina 314','3000000000'),
(null,222,'Prueba','Prueba','Calle de Prueba','3000000000'),
(null,1095821152,'Jhon Alexander','Fernandez','Calle 105 33-23','3102659655');

select * from cliente
