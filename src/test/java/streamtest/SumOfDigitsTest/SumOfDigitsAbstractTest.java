package streamtest.SumOfDigitsTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static utils.ErrorMessages.NON_POSITIVE_NUMBER;

/**
 * Абстрактный тестовый класс для всех реализаций sumOfDigits
 * Наследники должны реализовать sumOfDigits()
 *
 * @see stream.SumOfDigits#sumOfDigits_cycle(int)
 * @see stream.SumOfDigits#sumOfDigits_stream(int)
 * @see SumOfDigitsCycleTest
 * @see SumOfDigitsStreamTest
 */
@Epic("Java katas")
@Feature("Stream API")
@Story("Sum of digits")
public abstract class SumOfDigitsAbstractTest {
    protected abstract int sumOfDigits(int number);
    private static final int NEGATIVE_NUMBER = -100;

    @Test
    @DisplayName("sumOfDigits should throw IllegalArgumentException if the number is negative")
    void sumOfDigits_IllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> sumOfDigits(NEGATIVE_NUMBER));
        assertEquals(NON_POSITIVE_NUMBER, exception.getMessage());
    }

    @ParameterizedTest(name = "Number: {0} Sum: {1}")
    @DisplayName("sumOfDigits should return the correct sum for different values of the number")
    @CsvSource({
            "0, 0",
            "100, 1",
            "12345, 6",
            "80812, 1",
    })
    void sumOfDigitsTest(int number, int sum) {
        assertEquals(sum, sumOfDigits(number));
    }
}
