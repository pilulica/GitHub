/*
SQLyog Ultimate v12.14 (64 bit)
MySQL - 5.6.17 : Database - toytoy
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`toytoy` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `toytoy`;

/*Table structure for table `toys` */

DROP TABLE IF EXISTS `toys`;

CREATE TABLE `toys` (
  `toyid` int(5) NOT NULL AUTO_INCREMENT,
  `toyname` varchar(20) DEFAULT NULL,
  `toytype` varchar(15) DEFAULT NULL,
  `toyprice` double DEFAULT NULL,
  `toynumbers` int(10) DEFAULT NULL,
  `toyav` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`toyid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `toys` */

insert  into `toys`(`toyid`,`toyname`,`toytype`,`toyprice`,`toynumbers`,`toyav`) values 
(1,'TedyBear','plisana',1230,18,1),
(2,'Nerf555','gun',2990,155,1),
(4,'Barby','doll',4500,2000000,1),
(5,'Action Man','doll(man)',5000,250000,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
