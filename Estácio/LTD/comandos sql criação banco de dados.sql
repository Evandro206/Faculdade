-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20/05/2025 às 13:24
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `transporte`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_carreta`
--

CREATE TABLE `tb_carreta` (
  `ID_CARRETA` int(11) NOT NULL,
  `DESC_CARRETA` varchar(255) NOT NULL,
  `PLACA_CARRETA` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_carreta`
--

INSERT INTO `tb_carreta` (`ID_CARRETA`, `DESC_CARRETA`, `PLACA_CARRETA`) VALUES
(1, 'carreta1', '12314');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_cavalo`
--

CREATE TABLE `tb_cavalo` (
  `id_cavalo` int(11) NOT NULL,
  `TIPO_CAVALO` varchar(50) NOT NULL,
  `desc_cavalo` varchar(255) NOT NULL,
  `placa_cavalo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_cavalo`
--

INSERT INTO `tb_cavalo` (`id_cavalo`, `TIPO_CAVALO`, `desc_cavalo`, `placa_cavalo`) VALUES
(10, 'Truck', 'Volvo', '123'),
(11, 'bitrem', 'Volvo', '123'),
(12, 'Scania', '1234', '12345');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_cidade`
--

CREATE TABLE `tb_cidade` (
  `ID_CIDADE` int(11) NOT NULL,
  `DESC_CIDADE` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_cidade`
--

INSERT INTO `tb_cidade` (`ID_CIDADE`, `DESC_CIDADE`) VALUES
(1, 'São Paulo'),
(2, 'Rio de Janeiro'),
(3, 'Juiz de Fora'),
(4, 'sp');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_deposito`
--

CREATE TABLE `tb_deposito` (
  `ID_DEPOSITO` int(11) NOT NULL,
  `DESC_DEPOSITO` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_deposito`
--

INSERT INTO `tb_deposito` (`ID_DEPOSITO`, `DESC_DEPOSITO`) VALUES
(1, '123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_fabrica`
--

CREATE TABLE `tb_fabrica` (
  `ID_FABRICA` int(11) NOT NULL,
  `DESC_FABRICA` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_fabrica`
--

INSERT INTO `tb_fabrica` (`ID_FABRICA`, `DESC_FABRICA`) VALUES
(1, '123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_motorista`
--

CREATE TABLE `tb_motorista` (
  `ID_MOTORISTA` int(11) NOT NULL,
  `DESC_MOTORISTA` varchar(255) NOT NULL,
  `ID_SETOR` int(11) DEFAULT NULL,
  `ID_CIDADE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_motorista`
--

INSERT INTO `tb_motorista` (`ID_MOTORISTA`, `DESC_MOTORISTA`, `ID_SETOR`, `ID_CIDADE`) VALUES
(1, 'João Silva', 1, 1),
(2, 'Maria Souza', 2, 2),
(3, 'fabio', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_parada`
--

CREATE TABLE `tb_parada` (
  `ID_PARADA` int(11) NOT NULL,
  `TIPO` enum('ida','volta') NOT NULL,
  `HORA_INICIO` time NOT NULL,
  `HORA_FIM` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_parada`
--

INSERT INTO `tb_parada` (`ID_PARADA`, `TIPO`, `HORA_INICIO`, `HORA_FIM`) VALUES
(3, '', '09:00:00', '09:15:00'),
(4, '', '10:00:00', '10:15:00'),
(5, '', '14:00:00', '14:15:00'),
(6, '', '15:00:00', '15:15:00'),
(7, '', '09:00:00', '09:15:00'),
(8, '', '10:00:00', '10:15:00'),
(9, '', '14:00:00', '14:15:00'),
(10, '', '15:00:00', '15:15:00'),
(11, '', '09:00:00', '09:15:00'),
(12, '', '10:00:00', '10:15:00'),
(13, '', '14:00:00', '14:15:00'),
(14, '', '15:00:00', '15:15:00'),
(15, 'ida', '00:00:00', '00:00:00'),
(16, 'ida', '00:00:00', '00:00:00'),
(17, 'ida', '00:00:00', '00:00:00'),
(18, 'ida', '00:00:00', '00:00:00'),
(19, 'ida', '00:00:00', '00:00:00'),
(20, 'ida', '00:00:00', '00:00:00'),
(21, 'ida', '10:20:00', '10:40:00'),
(22, 'ida', '18:20:00', '19:00:00'),
(23, 'ida', '11:30:00', '12:30:00'),
(24, 'ida', '13:40:00', '15:40:00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_setor`
--

CREATE TABLE `tb_setor` (
  `ID_SETOR` int(11) NOT NULL,
  `DESC_SETOR` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_setor`
--

INSERT INTO `tb_setor` (`ID_SETOR`, `DESC_SETOR`) VALUES
(1, 'Logística'),
(2, 'Operações'),
(3, 'setor1');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_trecho`
--

CREATE TABLE `tb_trecho` (
  `ID_TRECHO` int(11) NOT NULL,
  `HORA_INICIO` time NOT NULL,
  `HORA_FIM` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_trecho`
--

INSERT INTO `tb_trecho` (`ID_TRECHO`, `HORA_INICIO`, `HORA_FIM`) VALUES
(2, '08:00:00', '12:00:00'),
(3, '13:00:00', '17:30:00'),
(4, '08:00:00', '12:00:00'),
(5, '13:00:00', '17:30:00'),
(6, '08:00:00', '12:00:00'),
(7, '13:00:00', '17:30:00'),
(8, '00:00:00', '00:00:00'),
(9, '00:00:00', '00:00:00'),
(10, '00:00:00', '00:00:00'),
(11, '00:00:00', '00:00:00'),
(12, '00:00:00', '00:00:00'),
(13, '00:00:00', '00:00:00'),
(14, '00:00:00', '00:00:00'),
(15, '00:00:00', '00:00:00'),
(16, '00:00:00', '00:00:00'),
(17, '00:00:00', '00:00:00'),
(18, '08:17:00', '10:20:00'),
(19, '10:40:00', '11:30:00'),
(20, '15:40:00', '18:20:00'),
(21, '19:00:00', '16:00:00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tb_viagem`
--

CREATE TABLE `tb_viagem` (
  `ID_VIAGEM` int(11) NOT NULL,
  `ID_MOTORISTA` int(11) DEFAULT NULL,
  `ID_CAVALO` int(11) DEFAULT NULL,
  `ID_CARRETA` int(11) DEFAULT NULL,
  `ID_DEPOSITO` int(11) DEFAULT NULL,
  `ID_FABRICA` int(11) DEFAULT NULL,
  `DATA_SAIDA` date DEFAULT NULL,
  `HORA_SAIDA` time DEFAULT NULL,
  `DATA_CHEGADA` date DEFAULT NULL,
  `HORA_CHEGADA` time DEFAULT NULL,
  `DIARIA` decimal(10,2) DEFAULT NULL,
  `ATUALIZADO` tinyint(1) DEFAULT NULL,
  `TRECHOS` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL CHECK (json_valid(`TRECHOS`)),
  `PARADAS` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL CHECK (json_valid(`PARADAS`))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `tb_viagem`
--

INSERT INTO `tb_viagem` (`ID_VIAGEM`, `ID_MOTORISTA`, `ID_CAVALO`, `ID_CARRETA`, `ID_DEPOSITO`, `ID_FABRICA`, `DATA_SAIDA`, `HORA_SAIDA`, `DATA_CHEGADA`, `HORA_CHEGADA`, `DIARIA`, `ATUALIZADO`, `TRECHOS`, `PARADAS`) VALUES
(10, 1, 10, 1, 1, 1, '2025-05-17', '08:00:00', NULL, NULL, NULL, NULL, NULL, NULL),
(15, 1, 10, 1, 1, 1, '2025-05-17', '08:00:00', '2025-05-17', '17:30:00', NULL, NULL, NULL, NULL),
(16, 1, 10, 1, 1, 1, '2025-05-17', '08:00:00', '2025-05-17', '17:30:00', NULL, NULL, '{\"ida\":[\"4\"],\"volta\":[\"5\"]}', '{\"ida\":[\"7\",\"8\"],\"volta\":[\"9\",\"10\"]}'),
(20, 1, 10, 1, 1, 1, '2025-01-01', '08:00:00', '2025-05-17', '17:30:00', NULL, NULL, '{\"ida\":[\"6\"],\"volta\":[\"7\"]}', '{\"ida\":[\"11\",\"12\"],\"volta\":[\"13\",\"14\"]}'),
(22, 1, 11, 1, 1, 1, '0001-01-01', '00:00:00', NULL, NULL, NULL, NULL, '{\"ida\":[\"8\",\"9\"],\"volta\":[\"10\",\"11\"]}', '{\"ida\":[\"15\"],\"volta\":[\"16\"]}'),
(23, 1, 11, 1, 1, 1, '0001-01-01', '00:00:00', NULL, NULL, NULL, NULL, '{\"ida\":[\"12\",\"13\",\"14\",\"15\"],\"volta\":[\"16\",\"17\"]}', '{\"ida\":[\"17\",\"18\",\"19\"],\"volta\":[\"20\"]}'),
(24, 3, 10, 1, 1, 1, '2025-05-20', '08:17:00', NULL, NULL, NULL, NULL, '{\"ida\":[\"18\",\"19\"],\"volta\":[\"20\",\"21\"]}', '{\"ida\":[\"21\"],\"volta\":[\"22\",\"23\",\"24\"]}');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `tb_carreta`
--
ALTER TABLE `tb_carreta`
  ADD PRIMARY KEY (`ID_CARRETA`);

--
-- Índices de tabela `tb_cavalo`
--
ALTER TABLE `tb_cavalo`
  ADD PRIMARY KEY (`id_cavalo`);

--
-- Índices de tabela `tb_cidade`
--
ALTER TABLE `tb_cidade`
  ADD PRIMARY KEY (`ID_CIDADE`);

--
-- Índices de tabela `tb_deposito`
--
ALTER TABLE `tb_deposito`
  ADD PRIMARY KEY (`ID_DEPOSITO`);

--
-- Índices de tabela `tb_fabrica`
--
ALTER TABLE `tb_fabrica`
  ADD PRIMARY KEY (`ID_FABRICA`);

--
-- Índices de tabela `tb_motorista`
--
ALTER TABLE `tb_motorista`
  ADD PRIMARY KEY (`ID_MOTORISTA`),
  ADD KEY `ID_SETOR` (`ID_SETOR`),
  ADD KEY `ID_CIDADE` (`ID_CIDADE`);

--
-- Índices de tabela `tb_parada`
--
ALTER TABLE `tb_parada`
  ADD PRIMARY KEY (`ID_PARADA`);

--
-- Índices de tabela `tb_setor`
--
ALTER TABLE `tb_setor`
  ADD PRIMARY KEY (`ID_SETOR`);

--
-- Índices de tabela `tb_trecho`
--
ALTER TABLE `tb_trecho`
  ADD PRIMARY KEY (`ID_TRECHO`);

--
-- Índices de tabela `tb_viagem`
--
ALTER TABLE `tb_viagem`
  ADD PRIMARY KEY (`ID_VIAGEM`),
  ADD KEY `ID_MOTORISTA` (`ID_MOTORISTA`),
  ADD KEY `ID_CAVALO` (`ID_CAVALO`),
  ADD KEY `ID_DEPOSITO` (`ID_DEPOSITO`),
  ADD KEY `ID_FABRICA` (`ID_FABRICA`),
  ADD KEY `ID_CARRETA` (`ID_CARRETA`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tb_carreta`
--
ALTER TABLE `tb_carreta`
  MODIFY `ID_CARRETA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tb_cavalo`
--
ALTER TABLE `tb_cavalo`
  MODIFY `id_cavalo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `tb_cidade`
--
ALTER TABLE `tb_cidade`
  MODIFY `ID_CIDADE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tb_deposito`
--
ALTER TABLE `tb_deposito`
  MODIFY `ID_DEPOSITO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tb_fabrica`
--
ALTER TABLE `tb_fabrica`
  MODIFY `ID_FABRICA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tb_motorista`
--
ALTER TABLE `tb_motorista`
  MODIFY `ID_MOTORISTA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_parada`
--
ALTER TABLE `tb_parada`
  MODIFY `ID_PARADA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de tabela `tb_setor`
--
ALTER TABLE `tb_setor`
  MODIFY `ID_SETOR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tb_trecho`
--
ALTER TABLE `tb_trecho`
  MODIFY `ID_TRECHO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de tabela `tb_viagem`
--
ALTER TABLE `tb_viagem`
  MODIFY `ID_VIAGEM` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `tb_motorista`
--
ALTER TABLE `tb_motorista`
  ADD CONSTRAINT `tb_motorista_ibfk_1` FOREIGN KEY (`ID_SETOR`) REFERENCES `tb_setor` (`ID_SETOR`),
  ADD CONSTRAINT `tb_motorista_ibfk_2` FOREIGN KEY (`ID_CIDADE`) REFERENCES `tb_cidade` (`ID_CIDADE`);

--
-- Restrições para tabelas `tb_viagem`
--
ALTER TABLE `tb_viagem`
  ADD CONSTRAINT `tb_viagem_ibfk_1` FOREIGN KEY (`ID_MOTORISTA`) REFERENCES `tb_motorista` (`ID_MOTORISTA`),
  ADD CONSTRAINT `tb_viagem_ibfk_2` FOREIGN KEY (`ID_CAVALO`) REFERENCES `tb_cavalo` (`id_cavalo`),
  ADD CONSTRAINT `tb_viagem_ibfk_3` FOREIGN KEY (`ID_DEPOSITO`) REFERENCES `tb_deposito` (`ID_DEPOSITO`),
  ADD CONSTRAINT `tb_viagem_ibfk_4` FOREIGN KEY (`ID_FABRICA`) REFERENCES `tb_fabrica` (`ID_FABRICA`),
  ADD CONSTRAINT `tb_viagem_ibfk_5` FOREIGN KEY (`ID_CARRETA`) REFERENCES `tb_carreta` (`ID_CARRETA`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
