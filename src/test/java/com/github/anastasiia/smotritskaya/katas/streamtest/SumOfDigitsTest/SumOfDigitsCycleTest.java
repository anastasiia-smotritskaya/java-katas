package com.github.anastasiia.smotritskaya.katas.streamtest.SumOfDigitsTest;

import com.github.anastasiia.smotritskaya.katas.stream.SumOfDigits;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static com.github.anastasiia.smotritskaya.katas.stream.SumOfDigits.sumOfDigits_cycle;

/**
 * Тестирование метода sumOfDigits_cycle
 * (реализация sumOfDigits через цикл do-while)
 *
 * @see SumOfDigits#sumOfDigits_cycle(int)
 * @see SumOfDigitsAbstractTest
 */
@Epic("Java katas")
@Feature("Stream API")
@Story("Sum of digits via do-while")
public class SumOfDigitsCycleTest extends SumOfDigitsAbstractTest{
    @Override
    protected int sumOfDigits(int number) {
        return sumOfDigits_cycle(number);
    }
}
