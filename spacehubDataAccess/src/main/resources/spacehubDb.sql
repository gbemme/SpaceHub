-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema spacehub
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `spacehub` ;

-- -----------------------------------------------------
-- Schema spacehub
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `spacehub` DEFAULT CHARACTER SET utf8 ;
USE `spacehub` ;


-- -----------------------------------------------------
-- Table `spacehub`.`spacehubUser`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`spacehubUser` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`spacehubUser` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  `enabled` TINYINT(1) NULL,
  PRIMARY KEY (`id`, `email`),
  INDEX `index2` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spacehub`.`spacehubBooking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`spacehubBooking` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`spacehubBooking` (
  `book_id` INT NOT NULL AUTO_INCREMENT,
  `time` DATETIME NULL,
  PRIMARY KEY (`book_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spacehub`.`productStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`productStatus` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`productStatus` (
  `productStatusId` INT NOT NULL AUTO_INCREMENT,
  `productStatusDetail` VARCHAR(45) NULL,
  PRIMARY KEY (`productStatusId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spacehub`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`product` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NULL,
  `product_plan` VARCHAR(45) NULL,
  `product_price` DOUBLE NULL,
  `product_image` VARCHAR(45) NULL,
  `spacehubUser_id` INT NOT NULL,
  `spacehubBooking_book_id` INT NOT NULL,
  `productStatus_productStatusId` INT NOT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `fk_product_spacehubUser1_idx` (`spacehubUser_id` ASC),
  INDEX `fk_product_spacehubBooking1_idx` (`spacehubBooking_book_id` ASC),
  INDEX `fk_product_productStatus1_idx` (`productStatus_productStatusId` ASC),
  CONSTRAINT `fk_product_spacehubUser1`
    FOREIGN KEY (`spacehubUser_id`)
    REFERENCES `spacehub`.`spacehubUser` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_spacehubBooking1`
    FOREIGN KEY (`spacehubBooking_book_id`)
    REFERENCES `spacehub`.`spacehubBooking` (`book_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_productStatus1`
    FOREIGN KEY (`productStatus_productStatusId`)
    REFERENCES `spacehub`.`productStatus` (`productStatusId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spacehub`.`spacehubRole`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`spacehubRole` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`spacehubRole` (
  `spacehubRoleId` INT NOT NULL AUTO_INCREMENT,
  `spacehubRoleName` VARCHAR(45) NULL,
  `spacehubUser_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`spacehubRoleId`),
  INDEX `fk_spacehubRole_spacehubUser1_idx` (`spacehubUser_email` ASC),
  CONSTRAINT `fk_spacehubRole_spacehubUser1`
    FOREIGN KEY (`spacehubUser_email`)
    REFERENCES `spacehub`.`spacehubUser` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spacehub`.`organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`organization` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`organization` (
  `organizationId` INT NOT NULL AUTO_INCREMENT,
  `organizationName` VARCHAR(100) NULL,
  `spacehubUser_id` INT NOT NULL,
  PRIMARY KEY (`organizationId`),
  INDEX `fk_organization_spacehubUser1_idx` (`spacehubUser_id` ASC),
  CONSTRAINT `fk_organization_spacehubUser1`
    FOREIGN KEY (`spacehubUser_id`)
    REFERENCES `spacehub`.`spacehubUser` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spacehub`.`organization_has_spacehubBooking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`organization_has_spacehubBooking` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`organization_has_spacehubBooking` (
  `organization_organizationId` INT NOT NULL,
  `spacehubBooking_book_id` INT NOT NULL,
  PRIMARY KEY (`organization_organizationId`),
  INDEX `fk_organization_has_spacehubBooking_organization1_idx` (`organization_organizationId` ASC),
  INDEX `fk_organization_has_spacehubBooking_spacehubBooking1_idx` (`spacehubBooking_book_id` ASC),
  CONSTRAINT `fk_organization_has_spacehubBooking_organization1`
    FOREIGN KEY (`organization_organizationId`)
    REFERENCES `spacehub`.`organization` (`organizationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_organization_has_spacehubBooking_spacehubBooking1`
    FOREIGN KEY (`spacehubBooking_book_id`)
    REFERENCES `spacehub`.`spacehubBooking` (`book_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
