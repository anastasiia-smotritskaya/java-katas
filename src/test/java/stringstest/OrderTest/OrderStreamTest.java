package stringstest.OrderTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static strings.Order.order_stream;

/**
 * Тестирование метода order_stream
 * (реализация order через цикл stream api)
 *
 * @see strings.Order#order_stream(String)
 * @see OrderAbstractTest
 */
@Epic("Java katas")
@Feature("Strings")
@Story("Your order, please via stream api")
public class OrderStreamTest extends OrderAbstractTest{
    @Override
    protected String order(String words) {
        return order_stream(words);
    }
}
