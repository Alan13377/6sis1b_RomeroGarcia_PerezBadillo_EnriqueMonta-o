-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ventas
-- ------------------------------------------------------
-- Server version	5.7.29-log

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cli` int(11) NOT NULL AUTO_INCREMENT,
  `dni_cli` varchar(45) NOT NULL,
  `nom_cli` varchar(45) NOT NULL,
  `direc_cli` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cli`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (10,'3343','Karla','rom@gmail.com','Insurgentes'),(11,'44398','Aldair','San antonio','alda@gmail.com'),(12,'94950','Juan','Mixcoac','juan@gmail.com'),(19,'444488','Alan','Alvaro Obregon','alan@gmail.com'),(20,'3344','Carlos','Insurgentes','rom@gmail.com'),(23,'334858','Gustavo','Alvaro Obregon','alan@gmail.com'),(27,'455','Maria','Mixcoac','mari@gmail.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!50001 DROP VIEW IF EXISTS `clientes`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `clientes` AS SELECT 
 1 AS `id_cli`,
 1 AS `dni_cli`,
 1 AS `nom_cli`,
 1 AS `direc_cli`,
 1 AS `email`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `cprovedor`
--

DROP TABLE IF EXISTS `cprovedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cprovedor` (
  `id_pro` int(11) NOT NULL AUTO_INCREMENT,
  `nom_empresa` varchar(45) NOT NULL,
  `ubi_pro` varchar(45) NOT NULL,
  `tel_pro` int(11) NOT NULL,
  `email_pro` varchar(45) NOT NULL,
  PRIMARY KEY (`id_pro`)
) ENGINE=InnoDB AUTO_INCREMENT=45563 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cprovedor`
--

LOCK TABLES `cprovedor` WRITE;
/*!40000 ALTER TABLE `cprovedor` DISABLE KEYS */;
INSERT INTO `cprovedor` VALUES (45562,'Chevorlet','Mixcoac',3455443,'chevo@gmail.com');
/*!40000 ALTER TABLE `cprovedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ealmacen`
--

DROP TABLE IF EXISTS `ealmacen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ealmacen` (
  `id_alm` int(11) NOT NULL AUTO_INCREMENT,
  `arm_prod` varchar(45) NOT NULL,
  `mod_prod` varchar(45) NOT NULL,
  `num_exis` int(11) NOT NULL,
  `ano_prod` date NOT NULL,
  PRIMARY KEY (`id_alm`)
) ENGINE=InnoDB AUTO_INCREMENT=23433 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ealmacen`
--

LOCK TABLES `ealmacen` WRITE;
/*!40000 ALTER TABLE `ealmacen` DISABLE KEYS */;
INSERT INTO `ealmacen` VALUES (23432,'Nissan','Chevrolet',0,'2020-09-08');
/*!40000 ALTER TABLE `ealmacen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eproduccion`
--

DROP TABLE IF EXISTS `eproduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eproduccion` (
  `id_prod` int(11) NOT NULL AUTO_INCREMENT,
  `fecini_prod` date NOT NULL,
  `fecter_prod` date NOT NULL,
  `mod_prod` varchar(45) NOT NULL,
  `num_prod` varchar(45) NOT NULL,
  PRIMARY KEY (`id_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=94596 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eproduccion`
--

LOCK TABLES `eproduccion` WRITE;
/*!40000 ALTER TABLE `eproduccion` DISABLE KEYS */;
INSERT INTO `eproduccion` VALUES (9549,'2020-08-13','2020-08-29','Aveo','4'),(94595,'2020-08-07','2020-08-21','Focus','2');
/*!40000 ALTER TABLE `eproduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `piezas_almacen`
--

DROP TABLE IF EXISTS `piezas_almacen`;
/*!50001 DROP VIEW IF EXISTS `piezas_almacen`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `piezas_almacen` AS SELECT 
 1 AS `id_alm`,
 1 AS `arm_prod`,
 1 AS `mod_prod`,
 1 AS `num_exis`,
 1 AS `ano_prod`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id_prod` int(11) NOT NULL AUTO_INCREMENT,
  `nom_prod` varchar(45) NOT NULL,
  `Precio` int(11) NOT NULL,
  `Stock` int(11) NOT NULL,
  PRIMARY KEY (`id_prod`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'LLantas',200,300),(2,'Faros',150,500),(3,'Ventanas',300,200),(4,'Volante',150,100);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!50001 DROP VIEW IF EXISTS `productos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `productos` AS SELECT 
 1 AS `id_prod`,
 1 AS `nom_prod`,
 1 AS `Precio`,
 1 AS `Stock`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `total_ventas`
--

DROP TABLE IF EXISTS `total_ventas`;
/*!50001 DROP VIEW IF EXISTS `total_ventas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `total_ventas` AS SELECT 
 1 AS `id_venta`,
 1 AS `id_cli`,
 1 AS `id_vend`,
 1 AS `num_ventas`,
 1 AS `fecha`,
 1 AS `monto`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `id_vend` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `user` varchar(45) NOT NULL,
  PRIMARY KEY (`id_vend`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedor`
--

LOCK TABLES `vendedor` WRITE;
/*!40000 ALTER TABLE `vendedor` DISABLE KEYS */;
INSERT INTO `vendedor` VALUES (1,'1337','Alan','5548585','Administrador','Alan'),(2,'74736','AlanYeren','54838575','Vendedor','Yeren'),(3,'39499','Enrique','5593994','Almacen','Enrique'),(4,'48384','Juan','64647384','Vendedor','Juan'),(5,'45678','Juan','566646','Administrador','Juan'),(6,'5677','Maria','455644','Vendedor','Maria'),(19,'4568','Carlos','556633','Almacen','Carlos');
/*!40000 ALTER TABLE `vendedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vendedores`
--

DROP TABLE IF EXISTS `vendedores`;
/*!50001 DROP VIEW IF EXISTS `vendedores`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vendedores` AS SELECT 
 1 AS `id_vend`,
 1 AS `dni`,
 1 AS `nombre`,
 1 AS `telefono`,
 1 AS `estado`,
 1 AS `user`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id_venta` int(11) NOT NULL AUTO_INCREMENT,
  `id_cli` int(11) NOT NULL,
  `id_vend` int(11) NOT NULL,
  `num_ventas` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `monto` float NOT NULL,
  PRIMARY KEY (`id_venta`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,1,1,3,'2020-08-22',600),(2,44398,1,4,'2020-08-15',800),(3,44398,1,4,'2020-08-15',800),(4,44398,1,4,'2020-08-15',800),(5,94950,1,3,'2020-08-16',1250);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'ventas'
--
/*!50003 DROP PROCEDURE IF EXISTS `Consulatr el Id de los empleados` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Consulatr el Id de los empleados`(
in nombre_empleado varchar(45),
in apellido_pat varchar(45),
in apellido_mat varchar(45)
)
BEGIN

select cod_emp as cod,
nom_emp as nombre_emple,
appat_emp as apellido_paterno,
apmat_emp as apellido_materno
from mempleado
where nom_emp=nom_empleado
and appat_emp=paterno
and apmat_emp=materno;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Consultar dni y nombre empleado por area` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Consultar dni y nombre empleado por area`(
in puesto varchar(45)
)
BEGIN
select dni, estado ,nombre
from vendedor as vend
where puesto = estado;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Consultar el ID cliente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Consultar el ID cliente`(
in nombre_cliente varchar(45),
in apellido_pat varchar(45),
in apellido_mat varchar(45)
)
BEGIN

select id_cli as cli,
nom_cli as nombre_emple,
appat_cli as apellido_paterno,
apmat_cli as apellido_materno
from cliente
where nom_cli=nom_cliente
and appat_cli=paterno
and apmat_cli=materno;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Consultar producto,precio, stock por ID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Consultar producto,precio, stock por ID`(
in id int
)
BEGIN
 select nom_prod as prod, Precio as pre, Stock as sto
 from producto
 where id = id_prod;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Consultar venta por ide de vendedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Consultar venta por ide de vendedor`(
in Id int
)
BEGIN

select num_ventas as No_ven, fecha as fec, monto as total
from ventas
where id = id_vend;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Insertar nueva venta` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar nueva venta`(
in id_cliente int,
in id_vendedor int,
in No_venta int,
in fecha date,
in total float
)
BEGIN

insert into ventas(id_cli, id_vend, num_ventas, fecha, monto)
values (id_cliente, id_vendedor, No_venta, fecha, total);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Insertar nuevo empleado` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar nuevo empleado`(
in dni int,
in nom varchar(45),
in tel int,
in estado varchar(45),
in usuario varchar(45)
)
BEGIN

insert into vendedor(dni,nombre,telefono,estado,user)
values (dni,nom,tel,estado,usuario);

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Insertar nuevo Producto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Insertar nuevo Producto`(
in producto varchar(45),
in precio float,
in stock int
)
BEGIN
insert into producto (nom_prod,Precio,Stock)
values (producto,precio,stock);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Ventas totales por dia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Ventas totales por dia`(
in fecha date
)
BEGIN

select fec_ven as fecha,
count(id_dventa) as ventas_totales
from ventasdiarias where fec_ven=fecha
group by fec_ven;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `clientes`
--

/*!50001 DROP VIEW IF EXISTS `clientes`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `clientes` AS select `cliente`.`id_cli` AS `id_cli`,`cliente`.`dni_cli` AS `dni_cli`,`cliente`.`nom_cli` AS `nom_cli`,`cliente`.`direc_cli` AS `direc_cli`,`cliente`.`email` AS `email` from `cliente` where (`cliente`.`id_cli` = 10) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `piezas_almacen`
--

/*!50001 DROP VIEW IF EXISTS `piezas_almacen`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `piezas_almacen` AS select `ealmacen`.`id_alm` AS `id_alm`,`ealmacen`.`arm_prod` AS `arm_prod`,`ealmacen`.`mod_prod` AS `mod_prod`,`ealmacen`.`num_exis` AS `num_exis`,`ealmacen`.`ano_prod` AS `ano_prod` from `ealmacen` order by `ealmacen`.`id_alm` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `productos`
--

/*!50001 DROP VIEW IF EXISTS `productos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `productos` AS select `producto`.`id_prod` AS `id_prod`,`producto`.`nom_prod` AS `nom_prod`,`producto`.`Precio` AS `Precio`,`producto`.`Stock` AS `Stock` from `producto` order by `producto`.`id_prod` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `total_ventas`
--

/*!50001 DROP VIEW IF EXISTS `total_ventas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `total_ventas` AS select `venta`.`id_venta` AS `id_venta`,`venta`.`id_cli` AS `id_cli`,`venta`.`id_vend` AS `id_vend`,`venta`.`num_ventas` AS `num_ventas`,`venta`.`fecha` AS `fecha`,`venta`.`monto` AS `monto` from `venta` group by `venta`.`id_venta` desc */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vendedores`
--

/*!50001 DROP VIEW IF EXISTS `vendedores`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vendedores` AS select `vendedor`.`id_vend` AS `id_vend`,`vendedor`.`dni` AS `dni`,`vendedor`.`nombre` AS `nombre`,`vendedor`.`telefono` AS `telefono`,`vendedor`.`estado` AS `estado`,`vendedor`.`user` AS `user` from `vendedor` where (`vendedor`.`id_vend` = 5) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-19 19:06:58
