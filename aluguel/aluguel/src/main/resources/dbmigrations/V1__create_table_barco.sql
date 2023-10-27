CREATE TABLE `barcos` (
  `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `marca` varchar(255),
  `anoFabr` date NOT NULL,
  `disponibilidade` enum('DISPONÌVEL','INDISPONÌVEL','CONSERTO') NOT NULL,
  `tipo_barco_id` bigint NOT NULL,
  FOREIGN KEY (`tipo_barco_id`) REFERENCES `tipo_barco` (`id`)
);
