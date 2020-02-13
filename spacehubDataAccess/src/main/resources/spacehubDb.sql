-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
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
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `company_name` VARCHAR(45) NULL DEFAULT NULL,
  `enabled` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `email`),
  UNIQUE INDEX `company_name_UNIQUE` (`company_name` ASC),
  INDEX `index2` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spacehub`.`organization`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`organization` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`organization` (
  `organizationId` INT(11) NOT NULL AUTO_INCREMENT,
  `organizationName` VARCHAR(100) NULL DEFAULT NULL,
  `spacehubUser_id` INT(11) NOT NULL,
  PRIMARY KEY (`organizationId`),
  INDEX `fk_organization_spacehubUser1_idx` (`spacehubUser_id` ASC),
  CONSTRAINT `fk_organization_spacehubUser1`
    FOREIGN KEY (`spacehubUser_id`)
    REFERENCES `spacehub`.`spacehubUser` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spacehub`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`product` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`product` (
  `product_id` INT(11) NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NULL DEFAULT NULL,
  `product_plan` VARCHAR(45) NULL DEFAULT NULL,
  `product_price` DOUBLE NULL DEFAULT NULL,
  `product_image` VARCHAR(45) NULL DEFAULT NULL,
  `product_status` VARCHAR(45) NULL,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spacehub`.`spacehubBooking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`spacehubBooking` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`spacehubBooking` (
  `book_id` INT(11) NOT NULL AUTO_INCREMENT,
  `time` DATETIME NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `duration` INT(31) NULL DEFAULT NULL,
  `product_product_id` INT(11) NOT NULL,
  `organization_organizationId` INT(11) NOT NULL,
  PRIMARY KEY (`book_id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_spacehubBooking_product1_idx` (`product_product_id` ASC),
  INDEX `fk_spacehubBooking_organization1_idx` (`organization_organizationId` ASC),
  CONSTRAINT `fk_spacehubBooking_organization1`
    FOREIGN KEY (`organization_organizationId`)
    REFERENCES `spacehub`.`organization` (`organizationId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_spacehubBooking_product1`
    FOREIGN KEY (`product_product_id`)
    REFERENCES `spacehub`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `spacehub`.`spacehubRole`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehub`.`spacehubRole` ;

CREATE TABLE IF NOT EXISTS `spacehub`.`spacehubRole` (
  `spacehubRoleId` INT(11) NOT NULL AUTO_INCREMENT,
  `spacehubRoleName` VARCHAR(45) NULL DEFAULT NULL,
  `spacehubUser_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`spacehubRoleId`),
  INDEX `fk_spacehubRole_spacehubUser1_idx` (`spacehubUser_email` ASC),
  CONSTRAINT `fk_spacehubRole_spacehubUser1`
    FOREIGN KEY (`spacehubUser_email`)
    REFERENCES `spacehub`.`spacehubUser` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
