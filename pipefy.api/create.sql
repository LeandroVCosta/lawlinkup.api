create database teste;
use teste;

create table clientespipefy (
id int primary key auto_increment,
card_id int unique,
nome varchar(45),
email  varchar(50),
telefone varchar(30),
tipo varchar(10),
fonte varchar(25),
ativo BOOLEAN,
p1 varchar(100),
p2 varchar(100),
fase varchar(15));