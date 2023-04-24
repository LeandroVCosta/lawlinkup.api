create database lawlinkup;
use lawlinkup;


create table Canal(
id int primary key auto_increment,
nome varchar(60),
descricao varchar(40));

insert into Canal(nome,descricao) values 
("Redes Sociais", "Navegando pela internet"),
("Pesquisas no Navegador", "Navegando pela internet"),
("Outros","Outras formas de divulgação"),
("Indicação", "Indicação de amigos/colegas");

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Pipefycard` (
  `id`INT AUTO_iNCREMENT NOT NULL,
  `fk_canal` INT NOT NULL,
  `id_pipefy` INT UNSIGNED NOT NULL UNIQUE,
  `nome` VARCHAR(60) NOT NULL,
  `telefone` VARCHAR(20) NULL,
  `email` VARCHAR(60) NULL,
  `card_data` DATETIME NOT NULL DEFAULT NOW(),
  `tipo_cliente` VARCHAR(45) NULL,
  `ativo` TINYINT NULL,
  `p1` VARCHAR(100) NULL,
  `p2` VARCHAR(100) NULL,
  `fase` VARCHAR(15) NULL,
  PRIMARY KEY (`id`),
  foreign key (fk_canal) references Canal(id));
