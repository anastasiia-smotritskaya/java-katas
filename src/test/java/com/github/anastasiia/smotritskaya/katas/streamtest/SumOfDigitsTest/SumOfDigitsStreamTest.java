package com.github.anastasiia.smotritskaya.katas.streamtest.SumOfDigitsTest;

import com.github.anastasiia.smotritskaya.katas.stream.SumOfDigits;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import static com.github.anastasiia.smotritskaya.katas.stream.SumOfDigits.sumOfDigits_stream;

/**
 * Тестирование метода sumOfDigits_stream
 * (реализация sumOfDigits через stream api)
 *
 * @see SumOfDigits#sumOfDigits_stream(int)
 * @see SumOfDigitsAbstractTest
 */
@Epic("Java katas")
@Feature("Stream API")
@Story("Sum of digits via stream api")
public class SumOfDigitsStreamTest extends SumOfDigitsAbstractTest{
    @Override
    protected int sumOfDigits(int number) {
        return sumOfDigits_stream(number);
    }
}
