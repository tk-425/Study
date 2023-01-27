create table person
(
	id integer not null,
	name varchar(255) not null,
	location varchar(255),
	birth_date DATE,
	primary key(id)
);

insert into person (id, name, location, birth_date) values ( 1001, 'Tom', 'DC', '1999-02-15' );
insert into person (id, name, location, birth_date) values ( 1002, 'James', 'NY', '1992-06-11' );
insert into person (id, name, location, birth_date) values ( 1003, 'Michael', 'VA', '1979-04-05' );
insert into person (id, name, location, birth_date) values ( 1004, 'Steve', 'MA', '1969-12-25' );
insert into person (id, name, location, birth_date) values ( 1005, 'James', 'CA', '1996-11-24' );
insert into person (id, name, location, birth_date) values ( 1006, 'Steve', 'MA', '1969-12-25' );
insert into person (id, name, location, birth_date) values ( 1007, 'George', 'NY', '1983-12-25' );
insert into person (id, name, location, birth_date) values ( 1008, 'Jimmy', 'MA', '1989-12-22' );
insert into person (id, name, location, birth_date) values ( 1009, 'Bill', 'MA', '1959-01-15' );



