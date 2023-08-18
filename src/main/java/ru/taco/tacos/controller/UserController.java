package ru.taco.tacos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@Controller
public class UserController {
    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessage = null;
        if (Objects.nonNull(error)) {
            errorMessage = "Username or Password is incorrect !!";
        }
        if (Objects.nonNull(logout)) {
            errorMessage = "You have been successfully logged out !!";
        }
        System.out.println(errorMessage);
        model.addAttribute("errorMessage", errorMessage);
        return "/login/login";
    }
}
