CREATE TABLE `cliente` (
  `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `endereco` varchar(255) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `tipoUsuario` enum('ADMINISTRADOR','CLIENTE','FUNCIONARIO') NOT NULL,
);
