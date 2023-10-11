package ru.taco.tacos.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.taco.tacos.model.Ingredient;
import ru.taco.tacos.model.Taco;
import ru.taco.tacos.model.TacoOrder;
import ru.taco.tacos.model.User;
import ru.taco.tacos.service.IngredientServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
@AllArgsConstructor
public class DesignTacoController {
    private IngredientServiceImpl ingredientService;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientService.findAll();
        Ingredient.Type[] types = Ingredient.Type.values();
        for (var type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Taco taco, @AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "design";
    }

    @PostMapping
    public String processTaco(HttpServletRequest req, @RequestParam("name") String name, Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        String[] ingredients = req.getParameterValues("ings");
        if (errors.hasErrors() || Objects.isNull(ingredients) || name.isEmpty()) {
            return "design";
        }
        List<Ingredient> ingredientList = Arrays.stream(ingredients)
                .map(Ingredient::new)
                .toList();
        taco.setIngredients(ingredientList);
        taco.setName(name);
        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(Iterable<Ingredient> ingredients, Ingredient.Type type) {
        List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
        for (var ingredient : ingredients) {
            if (ingredient.getType().equals(type)) {
                ingredientsList.add(ingredient);
            }
        }
        return ingredientsList;
    }
}
