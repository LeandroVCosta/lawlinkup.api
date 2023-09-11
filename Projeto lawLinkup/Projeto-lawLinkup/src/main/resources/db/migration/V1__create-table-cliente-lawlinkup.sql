'CREATE DATABASE `lawlinkup`;
USE `lawlinkup`;
CREATE TABLE IF NOT EXISTS `lawlinkup`.`Assinatura` (
  `id_assinatura` INT NOT NULL auto_increment,
  `data_inicio` DATETIME NOT NULL,
  `data_termino` DATETIME NOT NULL,
  PRIMARY KEY (`id_assinatura`)
);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Advogado` (
  `id_advogado` INT NOT NULL auto_increment,
  `fk_assinatura` INT ,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `cpf` CHAR(11) NOT NULL,
  `contato` CHAR(11) NOT NULL,
  `status_assinatura` BINARY NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  `foto_url` VARCHAR(45) ,
  `foto_oab` VARBINARY(255) ,
  `numero_oab` VARCHAR(10) NOT NULL,
  `sobre` VARCHAR(255),
  `especializacao` VARCHAR(45),
  `ultima_sessao` DATETIME,
  PRIMARY KEY (`id_advogado`),
  FOREIGN KEY (`fk_assinatura`)
    REFERENCES `lawlinkup`.`Assinatura` (`id_assinatura`)
);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Cliente` (
  `id_cliente` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `contato` CHAR(11) NOT NULL,
  `ultima_sessao` DATETIME,
  `cep` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `numero` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cliente`)
);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Caso` (
  `id_caso` INT NOT NULL auto_increment,
  `fk_cliente` INT NOT NULL,
  `servico` VARCHAR(30) NOT NULL,
  `especificacao` VARCHAR(45) NOT NULL,
  `detalhamento` VARCHAR(200) NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  `ativo` BINARY NOT NULL,
  PRIMARY KEY (`id_caso`),
  FOREIGN KEY (`fk_cliente`)
    REFERENCES `lawlinkup`.`Cliente` (`id_cliente`)
);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Vinculo` (
  `id_vinculo` INT NOT NULL auto_increment,
  `fk_caso` INT NOT NULL,
  `fk_advogado` INT NOT NULL,
  `fk_cliente` INT NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  `avaliacao` TINYINT,
  `orcamento` VARCHAR(45),
  PRIMARY KEY (`id_vinculo`),
  FOREIGN KEY (`fk_caso`)
    REFERENCES `lawlinkup`.`Caso` (`id_caso`),
  FOREIGN KEY (`fk_advogado`)
    REFERENCES `lawlinkup`.`Advogado` (`id_advogado`),
    FOREIGN KEY (`fk_cliente`)
    REFERENCES `lawlinkup`.`Cliente` (`id_cliente`)
);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Pagamento` (
  `id_pagamento` INT NOT NULL auto_increment,
  `fk_caso` INT NOT NULL,
  `status` BINARY NOT NULL,
  `forma` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pagamento`),
  FOREIGN KEY (`fk_caso`)
    REFERENCES `lawlinkup`.`Vinculo` (`id_vinculo`)
);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Mensagens` (
  `id_mensagem` INT NOT NULL,
  `fk_caso` INT NOT NULL,
  `mensagem` VARCHAR(255) NOT NULL,
  `data` DATETIME NOT NULL,
  `remetente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_mensagem`),
  FOREIGN KEY (`fk_caso`)
    REFERENCES `lawlinkup`.`Vinculo` (`id_vinculo`)
);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Status` (
  `id_status` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id_status`)
);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Alterações` (
  `id_alteracao` INT NOT NULL,
  `fk_caso` INT NOT NULL,
  `fk_status` INT NOT NULL,
  `data` DATETIME NOT NULL,
  PRIMARY KEY (`id_alteracao`),
  FOREIGN KEY (`fk_caso`)
    REFERENCES `lawlinkup`.`Vinculo` (`id_vinculo`),
  FOREIGN KEY (`fk_status`)
    REFERENCES `lawlinkup`.`Status` (`id_status`)
);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Canal` (
  `id` INT NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `desc` VARCHAR(15),
  PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`Pipefycard` (
  `id` INT NOT NULL,
  `fk_canal` INT NOT NULL,
  `id_pipefy` INT UNSIGNED NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `telefone` CHAR(12),
  `email` VARCHAR(60),
  `card_data` DATETIME NOT NULL,
  `tipo_cliente` VARCHAR(45),
  `ativo` TINYINT,
  `p1` VARCHAR(100),
  `p2` VARCHAR(100),
  `fase` VARCHAR(15),
  PRIMARY KEY (`id`),
  FOREIGN KEY (`fk_canal`)
    REFERENCES `lawlinkup`.`Canal` (`id`)
);'