package violet.neon.calculatorwithtest.service;

import org.springframework.stereotype.Service;
import violet.neon.calculatorwithtest.exception.NoneZeroDivideException;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    public int plus(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    public int minus(int firstNum, int secondNum) {
        return firstNum - secondNum;
    }

    public int multiply(int firstNum, int secondNum) {
        return firstNum * secondNum;
    }

    public float divide(int firstNum, int secondNum) {
        if (secondNum == 0) {
            throw new NoneZeroDivideException("Ошибка деления на ноль");
        }

        return (float) firstNum / secondNum;
    }
}