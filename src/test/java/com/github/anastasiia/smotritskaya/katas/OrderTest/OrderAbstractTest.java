package com.github.anastasiia.smotritskaya.katas.OrderTest;

import com.github.anastasiia.smotritskaya.katas.strings.Order;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static com.github.anastasiia.smotritskaya.katas.utils.ErrorMessages.NULL_OR_EMPTY_STRING;

/**
 * Абстрактный тестовый класс для всех реализаций order
 * Наследники должны реализовать order()
 *
 * @see Order#order_cycle(String)
 * @see Order#order_stream(String)
 * @see OrderCycleTest
 * @see OrderStreamTest
 */
@Epic("Java katas")
@Feature("Strings")
@Story("Your order, please")
public abstract class OrderAbstractTest {
    protected abstract String order(String words);

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("order should throw IllegalArgumentException if words is null or empty")
    void orderTest_IllegalArgumentException(String words) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> order(words));
        assertEquals(NULL_OR_EMPTY_STRING, exception.getMessage());
    }

    @ParameterizedTest(name = "[{index}] Words: {0}")
    @DisplayName("order should return words in the correct order")
    @MethodSource("orderDataProvider")
    void orderTest(String words, String expected) {
        assertEquals(expected, order(words));
    }

    private static Stream<Arguments> orderDataProvider() {
        return Stream.of(
                Arguments.of("is2 Thi1s T4est 3a", "Thi1s is2 3a T4est"),
                Arguments.of("4of Fo1r pe6ople g3ood th5e the2", "Fo1r the2 g3ood 4of th5e pe6ople")
        );
    }
}
