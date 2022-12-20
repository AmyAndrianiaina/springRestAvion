\c postgres

DROP DATABASE avion;

CREATE DATABASE avion; 

\c avion

CREATE TABLE avion
(
	id serial primary key,
	assurance date,
	dateentretien date,
	km int
);

INSERT INTO avion
(assurance, dateentretien, km)
VALUES
('2023-01-01','2022-01-10',100000),
('2023-01-13','2022-02-10',200000),
('2023-02-03','2022-03-10',300000),
('2023-04-04','2022-04-10',400000),
('2023-05-05','2022-05-10',500000);

CREATE TABLE utilisateur
(
	id serial primary key,
	name varchar(50),
	username varchar(50),
	email varchar(50),
	password varchar(50)
);

INSERT INTO utilisateur
(name, username, email, password)
VALUES
('Rakoto Ny Fitia','fitia','fitia@gmail.com','fitiamdp'),
('Randia Nary','nary','nary@gmail.com','narymdp'),
('Andria Amy ','amy','amy@gmail.com','amymdp'),
('Rabe Lahatra','lahatra','lahatra@gmail.com','lahatramdp'),
('Razana Ando','ando','ando@gmail.com','andomdp');