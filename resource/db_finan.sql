
/* Insertar a tabla financiera 
insert into financiera (nombre) values ('Naranja');
insert into financiera (nombre) values ('Santander Rio');
insert into financiera (nombre) values ('Galicia');

select * from financiera;
*/
/* Insertar a la tabla afiliado */
insert into afiliado (idAfiliado,nombre,apellido,dni,puesto,antiguedad,sueldo,clasificacion) values (1,'Martin','Ale',12345678,'','3',10000,null);
insert into afiliado (idAfiliado,nombre,apellido,dni,puesto,antiguedad,sueldo,clasificacion) values (2,'Daniel','Ramoz',87654321,'','2',10000,null);
insert into afiliado (idAfiliado,nombre,apellido,dni,puesto,antiguedad,sueldo,clasificacion) values (3,'Alex','Diaz',99654321,'','5',10000,null);
-- insert into afiliado (idAfiliado,nombre,apellido,dni,puesto,antiguedad,sueldo,clasificacion) values (3,'Mutual','Mutual',90000000,'','1',10000,null);


INSERT INTO `db_finan`.`usuario`(`email`,`password`,`rol`,`dni`)VALUES("usuario1@usuario.com",12345,"cliente",12345678);
INSERT INTO `db_finan`.`usuario`(`email`,`password`,`rol`,`dni`)VALUES("usuario2@usuario.com",12345,"cliente",87654321);
INSERT INTO `db_finan`.`usuario`(`email`,`password`,`rol`,`dni`)VALUES("usuario3@usuario.com",12345,"cliente",99654321);
INSERT INTO `db_finan`.`usuario`(`email`,`password`,`rol`,`dni`)VALUES("mutual@mutual.com",12345,"mutual",90000000);
select *from prestamo;

/* Insertar a la tabla prestamo */
insert into prestamo (idPrestamo,cuotas,dni,estado,interes,valor,afiliado_idAfiliado,financiera_idFinanciera) values (1,6,12345678,"aprobado",120,10000,1,null);

-- select * from prestamo;
select * from prestamo;
/* insert a la tabla que relaciona afiliado con prestamos */
insert into afiliado_prestamo (Afiliado_idAfiliado,prestamo_idPrestamo) values (1,1);
select * from afiliado_prestamo;

/* Insertar a tabla cuota*/
insert into cuota (idCuota,estado,fechaDePago,fechaDeVencimiento,interes,monto,montoTotal,prestamo_idPrestamo) values (1,null,'2018-01-15','10','1000',1010,1);
insert into prestamo_cuota(Prestamo_idAfiliado,Cuota_idCuota) values (1,1);

select * from cuota;



