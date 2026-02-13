package streamtest.MultiplesOf3or5Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static stream.MultiplesOf3or5.multiplesOf3or5_stream;

/**
 * Тестирование метода multiplesOf3or5_stream
 * (реализация multiplesOf3or5 через stream api)
 *
 * @see stream.MultiplesOf3or5#multiplesOf3or5_stream(int)
 * @see MultiplesOf3or5AbstractTest
 */
@Epic("Java katas")
@Feature("Stream API")
@Story("Multiples of 3 or 5 via stream api")
public class MultiplesOf3or5StreamTest extends MultiplesOf3or5AbstractTest {
    @Override
    protected int multiplesOf3or5(int number) {
        return multiplesOf3or5_stream(number);
    }
}
