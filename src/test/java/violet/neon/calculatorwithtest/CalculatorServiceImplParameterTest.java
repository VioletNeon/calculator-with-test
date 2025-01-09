package violet.neon.calculatorwithtest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import violet.neon.calculatorwithtest.exception.NoneZeroDivideException;
import violet.neon.calculatorwithtest.service.CalculatorService;
import violet.neon.calculatorwithtest.service.CalculatorServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static violet.neon.calculatorwithtest.CalculatorServiceImplTestConstants.*;

public class CalculatorServiceImplParameterTest {
    private final CalculatorService out = new CalculatorServiceImpl();

    @ParameterizedTest
    @MethodSource("provideParamsForCalculatorTests")
    public void shouldReturnCorrectResultOfAddition(int num1, int num2) {
        int result = out.plus(num1, num2);
        int expected = num1 + num2;

        assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForCalculatorTests")
    public void shouldReturnCorrectResultOfSubtraction(int num1, int num2) {
        int result = out.minus(num1, num2);
        int expected = num1 - num2;

        assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForCalculatorTests")
    public void shouldReturnCorrectResultOfMultiplication(int num1, int num2) {
        int result = out.multiply(num1, num2);
        int expected = num1 * num2;

        assertEquals(result, expected);
    }

    @ParameterizedTest
    @MethodSource("provideParamsForCalculatorTests")
    public void shouldReturnCorrectResultOfDivisionOrThrowNoneZeroDivideExceptionWhenSecondParamIsZero(int num1, int num2) {
        if (num2 == 0) {
            assertThrows(NoneZeroDivideException.class, () -> {
                out.divide(num1, num2);
            });

            return;
        }

        float result = out.divide(num1, num2);
        float expected = (float) num1 / num2;

        assertEquals(result, expected);
    }

    public static Stream<Arguments> provideParamsForCalculatorTests() {
        return Stream.of(
                Arguments.of(ZERO, THREE),
                Arguments.of(FIVE, TWO),
                Arguments.of(FOUR, FIVE),
                Arguments.of(THREE, TWO),
                Arguments.of(SIX, SEVEN),
                Arguments.of(TWO, ZERO),
                Arguments.of(FOUR, TWO),
                Arguments.of(SIX, FOUR),
                Arguments.of(SEVEN, SEVEN)
        );
    }
}
