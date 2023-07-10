package ru.taco.tacos.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ru.taco.tacos.model.TacoOrder;
import ru.taco.tacos.service.TacoOrderServiceImp;

@Slf4j
@Controller
@AllArgsConstructor
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    private final TacoOrderServiceImp orderServiceImp;

    @GetMapping("/current")
    public String orderForm() {
        return "orders/orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder tacoOrder, Errors errors, SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orders/orderForm";
        }
        log.info("Order submitted {} ", tacoOrder);
        orderServiceImp.save(tacoOrder);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
