DROP DATABASE  IF EXISTS `angularjs_user_list`;

CREATE DATABASE  IF NOT EXISTS `angularjs_user_list`;
USE `angularjs_user_list`;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
CREATE TABLE `profile` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `profile`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- A generation tool is avail at: https://www.dailycred.com/article/bcrypt-calculator
--
-- Default passwords are: test123
--

INSERT INTO `profile` 
VALUES 
('employee','{bcrypt}$2a$04$Db5KWqKHpsAYD9KFU8Xp2OIdyP3OaozRymW9refvUiimzSET3KuxC',1),
('manager','{bcrypt}$2a$04$4NK1N41BpUV4mGWEA9/CreFlsaDqfqSAKhgYt1D/H5LVi3gBne/b6',1),
('admin','{bcrypt}$2a$04$oXhqrK.YKDhc6EbpOz.MXOP5LQb.S8Uc27fv1GV7jVEI8sqi7yWfe',1);


--
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `profile` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

INSERT INTO `authorities` 
VALUES 
('employee','ROLE_EMPLOYEE'),
('manager','ROLE_EMPLOYEE'),
('manager','ROLE_MANAGER'),
('admin','ROLE_EMPLOYEE'),
('admin','ROLE_ADMIN');

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` VALUES 
(1,'Edin','Dzeko','edin@someemail.com'),
(2,'Meho','Kodro','meho@someemail.com');

