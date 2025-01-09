package violet.neon.calculatorwithtest;

import org.junit.jupiter.api.Test;
import violet.neon.calculatorwithtest.exception.NoneZeroDivideException;
import violet.neon.calculatorwithtest.service.CalculatorService;
import violet.neon.calculatorwithtest.service.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static violet.neon.calculatorwithtest.CalculatorServiceImplTestConstants.*;

public class CalculatorServiceImplTest {
    private final CalculatorService out = new CalculatorServiceImpl();

    @Test
    public void shouldReturn7AsSumOf4And3() {
        int result = out.plus(FOUR, THREE);

        assertEquals(result, SEVEN);
    }

    @Test
    public void shouldReturn5AsSumOf2And3() {
        int result = out.plus(TWO, THREE);

        assertEquals(result, FIVE);
    }

    @Test
    public void shouldReturn2AsSubtractionResultOf5And3() {
        int result = out.minus(FIVE, THREE);

        assertEquals(result, TWO);
    }

    @Test
    public void shouldReturn0AsSubtractionResultOf5And5() {
        int result = out.minus(FIVE, FIVE);

        assertEquals(result, ZERO);
    }

    @Test
    public void shouldReturn6AsMultiplicationResultOf2And3() {
        int result = out.multiply(TWO, THREE);

        assertEquals(result, SIX);
    }

    @Test
    public void shouldReturn0AsMultiplicationResultOf0And7() {
        int result = out.multiply(ZERO, SEVEN);

        assertEquals(result, ZERO);
    }

    @Test
    public void shouldReturn2AsDivisionResultOf6And3() {
        float result = out.divide(SIX, THREE);

        assertEquals(result, TWO);
    }

    @Test
    public void shouldReturn3point5AsDivisionResultOf7And2() {
        float result = out.divide(SEVEN, TWO);

        assertEquals(result, THREE_POINT_FIVE);
    }

    @Test
    public void shouldThrowNoneZeroDivideExceptionWhenSecondParamIsZero() {
        assertThrows(NoneZeroDivideException.class, () -> {
            out.divide(FIVE, ZERO);
        });
    }
}
