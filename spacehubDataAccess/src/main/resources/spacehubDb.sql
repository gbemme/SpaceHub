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
-- Table `spacehubUser`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehubUser` ;

CREATE TABLE IF NOT EXISTS `spacehubUser` (
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(100) NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spacehubBooking`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehubBooking` ;

CREATE TABLE IF NOT EXISTS `spacehubBooking` (
  `book_id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NULL,
  `lastname` VARCHAR(45) NULL,
  `phone_number` INT NULL,
  `email` VARCHAR(45) NULL,
  `time` DATETIME NULL,
  `spacehubUser_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`book_id`, `spacehubUser_email`),
  INDEX `fk_spacehubBooking_spacehubUser1_idx` (`spacehubUser_email` ASC),
  CONSTRAINT `fk_spacehubBooking_spacehubUser1`
    FOREIGN KEY (`spacehubUser_email`)
    REFERENCES `spacehubUser` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `productStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `productStatus` ;

CREATE TABLE IF NOT EXISTS `productStatus` (
  `productStatusId` INT NOT NULL AUTO_INCREMENT,
  `productStatusDetail` VARCHAR(45) NULL,
  PRIMARY KEY (`productStatusId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `product` ;

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NULL,
  `product_plan` VARCHAR(45) NULL,
  `product_price` DOUBLE NULL,
  `product_img` VARCHAR(45) NULL,
  `spacehubBooking_book_id` INT NOT NULL,
  `spacehubUser_email` VARCHAR(45) NOT NULL,
  `productStatus_productStatusId` INT NOT NULL,
  PRIMARY KEY (`product_id`, `spacehubBooking_book_id`, `spacehubUser_email`),
  INDEX `fk_product_spacehubBooking_idx` (`spacehubBooking_book_id` ASC),
  INDEX `fk_product_spacehubUser1_idx` (`spacehubUser_email` ASC),
  INDEX `fk_product_productStatus1_idx` (`productStatus_productStatusId` ASC),
  CONSTRAINT `fk_product_spacehubBooking`
    FOREIGN KEY (`spacehubBooking_book_id`)
    REFERENCES `spacehubBooking` (`book_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_spacehubUser1`
    FOREIGN KEY (`spacehubUser_email`)
    REFERENCES `spacehubUser` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_productStatus1`
    FOREIGN KEY (`productStatus_productStatusId`)
    REFERENCES `productStatus` (`productStatusId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spacehubRole`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `spacehubRole` ;

CREATE TABLE IF NOT EXISTS `spacehubRole` (
  `spacehubRoleId` INT NOT NULL AUTO_INCREMENT,
  `spacehubRoleName` VARCHAR(45) NULL,
  PRIMARY KEY (`spacehubRoleId`),
  UNIQUE KEY `TITLE_UNIQUE`(`spacehubRoleName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `spacehub`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_role` ;

CREATE TABLE IF NOT EXISTS `user_role` (
  `userRole_id` INT NOT NULL AUTO_INCREMENT,
  `spacehubUser_email` VARCHAR(45) NOT NULL,
  `spacehubRole_roleId` INT NOT NULL,
  PRIMARY KEY (`userRole_id`),
  INDEX `fk_user_role_spacehubUser1_idx` (`spacehubUser_email` ASC),
  INDEX `fk_user_role_spacehubRole1_idx` (`spacehubRole_roleId` ASC),
  CONSTRAINT `fk_user_role_spacehubUser1`
    FOREIGN KEY (`spacehubUser_email`)
    REFERENCES `spacehubUser` (`email`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_user_role_spacehubRole1`
    FOREIGN KEY (`spacehubRole_roleId`)
    REFERENCES `spacehubRole` (`spacehubRoleId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
