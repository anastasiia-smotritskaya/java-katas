package streamtest.MultiplesOf3or5Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static utils.ErrorMessages.SUM_GREATER_THAN_MAX;

/**
 * Абстрактный тестовый класс для всех реализаций multiplesOf3or5
 * Наследники должны реализовать multiplesOf3or5()
 *
 * @see stream.MultiplesOf3or5#multiplesOf3or5_cycle(int)
 * @see stream.MultiplesOf3or5#multiplesOf3or5_stream(int)
 * @see MultiplesOf3or5CycleTest
 * @see MultiplesOf3or5StreamTest
 */
@Epic("Java katas")
@Feature("Stream API")
@Story("Multiples of 3 or 5")
public abstract class MultiplesOf3or5AbstractTest {
    protected abstract int multiplesOf3or5(int number);

    protected static final int MAX_NUMBER = 95_936;

    @ParameterizedTest(name = "[{index}] Number: {0}, Sum: {1}")
    @DisplayName("multiplesOf3or5 must return the correct sum for different values of the number")
    @CsvSource({
            "0, 0",
            "10, 23",
            "-10, 0",
            "95_935, 2_147_472_998",
            "-95_934, 0"
    })
    public void multiply3or5Test(int number, int sum) {
        assertEquals(sum, multiplesOf3or5(number));
    }

    @Test
    public void multiply3or5_IllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> multiplesOf3or5(MAX_NUMBER));

        assertEquals(SUM_GREATER_THAN_MAX, exception.getMessage());
    }
}
