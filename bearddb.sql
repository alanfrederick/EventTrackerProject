-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema bearddb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bearddb` ;

-- -----------------------------------------------------
-- Schema bearddb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bearddb` DEFAULT CHARACTER SET utf8 ;
USE `bearddb` ;

-- -----------------------------------------------------
-- Table `stroking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `stroking` ;

CREATE TABLE IF NOT EXISTS `stroking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
GRANT USAGE ON *.* TO student@localhost;
 DROP USER student@localhost;
SET SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
CREATE USER 'student'@'localhost' IDENTIFIED BY 'student';

GRANT SELECT, INSERT, TRIGGER ON TABLE * TO 'student'@'localhost';
GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'student'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `stroking`
-- -----------------------------------------------------
START TRANSACTION;
USE `bearddb`;
INSERT INTO `stroking` (`id`, `first_name`, `last_name`, `city`) VALUES (1, 'Alan', 'Frederick', 'Denver');
INSERT INTO `stroking` (`id`, `first_name`, `last_name`, `city`) VALUES (2, 'Bob', 'Dobbs', 'Atlanta');

COMMIT;
