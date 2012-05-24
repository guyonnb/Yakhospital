-- phpMyAdmin SQL Dump
-- version 3.4.9
-- http://www.phpmyadmin.net
--
-- Client: 127.0.0.1
-- Généré le : Lun 21 Mai 2012 à 12:21
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `yakhospital`
--

-- --------------------------------------------------------

--
-- Structure de la table `droit`
--

CREATE TABLE IF NOT EXISTS `droit` (
  `ID_DROIT` int(11) NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_DROIT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE IF NOT EXISTS `patient` (
  `ID_PATIENT` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_PATIENT` varchar(255) NOT NULL,
  `PRENOM_PATIENT` varchar(255) NOT NULL,
  `NSS` char(13) NOT NULL,
  `NUMERO_RUE` int(11) DEFAULT NULL,
  `RUE` varchar(255) DEFAULT NULL,
  `CP` decimal(8,0) DEFAULT NULL,
  `VILLE` varchar(255) DEFAULT NULL,
  `SEXE` varchar(1) DEFAULT NULL,
  `NAISSANCE` date DEFAULT NULL,
  `TEL` decimal(10,10) DEFAULT NULL,
  `TEL_URGENCE` decimal(10,10) DEFAULT NULL,
  `NOTE` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ID_PATIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `poste`
--

CREATE TABLE IF NOT EXISTS `poste` (
  `ID_POSTE` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_POSTE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_POSTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `poste_droit`
--

CREATE TABLE IF NOT EXISTS `poste_droit` (
  `ID_POSTE` int(11) NOT NULL,
  `ID_DROIT` int(11) NOT NULL,
  PRIMARY KEY (`ID_POSTE`,`ID_DROIT`),
  KEY `ID_DROIT` (`ID_DROIT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `ID_SALLE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SERVICE` int(11) DEFAULT NULL,
  `NOM_SALLE` varchar(255) NOT NULL,
  `NB_LITS` int(11) NOT NULL,
  PRIMARY KEY (`ID_SALLE`),
  KEY `ID_SERVICE` (`ID_SERVICE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `sejour`
--

CREATE TABLE IF NOT EXISTS `sejour` (
  `ID_SEJOUR` int(11) NOT NULL AUTO_INCREMENT,
  `ID_PATIENT` int(11) DEFAULT NULL,
  `RAISON_ADMISSION` varchar(255) NOT NULL,
  `STATUS` smallint(6) NOT NULL,
  `DATE_DEBUT` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DATE_FIN` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID_SEJOUR`),
  KEY `ID_PATIENT` (`ID_PATIENT`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `service`
--

CREATE TABLE IF NOT EXISTS `service` (
  `ID_SERVICE` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_SERVICE` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_SERVICE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `service_compatible`
--

CREATE TABLE IF NOT EXISTS `service_compatible` (
  `ID_SERVICE` int(11) NOT NULL,
  `SER_ID_SERVICE` int(11) NOT NULL,
  PRIMARY KEY (`ID_SERVICE`,`SER_ID_SERVICE`),
  KEY `SER_ID_SERVICE` (`SER_ID_SERVICE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `soin`
--

CREATE TABLE IF NOT EXISTS `soin` (
  `ID_SOIN` int(11) NOT NULL AUTO_INCREMENT,
  `ID_SEJOUR` int(11) NOT NULL,
  `ID_TYPE_SOIN` int(11) NOT NULL,
  `ID_SALLE` int(11) DEFAULT NULL,
  `ID_TITULAIRE` int(11) DEFAULT NULL,
  `DATE_DEBUT_SOIN` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DATE_FIN_SOIN` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `COMMENTAIRE` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`ID_SOIN`),
  KEY `ID_SEJOUR` (`ID_SEJOUR`),
  KEY `ID_TYPE_SOIN` (`ID_TYPE_SOIN`),
  KEY `ID_SALLE` (`ID_SALLE`),
  KEY `ID_TITULAIRE` (`ID_TITULAIRE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `titulaire`
--

CREATE TABLE IF NOT EXISTS `titulaire` (
  `ID_TITULAIRE` int(11) NOT NULL AUTO_INCREMENT,
  `ID_POSTE` int(11) DEFAULT NULL,
  `ID_SERVICE` int(11) DEFAULT NULL,
  `NOM_TITULAIRE` varchar(255) NOT NULL,
  `PRENOM_TITULAIRE` varchar(255) NOT NULL,
  `NUM_PRO` decimal(8,0) NOT NULL,
  `MDP` varchar(512) NOT NULL,
  PRIMARY KEY (`ID_TITULAIRE`),
  KEY `ID_POSTE` (`ID_POSTE`),
  KEY `ID_SERVICE` (`ID_SERVICE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `type_soin`
--

CREATE TABLE IF NOT EXISTS `type_soin` (
  `ID_TYPE_SOIN` int(11) NOT NULL AUTO_INCREMENT,
  `NOM_SOIN` varchar(255) NOT NULL,
  PRIMARY KEY (`ID_TYPE_SOIN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `poste_droit`
--
ALTER TABLE `poste_droit`
  ADD CONSTRAINT `poste_droit_ibfk_3` FOREIGN KEY (`ID_POSTE`) REFERENCES `poste` (`ID_POSTE`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `poste_droit_ibfk_2` FOREIGN KEY (`ID_DROIT`) REFERENCES `droit` (`ID_DROIT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `salle`
--
ALTER TABLE `salle`
  ADD CONSTRAINT `salle_ibfk_2` FOREIGN KEY (`ID_SERVICE`) REFERENCES `service` (`ID_SERVICE`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Contraintes pour la table `sejour`
--
ALTER TABLE `sejour`
  ADD CONSTRAINT `sejour_ibfk_2` FOREIGN KEY (`ID_PATIENT`) REFERENCES `patient` (`ID_PATIENT`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `service_compatible`
--
ALTER TABLE `service_compatible`
  ADD CONSTRAINT `service_compatible_ibfk_2` FOREIGN KEY (`SER_ID_SERVICE`) REFERENCES `service` (`ID_SERVICE`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `service_compatible_ibfk_1` FOREIGN KEY (`ID_SERVICE`) REFERENCES `service` (`ID_SERVICE`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `soin`
--
ALTER TABLE `soin`
  ADD CONSTRAINT `soin_ibfk_4` FOREIGN KEY (`ID_TITULAIRE`) REFERENCES `titulaire` (`ID_TITULAIRE`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `soin_ibfk_1` FOREIGN KEY (`ID_SEJOUR`) REFERENCES `sejour` (`ID_SEJOUR`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `soin_ibfk_2` FOREIGN KEY (`ID_TYPE_SOIN`) REFERENCES `type_soin` (`ID_TYPE_SOIN`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `soin_ibfk_3` FOREIGN KEY (`ID_SALLE`) REFERENCES `salle` (`ID_SALLE`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Contraintes pour la table `titulaire`
--
ALTER TABLE `titulaire`
  ADD CONSTRAINT `titulaire_ibfk_2` FOREIGN KEY (`ID_SERVICE`) REFERENCES `service` (`ID_SERVICE`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `titulaire_ibfk_3` FOREIGN KEY (`ID_POSTE`) REFERENCES `poste` (`ID_POSTE`) ON DELETE SET NULL ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
