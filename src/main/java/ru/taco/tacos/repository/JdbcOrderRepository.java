package ru.taco.tacos.repository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.taco.tacos.model.Taco;
import ru.taco.tacos.model.TacoOrder;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

@Slf4j
@Repository
@AllArgsConstructor
public class JdbcOrderRepository implements OrderRepository {
    private final JdbcTemplate jdbc;

    private final static String SAVE_TACO_ORDER = "insert into Taco_Order "
            + "(delivery_Name, delivery_Street, delivery_City, delivery_State, delivery_Zip, cc_number, cc_expiration, cc_cvv, placed_at) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?) returning id";

    private final static String SAVE_TACO = "insert into Taco (name, created_at, taco_order, taco_order_key) values (?, ?, ?, ?) RETURNING id";

    private static final String SAVE_INGREDIENT_REF = "insert into Ingredient_Ref (ingredient, taco, taco_key) " + "values (?, ?, ?)";

    @Override
    public Optional<TacoOrder> save(TacoOrder tacoOrder) {
        log.info("The process save tacoOrder");
        try {
            var id = jdbc.queryForObject(
                    SAVE_TACO_ORDER,
                    Integer.class,
                    tacoOrder.getDeliveryName(),
                    tacoOrder.getDeliveryStreet(),
                    tacoOrder.getDeliveryCity(),
                    tacoOrder.getDeliveryState(),
                    tacoOrder.getDeliveryZip(),
                    tacoOrder.getCcNumber(),
                    tacoOrder.getCcExpiration(),
                    tacoOrder.getCcCVV(),
                    tacoOrder.getPlaceAt()
            );
            tacoOrder.setId(Objects.requireNonNull(id));
            saveTaco(tacoOrder);
            return Optional.of(tacoOrder);
        } catch (Exception e) {
            log.error("Save error occurred ", e);
        }
        return Optional.empty();
    }

    private void saveTaco(TacoOrder order) {
        log.info("Save the tacos");
        try {
            IntStream.range(0, order.getTacos().size())
                    .forEach(index -> {
                                var taco = order.getTacos().get(index);
                                taco.setCreateAt(new Date());
                                var tacoId = jdbc.queryForObject(SAVE_TACO,
                                        Integer.class,
                                        taco.getName(),
                                        taco.getCreateAt(),
                                        order.getId(),
                                        index
                                );
                                taco.setId(Objects.requireNonNull(tacoId));
                                saveIngredientRefs(taco);
                            }
                    );
        } catch (
                Exception e) {
            log.error("Save the tacos error ", e);
        }
    }

    private void saveIngredientRefs(Taco taco) {
        IntStream.range(0, taco.getIngredients().size())
                .forEach(index -> {
                    jdbc.update(SAVE_INGREDIENT_REF,
                            taco.getIngredients().get(index).getCode(),
                            taco.getId(),
                            index
                    );
                });
    }
}
