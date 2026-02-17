package stringstest.OrderTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static strings.Order.order_cycle;

/**
 * Тестирование метода order_cycle
 * (реализация order через цикл for)
 *
 * @see strings.Order#order_cycle(String)
 * @see OrderAbstractTest
 */
@Epic("Java katas")
@Feature("Strings")
@Story("Your order, please via for-loop")
public class OrderCycleTest extends OrderAbstractTest {
    @Override
    protected String order(String words) {
        return order_cycle(words);
    }
}
