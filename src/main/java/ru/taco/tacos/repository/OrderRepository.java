package ru.taco.tacos.repository;

import ru.taco.tacos.model.TacoOrder;

import java.util.Optional;

public interface OrderRepository {
    Optional<TacoOrder> save(TacoOrder tacoOrder);
}
