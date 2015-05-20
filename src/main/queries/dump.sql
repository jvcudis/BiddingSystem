-- MySQL dump 10.13  Distrib 5.7.7-rc, for Win64 (x86_64)
--
-- Host: localhost    Database: db_bidding
-- ------------------------------------------------------
-- Server version	5.7.7-rc-log

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
-- Current Database: `db_bidding`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `db_bidding` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_bidding`;

--
-- Table structure for table `tbl_bids`
--

DROP TABLE IF EXISTS `tbl_bids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_bids` (
  `bid_id` int(11) NOT NULL AUTO_INCREMENT,
  `bid_item` int(11) NOT NULL,
  `bid_owner` int(11) NOT NULL,
  `bid_offer_price` double NOT NULL,
  `bid_offer_date` datetime NOT NULL,
  PRIMARY KEY (`bid_id`),
  UNIQUE KEY `bid_id_UNIQUE` (`bid_id`),
  KEY `fk_item_id_idx` (`bid_item`),
  KEY `fk_owner_id_idx` (`bid_owner`),
  CONSTRAINT `fk_item_id` FOREIGN KEY (`bid_item`) REFERENCES `tbl_items` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_seller_id` FOREIGN KEY (`bid_owner`) REFERENCES `tbl_users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_bids`
--

LOCK TABLES `tbl_bids` WRITE;
/*!40000 ALTER TABLE `tbl_bids` DISABLE KEYS */;
INSERT INTO `tbl_bids` VALUES (1,1,3,0.00,'2015-05-15 14:33:14'),(2,2,5,0.00,'2015-05-15 14:33:14'),(3,3,3,0.00,'2015-05-15 14:33:14'),(4,4,5,0.00,'2015-05-15 14:33:14');
/*!40000 ALTER TABLE `tbl_bids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_items`
--

DROP TABLE IF EXISTS `tbl_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_items` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(80) NOT NULL,
  `item_desc` varchar(80) NOT NULL,
  `item_owner` int(11) NOT NULL,
  `item_date_added` datetime NOT NULL,
  `item_date_expiry` datetime NOT NULL,
  `item_price` double NOT NULL,
  PRIMARY KEY (`item_id`),
  UNIQUE KEY `item_id_UNIQUE` (`item_id`),
  KEY `fk_item_owner_idx` (`item_owner`),
  CONSTRAINT `fk_item_owner` FOREIGN KEY (`item_owner`) REFERENCES `tbl_users` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_items`
--

LOCK TABLES `tbl_items` WRITE;
/*!40000 ALTER TABLE `tbl_items` DISABLE KEYS */;
INSERT INTO `tbl_items` VALUES (1,'huggies','super diaper',2,'2015-05-15 14:33:13','2015-05-22 00:00:00',30.45),(2,'huggies','super diaper',2,'2015-05-15 14:33:13','2015-05-22 00:00:00',130.00),(3,'pampers','for babies and adults',4,'2015-05-15 14:33:14','2015-08-03 00:00:00',50.35),(4,'whisper','with wings and more',4,'2015-05-15 14:33:14','2015-08-20 00:00:00',20.00),(5,'modess','cool clean comfy',2,'2015-05-15 14:33:14','2015-06-12 00:00:00',50.00),(6,'sister','approved by Sarah Geronimo',2,'2015-05-15 14:33:14','2015-09-01 00:00:00',1000.00);
/*!40000 ALTER TABLE `tbl_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_roles`
--

DROP TABLE IF EXISTS `tbl_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_roles` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(80) NOT NULL,
  `role_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_id_UNIQUE` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_roles`
--

LOCK TABLES `tbl_roles` WRITE;
/*!40000 ALTER TABLE `tbl_roles` DISABLE KEYS */;
INSERT INTO `tbl_roles` VALUES (1,'ADMIN','An admin can do anything.'),(2,'SELLER','A seller can sell but not bid.'),(3,'BIDDER','A bidder bid but not sell.');
/*!40000 ALTER TABLE `tbl_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_users`
--

DROP TABLE IF EXISTS `tbl_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_username` varchar(45) NOT NULL,
  `user_password` varchar(45) NOT NULL,
  `user_name` varchar(80) NOT NULL,
  `user_email` varchar(80) NOT NULL,
  `user_role` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id_UNIQUE` (`user_id`),
  KEY `fk_user_role_idx` (`user_role`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`user_role`) REFERENCES `tbl_roles` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_users`
--

LOCK TABLES `tbl_users` WRITE;
/*!40000 ALTER TABLE `tbl_users` DISABLE KEYS */;
INSERT INTO `tbl_users` VALUES (1,'admin','admin123','Mr. Administrator','admin@fpt.com',1),(2,'seller','seller123','Mrs. Seller','seller@fpt.com',2),(3,'bidder','bidder123','Miss. Bidder','bidder@fpt.com',3),(4,'jstrange','jstrange','Jennifer Strange','jstrange@fpt.com',2),(5,'hpotter','hpotter','Harry Potter','hpotter@fpt.com',3);
/*!40000 ALTER TABLE `tbl_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-05-15 22:33:33
