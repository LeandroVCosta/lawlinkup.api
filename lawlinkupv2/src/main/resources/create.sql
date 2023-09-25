
CREATE DATABASE lawlinkup;
CREATE TABLE IF NOT EXISTS `lawlinkup`.`tipo_usuario` (
  `id_tipo` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo`));


CREATE TABLE IF NOT EXISTS `lawlinkup`.`assinatura` (
  `id_assinatura` INT NOT NULL,
  `data_inicio` DATETIME NOT NULL,
  `data_termino` DATETIME NOT NULL,
  PRIMARY KEY (`id_assinatura`));

CREATE TABLE IF NOT EXISTS `lawlinkup`.`usuario` (
  `idUsuario` INT NOT NULL,
  `fk_tipo` INT NOT NULL,
  `fk_assinatura` INT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `senha` VARCHAR(60) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `contato` VARCHAR(12) NOT NULL,
  `ultima_sessao` DATETIME NOT NULL,
  `cep` CHAR(8) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(20) NOT NULL,
  `numero` VARCHAR(5) NOT NULL,
  `status_assinatura` BINARY NULL,
  `data_criacao` DATETIME NULL,
  `foto_url` VARCHAR(100) NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_Usuario_assinatura1_idx` (`fk_assinatura` ASC) VISIBLE,
  INDEX `fk_usuario_tipo_usuario1_idx` (`fk_tipo` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_assinatura1`
    FOREIGN KEY (`fk_assinatura`)
    REFERENCES `lawlinkup`.`assinatura` (`id_assinatura`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_tipo_usuario1`
    FOREIGN KEY (`fk_tipo`)
    REFERENCES `lawlinkup`.`tipo_usuario` (`id_tipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`cliente` (
  `id_cliente` INT NOT NULL,
  `fk_usuario` INT NOT NULL,
  `profissao` VARCHAR(45) NULL,
  `estado_civil` VARCHAR(45) NULL,
  `nascimento` VARCHAR(45) NULL,
  `sexo` VARCHAR(45) NULL,
  PRIMARY KEY (`id_cliente`, `fk_usuario`),
  INDEX `fk_cliente_usuario1_idx` (`fk_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_usuario1`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `lawlinkup`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`advogado` (
  `id_advogado` INT NOT NULL,
  `fk_usuario` INT NOT NULL,
  `foto_oab_url` VARCHAR(200) NULL,
  `numero_oab` VARCHAR(45) NULL,
  `sobre` VARCHAR(200) NULL,
  `especializacao` VARCHAR(40) NULL,
  PRIMARY KEY (`id_advogado`, `fk_usuario`),
  INDEX `fk_advogado_usuario1_idx` (`fk_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_advogado_usuario1`
    FOREIGN KEY (`fk_usuario`)
    REFERENCES `lawlinkup`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`caso` (
  `id_caso` INT NOT NULL,
  `fk_cliente` INT NOT NULL,
  `servico` VARCHAR(40) NOT NULL,
  `especificacao` VARCHAR(45) NOT NULL,
  `detalhamento` VARCHAR(200) NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  `ativo` BINARY NOT NULL,
  PRIMARY KEY (`id_caso`, `fk_cliente`),
  INDEX `fk_caso_cliente1_idx` (`fk_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_caso_cliente1`
    FOREIGN KEY (`fk_cliente`)
    REFERENCES `lawlinkup`.`cliente` (`fk_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`vinculo` (
  `id_vinculo` INT NOT NULL,
  `fk_caso` INT NOT NULL,
  `fk_advogado` INT NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  `avaliacao` TINYINT NULL,
  `prazo_final` DATETIME NULL,
  PRIMARY KEY (`id_vinculo`, `fk_caso`, `fk_advogado`),
  INDEX `fk_vinculo_caso1_idx` (`fk_caso` ASC) VISIBLE,
  INDEX `fk_vinculo_advogado1_idx` (`fk_advogado` ASC) VISIBLE,
  CONSTRAINT `fk_vinculo_caso1`
    FOREIGN KEY (`fk_caso`)
    REFERENCES `lawlinkup`.`caso` (`id_caso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vinculo_advogado1`
    FOREIGN KEY (`fk_advogado`)
    REFERENCES `lawlinkup`.`advogado` (`id_advogado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`status` (
  `id_status` INT NOT NULL,
  `nome` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_status`));

CREATE TABLE IF NOT EXISTS `lawlinkup`.`historico` (
  `id_historico` INT NOT NULL auto_increment,
  `fk_vinculo` INT NOT NULL,
  `fk_status` INT NOT NULL,
  `data_alteracao` DATETIME NOT NULL,
  PRIMARY KEY (`id_historico`),
  INDEX `fk_HistoricoCaso_Caso1_idx` (`fk_vinculo` ASC) VISIBLE,
  INDEX `fk_HistoricoCaso_Status1_idx` (`fk_status` ASC) VISIBLE,
  CONSTRAINT `fk_HistoricoCaso_Caso1`
    FOREIGN KEY (`fk_vinculo`)
    REFERENCES `lawlinkup`.`vinculo` (`id_vinculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_HistoricoCaso_Status1`
    FOREIGN KEY (`fk_status`)
    REFERENCES `lawlinkup`.`status` (`id_status`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`mensagem` (
  `id_mensagem` INT NOT NULL,
  `fk_vinculo` INT NOT NULL,
  `mensagem` VARCHAR(255) NOT NULL,
  `data` DATETIME NOT NULL,
  `remetente` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_mensagem`),
  INDEX `fk_Mensagens_Caso1_idx` (`fk_vinculo` ASC) VISIBLE,
  CONSTRAINT `fk_Mensagens_Caso1`
    FOREIGN KEY (`fk_vinculo`)
    REFERENCES `lawlinkup`.`vinculo` (`id_vinculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`pagamento` (
  `id_pagamento` INT NOT NULL,
  `fk_caso` INT NOT NULL,
  `status` BINARY NOT NULL,
  `forma` VARCHAR(20) NOT NULL,
  `orcamento` DECIMAL(9,2) NOT NULL,
  PRIMARY KEY (`id_pagamento`),
  INDEX `fk_Pagamento_Caso1_idx` (`fk_caso` ASC) VISIBLE,
  CONSTRAINT `fk_Pagamento_Caso1`
    FOREIGN KEY (`fk_caso`)
    REFERENCES `lawlinkup`.`vinculo` (`id_vinculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
select * from caso;