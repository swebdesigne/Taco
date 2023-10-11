package ru.taco.tacos.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private Type type;

    public Ingredient(int id, String code, String name, Type type) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.type = type;
    }

    public Ingredient(String code) {
        this.code = code;
    }

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }
}
