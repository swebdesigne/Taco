package ru.taco.tacos.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.taco.tacos.model.Ingredient;
import ru.taco.tacos.repository.IngredientRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class IngredientServiceImpl implements IngredientService {
    private IngredientRepository repo;

    @Override
    public List<Ingredient> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        return repo.save(ingredient);
    }
}
