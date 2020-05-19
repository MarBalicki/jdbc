CREATE DATABASE IF NOT EXISTS `pets_jdbc`;

CREATE TABLE IF NOT EXISTS `pets` (
            `id` INT AUTO_INCREMENT PRIMARY KEY,
            `name` VARCHAR(30) NOT NULL,
            `age` INT NOT NULL,
            `ownerName` VARCHAR(30) NOT NULL,
            `weight` DECIMAL(10,2) NOT NULL,
            `pureRace`TINYINT NOT NULL);