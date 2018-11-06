create database db_finan;
use db_finan;

/* Insertar a tabla financiera */
insert into financiera (nombre) values ('Naranja');
insert into financiera (nombre) values ('Santander Rio');
insert into financiera (nombre) values ('Galicia');

select * from financiera;

/* Insertar a la tabla afiliado */
insert into afiliado (nombre,apellido,puesto,antiguedad,sueldo) values ('Martin','Ale','','3',20000);
insert into afiliado (nombre,apellido,puesto,antiguedad,sueldo) values ('Daniel','Ramoz','','2',25000);
insert into afiliado (nombre,apellido,puesto,antiguedad,sueldo) values ('Alex','Diaz','','5',30000);
