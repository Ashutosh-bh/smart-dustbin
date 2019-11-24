DROP TABLE IF EXISTS `dustbin`;
CREATE TABLE `dustbin` (
  `id` int(11) NOT NULL,
  `area_code` mediumtext NOT NULL,
  `latitude` mediumtext NOT NULL,
  `longitude` mediumtext NOT NULL,
  `address` varchar(255) NOT NULL,
  `filling_status` varchar(20) default NULL,
  `fire_status` varchar(20) default NULL,
  `decomp_status` varchar(20) default NULL,
  `ultrasensor` bigint(20) default NULL,
  `mq2` mediumtext,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


LOCK TABLES `dustbin` WRITE;
INSERT INTO `dustbin` VALUES (1,'110046','1112.11','1133.12','Gali no. 1, geetanjali park','unfilled','fire','ok',19,'450'),(2,'110046','1113.11','1134.12','Gali no. 5, geetanjali park','filled','ok','ok',3,'450'),(3,'110046','1160.66','1170.90','Gali no. 8, geetanjali park','ok','ok','ok',12,150),(4,'110046','1150.66','1160.90','Gali no. 6, geetanjali park','ok','ok','ok',10,200),(5,'110047','1212.11','1233.12','Gali no. 2, indra park','ok','ok','ok',16,100);
UNLOCK TABLES;