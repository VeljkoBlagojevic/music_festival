/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 10.4.27-MariaDB : Database - music_festival_veljko_blagojevic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`music_festival_veljko_blagojevic` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;

USE `music_festival_veljko_blagojevic`;

/*Table structure for table `band` */

DROP TABLE IF EXISTS `band`;

CREATE TABLE `band` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `formation_year` int(11) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `biography` varchar(1023) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `CHK_valid_year` CHECK (`formation_year` between 1900 and 2022)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `band` */

insert  into `band`(`id`,`name`,`formation_year`,`website`,`biography`) values 
(3,'Metallica',1982,'www.metallica.com','Metallica is an American thrash / heavz metal band. The band was formed in 1982 in Los Angeles, United States of America by vocalist/guitarist James Hetfield and drummer Lars Ulrich.'),
(4,'Megadeth',1983,'www.megadeth.com','Megadeth is an American thrash metal band formed in Los Angeles in 1983 by vocalist/guitarist Dave.'),
(5,'Pantera',1981,'www.pantera.com','Pantera (/pænˈtɛrə/) is an American heavy metal band from Arlington, Texas formed in 1981, and currently comprised of vocalist Phil Anselmo, bassist Rex Brown.'),
(6,'Haken',2007,'www.hakenmusic.com','Haken are an English progressive metal band formed in 2007 by multi-instrumentalist Richard Henshall, guitarist Matthew Marshall, and vocalist Ross Jennings.'),
(9,'Slayer',1981,'www.slayer.com','SLAAAAAAYYEEEER'),
(10,'Leprous',2001,'www.leprous.net','Leprous is amazing and quite dear to my heart and brain because they are really progressive!'),
(12,'Between the Buried and Me',2004,'www.btbam.com','BTBAM is awesome prog deathcore band from USA.'),
(14,'Periphery',2005,'www.periphery.net','Periphery is an American progressive metal band formed in Washington, D.C., in 2005. Their musical style has been described as progressive metal, djent, and progressive metalcore.'),
(15,'Porcupine Tree',1987,'www.porcupinetree.com','orcupine Tree are an English rock band formed by musician Steven Wilson in 1987. During an initial career spanning more than twenty years, they earned critical acclaim from critics and fellow musicians, developed a cult following, and became an influence for new artists.'),
(16,'Tool',1990,'www.toolband.com','Tool is an American rock band from Los Angeles. Formed in 1990, the groups line-up includes vocalist Maynard James Keenan, guitarist Adam Jones and drummer Danny Carey.');

/*Table structure for table `concert` */

DROP TABLE IF EXISTS `concert`;

CREATE TABLE `concert` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `start_time` date DEFAULT NULL,
  `band_id` bigint(20) unsigned NOT NULL,
  `stage_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `band_id` (`band_id`),
  KEY `stage_id` (`stage_id`),
  CONSTRAINT `concert_ibfk_1` FOREIGN KEY (`band_id`) REFERENCES `band` (`id`),
  CONSTRAINT `concert_ibfk_2` FOREIGN KEY (`stage_id`) REFERENCES `stage` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `concert` */

insert  into `concert`(`id`,`start_time`,`band_id`,`stage_id`) values 
(2,'2022-12-16',6,3),
(5,'2023-03-31',9,2),
(10,'2023-02-26',12,2),
(12,'2019-09-09',5,3),
(14,'2005-05-06',6,2),
(15,'2008-11-11',9,8);

/*Table structure for table `song` */

DROP TABLE IF EXISTS `song`;

CREATE TABLE `song` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `length` int(10) unsigned DEFAULT NULL,
  `band_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `band_id` (`band_id`),
  CONSTRAINT `song_ibfk_1` FOREIGN KEY (`band_id`) REFERENCES `band` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `song` */

insert  into `song`(`id`,`title`,`length`,`band_id`) values 
(1,'Enter Sandman',350,3),
(3,'Rust in Peace',400,4),
(4,'Walk',320,5),
(5,'Cockroach King',550,6),
(6,'1985',548,6),
(7,'One',480,3),
(8,'Fuel',280,3),
(9,'Domination',290,5),
(10,'Monochrome',56,12),
(11,'Sky is Red',560,10),
(12,'Trains',358,15),
(13,'Master Of Puppets',512,3),
(14,'Nothing Else Matters',399,3),
(15,'Fade To Black',419,3),
(16,'Holy Wars...',402,4),
(17,'Tornado Of Souls',341,4),
(18,'Angry Again',205,4),
(19,'Hangar 18',311,4),
(20,'Cowboys From Hell',423,5),
(21,'Cemetery Gates',425,5),
(22,'I Am Broken',290,5),
(23,'5 Minutes Alone',347,5),
(24,'Taurus',289,6),
(25,'Nightingale',431,6),
(26,'The Good Doctor',235,6),
(27,'Invasion',398,6),
(28,'Lovebite',226,6),
(29,'Canary Yellow',262,6),
(30,'Raining Blood',245,9),
(31,'South Of Heaven',295,9),
(32,'Angel Of Death',297,9),
(33,'Repentless',189,9),
(34,'Bloodline',199,9),
(35,'Dead Skin Mask',329,9),
(36,'War Ensemble',291,9),
(37,'From The Flame',251,10),
(38,'Below',390,10),
(39,'The Price',421,10),
(40,'Out Of Here',226,10),
(41,'Running Low',356,10),
(42,'Illuminate',267,10),
(43,'Foam Born (A)',92,12),
(44,'The Coma Machine',512,12),
(45,'Fix The Error',352,12),
(46,'Revolution In Limbo',552,12),
(47,'Dim Ignition',99,12),
(48,'Wildfire',425,14),
(49,'Marigold',335,14),
(50,'Reptile',565,14),
(51,'Scarlet',260,14),
(52,'Blood Eagle',452,14),
(53,'Atropos',541,14),
(54,'Omega',912,14),
(55,'Blackest Eyes',265,15),
(56,'Lazarus',296,15),
(57,'Open Car',312,15),
(58,'Fear Of A Blank Planet',611,15);

/*Table structure for table `song_performance` */

DROP TABLE IF EXISTS `song_performance`;

CREATE TABLE `song_performance` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `length` int(10) unsigned DEFAULT NULL,
  `original_song_id` bigint(20) unsigned DEFAULT NULL,
  `concert_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`,`concert_id`),
  KEY `original_song_id` (`original_song_id`),
  KEY `concert_id` (`concert_id`),
  CONSTRAINT `song_performance_ibfk_3` FOREIGN KEY (`original_song_id`) REFERENCES `song` (`id`),
  CONSTRAINT `song_performance_ibfk_4` FOREIGN KEY (`concert_id`) REFERENCES `concert` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `song_performance` */

insert  into `song_performance`(`id`,`length`,`original_song_id`,`concert_id`) values 
(5,390,3,2),
(8,250,10,10),
(9,500,6,10),
(14,444,4,12),
(37,400,5,14),
(38,350,12,2),
(39,290,30,15),
(42,283,36,15),
(43,260,3,15),
(44,125,43,10),
(45,250,44,10),
(46,500,21,12),
(47,400,22,12),
(53,150,30,5),
(54,250,31,5),
(55,123,1,10);

/*Table structure for table `stage` */

DROP TABLE IF EXISTS `stage`;

CREATE TABLE `stage` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `audience_capacity` int(10) unsigned DEFAULT NULL,
  `surface_area` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stage` */

insert  into `stage`(`id`,`name`,`location`,`audience_capacity`,`surface_area`) values 
(2,'World Stage','North',100000,12000),
(3,'Sunset Stage','West',75000,6600),
(5,'Barba Negra','Budapest',1500,1500),
(8,'Brutal Stage','Petrovoradin',560,456);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `CHK_password_len_5` CHECK (octet_length(`password`) >= 5)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`firstname`,`lastname`,`username`,`password`) values 
(1,'Admin','Admin','admin','Admin123!'),
(2,'Veljko','Blagojevic','veljko','Veljko123!');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
