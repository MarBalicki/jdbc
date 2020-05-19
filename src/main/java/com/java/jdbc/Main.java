package com.java.jdbc;

import com.java.jdbc.model.Pet;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PetDao dao = new PetDao();
        Pet pet = Pet.builder()
                .name("Abi")
                .age(1)
                .ownerName("Hania_Nagórska")
                .weight(2.0)
                .pureRace(false)
                .build();
        dao.addToDataBase(pet);

//        List<Pet> petList = dao.getAllPets();
//        petList.forEach(System.out::println);


    }
}
