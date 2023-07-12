package ru.taco.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import ru.taco.tacos.model.Ingredient;

public interface IngredientDataStore extends CrudRepository<Ingredient, Integer> {
}
