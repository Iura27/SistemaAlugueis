CREATE TABLE `aluguel` (
  `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `dataInicio` date NOT NULL,
  `dataFim` date NOT NULL,
  `valor` double NOT NULL,
  `cliente_id` bigint NOT NULL,
  `barco_id` bigint NOT NULL,
  FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`),
  FOREIGN KEY (`barco_id`) REFERENCES `barcos` (`id`)
);
