DROP TABLE IF EXISTS personajes_peliculas;
create table if not exists personajes_peliculas(
	id_pelicula int not null,
	id_personaje int not null
);

DROP TABLE IF EXISTS peliculas;
create table if not exists peliculas(
	id SERIAL not null,
	imagen BYTEA,
	titulo VARCHAR(45),
	fecha_creacion TIMESTAMP,
	id_genero int not null,
	id_calificacion int not null
);

DROP TABLE IF EXISTS calificaciones;
create table if not exists calificaciones(
	id SERIAL not null,
	calificacion int not null
);

DROP TABLE IF EXISTS generos;
create table if not exists generos(
	id SERIAL not null,
	nombre VARCHAR(45) not null,
	imagen BYTEA
);
DROP TABLE IF EXISTS personajes;
create table  IF NOT EXISTS personajes(
	id SERIAL not null,
	nombre VARCHAR(45) not null,
	imagen bytea,
	edad INT not null,
	peso INT,
	historia VARCHAR(100) not null
);

DROP TABLE IF EXISTS usuarios;
create table if not exists usuarios(
	id SERIAL not null,
	username VARCHAR(45) not null,
	email VARCHAR(45) not null,
	passwordd VARCHAR(45) not null,
	rol VARCHAR(45) not NULL,
	lockedd bool not null,
	enablee bool not null
);


alter table public.peliculas
add constraint fk_generos_peliculas
foreign key (id_genero)
references generos(id);

alter table public.peliculas
add constraint fk_calificaciones_peliculas
foreign key (id_calificacion)
references calificaciones(id);

alter table public.personajes_peliculas
add constraint fk_personajes_personajes_peliculas
foreign key (id_personaje)
references personajes(id);

alter table public.personajes_peliculas
add constraint fk_series_personajes_peliculas
foreign key (id_pelicula)
references peliculas(id);



insert into personajes(id,nombre, edad,peso, historia)
values (1,'Nelson', 21,12, 'Persona con historia normal');

insert into personajes(id,nombre,  edad,peso, historia)
values (2,'Gustavo',  27, 12,'Persona con historia triste');

insert into personajes(id,nombre, edad, peso,historia)
values (3,'Cristian', 26,12, 'Persona con historia Feliz');

insert into calificaciones(calificacion)
values (1);

insert into calificaciones(calificacion)
values (2);

insert into calificaciones(calificacion)
values (3);

insert into calificaciones(calificacion)
values (4);

insert into calificaciones(calificacion)
values (5);

insert into generos(nombre)
values ('Terror');

insert into generos(nombre)
values ('Romance');

insert into generos(nombre)
values ('Accion');

insert into peliculas(titulo,fecha_creacion,id_genero,id_calificacion)
values ('Conjuro',TO_TIMESTAMP('10/08/2009','DD/MM/YYYY'), 1,3);


insert into peliculas(titulo,fecha_creacion,id_genero,id_calificacion)
values ('It',TO_TIMESTAMP('10/08/2008','DD/MM/YYYY'), 1,4);


--insert into peliculas(imagen,titulo,fecha_creacion,id_genero,id_calificacion)
--values (bytea('C:/Users/Nelson/Downloads/promance1.jpg'),'Romance 1',TO_TIMESTAMP('10/08/2012','DD/MM/YYYY'), 2,5);

--insert into peliculas(imagen,titulo,fecha_creacion,id_genero,id_calificacion)
--values (bytea('C:/Users/Nelson/Downloads/jhon.jpg'),'Jhon',TO_TIMESTAMP('10/08/2014','DD/MM/YYYY'), 3,5);

--insert into peliculas(imagen,titulo,fecha_creacion,id_genero,id_calificacion)
--values (bytea('C:/Users/Nelson/Downloads/conjuro2.jpg'),'Conjuro parte final',TO_TIMESTAMP('10/08/2020','DD/MM/YYYY'), 1,5);


insert into personajes_peliculas(id_pelicula,id_personaje)
values (1,1);
insert into personajes_peliculas(id_pelicula,id_personaje)
values (2,2);

insert into personajes_peliculas(id_pelicula,id_personaje)
values (2,3);



insert into public.usuarios(id,username,email,passwordd,rol, lockedd, enablee)
values (1,'nedacort','nelsondmondragon@gmail.com', '1234', 'USER', false, true);


