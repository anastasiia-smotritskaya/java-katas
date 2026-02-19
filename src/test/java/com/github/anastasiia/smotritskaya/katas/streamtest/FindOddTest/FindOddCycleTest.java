package com.github.anastasiia.smotritskaya.katas.streamtest.FindOddTest;

import com.github.anastasiia.smotritskaya.katas.stream.FindOdd;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static com.github.anastasiia.smotritskaya.katas.stream.FindOdd.findIt_cycle;

/**
 * Тестирование метода findIt_cycle
 * (реализация findIt через цикл for)
 *
 * @see FindOdd#findIt_cycle(int[])
 * @see FindOddAbstractTest
 */
@Epic("Java katas")
@Feature("Stream API")
@Story("Find odd via for-loop")
public class FindOddCycleTest extends FindOddAbstractTest {
    @Override
    protected int findIt(int[] a) {
        return findIt_cycle(a);
    }
}
