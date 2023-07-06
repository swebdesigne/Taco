package ru.taco.tacos.model;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@NoArgsConstructor
public class Taco {
   @NonNull
   @Size(min = 5, message = "Name must be at least 5 characters long")
   private String name;
   @NonNull
   @Size(min = 1, message = "You myst choose at least 1 ingredient")
   private List<Ingredient> ingredients;
}
