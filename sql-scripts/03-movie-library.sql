-- Create database

CREATE DATABASE  IF NOT EXISTS `movie_library`;
USE `movie_library`;

-- Table structure for table `code`

DROP TABLE IF EXISTS `movies`;

CREATE TABLE `movies` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `category` varchar(50) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `plot` varchar(1000) DEFAULT NULL,
  `image_name` varchar(100) DEFAULT NULL,
  `image_location` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;