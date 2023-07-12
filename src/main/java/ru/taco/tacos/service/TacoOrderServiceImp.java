package ru.taco.tacos.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.taco.tacos.model.TacoOrder;
import ru.taco.tacos.repository.OrderJdbcTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TacoOrderServiceImp {
    private final OrderJdbcTemplate tacoOrderRepository;

    public Optional<TacoOrder> save(TacoOrder tacoOrder) {
        return tacoOrderRepository.save(tacoOrder);
    }
}
