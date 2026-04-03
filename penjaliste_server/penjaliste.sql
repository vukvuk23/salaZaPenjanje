/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 8.0.18 : Database - penjaliste
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`penjaliste` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `penjaliste`;

/*Table structure for table `kategorija` */

DROP TABLE IF EXISTS `kategorija`;

CREATE TABLE `kategorija` (
  `idKategorija` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idKategorija`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `kategorija` */

insert  into `kategorija`(`idKategorija`,`naziv`) values 
(1,'Odrasli'),
(2,'Student'),
(3,'Dete'),
(4,'Penzioner');

/*Table structure for table `penjac` */

DROP TABLE IF EXISTS `penjac`;

CREATE TABLE `penjac` (
  `idPenjac` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prezime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `godine` bigint(20) NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `kategorija` bigint(20) NOT NULL,
  PRIMARY KEY (`idPenjac`),
  KEY `kategorija` (`kategorija`),
  CONSTRAINT `penjac_ibfk_1` FOREIGN KEY (`kategorija`) REFERENCES `kategorija` (`idKategorija`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `penjac` */

insert  into `penjac`(`idPenjac`,`ime`,`prezime`,`godine`,`email`,`kategorija`) values 
(4,'Marko','Markovic',7,'roditelj@gmail.com',3),
(6,'Pera','Peric',20,'pera@gmail.com',2),
(7,'Ana','Anic',8,'roditelj@gmail.com',3),
(9,'Bojana','Bojanovic',47,'bojana@gmail.com',1),
(16,'Nikola','Nikolic',22,'nikola@gmail.com',2),
(24,'Vuk','Tajsic',22,'vuk.tajsic@gmail.com',2);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `idRacun` bigint(20) NOT NULL AUTO_INCREMENT,
  `zaposleni` bigint(20) NOT NULL,
  `penjac` bigint(20) NOT NULL,
  `datumVreme` datetime NOT NULL,
  `ukupanIznos` double NOT NULL,
  PRIMARY KEY (`idRacun`),
  KEY `zaposleni` (`zaposleni`),
  KEY `penjac` (`penjac`),
  CONSTRAINT `racun_ibfk_1` FOREIGN KEY (`zaposleni`) REFERENCES `zaposleni` (`idZaposleni`),
  CONSTRAINT `racun_ibfk_2` FOREIGN KEY (`penjac`) REFERENCES `penjac` (`idPenjac`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `racun` */

insert  into `racun`(`idRacun`,`zaposleni`,`penjac`,`datumVreme`,`ukupanIznos`) values 
(2,1,9,'2026-03-15 00:19:01',2000),
(4,1,7,'2026-03-15 11:10:13',1000),
(5,1,4,'2026-03-15 09:38:19',600),
(7,1,7,'2026-03-14 23:57:07',1200),
(8,2,9,'2026-03-13 02:25:57',1000),
(9,2,7,'2026-03-13 02:41:20',900),
(15,1,16,'2026-04-03 13:44:42',600),
(16,2,16,'2026-03-15 12:12:30',600),
(17,1,16,'2026-03-15 12:13:04',2200);

/*Table structure for table `smena` */

DROP TABLE IF EXISTS `smena`;

CREATE TABLE `smena` (
  `idSmena` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `vremeOd` time NOT NULL,
  `vremeDo` time NOT NULL,
  PRIMARY KEY (`idSmena`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `smena` */

insert  into `smena`(`idSmena`,`naziv`,`vremeOd`,`vremeDo`) values 
(1,'prva','10:00:00','16:00:00'),
(2,'druga','16:00:00','22:00:00'),
(4,'treca','18:00:00','22:00:00');

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `rbr` bigint(20) NOT NULL AUTO_INCREMENT,
  `racun` bigint(20) NOT NULL,
  `kolicina` bigint(20) NOT NULL,
  `cena` double NOT NULL,
  `iznos` double NOT NULL,
  `usluga` bigint(20) NOT NULL,
  PRIMARY KEY (`rbr`,`racun`),
  KEY `racun` (`racun`),
  KEY `usluga` (`usluga`),
  CONSTRAINT `stavkaracuna_ibfk_1` FOREIGN KEY (`racun`) REFERENCES `racun` (`idRacun`),
  CONSTRAINT `stavkaracuna_ibfk_2` FOREIGN KEY (`usluga`) REFERENCES `usluga` (`idUsluga`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `stavkaracuna` */

insert  into `stavkaracuna`(`rbr`,`racun`,`kolicina`,`cena`,`iznos`,`usluga`) values 
(2,2,1,600,600,1),
(11,5,1,600,600,1),
(15,8,1,1000,1000,4),
(16,9,1,600,600,1),
(17,9,1,300,300,2),
(27,7,2,600,1200,1),
(37,4,1,1000,1000,4),
(38,2,2,700,1400,3),
(39,15,1,600,600,1),
(43,16,2,300,600,2),
(44,17,1,700,700,3),
(45,17,1,1500,1500,5);

/*Table structure for table `usluga` */

DROP TABLE IF EXISTS `usluga`;

CREATE TABLE `usluga` (
  `idUsluga` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cena` double NOT NULL,
  PRIMARY KEY (`idUsluga`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `usluga` */

insert  into `usluga`(`idUsluga`,`naziv`,`cena`) values 
(1,'Slobodan termin',600),
(2,'Najam patika',300),
(3,'Magnezijum kocka',700),
(4,'Najam pojas',1000),
(5,'Prirodni melem',1500);

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `idZaposleni` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prezime` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `brTelefona` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `lozinka` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idZaposleni`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`idZaposleni`,`ime`,`prezime`,`email`,`brTelefona`,`lozinka`) values 
(1,'Vuk','Tajsic','vuk.tajsic@gmail.com','0651234123','vuk123'),
(2,'Aleksa','Tomic','nzmaleksa@gmail.com','0647654321','aleksa123');

/*Table structure for table `zaposlenismena` */

DROP TABLE IF EXISTS `zaposlenismena`;

CREATE TABLE `zaposlenismena` (
  `zaposleni` bigint(20) NOT NULL,
  `smena` bigint(20) NOT NULL,
  `datum` date NOT NULL,
  `napomena` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`zaposleni`,`smena`,`datum`),
  KEY `smena` (`smena`),
  CONSTRAINT `zaposlenismena_ibfk_1` FOREIGN KEY (`zaposleni`) REFERENCES `zaposleni` (`idZaposleni`),
  CONSTRAINT `zaposlenismena_ibfk_2` FOREIGN KEY (`smena`) REFERENCES `smena` (`idSmena`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `zaposlenismena` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
