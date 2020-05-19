package com.java.jdbc;

import com.java.jdbc.model.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDao {
    private MysqlConnection mysqlConnection;

    public PetDao() {
        this.mysqlConnection = new MysqlConnection();
    }

    public void addToDataBase(Pet pet) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = mysqlConnection.getConnection();
//            statement = connection.prepareStatement(PetsTableQueries.CREATE_DATABASE_QUERY);
            statement = connection.prepareStatement(PetsTableQueries.CREATE_DATABASE_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, pet.getName());
            statement.setInt(2, pet.getAge());
            statement.setString(3, pet.getOwnerName());
            statement.setDouble(4, pet.getWeight());
            statement.setBoolean(5, pet.isPureRace());

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long generatedKey = generatedKeys.getLong(1);
                pet.setId(generatedKey);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    if (statement != null) {
                        statement.close();
                    }
                    connection.close();
                }
            } catch (SQLException throwables) {
                System.err.println("Błąd zamknięcia połączenia");
            }
        }
    }

    public List<Pet> getAllPets() {
        List<Pet> list = new ArrayList<>();
        try (Connection connection = mysqlConnection.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(PetsTableQueries.SELECT_ALL_PET_QUERY)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Pet newPet = Pet.builder()
                            .id(resultSet.getLong(1))
                            .name(resultSet.getString(2))
                            .age(resultSet.getInt(3))
                            .ownerName(resultSet.getString(4))
                            .weight(resultSet.getDouble(5))
                            .pureRace(resultSet.getBoolean(6))
                            .build();
                    list.add(newPet);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
