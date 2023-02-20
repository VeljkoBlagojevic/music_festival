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
  `band_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `formation_year` int(11) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `biography` varchar(1023) DEFAULT NULL,
  PRIMARY KEY (`band_id`),
  CONSTRAINT `CHK_valid_year` CHECK (`formation_year` between 1900 and 2022)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `band` */

insert  into `band`(`band_id`,`name`,`formation_year`,`website`,`biography`) values 
(3,'Metallica',1981,'www.metallica.com','Metallica is an American heavy metal band. The band was formed in 1981 in Los Angeles by vocalist/guitarist James Hetfield and drummer Lars Ulrich, and has been based in San Francisco for most of its career.[1][2] The band\'s fast tempos, instrumentals and aggressive musicianship made them one of the founding \"big four\" bands of thrash metal, alongside Megadeth, Anthrax and Slayer. Metallica\'s current lineup comprises founding members and primary songwriters Hetfield and Ulrich, longtime lead guitarist Kirk Hammett and bassist Robert Trujillo. Guitarist Dave Mustaine, who formed Megadeth after being fired from the band, and bassists Ron McGovney, Cliff Burton and Jason Newsted are former members of the band.'),
(4,'Megadeth',1983,'www.megadeth.com','Megadeth is an American thrash metal band formed in Los Angeles in 1983 by vocalist/guitarist Dave. Known for their technically complex guitar work and musicianship, Megadeth is one of the \"big four\" of American thrash metal along with Metallica, Anthrax, and Slayer, responsible for the genre\'s development and popularization. Their music features complex arrangements and fast rhythm sections, dual lead guitars, and lyrical themes of war, politics, religion, death, and personal relationships.'),
(5,'Pantera',1981,'www.pantera.com','Pantera (/pænˈtɛrə/) is an American heavy metal band from Arlington, Texas formed in 1981, and currently comprised of vocalist Phil Anselmo, bassist Rex Brown, and touring musicians Zakk Wylde and Charlie Benante. The group\'s best-known lineup consisted of drummer Vinnie Paul and guitarist Dimebag Darrell, along with Brown and Anselmo, who joined in 1982 and 1986 respectively. In addition to their development and popularization of the groove metal subgenre, Pantera is credited (along with others, such as Testament, Sepultura, and Machine Head) for being part of the second wave of thrash metal scene from the late 1980s to early-to-mid 1990s.[2][3] Pantera is regarded as one of the most successful and influential bands in heavy metal history, having sold around 20 million records worldwide[4] and having received four Grammy nominations.[5]'),
(6,'Haken',2007,'www.hakenmusic.com','Haken are an English progressive metal band formed in 2007 by multi-instrumentalist Richard Henshall, guitarist Matthew Marshall, and vocalist Ross Jennings. While Henshall, Marshall, and Jennings first had the idea of forming Haken in 2004, they opted to pursue their instruments and songwriting first. Upon recruiting other members three years later, they eventually released the demo Enter the 5th Dimension in 2008, signing with Sensory Records and releasing their first album Aquarius in 2010. As of 2020, they have released six studio albums, an EP, and two live albums.'),
(9,'Slayer',1981,'www.slayer.com','SLAAAAAAYYEEEER'),
(10,'Leprous',2001,'www.leprous.net','Leprous is amazing and quite dear to my heart and brain because they are really progressive!');

/*Table structure for table `concert` */

DROP TABLE IF EXISTS `concert`;

CREATE TABLE `concert` (
  `concert_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `start_time` date DEFAULT NULL,
  `band_id` bigint(20) unsigned NOT NULL,
  `stage_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`concert_id`),
  KEY `band_id` (`band_id`),
  KEY `stage_id` (`stage_id`),
  CONSTRAINT `concert_ibfk_1` FOREIGN KEY (`band_id`) REFERENCES `band` (`band_id`),
  CONSTRAINT `concert_ibfk_2` FOREIGN KEY (`stage_id`) REFERENCES `stage` (`stage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `concert` */

insert  into `concert`(`concert_id`,`start_time`,`band_id`,`stage_id`) values 
(1,'2022-12-27',3,1),
(2,'2022-12-16',6,3),
(3,'2022-07-14',10,2),
(5,'2023-03-31',9,2);

/*Table structure for table `song` */

DROP TABLE IF EXISTS `song`;

CREATE TABLE `song` (
  `song_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `length` int(10) unsigned DEFAULT NULL,
  `band_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`song_id`),
  KEY `band_id` (`band_id`),
  CONSTRAINT `song_ibfk_1` FOREIGN KEY (`band_id`) REFERENCES `band` (`band_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `song` */

insert  into `song`(`song_id`,`title`,`length`,`band_id`) values 
(1,'Enter Sandman',350,3),
(3,'Rust in Peace',400,4),
(4,'Walk',320,5),
(5,'Cockroach King',550,6),
(6,'1985',548,6),
(7,'One',480,3),
(8,'Fuel',280,3),
(9,'Domination',290,5);

/*Table structure for table `song_performance` */

DROP TABLE IF EXISTS `song_performance`;

CREATE TABLE `song_performance` (
  `song_performance_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `length` int(10) unsigned DEFAULT NULL,
  `original_song_id` bigint(20) unsigned DEFAULT NULL,
  `concert_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`song_performance_id`),
  KEY `original_song_id` (`original_song_id`),
  KEY `concert_id` (`concert_id`),
  CONSTRAINT `song_performance_ibfk_1` FOREIGN KEY (`original_song_id`) REFERENCES `song` (`song_id`) ON DELETE NO ACTION,
  CONSTRAINT `song_performance_ibfk_2` FOREIGN KEY (`concert_id`) REFERENCES `concert` (`concert_id`) ON DELETE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `song_performance` */

insert  into `song_performance`(`song_performance_id`,`length`,`original_song_id`,`concert_id`) values 
(1,250,1,1),
(2,360,5,3),
(3,550,6,3),
(4,320,8,1),
(5,390,3,2),
(6,410,7,1),
(7,200,4,5);

/*Table structure for table `stage` */

DROP TABLE IF EXISTS `stage`;

CREATE TABLE `stage` (
  `stage_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `audience_capacity` int(10) unsigned DEFAULT NULL,
  `surface_area` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`stage_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `stage` */

insert  into `stage`(`stage_id`,`name`,`location`,`audience_capacity`,`surface_area`) values 
(1,'Utopia Stage','South',85000,8500),
(2,'World Stage','North',100000,12000),
(3,'Sunset Stage','West',70000,5000),
(4,'Zisel bina','Omoljica',500,500);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `CHK_password_len_5` CHECK (octet_length(`password`) >= 5)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `user` */

insert  into `user`(`user_id`,`firstname`,`lastname`,`username`,`password`) values 
(1,'Admin','Admin','admin','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
