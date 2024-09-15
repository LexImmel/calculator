package com.example.calculator.controller;

import com.example.calculator.DivideByZeroException;
import com.example.calculator.NullParameterException;
import com.example.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService service;

    public CalculatorController(CalculatorService service) {
        this.service = service;
    }


    @GetMapping
    public String hello() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam(required = false) Integer a, @RequestParam(required = false) Integer b) {
        validateParameter(a, b);
        return a + " + " + b + " = " + service.plus(a, b);
    }

    @GetMapping("/minus")
    public String minus(@RequestParam(required = false) Integer a, @RequestParam(required = false) Integer b) {
        validateParameter(a, b);
        return a + " - " + b + " = " + service.minus(a, b);
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam(required = false) Integer a, @RequestParam(required = false) Integer b) {
        validateParameter(a, b);
        return a + " * " + b + " = " + service.multiply(a, b);
    }

    @GetMapping("/divide")
    public String divide(@RequestParam(required = false) Integer a, @RequestParam(required = false) Integer b) {
        validateParameter(a, b);
        if (b == 0) {
            throw new DivideByZeroException("Не делим на ноль!");
        }
        return a + " / " + b + " = " + service.divide(a, b);
    }

    private void validateParameter(Integer a, Integer b) {
        if (a == null || b == null) {
            throw new NullParameterException("Не задан один или оба параметра!");
        }
    }
}
