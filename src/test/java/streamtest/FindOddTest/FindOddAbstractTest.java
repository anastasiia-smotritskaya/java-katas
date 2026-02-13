package streamtest.FindOddTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Абстрактный тестовый класс для всех реализаций findIt
 * Наследники должны реализовать findIt()
 *
 * @see stream.FindOdd#findIt_cycle(int[])
 * @see stream.FindOdd#findIt_stream(int[])
 * @see FindOddCycleTest
 * @see FindOddStreamTest
 */
@Epic("Java katas")
@Feature("Stream API")
@Story("Sum of digits")
public abstract class FindOddAbstractTest {
    protected abstract int findIt(int[] a);

    @ParameterizedTest(name = "[{index}] Array: {0}")
    @DisplayName("findIt should return the correct number")
    @MethodSource("findItDataProvider")
    void findItTest(int[] a, int expected) {
        assertEquals(expected, findIt(a));
    }

    private static Stream<Arguments> findItDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{7}, 7),
                Arguments.of(new int[]{0}, 0),
                Arguments.of(new int[]{1, 1, 2}, 2),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}, 4)
        );
    }
}
