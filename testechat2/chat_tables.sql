drop database if exists testechat;
create database testechat;
use testechat;

CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `socket_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `mensagem` (
  `id_mensagem` int NOT NULL AUTO_INCREMENT,
  `mensagem` varchar(50) DEFAULT NULL,
  `fk_remetente` int DEFAULT NULL,
  `fk_destinatario` int DEFAULT NULL,
  PRIMARY KEY (`id_mensagem`),
  KEY `fk_remetente` (`fk_remetente`),
  KEY `fk_destinatario` (`fk_destinatario`),
  CONSTRAINT `mensagem_ibfk_1` FOREIGN KEY (`fk_remetente`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `mensagem_ibfk_2` FOREIGN KEY (`fk_destinatario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;