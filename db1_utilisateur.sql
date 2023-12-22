-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: db1
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utilisateur` (
  `id_utilisateur` int NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utilisateur`
--

LOCK TABLES `utilisateur` WRITE;
/*!40000 ALTER TABLE `utilisateur` DISABLE KEYS */;
INSERT INTO `utilisateur` VALUES (1,'hh@gmail.com','111','2023-04-20','ii','gg',NULL),(2,'i@gmail.com','xy','2023-04-20','ibtissam','amine',NULL),(7,'ta@gmail.com','123456789','2023-12-10','tata','',NULL),(8,'y@gmail.com','11111111','2023-12-10','yyy','',NULL),(9,'y@gmail.com','1234567890','2023-12-10','yyy','',NULL),(10,'j@gmail.com','aaaaaaaa','2023-12-10','jjjj','',NULL),(11,'hh@mail.com','123123123','2023-12-12','hihi','',NULL),(12,'ibt@gmail.com','qwertyui','2023-12-13','elamine','ibtissam',NULL),(13,'gi@gmail.com','123456788','2023-12-13','hi','gi',NULL),(14,'tt@gmail.com','wwwwwwww','2023-12-13','tt','yy',NULL),(15,'y@gmail.com','qqqqqqqq','2023-12-13','x','y',NULL),(16,'xy@gmail.com','wwwwwwww','2023-12-18','xxxxxxxxxx','yyyyyyyyyyyyy',NULL),(17,'xy@gmail.com','wwwwwwww','2023-12-18','xxxxxxxxxx','yyyyyyyyyyyyy',NULL),(20,'gg@gmail.com','11111111','2023-12-18','hhhh','hhhhhhh1','Stock Manager'),(21,'gg@gmail.com','11111111','2023-12-18','hhhh','hhhhhhh1','Stock Manager'),(22,'xy','123123123','2023-09-09','x','y',NULL),(23,'zy','123123123','2023-09-09','x','y',NULL);
/*!40000 ALTER TABLE `utilisateur` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-19 13:09:31
