CREATE TABLE `db_bidding`.`tbl_users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email` (`id` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
