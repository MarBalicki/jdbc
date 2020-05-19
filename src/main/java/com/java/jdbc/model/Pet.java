package com.java.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Pet {
    private Long id;
    private String name;
    private int age;
    private String ownerName;
    private double weight;
    private boolean pureRace;
}
