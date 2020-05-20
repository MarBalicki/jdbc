package com.java.jdbc;

import com.java.jdbc.model.Pet;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PetDao dao = new PetDao();

        Scanner scanner = new Scanner(System.in);
        String komenda;
        do {
            System.out.println("Wybierz polecenie: [add/list/byID/update/delete/quit]");
            komenda = scanner.nextLine();
            if (komenda.equalsIgnoreCase("add")) {
                addPet(dao, scanner);
            } else if (komenda.equalsIgnoreCase("list")) {
                getAllPets(dao);
            }else if (komenda.equalsIgnoreCase("byID")) {
                getByID(dao, scanner);
            } else if (komenda.equalsIgnoreCase("update")) {
                updatePet(dao, scanner);
            } else if (komenda.equalsIgnoreCase("delete")) {
                deletePet(dao, scanner);
            }
        } while (!komenda.equalsIgnoreCase("quit"));
    }

    private static void getByID(PetDao dao, Scanner scanner) {
        System.out.println("Wyszukaj po ID: ");
        Pet pet = getPet(scanner);
        dao.getById(pet);
    }

    private static void deletePet(PetDao dao, Scanner scanner) {
        System.out.println("Podaj id do skasowania: ");
        Pet pet = getPet(scanner);
        dao.deletePet(pet);
    }

    private static Pet getPet(Scanner scanner) {
        String id = scanner.nextLine();
        return Pet.builder()
                .id(Long.parseLong(id))
                .build();
    }

    private static void updatePet(PetDao dao, Scanner scanner) {
        System.out.println("Podaj parametry zwierzaka: IMIE WIEK WŁAŚCICIEL WAGA CZYSTA_RASA ID");
        String linie = scanner.nextLine();
        String[] dane = linie.split(" ");
        Pet pet = Pet.builder()
                .name(dane[0])
                .age(Integer.parseInt(dane[1]))
                .ownerName(dane[2])
                .weight(Double.parseDouble(dane[3]))
                .pureRace(Boolean.parseBoolean(dane[4]))
                .id(Long.parseLong(dane[5]))
                .build();
        dao.updatePet(pet);
    }

    private static void getAllPets(PetDao dao) {
        System.out.println("Lista zwierzaków:");
        List<Pet> list = dao.getAllPets();
        list.forEach(System.out::println);
    }

    private static void addPet(PetDao dao, Scanner scanner) {
        System.out.println("Podaj parametry zwierzaka: IMIE WIEK WŁAŚCICIEL WAGA CZYSTA_RASA");
        String linie = scanner.nextLine();
        String[] dane = linie.split(" ");
        Pet pet = Pet.builder()
                .name(dane[0])
                .age(Integer.parseInt(dane[1]))
                .ownerName(dane[2])
                .weight(Double.parseDouble(dane[3]))
                .pureRace(Boolean.parseBoolean(dane[4]))
                .build();
        dao.addToDataBase(pet);
    }
}
