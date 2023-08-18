package ru.taco.tacos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Component;
import ru.taco.tacos.model.Ingredient;
import ru.taco.tacos.repository.IngredientDataStore;

@Component
public class IngredientByIdConverter implements Converter<Integer, Ingredient> {
    private final IngredientDataStore ingredientRepo;

    @Autowired
    public IngredientByIdConverter(IngredientDataStore ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient convert(Integer id) {
        return ingredientRepo.findById(id).orElse(null);
    }

}
