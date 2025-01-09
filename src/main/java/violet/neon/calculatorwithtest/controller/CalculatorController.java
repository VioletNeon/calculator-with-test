package violet.neon.calculatorwithtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import violet.neon.calculatorwithtest.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String greetings() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int firstNum, @RequestParam("num2") int secondNum) {
        int result = calculatorService.plus(firstNum, secondNum);

        return firstNum + " + " + secondNum + " = " + result;
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam("num1") int firstNum, @RequestParam("num2") int secondNum) {
        int result = calculatorService.minus(firstNum, secondNum);

        return firstNum + " - " + secondNum + " = " + result;
    }

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam("num1") int firstNum, @RequestParam("num2") int secondNum) {
        int result = calculatorService.multiply(firstNum, secondNum);

        return firstNum + " * " + secondNum + " = " + result;
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam("num1") int firstNum, @RequestParam("num2") int secondNum) {
        float result = calculatorService.divide(firstNum, secondNum);

        return firstNum + " / " + secondNum + " = " + result;
    }
}
