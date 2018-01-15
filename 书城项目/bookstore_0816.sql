/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.0.67-community-nt : Database - bookstore_0816
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore_0816` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore_0816`;

/*Table structure for table `bs_book` */

DROP TABLE IF EXISTS `bs_book`;

CREATE TABLE `bs_book` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) default NULL,
  `price` double(11,2) default NULL,
  `sales` int(11) default NULL,
  `stock` int(11) default NULL,
  `img_path` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `title` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8;

/*Data for the table `bs_book` */

insert  into `bs_book`(`id`,`title`,`author`,`price`,`sales`,`stock`,`img_path`) values (39,'边城','沈从文',23.00,100,100,'static/img/default.jpg'),(40,'中国哲学史','冯友兰sd',44.50,102,98,'static/img/default.jpg'),(42,'苏东坡传dd','林语堂',19.30,63,87,'static/img/default.jpg'),(43,'百年孤独','马尔克斯',29.50,103,97,'/static/img/default.jpg'),(44,'扶桑','严歌苓',19.80,100,100,'/static/img/default.jpg'),(45,'教父','马里奥·普佐',29.00,100,100,'/static/img/default.jpg'),(46,'给孩子的诗','北岛',22.20,100,100,'/static/img/default.jpg'),(47,'为奴十二年','所罗门',16.50,100,100,'/static/img/default.jpg'),(48,'平凡的世界','路遥',55.00,100,100,'/static/img/default.jpg'),(49,'悟空传','今何在',14.00,100,100,'/static/img/default.jpg'),(50,'硬派健身','斌卡',31.20,103,97,'/static/img/default.jpg'),(51,'从晚清到民国','唐德刚',39.90,101,99,'/static/img/default.jpg'),(52,'三体','刘慈欣',56.50,101,99,'/static/img/default.jpg'),(53,'看见','柴静',19.50,101,99,'/static/img/default.jpg'),(54,'活着','余华',11.00,100,100,'/static/img/default.jpg'),(55,'小王子','安托万',19.20,100,100,'/static/img/default.jpg'),(56,'我们仨','杨绛',11.30,100,100,'/static/img/default.jpg'),(58,'皮囊','蔡崇达',23.90,100,100,'/static/img/default.jpg'),(59,'恰到好处的幸福','毕淑敏',16.40,100,100,'/static/img/default.jpg'),(60,'艾伦·图灵传','安德鲁',47.20,100,100,'/static/img/default.jpg'),(61,'大数据预测','埃里克',37.20,100,100,'/static/img/default.jpg'),(62,'人月神话','布鲁克斯',55.90,100,100,'/static/img/default.jpg'),(63,'C语言入门经典','霍尔顿',45.00,100,100,'static/img/default.jpg'),(64,'数学之美','吴军',29.90,100,100,'/static/img/default.jpg'),(65,'Java编程思想','埃史尔',70.50,100,100,'/static/img/default.jpg'),(66,'设计模式之禅','秦小波',20.20,100,100,'/static/img/default.jpg'),(67,'图解机器学习','杉山将',33.80,100,100,'/static/img/default.jpg'),(68,'解忧杂货店1','东野圭吾',27.20,100,100,'static/img/default.jpg'),(70,'javaWeb','陈昊鹏',20.00,50,100,'static/img/default.jpg'),(71,'javaWebsdf','陈昊鹏',20.00,50,100,'static/img/default.jpg');

/*Table structure for table `bs_order` */

DROP TABLE IF EXISTS `bs_order`;

CREATE TABLE `bs_order` (
  `id` varchar(100) NOT NULL,
  `total_count` int(11) default NULL,
  `total_amount` double(11,2) default NULL,
  `state` int(11) default NULL,
  `create_time` datetime default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bs_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `bs_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_order` */

insert  into `bs_order`(`id`,`total_count`,`total_amount`,`state`,`create_time`,`user_id`) values ('14718563024483',10,100.00,2,'2016-08-22 16:58:22',3),('14718706642383',6,209.50,2,'2016-08-22 20:57:44',3),('14718719238673',2,48.80,2,'2016-08-22 21:18:43',3),('14718752827653',12,267.00,2,'2016-08-22 22:14:42',3),('14719190025813',6,209.50,0,'2016-08-23 10:23:22',3),('14719190541373',6,209.50,0,'2016-08-23 10:24:14',3),('14719196374993',6,209.50,0,'2016-08-23 10:33:57',3),('14720274500133',2,48.80,0,'2016-08-24 16:30:50',3),('14725472183243',2,63.80,0,'2016-08-30 16:53:38',3);

/*Table structure for table `bs_order_item` */

DROP TABLE IF EXISTS `bs_order_item`;

CREATE TABLE `bs_order_item` (
  `id` int(11) NOT NULL auto_increment,
  `count` int(11) default NULL,
  `amount` double(11,2) default NULL,
  `order_id` varchar(100) default NULL,
  `title` varchar(50) default NULL,
  `author` varchar(50) default NULL,
  `price` double(11,2) default NULL,
  `img_path` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `bs_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `bs_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `bs_order_item` */

insert  into `bs_order_item`(`id`,`count`,`amount`,`order_id`,`title`,`author`,`price`,`img_path`) values (1,10,100.00,'14718563024483','三国演义','老罗',20.00,'/img/*'),(2,3,93.60,'14718706642383','硬派健身','斌卡',31.20,'/static/img/default.jpg'),(3,1,39.90,'14718706642383','从晚清到民国','唐德刚',39.90,'/static/img/default.jpg'),(4,1,56.50,'14718706642383','三体','刘慈欣',56.50,'/static/img/default.jpg'),(5,1,19.50,'14718706642383','看见','柴静',19.50,'/static/img/default.jpg'),(6,1,19.30,'14718719238673','苏东坡传dd','林语堂',19.30,'static/img/default.jpg'),(7,1,29.50,'14718719238673','百年孤独','马尔克斯',29.50,'/static/img/default.jpg'),(8,1,44.50,'14718752827653','中国哲学史','冯友兰sd',44.50,'static/img/default.jpg'),(9,10,193.00,'14718752827653','苏东坡传dd','林语堂',19.30,'static/img/default.jpg'),(10,1,29.50,'14718752827653','百年孤独','马尔克斯',29.50,'/static/img/default.jpg'),(11,3,93.60,'14719196374993','硬派健身','斌卡',31.20,'/static/img/default.jpg'),(12,1,39.90,'14719196374993','从晚清到民国','唐德刚',39.90,'/static/img/default.jpg'),(13,1,56.50,'14719196374993','三体','刘慈欣',56.50,'/static/img/default.jpg'),(14,1,19.50,'14719196374993','看见','柴静',19.50,'/static/img/default.jpg'),(15,1,29.50,'14720274500133','百年孤独','马尔克斯',29.50,'/static/img/default.jpg'),(16,1,19.30,'14720274500133','苏东坡传dd','林语堂',19.30,'static/img/default.jpg'),(17,1,19.30,'14725472183243','苏东坡传dd','林语堂',19.30,'static/img/default.jpg'),(18,1,44.50,'14725472183243','中国哲学史','冯友兰sd',44.50,'static/img/default.jpg');

/*Table structure for table `bs_user` */

DROP TABLE IF EXISTS `bs_user`;

CREATE TABLE `bs_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `bs_user` */

insert  into `bs_user`(`id`,`username`,`password`,`email`) values (3,'admin','123123','123@163.com'),(11,'gagaga','gagaga','ga@163.com'),(12,'wukong','wukong','wukong@163.com'),(13,'userwang','123456','123@163.com'),(14,'hahaha','hahaha','haha@163.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
