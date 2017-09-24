-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: wireless_db
-- ------------------------------------------------------
-- Server version	5.1.45-community

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `wireless_db`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `wireless_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `wireless_db`;

--
-- Table structure for table `menutbl`
--

DROP TABLE IF EXISTS `menutbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menutbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `name` varchar(60) DEFAULT NULL,
  `pic` varchar(1000) DEFAULT NULL,
  `remark` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menutbl`
--

LOCK TABLES `menutbl` WRITE;
/*!40000 ALTER TABLE `menutbl` DISABLE KEYS */;
INSERT INTO `menutbl` VALUES (1,16,1,'特色炒饭','images/500034.jpg','原料：蘑菇、鸡蛋、胡萝卜、青椒、绿色蔬菜。口感极好！'),(2,8,1,'青椒土豆丝','images/500008.jpg','土豆丝、辣椒、清淡首选！'),(3,10,1,'阳春面','images/500024.jpg','面条、花生米、香菜！'),(4,12,1,'青菜蛋汤','images/500025.jpg','青菜、鸡蛋，三鲜汤！'),(5,18,1,'茶树菇炒肉','images/500041.jpg','茶树菇烧肉,味道不错哦!'),(6,20,1,'京酱肉丝','images/500045.jpg','肉丝,黄瓜,煎饼,传统风味!'),(7,6,1,'小馄饨','images/500042.jpg','香菜小馄饨！'),(8,38,1,'老母鸡汤','images/500026.jpg','老母鸡一只、葱姜蒜，味道独特！');
/*!40000 ALTER TABLE `menutbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetailtbl`
--

DROP TABLE IF EXISTS `orderdetailtbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetailtbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `menuId` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetailtbl`
--

LOCK TABLES `orderdetailtbl` WRITE;
/*!40000 ALTER TABLE `orderdetailtbl` DISABLE KEYS */;
INSERT INTO `orderdetailtbl` VALUES (1,1,1,2,'ptomain '),(2,1,4,2,'good ');
/*!40000 ALTER TABLE `orderdetailtbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordertbl`
--

DROP TABLE IF EXISTS `ordertbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordertbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderTime` varchar(100) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `tableId` int(11) DEFAULT NULL,
  `personNum` int(11) DEFAULT NULL,
  `isPay` int(11) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordertbl`
--

LOCK TABLES `ordertbl` WRITE;
/*!40000 ALTER TABLE `ordertbl` DISABLE KEYS */;
INSERT INTO `ordertbl` VALUES (1,'2013-04-12 06:16:43',3,202,2,1,NULL);
/*!40000 ALTER TABLE `ordertbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tabletbl`
--

DROP TABLE IF EXISTS `tabletbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tabletbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL,
  `personNum` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tabletbl`
--

LOCK TABLES `tabletbl` WRITE;
/*!40000 ALTER TABLE `tabletbl` DISABLE KEYS */;
INSERT INTO `tabletbl` VALUES (1,201,0,4),(2,202,0,10),(3,203,0,8),(4,208,0,16);
/*!40000 ALTER TABLE `tabletbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertbl`
--

DROP TABLE IF EXISTS `usertbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `account` varchar(100) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `permission` int(11) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertbl`
--

LOCK TABLES `usertbl` WRITE;
/*!40000 ALTER TABLE `usertbl` DISABLE KEYS */;
INSERT INTO `usertbl` VALUES (1,'user1','user1','123','男',2,'学生'),(2,'user2','user2','1234','女',2,'学生'),(3,'admin','admin','8888','女',1,'管理员');
/*!40000 ALTER TABLE `usertbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-04-12 14:24:22
