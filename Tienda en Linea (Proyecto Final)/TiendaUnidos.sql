-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tiendaunidos
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `carrito`
--

DROP TABLE IF EXISTS `carrito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrito` (
  `CarritoID` int(11) NOT NULL AUTO_INCREMENT,
  `NumeroProductos` int(11) NOT NULL,
  `PrecioTotal` int(11) NOT NULL,
  `ProductoID` int(11) NOT NULL,
  PRIMARY KEY (`CarritoID`),
  KEY `ProductoID` (`ProductoID`),
  CONSTRAINT `carrito_ibfk_1` FOREIGN KEY (`ProductoID`) REFERENCES `producto` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrito`
--

LOCK TABLES `carrito` WRITE;
/*!40000 ALTER TABLE `carrito` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `CategoriaID` int(11) NOT NULL AUTO_INCREMENT,
  `NombreCat` varchar(20) NOT NULL,
  `Descripcion` varchar(50) NOT NULL,
  PRIMARY KEY (`CategoriaID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'juguete','juguetes varios');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacionpago`
--

DROP TABLE IF EXISTS `informacionpago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `informacionpago` (
  `InfoPagoID` int(11) NOT NULL AUTO_INCREMENT,
  `FechaPago` varchar(10) NOT NULL,
  `Direccion` varchar(20) NOT NULL,
  `ExpiracionTjt` varchar(10) NOT NULL,
  `PinTarjeta` varchar(5) NOT NULL,
  `NumeroTarjeta` varchar(20) NOT NULL,
  `OrdenID` int(11) NOT NULL,
  PRIMARY KEY (`InfoPagoID`),
  KEY `OrdenID` (`OrdenID`),
  CONSTRAINT `informacionpago_ibfk_1` FOREIGN KEY (`OrdenID`) REFERENCES `orden` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacionpago`
--

LOCK TABLES `informacionpago` WRITE;
/*!40000 ALTER TABLE `informacionpago` DISABLE KEYS */;
/*!40000 ALTER TABLE `informacionpago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacionpersonal`
--

DROP TABLE IF EXISTS `informacionpersonal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `informacionpersonal` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Telefono` varchar(20) NOT NULL,
  `Correo` varchar(20) NOT NULL,
  `Ciudad` varchar(20) NOT NULL,
  `Pais` varchar(20) NOT NULL,
  `Direccion` varchar(20) NOT NULL,
  `CodigoPostal` varchar(10) NOT NULL,
  `UsuarioID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `UsuarioID` (`UsuarioID`),
  CONSTRAINT `informacionpersonal_ibfk_1` FOREIGN KEY (`UsuarioID`) REFERENCES `usuario` (`UsuarioID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacionpersonal`
--

LOCK TABLES `informacionpersonal` WRITE;
/*!40000 ALTER TABLE `informacionpersonal` DISABLE KEYS */;
/*!40000 ALTER TABLE `informacionpersonal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden`
--

DROP TABLE IF EXISTS `orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orden` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UsuarioID` int(11) NOT NULL,
  `NumOrden` int(11) NOT NULL,
  `FechaOrden` varchar(20) NOT NULL,
  `FechaRequerida` varchar(20) NOT NULL,
  `FechaEnvio` varchar(20) NOT NULL,
  `MetodoEnvio` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `UsuarioID` (`UsuarioID`),
  CONSTRAINT `orden_ibfk_1` FOREIGN KEY (`UsuarioID`) REFERENCES `usuario` (`UsuarioID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden`
--

LOCK TABLES `orden` WRITE;
/*!40000 ALTER TABLE `orden` DISABLE KEYS */;
/*!40000 ALTER TABLE `orden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderdetail` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ProductoID` int(11) NOT NULL,
  `Precio` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `NumeroDeOrden` int(11) NOT NULL,
  `Descuento` int(11) DEFAULT NULL,
  `OrdenID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ProductoID` (`ProductoID`),
  KEY `OrdenID` (`OrdenID`),
  CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`ProductoID`) REFERENCES `producto` (`ID`),
  CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`OrdenID`) REFERENCES `orden` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `producto` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NombreProducto` varchar(20) NOT NULL,
  `Descuento` int(11) DEFAULT NULL,
  `UnidadesEnOrden` int(11) NOT NULL,
  `UnidadesEnAlmacen` int(11) NOT NULL,
  `PrecioPorUnidad` int(11) NOT NULL,
  `CatntidadPorUnidad` int(11) NOT NULL,
  `DescripcionProducto` varchar(120) NOT NULL,
  `CategoriaID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `CategoriaID` (`CategoriaID`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`CategoriaID`) REFERENCES `categoria` (`CategoriaID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'pelota',0,0,10,100,1,'pelota roja',1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `UsuarioID` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(20) NOT NULL,
  `Pass` varchar(20) NOT NULL,
  `Admin` tinyint(1) NOT NULL,
  PRIMARY KEY (`UsuarioID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'juan luis','flores','123',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-22  3:03:47
