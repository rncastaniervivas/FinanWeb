select * from financiera;
select * from afiliado;
select * from prestamo;
select * from cuota;
select * from afiliado_prestamo;
select * from financiera_prestamo;

insert into financiera (idFinanciera,nombre,montoCapital) values (1,'Naranja',100000);
insert into afiliado (idAfiliado,nombre,apellido,dni,puesto,antiguedad,sueldo,clasificacion) values (1,'Martin','Ale',123456789,null,9,20000,null);
insert into prestamo (idPrestamo,cuotas,estado,interes,valor,afiliado_idAfiliado,financiera_idFinanciera) values (1,6,'activo',0.35,5000,1,null),(2,6,'activo',0.20,5000,null,1);

insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(1,'833','145.8','978.8',true,'2018-07-15','2018-07-30',1,false);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(2,'833','145.8','978.8',true,'2018-08-15','2018-08-30',1,false);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(3,'833','145.8','978.8',true,'2018-09-15','2018-09-30',1,false);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(4,'833','145.8','978.8',false,null,'2018-10-30',1,false);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(5,'833','145.8','978.8',false,null,'2018-11-30',1,false);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(6,'833','145.8','978.8',false,null,'2018-12-30',1,false);

insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(7,'833','83.3','916.3',true,'2018-07-15','2018-07-30',2,false);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(8,'833','83.3','916.3',true,'2018-08-15','2018-08-30',2,false);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(9,'833','83.3','916.3',true,'2018-09-15','2018-09-30',2,false);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(10,'833','83.3','916.3',true,'2018-10-15','2018-10-30',2,false);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(11,'833','83.3','916.3',true,'2018-11-15','2018-11-30',2,false);
insert into cuota (idCuota,monto,interes,montoTotal,estado,fechaDePago,fechaDeVencimiento,prestamo_idPrestamo,cubierto)values(12,'833','83.3','916.3',false,null,'2018-12-30',2,false);

insert into afiliado_prestamo (Afiliado_idAfiliado,prestamo_idPrestamo) values (1,1);
insert into financiera_prestamo (Financiera_idFinanciera,pestamos_idPrestamo) values (1,2);
insert into prestamo_cuota (Prestamo_idPrestamo,cuota_idCuota) values (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(2,7),(2,8),(2,9),(2,10),(2,11),(2,12);

