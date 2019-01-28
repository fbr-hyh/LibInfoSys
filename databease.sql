-- MySQL dump 10.13  Distrib 8.0.13, for osx10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: libinfo
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `Book`
--

DROP TABLE IF EXISTS `Book`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `Book`
(
  `bookId`     varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `bookName`   varchar(20) COLLATE utf8mb4_general_ci NOT NULL,
  `bookPrice`  double                                 NOT NULL,
  `bookStatus` int(11)                                NOT NULL,
  PRIMARY KEY (`bookId`),
  UNIQUE KEY `Book_bookId_uindex` (`bookId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Book`
--

LOCK TABLES `Book` WRITE;
/*!40000 ALTER TABLE `Book`
  DISABLE KEYS */;
INSERT INTO `Book` (`bookId`, `bookName`, `bookPrice`, `bookStatus`)
VALUES ('Q124.1-1', 'Q124.1-1书书书', 232, 0),
       ('Q124.2-1', 'Q124.2-1书书书', 32, 0),
       ('TP124.1-1', 'TP124.1-1书书书', 123, 0),
       ('TP125.6-4', 'TP125.6-4书书书', 32, 0),
       ('TP126.6-4', 'TP126.6-4书书书', 32, 0);
/*!40000 ALTER TABLE `Book`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `BookStrategy`
--

DROP TABLE IF EXISTS `BookStrategy`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `BookStrategy`
(
  `strategyId`        int(11)                                 NOT NULL AUTO_INCREMENT,
  `strategyName`      varchar(20) COLLATE utf8mb4_general_ci  NOT NULL,
  `maxBorrowNum`      int(11)                                 NOT NULL,
  `borrowPeriods`     int(11)                                 NOT NULL,
  `blockedCategories` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`strategyId`),
  UNIQUE KEY `BookStrategy_strategyId_uindex` (`strategyId`),
  UNIQUE KEY `BookStrategy_strategyName_uindex` (`strategyName`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `BookStrategy`
--

LOCK TABLES `BookStrategy` WRITE;
/*!40000 ALTER TABLE `BookStrategy`
  DISABLE KEYS */;
INSERT INTO `BookStrategy` (`strategyId`, `strategyName`, `maxBorrowNum`, `borrowPeriods`, `blockedCategories`)
VALUES (1, 'teacherDefaultStra', 30, 50, ''),
       (2, 'underGraDefaultStra', 10, 20, 'Q'),
       (3, 'graDefaultStra', 20, 30, '');
/*!40000 ALTER TABLE `BookStrategy`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Record`
--

DROP TABLE IF EXISTS `Record`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `Record`
(
  `recordId`       int(11)                                NOT NULL AUTO_INCREMENT,
  `bookId`         varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `userId`         varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `borrowTime`     timestamp                              NOT NULL,
  `returnTime`     timestamp                              NULL DEFAULT NULL,
  `overduePenalty` double                                 NOT NULL,
  `recordStatus`   int(11)                                NOT NULL,
  PRIMARY KEY (`recordId`),
  UNIQUE KEY `Record_recordId_uindex` (`recordId`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 56
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Record`
--

LOCK TABLES `Record` WRITE;
/*!40000 ALTER TABLE `Record`
  DISABLE KEYS */;
INSERT INTO `Record` (`recordId`, `bookId`, `userId`, `borrowTime`, `returnTime`, `overduePenalty`, `recordStatus`)
VALUES (36, 'TP124.1-1', 'teacher', '2019-01-27 00:28:10', NULL, 100, 1);
/*!40000 ALTER TABLE `Record`
  ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `User`
(
  `userId`   varchar(15) COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `userType` int(11)                                NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `User_userId_uindex` (`userId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User`
  DISABLE KEYS */;
INSERT INTO `User` (`userId`, `password`, `userType`)
VALUES ('admin', '123', 4),
       ('admin2', '123123', 4),
       ('graduate', '123', 3),
       ('teacher', '123', 1),
       ('undergraduate', '123', 2);
/*!40000 ALTER TABLE `User`
  ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2019-01-27 22:57:02
