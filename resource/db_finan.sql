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

select *from afiliado;

/* Insertar a la tabla prestamo */
insert into prestamo (cuotas,valor,interes) values (12,24000,5);

select * from prestamo;

/* Insertar a tabla cuota*/
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-01-15','2018-01-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-02-15','2018-02-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-03-15','2018-03-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-04-15','2018-04-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-05-15','2018-05-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-06-15','2018-06-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-07-15','2018-07-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-08-15','2018-08-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-09-15','2018-09-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-10-15','2018-10-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-11-15','2018-11-30');
insert into cuota (monto,interes,estado,fechaDePago,fechaDeVencimiento)values('1000','50',false,'2018-12-15','2018-12-30');

select * from cuota;








