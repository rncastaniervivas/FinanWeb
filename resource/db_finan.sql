create database db_finan;
use db_finan;

/* Insertar a tabla financiera */
insert into financiera (nombre) values ('Naranja');
insert into financiera (nombre) values ('Santander Rio');
insert into financiera (nombre) values ('Galicia');

select * from financiera;

/* Insertar a la tabla afiliado */
insert into afiliado (idAfiliado,nombre,apellido,puesto,antiguedad,sueldo) values (1,'Martin','Ale','','3',20000);
insert into afiliado (idAfiliado,nombre,apellido,puesto,antiguedad,sueldo) values (2,'Daniel','Ramoz','','2',25000);
insert into afiliado (idAfiliado,nombre,apellido,puesto,antiguedad,sueldo) values (3,'Alex','Diaz','','5',30000);

select *from afiliado;

/* Insertar a la tabla prestamo */
insert into prestamo (idPrestamo,cuotas,valor,interes,afiliado_idAfiliado) values (1,12,24000,0.35,1);

select * from prestamo;

/* Insertar a tabla cuota*/
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo) values (1,'1000','50','1050',true,'2018-01-15','2018-01-30',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo) values (2,'1000','50','1050',true,'2018-02-15','2018-02-17',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo) values (3,'1000','50','1050',true,'2018-03-15','2018-03-30',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo)values(4,'1000','50','1050',true,'2018-04-15','2018-04-30',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo)values(5,'1000','50','1050',true,'2018-05-15','2018-05-30',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo)values(6,'1000','50','1050',true,'2018-06-15','2018-06-30',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo)values(7,'1000','50','1050',true,'2018-07-15','2018-07-30',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo)values(8,'1000','50','1050',true,'2018-08-15','2018-08-30',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo)values(9,'1000','50','1050',false,null,'2018-09-30',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo)values(10,'1000','50','1050',false,null,'2018-10-30',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo)values(11,'1000','50','1050',false,null,'2018-11-30',1);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo)values(12,'1000','50','1050',false,null,'2018-12-30',1);

select * from cuota;








