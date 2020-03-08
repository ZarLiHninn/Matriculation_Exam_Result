-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: mer
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `admin_id` int(3) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(50) NOT NULL,
  `password_id` int(6) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (001,'John',77),(002,'Sakura',78),(003,'Merry',79),(004,'Hsu',80),(005,'Zar',81),(006,'Thet',82),(007,'Tala',83),(008,'Thi Thi',84);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `division`
--

DROP TABLE IF EXISTS `division`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `division` (
  `div_id` int(2) NOT NULL AUTO_INCREMENT,
  `div_name` varchar(30) NOT NULL,
  UNIQUE KEY `div_id_UNIQUE` (`div_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `division`
--

LOCK TABLES `division` WRITE;
/*!40000 ALTER TABLE `division` DISABLE KEYS */;
INSERT INTO `division` VALUES (1,'Yangon'),(2,'Mandalay'),(3,'Naypyitaw'),(4,'Ayeyarwady'),(5,'Sagaing'),(6,'Magway'),(7,'Bago'),(8,'Tanintharyi'),(9,'Kachin'),(10,'Kayah'),(11,'Kayin'),(12,'Chin'),(13,'Mon'),(14,'Rakhine'),(15,'Shan'),(16,'Overseas');
/*!40000 ALTER TABLE `division` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `major` (
  `major_id` int(1) NOT NULL AUTO_INCREMENT,
  `major_name` varchar(15) NOT NULL,
  PRIMARY KEY (`major_id`),
  UNIQUE KEY `major_id_UNIQUE` (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (1,'Bio'),(2,'Eco');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `password`
--

DROP TABLE IF EXISTS `password`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `password` (
  `password_id` int(8) NOT NULL AUTO_INCREMENT,
  `password` varchar(65) NOT NULL,
  `create_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_timestamp` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `is_logged_in` tinyint(1) NOT NULL,
  PRIMARY KEY (`password_id`),
  UNIQUE KEY `password_id_UNIQUE` (`password_id`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `password`
--

LOCK TABLES `password` WRITE;
/*!40000 ALTER TABLE `password` DISABLE KEYS */;
INSERT INTO `password` VALUES (1,'$2a$10$9i5NEcC.P60iJr8t2fwsG.GQHx/DjCv/uFXw8CkAKkRzugwZakLpW','2019-06-16 13:58:01','2019-06-16 14:00:02',0),(2,'$2a$10$mTKXLjhcslwtESszMH2WzeBljY7I5KuDvIMdhN6SkVCkdfwFuX0rW','2019-06-16 14:01:02','2019-06-16 14:01:02',0),(3,'$2a$10$vMLWFJVKKABZ6LAPMqoujeqeJqrtPcaFzBVmcj5N2V4GhlbXd44Li','2019-06-16 14:02:01','2019-06-16 14:01:02',0),(4,'$2a$10$iwJVCtZvfEB5E8YVX9gKoO0xurzbbksGrEBPnCdW9fzy629PGep6a','2019-06-16 14:06:04','2019-06-16 14:06:04',0),(5,'$2a$10$4AK1p/Iavk7ct7XrbchQNugNGW/PFd3dVRwIqq8pjhky3cgtw3qNu','2019-06-16 14:08:05','2019-06-16 14:08:05',0),(6,'$2a$10$./jPNupwPrygdHHc0wDYcO32Svx6RS/VaJVr7Bq.g0/lt3usslAl.','2019-06-16 14:22:09','2019-06-16 14:22:09',0),(7,'$2a$10$SGl6ivHPKpj3QfTxD32k/eVLhJuiFRVkOr2AINSp.DJYGEuAtCR5G','2019-06-16 14:23:01','2019-06-16 14:23:01',0),(8,'$2a$10$ppYfL64q/MZKMcc4stipouPiZJTarjoyYT5raNQh9fOV1qp4Qid.O','2019-06-16 14:23:56','2019-06-16 14:23:56',0),(9,'$2a$10$sqj.Vs60TjZ6sO3828VHz.uyrroE9rjl0x/bvBwt/Qc2VyfYtTic2','2019-06-16 14:24:11','2019-06-16 14:24:55',0),(10,'$2a$10$yOv0EtfM3b5HtWk0OvPJ5.fEcqq7p8UjLvO39A197RXLf4sIltcTK','2019-06-16 14:25:05','2019-06-16 14:25:05',0),(11,'$2a$10$Z8JDWpWGoU7lTFx.bCUEFOLzbHaK.4Q0DkbM6Ay51EYIXYHIuuNaK','2019-06-16 14:25:54','2019-06-16 14:25:54',0),(12,'$2a$10$OZzOimiwF36A740kwAoqx.0I/SfHs9P/4.9HF2qo9qKtrsSLwdxN6','2019-06-16 14:26:22','2019-06-16 14:26:22',0),(13,'$2a$10$UbbXUgCrv1aaGcyVzbat4ewkRcuv0Dxv.6k8agzlek1nKEKPHpedW','2019-06-16 14:27:22','2019-06-16 14:27:22',0),(14,'$2a$10$PMTOg0PRW6rXHRjDs2baTuYJuwCukwJEjtzEyFgxGkIOF16X.RsQu','2019-06-16 14:28:12','2019-06-16 14:28:12',0),(15,'$2a$10$2RSNBTOPAHifJNbKUenKQed/KuIQJPpo7sKPaxjSs8rTw80FpalN6','2019-06-16 14:28:33','2019-06-16 14:28:33',0),(17,'$2a$10$EzFZ8JhKFtIS12dbFphDQeUPOjDEjsT3RyLuKOhl1AYTSHnLPv/pK','2019-07-17 07:30:03','2019-07-17 07:30:04',0),(18,'$2a$10$/zlPgpBl2BrN/tT4J6w7L.S6V4SHNJ6c2oTZ48h8elp/9LeurKUqC','2019-07-17 04:47:53','2019-07-17 04:47:54',0),(20,'$2a$10$CRp3AQAnF37PDbKNoPW6xefzzBhx2LwbeCJiKaUQ07BIv4lg./nem','2019-07-12 04:23:19','2019-07-12 04:23:20',0),(21,'$2a$10$RdjI3Pxjd0TFr7kIelhwQ.gLnCsdro21NdNxh.YwyPDKS60Glk9G6','2019-06-16 14:55:05','2019-06-16 14:55:05',0),(22,'$2a$10$N62hYJ7Zs8Hc6Zp7w/9nAerpz2JtdC/yyYB0xtTb//j8iH7uNvzEC','2019-06-16 14:55:22','2019-06-16 14:55:22',0),(23,'$2a$10$JTrlxwlQYTlbuQPi3cRE1./RseCyHEu8nf2zkNscsJmMvW5JfFSY.','2019-06-16 14:56:02','2019-06-16 14:56:02',0),(24,'$2a$10$/ZIq0wiwoKmW5N0VU.aE6uz14YicQfyOyl3ADlliAsH.n0IK.uFK.','2019-06-16 14:56:10','2019-06-16 14:56:10',0),(25,'$2a$10$k1cnJdehSoYFv1x0AMrsWuRmiuB11FtIPOGiFSZEp/HHIw09G7bJK','2019-06-16 14:56:26','2019-06-16 14:56:26',0),(26,'$2a$10$/3iALrku0ecMcKM/iodv7.wC5NPrGHV0PW3XVj0QXhCFX47TnIQX.','2019-06-16 14:57:22','2019-06-16 14:57:22',0),(27,'$2a$10$SFm5i5ZoIDdYitaKln.kGOUwbgFVj2juvxpVgrFGqVdYcN/pt3M5e','2019-06-16 14:57:45','2019-06-16 14:57:45',0),(28,'$2a$10$H3h1gsJi6z5LV6hD7sc61O.E1Nze3yihiAWNY9PxbUWWWT0qVJBJO','2019-06-16 14:57:55','2019-06-16 14:57:55',0),(29,'$2a$10$ksHr/htsh.6TJczObQ9WbuePtRk2WnppopSwlK4XM2hUiSfAiS9Km','2019-06-16 14:57:59','2019-06-16 14:57:59',0),(30,'$2a$10$00z971yMWJmx5ABKqEBEJOBP5O5rT1zq50Ae4UDSWwXqyDIaxYe62','2019-06-16 14:58:08','2019-06-16 14:58:08',0),(31,'$2a$10$fluHLqdlGTmrf9Gywq0T0ucik25n1o6xNKCXCIr97pXxI/7MgxH56','2019-06-16 14:58:11','2019-06-16 14:58:11',0),(32,'$2a$10$hWOiKYJmoJiySNVyF7Ei.eEEWHg5oxbhelxxMAsAmfd92BJCncVwu','2019-06-16 15:00:02','2019-06-16 15:00:02',0),(33,'$2a$10$Uc2sW.cehPTmqi8VseKWluq/vk7pD6jBidARmE9q/uzJGvrS0/LQG','2019-06-16 15:01:02','2019-06-16 15:01:02',0),(34,'$2a$10$WSCl2RFQgIGSjy0Tg9s8xuMg6USlM/d6AJ3dBGGrffYDkAh8Dw3R6','2019-06-16 15:01:43','2019-06-16 15:01:43',0),(35,'$2a$10$KpASa4kFtYb8gUUJxpClHuSPgdi7fr.DXg2lTZXo.kN2o.QQIoAIS','2019-06-16 15:01:51','2019-06-16 15:01:51',0),(36,'$2a$10$4ikJUTPyLEmBU7YRqqpn.uo08vx1i0xWunZv6vvZpddQSAbH9yyvu','2019-06-16 15:02:08','2019-06-16 15:02:08',0),(37,'$2a$10$u4f7NZZuyEjUJnUdph4JxeqMfAnKTPchfqNweQM/vXYu6sh./rnPi','2019-06-16 15:32:02','2019-06-16 15:32:02',0),(38,'$2a$10$MKmYhiFn8ddLRfs8c.wnu.tIwkSVRqrPty3WagUcK4XOkodMlrrOy','2019-06-16 15:32:15','2019-06-16 15:32:15',0),(39,'$2a$10$c8rNx21T/WY.O56bGJ2Z7.RGenjYPktIRHJOaudDThQDu4wWWxk2.','2019-06-16 15:32:55','2019-06-16 15:32:55',0),(40,'$2a$10$fvSiwnIi6Vox/StF4YUpoe8goIcCaafeiaB7lyU2vlkq..ok2pVKi','2019-06-16 15:33:12','2019-06-16 15:33:12',0),(41,'$2a$10$FUxGpQ9zd1KyyGmJk2HKL.tTA.mnSmGRE3yKKKIga/TS.dg.Bb8Ba','2019-06-16 15:34:12','2019-06-16 15:34:12',0),(42,'$2a$10$niRgYEXXdaQe62FGvKTg.uBd8Vd/dDW0Y7msveRmEgcccKmub0g36','2019-06-16 15:34:15','2019-06-16 15:34:15',0),(43,'$2a$10$QQkSOQcTRtSnkHXDlEKw9OeN7eOU70MEFjXzabfGfA.G20wKF7zAO','2019-06-16 15:34:22','2019-06-16 15:34:22',0),(44,'$2a$10$P1JAWQVHggBgUdutzyYfWu8vzWbrFHp3B2cFfw5vjTQH3Qd/TGVle','2019-07-15 10:38:45','2019-07-15 10:38:45',0),(45,'$2a$10$RL74QqOmFf0hPc6CSUL/veQqBYUW9lE4Agrm2.5FwiwEzHpn80/yG','2019-06-16 15:35:12','2019-06-16 15:35:12',0),(46,'$2a$10$6xsxPxzvakte/Kgu3HoveuTIdcbChbTqgJ6bAkwZfgCl8a65Tx3Sq','2019-06-16 15:35:33','2019-06-16 15:35:33',0),(47,'$2a$10$hdYqfFq7LR04JR7kYJXVcuPWeku3POo1UB7ZTJdG7.IdWCRY31r6y','2019-06-16 15:35:44','2019-06-16 15:35:44',0),(48,'$2a$10$sT7T.xgKA5lVJA1DpTTJkeSX74Qova3hUKSrzVERUVgItozENskVW','2019-06-16 15:35:55','2019-06-16 15:35:55',0),(49,'$2a$10$H0NokqgUhWjnDCkxoJUj1uUENIQWEGf66SwwP9ZlaFIzsy4RoGLky','2019-06-16 15:36:11','2019-06-16 15:36:11',0),(50,'$2a$10$BFqJgYpjsqjcV6BFEO8Ve.7Hv.FHjaz3LmjM1ketS0s5L4UzdXhfu','2019-06-16 15:36:22','2019-06-16 15:36:22',0),(51,'$2a$10$I89H71on9cb2lK0tWhCZq..b6c3naNGeQEzZxTQcvQwUMycONjYFe','2019-06-16 15:36:33','2019-06-16 15:36:33',0),(52,'$2a$10$JDLtUWakDOV0tmn4bMfgOOMfbDXwENjpnSh.zT/op/4na9B9IV3Ya','2019-06-16 15:36:44','2019-06-16 15:36:44',0),(53,'$2a$10$oF/ldtu5.I9CAlOvLXdCNemVrxaLC0Sv9fToxCZvQUK14dJ7mYqQK','2019-06-16 15:36:55','2019-06-16 15:36:55',0),(54,'$2a$10$ztB04/Xocs.jK0hEwFE8R.wxmqbqVRGfoi8wlGAXiopHMZlwqXVV2','2019-06-16 15:37:11','2019-06-16 15:37:11',0),(55,'$2a$10$KhGg0ZDgUwQHVSUCH6h82uIwIedDpCu1cyrC7F8ficb1XJ8.D/EkC','2019-06-16 15:37:33','2019-06-16 15:37:33',0),(56,'$2a$10$t/ZjfgTtEDO9s8Q/HSZhUeQv4eLVO1ysyCiNzwfSUkwYdSFwzVIv6','2019-06-16 15:37:44','2019-06-16 15:37:44',0),(57,'$2a$10$Y3Y77WBrgjASEdMRxO7tVuJkf5f.knva3MmXiJLb5JBU3iX/mxDuu','2019-06-16 15:37:55','2019-06-16 15:37:55',0),(58,'$2a$10$A6Pq.jMdfGEMWJ0pzkDite2mRwWq7BsAToNaXL7RtQxCk6t8qycp6','2019-06-16 15:38:12','2019-06-16 15:38:12',0),(59,'$2a$10$U5EgyMMNLvjoZYVA0Fx7Q.XTWFyXaH3xw85axiWWFZWzz3RyuT3vC','2019-06-16 15:38:33','2019-06-16 15:38:33',0),(60,'$2a$10$Gj/YSk8CCNi9IY64QqFdzemi3jINtA8SVShk/dc9Kr2.fzPqxHrWa','2019-06-16 15:39:11','2019-06-16 15:39:11',0),(61,'$2a$10$VBaPw1CztpBoyox5Bc/OHe9ygKjzpAPiaPQIAoUosz0Ai8Eah8k3a','2019-06-16 15:40:11','2019-06-16 15:40:11',0),(62,'$2a$10$vSqXYkMMxvk4BygnBl9r7OjAfnjOzTuXoVgadmgt6Tpj/w7Q/3hCS','2019-06-16 15:40:22','2019-06-16 15:40:22',0),(63,'$2a$10$W0DlWRwfDt1Agnpgjv3QmO0ZiSZXlaBtzo1eHDCHgB4s0SiM5gz2a','2019-06-16 15:40:33','2019-06-16 15:40:33',0),(64,'$2a$10$Hg11sx3eg30ThFLL.WH1Q.98mZg9DiKuC5qDn3Tq21Xri17CHjgAy','2019-06-16 15:40:44','2019-06-16 15:40:44',0),(65,'$2a$10$f/QJQRPheCQqOYCs6AaOlOLi5UyiktHOguoLhH82nL00LUPdhnXSS','2019-06-16 15:40:55','2019-06-16 15:40:55',0),(66,'$2a$10$ODovb6VuylEMCVJ37Gx/UOfGmzGy6.gV4vg6xXF.UotWTGcB3LSZG','2019-07-10 03:40:20','2019-07-10 03:40:20',0),(67,'$2a$10$ijgZ/x744XChWsfZD/K6Su8KmUC.WAesIfkURfuntJxbfgx0TeYL.','2019-06-16 15:41:22','2019-06-16 15:41:22',0),(68,'$2a$10$AaK6KoeR7Ynbo6JKHCJb2.WSIuR/DLirDw1qpBcff8PO9gcpv6f.C','2019-06-16 15:41:33','2019-06-16 15:41:33',0),(69,'$2a$10$2QVR6Iwt8K/SVHu4T4Y7Gex6Xb1IIlyhMPHefnDjfP5bL4jA1vZda','2019-07-17 04:11:56','2019-07-17 04:11:56',0),(70,'$2a$10$xNk4pPacVfE8PkpAaw0g.efdARMlUmZY76s2Spsfvh/kGNjtUaIRy','2019-06-16 15:42:33','2019-06-16 15:42:33',0),(71,'$2a$10$7uAnpMxC3XU.tocyaSOHEuql/pYEHSkZqfLgNiVJFijEbxS8iBo..','2019-06-16 15:42:45','2019-06-16 15:42:45',0),(72,'$2a$10$VDcAZE1M04iGn/F3ZolLEuJ6WOuwdj0tGVX6NiPMOH5qTxjqwfMkq','2019-06-16 15:42:55','2019-06-16 15:42:55',0),(73,'$2a$10$hcKjRD3zvnZJM2zBDQYB9uJ8EiGnq.i6lN6whv8zmr3At8tC3M9Oq','2019-06-16 15:42:32','2019-06-16 15:42:32',0),(74,'$2a$10$BErg95YNh7aX058suQwtXu7gCL51RuDC5.dDXqpAclouKX8vR4nXq','2019-06-16 15:43:42','2019-06-16 15:43:42',0),(75,'$2a$10$rvrdOU73hTFNJ9i9Jgrzze3l/iNL9EMG2uK1OjajmjNaJ4nQJ6K6y','2019-06-16 15:43:55','2019-06-16 15:43:55',0),(76,'$2a$10$w2savAgFQZYtl8A6Rsjh/OyC2R79ldqKwBx0zbHbaXbX6Bbh.7tt2','2019-06-16 15:44:22','2019-06-16 15:44:22',0),(77,'$2a$10$GAbRp9VTDtpTaoZKyEdLNu.SMJnH8.sd9QHAWhkU.NcQ94f87LESq','2019-07-25 07:36:37','2019-07-02 00:16:24',0),(78,'$2a$10$GAbRp9VTDtpTaoZKyEdLNu.SMJnH8.sd9QHAWhkU.NcQ94f87LESq','2019-07-25 07:32:49','2019-06-16 06:25:40',0),(79,'$2a$10$GAbRp9VTDtpTaoZKyEdLNu.SMJnH8.sd9QHAWhkU.NcQ94f87LESq','2019-07-25 04:32:55','2019-06-16 06:26:11',0),(80,'$2a$10$GAbRp9VTDtpTaoZKyEdLNu.SMJnH8.sd9QHAWhkU.NcQ94f87LESq','2019-07-25 04:08:57','2019-07-15 05:38:21',0),(81,'$2a$10$GAbRp9VTDtpTaoZKyEdLNu.SMJnH8.sd9QHAWhkU.NcQ94f87LESq','2019-07-25 04:28:05','2019-07-15 05:38:21',0),(82,'$2a$10$GAbRp9VTDtpTaoZKyEdLNu.SMJnH8.sd9QHAWhkU.NcQ94f87LESq','2019-07-25 04:28:05','2019-07-15 05:38:21',0),(83,'$2a$10$GAbRp9VTDtpTaoZKyEdLNu.SMJnH8.sd9QHAWhkU.NcQ94f87LESq','2019-07-25 04:28:05','2019-07-15 05:38:21',0),(84,'$2a$10$GAbRp9VTDtpTaoZKyEdLNu.SMJnH8.sd9QHAWhkU.NcQ94f87LESq','2019-07-25 04:28:05','2019-07-15 05:38:21',0),(85,'$2a$10$mIIF3MThwPuSTidkAsyB6.46HGF6Aj15Au04/JGj2btgyeUf2x/xu','2019-07-17 06:18:16','2019-07-17 06:18:16',0),(86,'$2a$10$BqsgWMk4qHgRcBjjvIq6G.GHI7DMRPwbvhmSDTJ0Xu.P.utOseJnq','2019-07-20 13:49:42','2019-07-20 18:58:55',0);
/*!40000 ALTER TABLE `password` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `result` (
  `res_id` int(7) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `stu_id` int(7) unsigned zerofill DEFAULT NULL,
  `Myan` int(3) DEFAULT NULL,
  `Engl` int(3) DEFAULT NULL,
  `Math` int(3) DEFAULT NULL,
  `Chem` int(3) DEFAULT NULL,
  `Phys` int(3) DEFAULT NULL,
  `Bio_Eco` int(3) DEFAULT NULL,
  PRIMARY KEY (`res_id`),
  UNIQUE KEY `res_id_UNIQUE` (`res_id`),
  KEY `stu` (`stu_id`),
  CONSTRAINT `stu_id` FOREIGN KEY (`stu_id`) REFERENCES `student` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=156 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
INSERT INTO `result` VALUES (0000125,0000003,75,75,90,90,83,92),(0000126,0000004,40,34,63,52,48,50),(0000127,0000005,56,54,65,83,74,51),(0000128,0000006,56,54,65,83,74,51),(0000129,0000007,56,54,65,83,74,51),(0000130,0000008,56,78,62,83,74,88),(0000131,0000009,56,54,65,83,74,51),(0000132,0000010,56,54,65,83,74,51),(0000133,0000011,56,54,65,83,74,51),(0000134,0000012,56,54,65,83,74,51),(0000135,0000025,56,54,65,83,74,51),(0000136,0000014,56,54,65,83,74,51),(0000137,0000015,56,54,65,83,74,51),(0000138,0000016,56,54,65,83,74,51),(0000139,0000017,56,54,65,83,74,51),(0000140,0000018,64,74,80,83,70,75),(0000141,0000019,75,75,90,90,83,92),(0000142,0000020,40,34,63,52,48,50),(0000143,0000021,56,54,65,83,74,51),(0000144,0000022,56,54,65,83,74,51),(0000145,0000023,56,54,65,83,74,51),(0000146,0000024,66,77,88,80,40,50),(0000147,0000077,55,80,80,90,90,90),(0000148,0000076,66,80,80,90,99,99),(0000149,0000066,89,89,89,89,89,89),(0000150,0000026,8,88,8,8,8,8),(0000155,0000079,8,8,8,8,8,8);
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spring_session`
--

DROP TABLE IF EXISTS `spring_session`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `spring_session` (
  `PRIMARY_ID` char(36) NOT NULL,
  `SESSION_ID` char(36) NOT NULL,
  `CREATION_TIME` bigint(20) NOT NULL,
  `LAST_ACCESS_TIME` bigint(20) NOT NULL,
  `MAX_INACTIVE_INTERVAL` int(11) NOT NULL,
  `EXPIRY_TIME` bigint(20) NOT NULL,
  `PRINCIPAL_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY `SPRING_SESSION_IX1` (`SESSION_ID`),
  KEY `SPRING_SESSION_IX2` (`EXPIRY_TIME`),
  KEY `SPRING_SESSION_IX3` (`PRINCIPAL_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_session`
--

LOCK TABLES `spring_session` WRITE;
/*!40000 ALTER TABLE `spring_session` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spring_session_attributes`
--

DROP TABLE IF EXISTS `spring_session_attributes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `spring_session_attributes` (
  `SESSION_PRIMARY_ID` char(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`,`ATTRIBUTE_NAME`),
  CONSTRAINT `SPRING_SESSION_ATTRIBUTES_FK` FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `spring_session` (`PRIMARY_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spring_session_attributes`
--

LOCK TABLES `spring_session_attributes` WRITE;
/*!40000 ALTER TABLE `spring_session_attributes` DISABLE KEYS */;
/*!40000 ALTER TABLE `spring_session_attributes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `stu_id` int(7) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `stu_rollno` varchar(20) NOT NULL,
  `year` varchar(4) NOT NULL,
  `twn_id` int(3) NOT NULL,
  `major_id` int(1) NOT NULL,
  `stu_name` varchar(50) NOT NULL,
  `password_id` int(8) NOT NULL,
  `stu_dob` date NOT NULL,
  `stu_nrc` varchar(25) DEFAULT NULL,
  `stu_school` varchar(35) NOT NULL,
  PRIMARY KEY (`stu_id`),
  KEY `major_id_idx` (`major_id`),
  KEY `twn_id_idx` (`twn_id`),
  KEY `password_id_idx` (`password_id`),
  CONSTRAINT `major_id` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`),
  CONSTRAINT `password_id` FOREIGN KEY (`password_id`) REFERENCES `password` (`password_id`),
  CONSTRAINT `twn_id` FOREIGN KEY (`twn_id`) REFERENCES `township` (`twn_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (0000001,'nakata-67','2018',13,2,'Mg Wai Yan',86,'2003-07-18','12/dagama(N)098976','Success Private School'),(0000003,'aawa-18','2019',18,1,'Mg Htet Aung',18,'2003-03-03','-','Ahtaka Thabaung'),(0000004,'aaya-17','2019',17,2,'Ma Aye Chan',17,'2003-03-04','-','Ahtaka Yegyi'),(0000005,'aazaa-20','2019',20,1,'Mg Oo Thiha',20,'2003-04-05','-','Ahtaka Ngapudaw'),(0000006,'daba-67','2019',67,2,'Ma Moe Moe Swe',67,'2003-06-09','-','Ahtaka Buthidaung'),(0000007,'daga-68','2019',68,2,'Mg Thura Oo',68,'2003-06-08','-','Ahtaka Gwa'),(0000008,'daka-69','2019',69,2,'Mg Kaung Zaw Thant',69,'2003-09-03','-','Ahtaka Kyaukkpyu'),(0000009,'dakha-70','2019',70,2,'Mg Thet Moe',70,'2003-08-03','-','Ahtaka Kyauktaw'),(0000010,'dana-66','2019',66,2,'Ma Su Sandar Swe',66,'2003-05-07','-','Ahtaka Ann'),(0000011,'hsabahta-5','2019',5,2,'Ma Hayman',5,'2003-04-02','-','Ahtaka Botataung'),(0000012,'hsamaou-1','2019',1,1,'Mg Hein Htet',1,'2003-02-01','12/OKM(N)223271','Ahtaka North Okkalapa'),(0000013,'hsataou-3','2019',3,1,'Ma Moe',3,'2003-06-01','-','Ahtaka South Okkalapa'),(0000014,'hsathaka-4','2019',4,1,'Mg Thiha',4,'2003-02-04','1/MKN(N)566777','Ahtaka Thingangyun'),(0000015,'hsayaka-2','2019',2,2,'Ma Su Su',2,'2003-06-04','-','Ahtaka Yankin'),(0000016,'kama-41','2019',41,2,'Ma Wint Thiri Myaing',41,'2003-03-05','-','Ahtaka Myityina'),(0000017,'kana-42','2019',42,1,'Ma May Zin Phyo Wai',42,'2003-02-04','-','Ahtaka Tanai'),(0000018,'kanya-45','2019',45,1,'Mg Htet Linn Maung',45,'2003-02-05','-','Ahtaka Mohnyin'),(0000019,'kawa-44','2019',44,1,'Mg Wai Yan Nay Min',44,'2003-05-09','-','Ahtaka Waingmaw'),(0000020,'kaza-43','2019',43,1,'Mg Nay Min Zaw',43,'2003-06-04','-','Ahtaka Chipwi'),(0000021,'khaha-57','2019',57,1,'Mg Zin Min Myat',57,'2003-09-02','-','Ahtaka Hakaha'),(0000022,'khapa-58','2019',58,1,'Mg Aye Thu Aung',58,'2003-03-08','-','Ahtaka Matupi'),(0000023,'khapha-56','2019',56,1,'Mg Aung Win Htut',56,'2003-03-15','-','Ahtaka Falam'),(0000024,'khatahta-60','2019',60,2,'Ma San Myint Mo Htet',60,'2003-09-09','-','Ahtaka Htanlang'),(0000025,'khawa-59','2019',59,1,'Ma Hnin Set',59,'2003-04-08','-','Ahtaka Paletwa'),(0000026,'laba-52','2019',52,1,'Ma Thae Thae',52,'2002-12-30','-','Ahtaka Hpa-An'),(0000027,'laka-53','2019',53,1,'Ma Zin Zin Myint',53,'2003-02-01','6/KTN(N)788976','Ahtaka KawKareik'),(0000028,'lala-51','2019',51,2,'Ma Thet Hmue',51,'2003-07-07','-','Ahtaka HlaingBwe'),(0000029,'lama-54','2019',54,2,'Ma Yu War Aung',54,'2003-08-09','6/BPN(N)092738','Ahtaka Myawaddy'),(0000030,'latatha-55','2019',55,2,'Ma Nolay',55,'2003-03-08','-','Ahtaka Thandaunggy(Thandaung)'),(0000031,'manaaa-10','2019',10,1,'Ma Thandar',10,'2003-10-10','-','Ahtaka  Maha Aungmye'),(0000032,'manakha-6','2019',6,1,'Ma Thet Hnin',6,'2004-03-01','-','Ahtaka Pyigyidagun '),(0000033,'manama-8','2019',8,2,'Mg Tala',8,'2003-09-01','-','Ahtaka Aungmyethazan'),(0000034,'manata-7','2019',7,1,'Ma Zar Li',7,'2004-06-07','-','Ahtaka Chanayethazan '),(0000035,'manatha-9','2019',9,1,'Ma Myint Myat',9,'2003-04-15','-','Ahtaka Chanmyathazi'),(0000036,'nakata-13','2019',13,1,'Ma Chan May',13,'2003-02-05','-','Ahtaka Pobbathiri'),(0000037,'nakha-76','2019',76,2,'Ma Honey',76,'2003-06-03','-','Ahtaka Overseas'),(0000038,'naouta-11','2019',11,2,'Mg Zaw Htet',11,'2003-10-02','-','Ahtaka Ottarathiri'),(0000039,'napana-14','2019',14,1,'Ma Sandi',14,'2003-04-04','9/PBN(N)234444','Ahtaka Pyinmana'),(0000040,'naya-12','2019',12,1,'Ma Hsu Nandar',12,'2003-10-08','-','Ahtaka Zeyathiri'),(0000041,'nazama-15','2019',15,2,'Ma Wathann',15,'2003-03-03','-','Ahtaka Zabuthiri'),(0000042,'nyaba-61','2019',61,2,'Ma May Htet Shan ',61,'2003-03-08','-','Ahtaka Bilin'),(0000043,'nyada-64','2019',64,2,'Mg Zaw Win Htut',64,'2002-12-09','-','Ahtaka Mudon'),(0000044,'nyaka-63','2019',63,1,'Ma Aye Chan Myint',63,'2003-03-09','-','Ahtaka Kyaikto'),(0000045,'nyakha-62','2019',62,1,'Ma Su Su Htwe',62,'2003-04-09','-','Ahtaka Chaungzon'),(0000046,'nyapa-65','2019',65,1,'Ma War So Moe Oo',65,'2003-03-09','-','Ahtaka Paung'),(0000047,'pada-35','2019',35,1,'Ma Pann Kapyar ',35,'2003-06-03','-','Ahtaka Daik-U'),(0000048,'pakha-31','2019',31,2,'Mg Htaw',31,'2003-02-04','-','Ahtaka Bago'),(0000049,'panaa-34','2019',34,1,'Ma Mee Mee',34,'2003-03-05','-','Ahtaka Shwegyin'),(0000050,'panya-33','2019',33,1,'Ma Hsu Htet',33,'2002-10-18','-','Ahtaka Nyaunglebin '),(0000051,'pazaa-32','2019',32,2,'Mg Aung Zaw Htet',32,'2002-09-25','-','Ahtaka Kyauktaga'),(0000052,'phahsa-28','2019',28,1,'Ma Moe Wathann',28,'2003-04-03','-','Ahtaka Myothit'),(0000053,'phakha-27','2019',27,1,'Ma Sandi Su',27,'2003-03-04','-','Ahtaka Chauk'),(0000054,'phama-26','2019',26,1,'Ma Thu Thu Myint ',26,'2003-06-15','-','Ahtaka Magway'),(0000055,'phana-29','2019',29,2,'Ma Hnin Zarli',29,'2003-02-01','-','Ahtaka Natmauk'),(0000056,'phaya-30','2019',30,2,'Ma Hnin Phyu Thet',30,'2003-04-04','-','Ahtaka Yenangyaung'),(0000057,'raka-74','2019',74,1,'Ma Htet Htet Naing',74,'2003-09-04','-','Ahtaka Taunggyi'),(0000058,'rala-71','2019',71,2,'Ma Ei Ei Swe',71,'2003-03-08','-','Ahtaka LoilLin'),(0000059,'ranya-73','2019',73,1,'Mg Htet Linn Naing',73,'2003-04-08','-','Ahtaka Nyaungshwe'),(0000060,'ratha-75','2019',75,1,'Ma Eaint Chue',75,'2003-03-08','-','Ahtaka Kalaw'),(0000061,'raya-72','2019',72,1,'Ma Htet War Ni Lin',72,'2003-06-14','-','Ahtaka Pintaya'),(0000062,'sahsa-22','2019',22,1,'Ma Nandar Su',22,'2003-06-06','-','Ahtaka Myinmu'),(0000063,'saka-24','2019',24,1,'Ma May Chan Aye',24,'2003-04-17','-','Ahtaka Kale'),(0000064,'sama-23','2019',23,1,'Mg Htet Aung Zaw ',23,'2003-03-08','-','Ahtaka Myaung'),(0000065,'sanga-25','2019',25,1,'Ma Phyo Thandar',25,'2003-05-06','-','Ahtaka Mingin'),(0000066,'sasa-21','2019',21,1,'Ma Myat Thu',21,'2003-04-21','-','Ahtaka Sagaing'),(0000067,'tahta-36','2019',36,1,'Ma Aye Aye Moe',36,'2003-02-03','-','Ahtaka Dawei'),(0000068,'tala-37','2017',37,1,'Ma Pont Pont',37,'2003-03-03','-','Ahtaka Launglon'),(0000069,'tama-39','2019',39,2,'Ma Win Myat Myat Thandar Phyo',39,'2003-03-06','6/MMN(N)425282','Ahtaka Myeik'),(0000070,'tana-40','2019',40,2,'Ma Htet Htet ',40,'2003-03-06','-','Ahtaka Tanintharyi'),(0000071,'tatha-38','2019',38,2,'Ma Thiri Moe ',38,'2003-02-04','-','Ahtaka Thayetchaung'),(0000072,'yaba-47','2019',47,1,'Ma Nay Chi',47,'2003-02-05','-','Ahtaka BawLakhe'),(0000073,'yala-46','2019',46,1,'Mg Chan Myae Naing',46,'2003-03-05','-','Ahtaka Loikaw'),(0000074,'yama-50','2019',50,2,'Mg Nan Maung',50,'2003-01-30','-','Ahtaka Mese'),(0000075,'yapha-49','2019',49,1,'Ma Kay Thi',49,'2003-06-17','-','Ahtaka Hpruso'),(0000076,'yarata-48','2019',48,1,'Mg Chan Myae Aung',48,'2003-04-09','-','Ahtaka Shadaw'),(0000077,'yarata-48','2018',48,1,'Mg Thaw',48,'2000-04-09','-','Ahtaka Shadaw'),(0000078,'sama-90','2019',23,1,'Kyi Oo Khin',80,'2003-07-15','','Ahtaka Ma-Ubin	'),(0000079,'hsayaka-15','2018',2,1,'Ma Kin kin',85,'1996-07-02','','Athaka  1 Yankin'),(0000080,'naya-66','1998',12,1,'Ma Thet Mhue',86,'2003-07-09','12/dagama(N)035854','Success Private School');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `township`
--

DROP TABLE IF EXISTS `township`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `township` (
  `twn_id` int(3) NOT NULL AUTO_INCREMENT,
  `div_id` int(2) NOT NULL,
  `twn_code` varchar(8) NOT NULL,
  `twn_name` varchar(30) NOT NULL,
  PRIMARY KEY (`twn_id`),
  UNIQUE KEY `twn_id_UNIQUE` (`twn_id`),
  KEY `div_id_idx` (`div_id`),
  CONSTRAINT `div_id` FOREIGN KEY (`div_id`) REFERENCES `division` (`div_id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `township`
--

LOCK TABLES `township` WRITE;
/*!40000 ALTER TABLE `township` DISABLE KEYS */;
INSERT INTO `township` VALUES (1,1,'hsamaou','North Okkalapa'),(2,1,'hsayaka','Yankin'),(3,1,'hsataou','South Okkalapa'),(4,1,'hsathaka','Thingangyun'),(5,1,'hsabahta','Botataung'),(6,2,'manakha','Pyigyidagun '),(7,2,'manata','Chanayethazan '),(8,2,'manama','Aungmyethazan'),(9,2,'manatha','Chanmyathazi'),(10,2,'manaaa','Maha Aungmye'),(11,3,'naouta','Ottarathiri'),(12,3,'naya','Zeyathiri'),(13,3,'nakata','Pobbathiri'),(14,3,'napana','Pyinmana'),(15,3,'nazama','Zabuthiri'),(16,4,'aatha','Pathein'),(17,4,'aaya','Yegyi'),(18,4,'aawa','Thabaung'),(19,4,'aanga','Ma-Ubin'),(20,4,'aazaa','Ngapudaw'),(21,5,'sasa','Sagaing'),(22,5,'sahsa','Myinmu'),(23,5,'sama','Myaung'),(24,5,'saka','Kale'),(25,5,'sanya','Mingin'),(26,6,'phama','Magway'),(27,6,'phakha','Chauk'),(28,6,'phahsa','Myothit'),(29,6,'phana','Natmauk'),(30,6,'phaya','Yenangyaung'),(31,7,'pakha','Bago'),(32,7,'pazaa','Kyauktaga'),(33,7,'panya','Nyaunglebin '),(34,7,'panaa','Shwegyin'),(35,7,'pada','Daik-U'),(36,8,'tahta','Dawei'),(37,8,'tala','Launglon'),(38,8,'tatha','Thayetchaung'),(39,8,'tama','Myeik'),(40,8,'tana','Tanintharyi'),(41,9,'kama','Myityina'),(42,9,'kana','Tanai'),(43,9,'kaza','Chipwi'),(44,9,'kawa','Waingmaw'),(45,9,'kanya','Mohnyin'),(46,10,'yala','Loikaw'),(47,10,'yaba','BawLakhe'),(48,10,'yarata','Shadaw'),(49,10,'yapha','Hpruso'),(50,10,'yama','Mese'),(51,11,'lala','HlaingBwe'),(52,11,'laba','Hpa-An'),(53,11,'laka','KawKareik'),(54,11,'lama','Myawaddy'),(55,11,'latatha','Thandaunggy(Thandaung)\n'),(56,12,'khapha','Falam'),(57,12,'khaha','Hakaha'),(58,12,'khapa','Matupi'),(59,12,'khawa','Paletwa'),(60,12,'khatahta','Htanlang'),(61,13,'nyaba','Bilin'),(62,13,'nyakha','Chaungzon'),(63,13,'nyaka','Kyaikto'),(64,13,'nyada','Mudon'),(65,13,'nyapa','Paung'),(66,14,'dana','Ann'),(67,14,'daba','Buthidaung'),(68,14,'daga','Gwa'),(69,14,'daka','Kyaukkpyu'),(70,14,'dakha','Kyauktaw'),(71,15,'rala','LoilLin'),(72,15,'raya','Pintaya'),(73,15,'ranya','Nyaungshwe'),(74,15,'raka','Taunggyi'),(75,15,'ratha','Kalaw'),(76,16,'nakha','Overseas'),(77,15,'yahaha','Heho'),(78,2,'catsi','Chan Aye Thar Si');
/*!40000 ALTER TABLE `township` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-08 16:20:13
