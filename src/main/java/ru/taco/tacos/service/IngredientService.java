package ru.taco.tacos.service;

import ru.taco.tacos.model.Ingredient;

import java.util.Optional;

public interface IngredientService {
    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(Integer id);

    Ingredient save(Ingredient ingredient);
}
