package streamtest.MultiplesOf3or5Test;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static stream.MultiplesOf3or5.multiplesOf3or5_cycle;

/**
 * Тестирование метода multiplesOf3or5_cycle
 * (реализация multiplesOf3or5 через цикл for)
 *
 * @see stream.MultiplesOf3or5#multiplesOf3or5_cycle(int)
 * @see MultiplesOf3or5AbstractTest
 */
@Epic("Java katas")
@Feature("Stream API")
@Story("Multiples of 3 or 5 via for-loop")
public class MultiplesOf3or5CycleTest extends MultiplesOf3or5AbstractTest {
    @Override
    protected int multiplesOf3or5(int number) {
        return multiplesOf3or5_cycle(number);
    }
}
