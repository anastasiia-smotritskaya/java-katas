package com.github.anastasiia.smotritskaya.katas.stream;

import java.util.Arrays;

import static com.github.anastasiia.smotritskaya.katas.utils.ErrorMessages.NON_POSITIVE_NUMBER;

/**
 * Возвращает рекурсивную сумму цифр в числе.
 * Представлены две реализации:
 * 1) через цикл do-while (sumOfDigits_cycle)
 * 2) через stream api (sumOfDigits_stream)
 */
public class SumOfDigits {
    /**
     * Реализация sumOfDigits через цикл do-while
     *
     * @param number число, для которого необходимо вычислить рекурсивную сумму цифр
     * @return int - рекурсивная сумма цифр числа
     * {@code int sum = sumOfDigits_cycle(12345);} || 6
     * @throws IllegalArgumentException если number меньше нуля
     */
    public static int sumOfDigits_cycle(int number) {
        if (number < 0) throw new IllegalArgumentException(NON_POSITIVE_NUMBER);

        int sum = 0;

        while (true) {
            do {
                int digit = number % 10;
                sum += digit;
                number /= 10;
            } while (number != 0);

            if (sum >= 10) {
                number = sum;
                sum = 0;
            } else break;
        }

        return sum;
    }

    /**
     * Реализация sumOfDigits через stream api
     *
     * @param number число, для которого необходимо вычислить рекурсивную сумму цифр
     * @return int - рекурсивная сумма цифр числа
     * {@code int sum = sumOfDigits_stream(12345);} || 6
     * @throws IllegalArgumentException если number меньше нуля
     */
    public static int sumOfDigits_stream(int number) {
        if (number < 0) throw new IllegalArgumentException(NON_POSITIVE_NUMBER);
        int result = Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        return result < 10 ? result : sumOfDigits_stream(result);
    }
}
