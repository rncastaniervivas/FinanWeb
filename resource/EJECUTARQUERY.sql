insert into afiliado (idAfiliado,nombre,apellido,dni,puesto,antiguedad,sueldo,clasificacion) values (1,'Martin','Ale',12345678,'','3',10000,null);
insert into afiliado (idAfiliado,nombre,apellido,dni,puesto,antiguedad,sueldo,clasificacion) values (2,'Daniel','Ramoz',87654321,'','2',10000,null);
insert into afiliado (idAfiliado,nombre,apellido,dni,puesto,antiguedad,sueldo,clasificacion) values (3,'Alex','Diaz',99654321,'','5',10000,null);
-- insert into afiliado (idAfiliado,nombre,apellido,dni,puesto,antiguedad,sueldo,clasificacion) values (3,'Mutual','Mutual',90000000,'','1',10000,null);


INSERT INTO `db_finan`.`usuario`(`email`,`password`,`rol`,`dni`)VALUES("usuario1@usuario.com",12345,"cliente",12345678);
INSERT INTO `db_finan`.`usuario`(`email`,`password`,`rol`,`dni`)VALUES("usuario2@usuario.com",12345,"cliente",87654321);
INSERT INTO `db_finan`.`usuario`(`email`,`password`,`rol`,`dni`)VALUES("usuario3@usuario.com",12345,"cliente",99654321);
INSERT INTO `db_finan`.`usuario`(`email`,`password`,`rol`,`dni`)VALUES("mutual@mutual.com",12345,"mutual",90000000);
select * from prestamo;

