package ru.taco.tacos.repository;

import org.springframework.data.repository.CrudRepository;
import ru.taco.tacos.model.TacoOrder;

public interface OrderDataStore extends CrudRepository<TacoOrder, Integer> {
}
