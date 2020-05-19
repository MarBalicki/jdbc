package com.java.jdbc;

public interface PetsTableQueries {
    String CREATE_DATABASE_QUERY = "CREATE DATABASE IF NOT EXISTS `pets_jdbc`;";
    String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS `petsCopy` (\n" +
            "`id` INT AUTO_INCREMENT PRIMARY KEY, \n" +
            "`name` VARCHAR(30) NOT NULL, \n" +
            "`age` INT NOT NULL, \n" +
            "`ownerName` VARCHAR(30) NOT NULL, \n" +
            "`weight` DECIMAL(10,2),\n" +
            "`pureRace` TINYINT NOT NULL);";
    String INSERT_PET_QUERY = "INSERT INTO `pets` (`name`, `age`, `ownerName`, `weight`, `pureRace`) values (?, ?, ?, ?, ?);";
    String SELECT_ALL_PET_QUERY = "SELECT * FROM `pets`;";
    String UPDATE_PET_QUERY = "UPDATE `pets` SET `name` = ?, `age` = ?, `ownerName` = ?, `weight` = ?, `pureRace` = ? where `id` = ?;";
    String DELETE_PET_QUERY = "DELETE FROM `pets` WHERE `id` = ?;";
//    String ID_PET_QUERY = "select id from pets where id = ?;";
}
