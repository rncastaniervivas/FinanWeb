create database db_finan;
use db_finan;

create table financiera(
	id integer,
	nombre varchar(50) not null
);

insert into financiera (id,nombre) values (1,'Naranja');

select * from financiera;