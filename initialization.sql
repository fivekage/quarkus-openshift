-- Adminer 4.8.1 MySQL 5.5.5-10.3.36-MariaDB-1:10.3.36+maria~ubu2004 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `DivinityGroup`;
CREATE TABLE `DivinityGroup` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `God`;
CREATE TABLE `God` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  `country` varchar(100) DEFAULT NULL,
  `idDivinityGroup` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_God_DivinityGroup` (`idDivinityGroup`),
  CONSTRAINT `fk_God_DivinityGroup` FOREIGN KEY (`idDivinityGroup`) REFERENCES `DivinityGroup` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `God` (`id`, `name`, `place`, `country`, `idDivinityGroup`) VALUES
(1,	'bchaicker',	'amiens',	'france',	1);

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;


-- 2023-02-22 10:30:58