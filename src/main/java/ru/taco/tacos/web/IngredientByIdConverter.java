package ru.taco.tacos.web;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ru.taco.tacos.model.Ingredient;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {
    private final Map<String, Ingredient> ingredientMap = new HashMap<>();

    public IngredientByIdConverter() {
        ingredientMap.put("FLTO",
                new Ingredient(1, "FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
        ingredientMap.put("COTO",
                new Ingredient(2, "COTO", "Corn Tortilla", Ingredient.Type.WRAP));
        ingredientMap.put("GRBF",
                new Ingredient(3, "GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
        ingredientMap.put("CARN",
                new Ingredient(4, "CARN", "Carnitas", Ingredient.Type.PROTEIN));
        ingredientMap.put("TMTO",
                new Ingredient(5, "TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
        ingredientMap.put("LETC",
                new Ingredient(6, "LETC", "Lettuce", Ingredient.Type.VEGGIES));
        ingredientMap.put("CHED",
                new Ingredient(7,"CHED", "Cheddar", Ingredient.Type.CHEESE));
        ingredientMap.put("JACK",
                new Ingredient(8, "JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
        ingredientMap.put("SLSA",
                new Ingredient(9, "SLSA", "Salsa", Ingredient.Type.SAUCE));
        ingredientMap.put("SRCR",
                new Ingredient(10, "SRCR", "Sour Cream", Ingredient.Type.SAUCE));
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientMap.get(id);
    }
}
