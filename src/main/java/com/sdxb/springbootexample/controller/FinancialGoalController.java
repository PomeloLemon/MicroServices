package com.sdxb.springbootexample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FinancialGoalController {

    @GetMapping("/")
    public String defaultHTML() {
        return "default.html";
    }

}
