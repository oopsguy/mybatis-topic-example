CREATE DATABASE `mybatis_topic_chapter2`;

USE mybatis_topic_chapter2;

CREATE TABLE `user` (
  `id` INT(11) AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` char(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;