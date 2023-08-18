package ru.taco.tacos.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Taco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date createAt = new Date();
    @NonNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    @NonNull
    @Size(min = 1, message = "You myst choose at least 1 ingredient")
    @OneToMany
    private List<Ingredient> ingredients;
}
