package ru.taco.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import ru.taco.tacos.model.Ingredient;

import java.util.List;

public interface IngredientDataStore extends CrudRepository<Ingredient, Integer> {
    List<Ingredient> findAll();
}
