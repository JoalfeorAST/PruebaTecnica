Create database tiendaInformatica;
Use tiendaInformatica;

Create table Fabricante(
Id_Fabricante int auto_increment,
Nom_Fabricante nvarchar (100) not null,

Primary key (Id_Fabricante)
);

Create table Articulo(
Id_Articulo int auto_increment,
Nom_Articulo nvarchar (100) not null,
Pre_Articulo int not null,
Id_Fab_Articulo int not null,

Primary key (Id_Articulo),
Foreign key (Id_Fab_Articulo) references Fabricante (Id_Fabricante) 
);

/*
Insertamos los datos de la tabla Fabricante
*/
Insert into Fabricante
(Nom_Fabricante)
Values
('Msi'),
('Gigabyte'),
('Asus'),
('Intel'),
('Amd');

/*
Insertamos los datos de la tabla Articulo
*/
Insert into Articulo
(Nom_Articulo, Pre_Articulo, Id_Fab_Articulo)
Values
('Motherboard Msi H110',50,1),
('Motherboard Msi Z270',180,1),
('Gpu Msi GTX 1060',370,1),
('Gpu Msi GTX 1080',600,1),
('Motherboard Gigabyte H110',60,2),
('Motherboard Gigabyte B250',90,2),
('Gpu Gigabyte GTX 1050Ti',190,2),
('Gpu Gigabyte RX 580',490,2),
('Motherboard Asus PRIME X370',160,3),
('Motherboard Asus Z270F',250,3),
('Gpu Asus GTX 1060',380,3),
('Gpu Asus RX 580',490,3),
('Procesador Intel i3 7100',100,4),
('Procesador Intel i5 7400',250,4),
('Procesador Intel i7 7700k',350,4),
('Procesador Intel i9 7900X',960,4),
('Procesador Amd A10 7860',90,5),
('Procesador Amd FX 6300',300,5),
('Procesador Amd Ryzen 1600x',230,5),
('Procesador Amd Ryzen 1800x',550,5);

/*
Obtener el nombre de los productos cuyo precio sea menor o igual a 200€
*/
Select A.Nom_Articulo as Articulo
From Articulo A, Fabricante F
Where A.Id_Fab_Articulo = Id_Fabricante and A.Pre_Articulo <= 200;

/*
Obtener el nombre y precio de los articulos cuyo precio sea mayor o igual a 180€
y ordenarlos descendetemente por precio, y luego ascendetemente por nombre.
*/
Select A.Nom_Articulo as Articulo, A.Pre_Articulo as Precio
From Articulo A, Fabricante F
Where A.Id_Fab_Articulo = Id_Fabricante and A.Pre_Articulo >= 180
group by A.Pre_Articulo desc, A.Nom_Articulo asc;

/*
Obtener un listado completo de articulos, incluyendo por cada articulo los datos
del articulo y de su fabricante.
*/
Select A.Id_Articulo as Codigo_Articulo,A.Nom_Articulo as Articulo, A.Pre_Articulo as Precio, 
	   F.Nom_Fabricante as Fabricante, F.Id_Fabricante as Codigo_Fabricante
From Articulo A, Fabricante F
Where A.Id_Fab_Articulo = Id_Fabricante;

/*
Aplicar un descuento de 10€ a todos los productos cuyo precio sea mayor o igual
a 120€
*/

/*
MySQL Workbench da error 1175 para hacer el update a la table,
se recomienda usar el comando: 
SET SQL_SAFE_UPDATES=0;
para desactivar el actualizado seguro
 */
Select * from Articulo; 
 
Update Articulo 
Set Pre_Articulo = Pre_Articulo - 10
Where Pre_Articulo >= 120;

Select * from Articulo;

/*
Obtener una lista con el nombre y precio de los articulos mas caros de cada
proveedor(incluyendo el nombre del proveedor).
*/
Select A.Nom_Articulo as Articulo, A.Pre_Articulo as Precio, 
	   F.Nom_Fabricante as Fabricante
From Articulo A, Fabricante F
Where A.Id_Fab_Articulo = Id_Fabricante and A.Pre_Articulo=(select Max(A.Pre_Articulo)from Articulo A where A.Id_Fab_Articulo = Id_Fabricante);

/*
Prueba Tecnica
Jhon Alexander Fernandez Ortiz
*/








