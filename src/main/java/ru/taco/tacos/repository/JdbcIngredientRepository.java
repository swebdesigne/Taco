package ru.taco.tacos.repository;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.taco.tacos.model.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JdbcIngredientRepository implements IngredientRepository {
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Ingredient> findAll() {
        return jdbcTemplate.query(
                "select id, code, name, type from Ingredient",
                this::mapRowToIngredient
        );
    }

    private Ingredient mapRowToIngredient(ResultSet resultSet, int i) throws SQLException {
        return new Ingredient(
                resultSet.getInt("id"),
                resultSet.getString("code"),
                resultSet.getString("name"),
                Ingredient.Type.valueOf(resultSet.getString("type"))
        );
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        var result = jdbcTemplate.query(
                "select id, name, type from Ingredient where id = ?",
                this::mapRowToIngredient, id);
        return Optional.of(result.get(0));
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbcTemplate.update(
                "insert into Ingredient (code, name, type) values (?, ?, ?)",
                ingredient.getCode(),
                ingredient.getName(),
                ingredient.getType().toString());
        return ingredient;
    }
}
