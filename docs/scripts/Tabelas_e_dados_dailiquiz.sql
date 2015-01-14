-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: 127.0.0.1    Database: dailyquiz
-- ------------------------------------------------------
-- Server version	5.6.22

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
-- Table structure for table `Alternativa`
--

DROP TABLE IF EXISTS `Alternativa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alternativa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordem` int(11) NOT NULL,
  `descricao` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `idQuestao` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_alternativa_questao1_idx` (`idQuestao`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alternativa`
--

LOCK TABLES `Alternativa` WRITE;
/*!40000 ALTER TABLE `Alternativa` DISABLE KEYS */;
INSERT INTO `Alternativa` VALUES (1,0,'Pedro',1),(2,0,'4',2),(3,1,'7',2),(4,2,'90',2),(5,0,'Um vetor',3),(6,1,'nao array',3),(7,2,'Alguma coisa',3),(8,0,'Um conceito de linguagem de programação',4),(9,1,'uma coisa do mundo real',4),(10,2,'nao sei',4),(11,0,'uma propriedade de uma classe',5),(12,1,'uma coisa atribuida',5),(13,2,'é um atributo',5);
/*!40000 ALTER TABLE `Alternativa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Membro`
--

DROP TABLE IF EXISTS `Membro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Membro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `senha` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `dataNascimento` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Membro`
--

LOCK TABLES `Membro` WRITE;
/*!40000 ALTER TABLE `Membro` DISABLE KEYS */;
INSERT INTO `Membro` VALUES (1,'Fernando','fercampospinheiro','sueli','1985-01-14 00:00:00'),(2,'Fernando','fercampospinheiro@gmail.com','5f071429250ee41b3570bdbe30d10d18e17f7516','1985-01-14 00:00:00'),(3,'Sueli','suelibcp@gmail.com','f0fa59c2cce064b49c5b801c5883aada84ef63c5','1966-09-26 00:00:00');
/*!40000 ALTER TABLE `Membro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Questao`
--

DROP TABLE IF EXISTS `Questao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Questao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idQuestionario` int(11) NOT NULL,
  `idAlternativaCorreta` int(11) NOT NULL,
  `ordem` int(11) NOT NULL,
  `pergunta` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_questao_questionario_idx` (`idQuestionario`),
  KEY `fk_Questao_Alternativa1_idx` (`idAlternativaCorreta`),
  CONSTRAINT `fk_Questao_Alternativa1` FOREIGN KEY (`idAlternativaCorreta`) REFERENCES `Alternativa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_questao_questionario` FOREIGN KEY (`idQuestionario`) REFERENCES `Questionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Questao`
--

LOCK TABLES `Questao` WRITE;
/*!40000 ALTER TABLE `Questao` DISABLE KEYS */;
INSERT INTO `Questao` VALUES (1,1,1,0,'Quem descobriu'),(2,2,2,0,'Quanto é 2+2?'),(3,2,5,1,'O que é um array?'),(4,2,8,2,'O que é um objeto?'),(5,2,11,3,'O que é um atributo?');
/*!40000 ALTER TABLE `Questao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Questionario`
--

DROP TABLE IF EXISTS `Questionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Questionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dataDisponivel` datetime DEFAULT NULL,
  `dataLimite` datetime DEFAULT NULL,
  `idMembroCriador` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Questionario_Membro1_idx` (`idMembroCriador`),
  CONSTRAINT `fk_Questionario_Membro1` FOREIGN KEY (`idMembroCriador`) REFERENCES `Membro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Questionario`
--

LOCK TABLES `Questionario` WRITE;
/*!40000 ALTER TABLE `Questionario` DISABLE KEYS */;
INSERT INTO `Questionario` VALUES (1,'Prova de ingles','2014-11-11 00:00:00','2014-11-12 00:00:00',1),(2,'Teste de Lógica','2014-11-11 00:00:00','2014-11-12 00:00:00',1),(3,'Perguntas da Bíblia','2014-11-11 00:00:00','2014-11-12 00:00:00',1);
/*!40000 ALTER TABLE `Questionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RespostaQuestao`
--

DROP TABLE IF EXISTS `RespostaQuestao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RespostaQuestao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idRespostaQuestionario` int(11) NOT NULL,
  `idQuestao` int(11) NOT NULL,
  `idAlternativa` int(11) NOT NULL,
  `ordem` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_RespostaQuestao_RespostaQuestionario1_idx` (`idRespostaQuestionario`),
  KEY `fk_RespostaQuestao_Questao1_idx` (`idQuestao`),
  KEY `fk_RespostaQuestao_Alternativa1_idx` (`idAlternativa`),
  CONSTRAINT `fk_RespostaQuestao_Alternativa1` FOREIGN KEY (`idAlternativa`) REFERENCES `Alternativa` (`id`),
  CONSTRAINT `fk_RespostaQuestao_Questao1` FOREIGN KEY (`idQuestao`) REFERENCES `Questao` (`id`),
  CONSTRAINT `fk_RespostaQuestao_RespostaQuestionario1` FOREIGN KEY (`idRespostaQuestionario`) REFERENCES `RespostaQuestionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RespostaQuestao`
--

LOCK TABLES `RespostaQuestao` WRITE;
/*!40000 ALTER TABLE `RespostaQuestao` DISABLE KEYS */;
INSERT INTO `RespostaQuestao` VALUES (1,4,2,3,0),(2,4,3,6,1),(3,4,4,9,2),(4,4,5,12,3);
/*!40000 ALTER TABLE `RespostaQuestao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `RespostaQuestionario`
--

DROP TABLE IF EXISTS `RespostaQuestionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `RespostaQuestionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` datetime NOT NULL,
  `idMembro` int(11) NOT NULL,
  `IdQuestionario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_RespostaQuestionario_Membro1_idx` (`idMembro`),
  KEY `fk_RespostaQuestionario_Questionario1_idx` (`IdQuestionario`),
  CONSTRAINT `fk_RespostaQuestionario_Membro1` FOREIGN KEY (`idMembro`) REFERENCES `Membro` (`id`),
  CONSTRAINT `fk_RespostaQuestionario_Questionario1` FOREIGN KEY (`IdQuestionario`) REFERENCES `Questionario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RespostaQuestionario`
--

LOCK TABLES `RespostaQuestionario` WRITE;
/*!40000 ALTER TABLE `RespostaQuestionario` DISABLE KEYS */;
INSERT INTO `RespostaQuestionario` VALUES (4,'2015-01-13 00:00:00',2,2);
/*!40000 ALTER TABLE `RespostaQuestionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-01-14  0:02:15
