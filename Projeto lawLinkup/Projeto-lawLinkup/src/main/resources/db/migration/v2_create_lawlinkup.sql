DROP DATABASE IF EXISTS lawlinkup;
CREATE DATABASE lawlinkup;

CREATE TABLE IF NOT EXISTS `lawlinkup`.`tipo_usuario` (
  `id_tipo` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_tipo`));

  CREATE TABLE IF NOT EXISTS `lawlinkup`.`assinatura` (
  `id_assinatura` INT NOT NULL AUTO_INCREMENT,
  `data_inicio` DATETIME NOT NULL,
  `data_termino` DATETIME NOT NULL,
  PRIMARY KEY (`id_assinatura`));

CREATE TABLE IF NOT EXISTS `lawlinkup`.`usuario` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `fk_tipo` INT NOT NULL,
  `fk_assinatura` INT NULL,
  `nome` VARCHAR(80) NOT NULL,
  `senha` VARCHAR(60) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `contato` VARCHAR(12) NOT NULL,
  `ultima_sessao` DATE NULL,
  `cep` CHAR(8) NOT NULL,
  `cidade` VARCHAR(60) NOT NULL,
  `bairro` VARCHAR(60) NOT NULL,
  `numero` VARCHAR(5) NOT NULL,
  `status_assinatura` BOOLEAN NULL,
  `data_criacao` DATETIME NULL,
  `foto_url` VARCHAR(100) NULL,
  `profissao` VARCHAR(45) NULL,
  `estado_civil` VARCHAR(45) NULL,
  `data_nascimento` VARCHAR(45) NULL,
  `sexo` VARCHAR(45) NULL,
  `foto_oab_url` VARCHAR(100) NULL,
  `numero_oab` VARCHAR(45) NULL,
  `sobre` VARCHAR(45) NULL,
  `especializacao` VARCHAR(45) NULL,
  `visitas` VARCHAR(45) NULL,
  `socket_id` varchar(50) UNIQUE NULL,
  PRIMARY KEY (`id_usuario`),
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

CREATE TABLE IF NOT EXISTS `lawlinkup`.`caso` (
  `id_caso` INT NOT NULL AUTO_INCREMENT,
  `fk_cliente` INT NOT NULL,
  `servico` VARCHAR(40) NOT NULL,
  `especificacao` VARCHAR(45) NOT NULL,
  `detalhamento` VARCHAR(200) NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  `ativo` BINARY NOT NULL,
  PRIMARY KEY (`id_caso`),
  INDEX `fk_caso_cliente1_idx` (`fk_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_caso_cliente1`
    FOREIGN KEY (`fk_cliente`)
    REFERENCES `lawlinkup`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS `lawlinkup`.`vinculo` (
  `id_vinculo` INT NOT NULL AUTO_INCREMENT,
  `fk_caso` INT NOT NULL,
  `fk_advogado` INT NOT NULL,
  `data_criacao` DATETIME NOT NULL,
  `avaliacao` TINYINT NULL,
  `situacao` varchar(20) null,
  `comentario` varchar(200) null,
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
    REFERENCES `lawlinkup`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `lawlinkup`.`registro` (
  `id_historico` INT NOT NULL AUTO_INCREMENT,
  `fk_vinculo` INT NOT NULL,
  `status` VARCHAR(50) NOT NULL,
  `data_alteracao` DATETIME NOT NULL,
  PRIMARY KEY (`id_historico`),
  INDEX `fk_HistoricoCaso_Caso1_idx` (`fk_vinculo` ASC) VISIBLE,
  CONSTRAINT `fk_HistoricoCaso_Caso1`
    FOREIGN KEY (`fk_vinculo`)
    REFERENCES `lawlinkup`.`vinculo` (`id_vinculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `lawlinkup`.`orcamento` (
  `id_orcamento` INT NOT NULL AUTO_INCREMENT,
  `fk_vinculo` INT NOT NULL,
  `valor_orcamento` DECIMAL(9,2) NOT NULL,
  `prazo_final` DATE not null,
  PRIMARY KEY (`id_orcamento`),
  INDEX `fk_Pagamento_Caso1_idx` (`fk_vinculo` ASC) VISIBLE,
  CONSTRAINT `fk_Pagamento_Caso1`
    FOREIGN KEY (`fk_vinculo`)
    REFERENCES `lawlinkup`.`vinculo` (`id_vinculo`)
    ON DELETE NO ACTION
    ON UPDATE NO action);

CREATE TABLE IF NOT EXISTS `lawlinkup`.`mensagem` (
  `id_mensagem` INT NOT NULL AUTO_INCREMENT,
  `fk_vinculo` INT NOT NULL,
  `fk_remetente` INT NOT NULL,
  `fk_destinatario` INT NOT NULL,
  `mensagem` VARCHAR(255) NOT NULL,
  `data` DATETIME NOT NULL,
  PRIMARY KEY (`id_mensagem`),
  INDEX `fk_Mensagens_Caso1_idx` (`fk_vinculo` ASC) VISIBLE,
  CONSTRAINT `fk_Mensagens_Caso1`
    FOREIGN KEY (`fk_vinculo`)
    REFERENCES `lawlinkup`.`vinculo` (`id_vinculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
 CONSTRAINT `fk_rementente_id`
	FOREIGN KEY (`fk_remetente`)
	REFERENCES `lawlinkup`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_destinatario_id`
	FOREIGN KEY (`fk_destinatario`)
	REFERENCES `lawlinkup`.`usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);