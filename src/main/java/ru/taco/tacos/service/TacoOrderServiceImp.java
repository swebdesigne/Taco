package ru.taco.tacos.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.taco.tacos.model.TacoOrder;
import ru.taco.tacos.repository.OrderDataStore;

@Service
@AllArgsConstructor
public class TacoOrderServiceImp {
//    private final OrderJdbcTemplate tacoOrderRepository;
    private final OrderDataStore tacoOrderRepository;

    public TacoOrder save(TacoOrder tacoOrder) {
        return tacoOrderRepository.save(tacoOrder);
    }
}
