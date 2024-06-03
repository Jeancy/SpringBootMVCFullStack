package com.jeancy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Jeancy
 */

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        // You can add attributes to the model to be displayed in the home page
        model.addAttribute("message", "Welcome to the home page!");
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

