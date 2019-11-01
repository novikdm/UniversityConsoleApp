CREATE DATABASE university
DEFAULT CHARACTER SET 'utf8'
COLLATE utf8_general_ci;

USE university;

CREATE TABLE `lector` (
  `id` int PRIMARY KEY AUTO_INCREMENT,
  `firstName` varchar(45),
  `lastName` varchar(45),
  `salary` double(7,2),
  `degree` int
);


CREATE TABLE `department` (
  `departmentId` int PRIMARY KEY AUTO_INCREMENT,
  `departmentName` varchar(255),
  `headOfDepartment` int
);

CREATE TABLE `degree` (
  `degreeId` int PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(45) NOT NULL UNIQUE
);

CREATE TABLE `lectorsdepartment` (
  `lectorsDepartmentId` int PRIMARY KEY AUTO_INCREMENT,
  `lector` int,
  `department` int
);

ALTER TABLE `department` ADD FOREIGN KEY (`headOfDepartment`) REFERENCES `lector` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `lector` ADD FOREIGN KEY (`degree`) REFERENCES `degree` (`degreeId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `lectorsDepartment` ADD FOREIGN KEY (`lector`) REFERENCES `lector` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `lectorsDepartment` ADD FOREIGN KEY (`department`) REFERENCES `department` (`departmentId`) ON DELETE NO ACTION ON UPDATE NO ACTION;
