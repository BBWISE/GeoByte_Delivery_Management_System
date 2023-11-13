CREATE DATABASE IF NOT EXISTS `geobyte_delivery_management_system`;  -- Creating the System's database if not exists.

USE `geobyte_delivery_management_system`; -- Statement to use the newly created database.

-- Creating the 'user' table.
CREATE TABLE IF NOT EXISTS `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    
    PRIMARY KEY(`id`)
);

-- Creating the 'location' table.
CREATE TABLE IF NOT EXISTS `location` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL UNIQUE,
    `clearing_cost` INT NOT NULL,
    
    PRIMARY KEY (`id`)
);

-- Creating the 'delivery' table.
CREATE TABLE IF NOT EXISTS `delivery` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `location_id` INT  NOT NULL,
    
    PRIMARY KEY(`id`),
    
    CONSTRAINT `location_ref`
		FOREIGN KEY(`location_id`)
        REFERENCES `geobyte_delivery_management_system`.`location`(`id`)
);

-- Creating the 'path' table
CREATE TABLE IF NOT EXISTS `path` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `location_id` INT NOT NULL,
    `intermediate_id` INT NOT NULL,
    `distance` INT NOT NULL,
    
    PRIMARY KEY(`id`),
    
    CONSTRAINT `location_ref2`
		FOREIGN KEY (`location_id`)
        REFERENCES `geobyte_delivery_management_system`.`location`(`id`),
	
    CONSTRAINT `intermediate_ref`
		FOREIGN KEY (`location_id`)
        REFERENCES `geobyte_delivery_management_system`.`location`(`id`)
);

INSERT INTO location (id,name,clearing_cost) VALUES(1, 'GeoByte',25);