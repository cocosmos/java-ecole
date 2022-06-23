-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 23, 2022 at 09:45 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecole_clean`
--

-- --------------------------------------------------------

--
-- Table structure for table `chambre`
--

DROP TABLE IF EXISTS `chambre`;
CREATE TABLE IF NOT EXISTS `chambre` (
  `no` int(11) NOT NULL COMMENT 'Numéro identifiant de la chambre de l''élève',
  `prix` float NOT NULL COMMENT 'Prix de location de la chambre',
  PRIMARY KEY (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table des chambres éventuellement associées aux élèves.';

--
-- Dumping data for table `chambre`
--

INSERT INTO `chambre` (`no`, `prix`) VALUES
(1, 500.5),
(3, 680),
(4, 400.55),
(5, 250.45),
(6, 150.75),
(7, 200.25),
(9, 500),
(777, 333);

-- --------------------------------------------------------

--
-- Table structure for table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `num` varchar(100) NOT NULL COMMENT 'Numéro identifiant l''elève',
  `no` int(11) DEFAULT NULL COMMENT 'Numéro de la chambre de l''élève',
  `nom` varchar(50) DEFAULT NULL COMMENT 'Nom de l''élève',
  `age` tinyint(4) DEFAULT NULL COMMENT 'Age de l''élève',
  `adresse` varchar(200) DEFAULT NULL COMMENT 'Adresse de l''élève',
  PRIMARY KEY (`num`),
  KEY `Eleve_fk1` (`no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table contenant l''ensemble des élèves';

--
-- Dumping data for table `eleve`
--

INSERT INTO `eleve` (`num`, `no`, `nom`, `age`, `adresse`) VALUES
('AGUE001', 9, 'AGUE MAX', 40, 'Chemin de Mancy 1'),
('KAMTO005', 3, 'KAMTO Diogène', 50, '54 Rue des Ebisoires 78300 Poissy'),
('TABIS003', 777, 'Ghislaine TABIS', 30, '12 Rue du louvre 75013 Paris'),
('teret', NULL, 'Tertt', 33, '4eddd');

-- --------------------------------------------------------

--
-- Table structure for table `inscrit`
--

DROP TABLE IF EXISTS `inscrit`;
CREATE TABLE IF NOT EXISTS `inscrit` (
  `code` varchar(100) NOT NULL COMMENT 'Id Code de l''uv',
  `num` varchar(100) NOT NULL COMMENT 'Numéro identifiant de l''élève',
  `note` float DEFAULT NULL COMMENT 'Note accordée à un élève sur une matière ou UV',
  PRIMARY KEY (`code`,`num`),
  KEY `inscrit_index_Eleve` (`num`),
  KEY `inscrit_index_Uv` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table recapitulant les élèves inscrit aux différents UV';

--
-- Dumping data for table `inscrit`
--

INSERT INTO `inscrit` (`code`, `num`, `note`) VALUES
('JAVA_Grp1', 'AGUE001', 5),
('JAVA_Grp1', 'TABIS003', 20),
('maths_info_Grp1', 'AGUE001', 22);

-- --------------------------------------------------------

--
-- Table structure for table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `cote` varchar(100) NOT NULL COMMENT 'Numéro identifiant du livre',
  `num` varchar(100) DEFAULT NULL COMMENT 'Numéro identifiant de l''élève qui a emprunté le livre',
  `titre` varchar(100) NOT NULL COMMENT 'Titre du livre',
  `datepret` datetime DEFAULT NULL COMMENT 'Date et heure du pret du livre par l''élève',
  PRIMARY KEY (`cote`),
  KEY `Livre_index_Eleve` (`num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table contenant les livres éventuellement associés aux élèves.';

--
-- Dumping data for table `livre`
--

INSERT INTO `livre` (`cote`, `num`, `titre`, `datepret`) VALUES
('ISBN10000', NULL, 'toto', NULL),
('ISBN10001', NULL, 'Seul au monded', NULL),
('ISBN10002', 'TABIS003', 'Meutre à la maison blanche', '2022-06-23 18:35:01'),
('ISBN10003', 'KAMTO005', 'Double Impacts', '2022-06-23 20:12:54'),
('ISBN11222', NULL, 'Le livre', NULL),
('title', NULL, 'Un vase dhonneur', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `uv`
--

DROP TABLE IF EXISTS `uv`;
CREATE TABLE IF NOT EXISTS `uv` (
  `code` varchar(100) NOT NULL COMMENT 'Id Code de l''uv',
  `nbh` tinyint(3) NOT NULL COMMENT 'Nombre d''heure de cour',
  `coord` varchar(255) DEFAULT NULL COMMENT 'COORD',
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Table des unités de valeurs ou d''enseignement';

--
-- Dumping data for table `uv`
--

INSERT INTO `uv` (`code`, `nbh`, `coord`) VALUES
('JAVA_Grp1', 30, 'Mr RIDEN'),
('maths_info_Grp1', 26, 'Mme ASSELAH'),
('Web_Service_Grp1', 10, 'Mr PLASSE');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `Eleve_fk1` FOREIGN KEY (`no`) REFERENCES `chambre` (`no`) ON UPDATE CASCADE;

--
-- Constraints for table `inscrit`
--
ALTER TABLE `inscrit`
  ADD CONSTRAINT `inscrit_fk1` FOREIGN KEY (`num`) REFERENCES `eleve` (`num`) ON UPDATE CASCADE,
  ADD CONSTRAINT `inscrit_fk2` FOREIGN KEY (`code`) REFERENCES `uv` (`code`) ON UPDATE CASCADE;

--
-- Constraints for table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `livre_fk1` FOREIGN KEY (`num`) REFERENCES `eleve` (`num`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
