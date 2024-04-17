/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.0.28 : Database - health
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`health` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

/*Table structure for table `healthdeveloptable` */

CREATE TABLE `healthdeveloptable` (
  `delId` varchar(20) NOT NULL,
  `delMethod` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`delId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `healthdeveloptable` */

/*Table structure for table `healthmestable` */

CREATE TABLE `healthmestable` (
  `id` varchar(20) NOT NULL,
  `realName` varchar(20) DEFAULT NULL,
  `realAge` int DEFAULT NULL,
  `realPhone` varchar(16) DEFAULT NULL,
  `realMes` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `healthmestable` */

insert  into `healthmestable`(`id`,`realName`,`realAge`,`realPhone`,`realMes`) values ('001','张一',23,'13557444687','精神病');

/*Table structure for table `userdoctor` */

CREATE TABLE `userdoctor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `staffId` varchar(20) DEFAULT NULL,
  `staffName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;

/*Data for the table `userdoctor` */

insert  into `userdoctor`(`id`,`staffId`,`staffName`) values (1,'admin001','admin001');
insert  into `userdoctor`(`id`,`staffId`,`staffName`) values (2,'admin002','admin002');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
