CREATE DATABASE `db_bidding` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `db_bidding`.`tbl_roles` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE INDEX `role_id` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `db_bidding`.`tbl_users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
