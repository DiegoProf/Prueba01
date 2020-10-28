-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: 01_taller2
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `registrousuario`
--

DROP TABLE IF EXISTS `registrousuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registrousuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `NombreUsuario` varchar(45) NOT NULL,
  `Clave` varchar(45) NOT NULL,
  `TipoPerfil` varchar(45) NOT NULL,
  `NivelJuego` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NombreUsuario_UNIQUE` (`NombreUsuario`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrousuario`
--

LOCK TABLES `registrousuario` WRITE;
/*!40000 ALTER TABLE `registrousuario` DISABLE KEYS */;
INSERT INTO `registrousuario` VALUES (5,'Marcelo666','123123','Estudiante',NULL),(6,'DiegoM','123654','Profesor',NULL),(9,'Lolo Pepe','147147','Profesor',NULL),(14,'Tincho Profe','123147','Profesor',NULL),(15,'Diego Mendez','war666','Profesor',NULL),(19,'Lolo Popo','666999','Estudiante',NULL),(20,'Profe 1','profe333','Profesor',NULL),(21,'Estudiante 1','est777','Estudiante',NULL),(22,'Enzi','123888','Profesor',NULL),(23,'Manolo Pu','estaesparavos','Estudiante',NULL),(24,'Lalo Pipi','lalala01','Estudiante',NULL),(25,'admin','admin','Administrador',NULL),(26,'Bananero','lachota666','Profesor',NULL),(29,'Prophet','crysis','Profesor',NULL),(30,'Tiscornia','Pablito','Profesor',NULL),(39,'Sales','johnny','Profesor',NULL),(40,'Tisco','222','Profesor',NULL),(43,'Pimienta','podnopodno','Estudiante',NULL),(44,'Fedi','fefe44','Estudiante',NULL),(45,'Gaste','gastegod','Profesor',NULL),(47,'Pancho','101010','Profesor',NULL),(48,'Lalo Momo','111','Estudiante',NULL),(49,'Fabian','333','Profesor',NULL),(51,'Sales Choborra','johny','Profesor',NULL),(54,'Lanngguth','555','Profesor',NULL),(55,'Gloria','222111','Estudiante',NULL);
/*!40000 ALTER TABLE `registrousuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-26  0:34:02
