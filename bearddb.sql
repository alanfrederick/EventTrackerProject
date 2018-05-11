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
-- Table `strokingdb`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `strokingdb` ;

CREATE TABLE IF NOT EXISTS `strokingdb` (
  `idbeard` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `date` DATETIME NULL,
  PRIMARY KEY (`idbeard`))
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
