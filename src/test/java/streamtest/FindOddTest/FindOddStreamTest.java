package streamtest.FindOddTest;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static stream.FindOdd.findIt_stream;

/**
 * Тестирование метода findIt_stream
 * (реализация findIt через stream api)
 *
 * @see stream.FindOdd#findIt_stream(int[])
 * @see FindOddAbstractTest
 */
@Epic("Java katas")
@Feature("Stream API")
@Story("Find odd via stream api")
public class FindOddStreamTest extends FindOddAbstractTest {
    @Override
    protected int findIt(int[] a) {
        return findIt_stream(a);
    }
}
