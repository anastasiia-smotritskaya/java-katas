package com.github.anastasiia.smotritskaya.katas.stream;

import java.util.stream.IntStream;

import static com.github.anastasiia.smotritskaya.katas.utils.ErrorMessages.SUM_GREATER_THAN_MAX;

/**
 * Возвращает сумму всех чисел, кратных 3 или 5, которые меньше переданного числа.
 * Даны две реализации:
 * 1) через цикл for (multiplesOf3or5_cycle)
 * 2) через stream api (multiplesOf3or5_stream)
 * 95_935 — максимальное число, при котором сумма не превышает Integer.MAX_VALUE
 * При n = 95_936 сумма = 2_147_483_648 > Integer.MAX_VALUE
 *
 */
public class MultiplesOf3or5 {
    /**
     * Возвращает сумму всех чисел, кратных 3 или 5, которые меньше переданного числа (через цикл for)
     *
     * @param number число, до которого (не включительно) мы ищем числа, кратные 3 или 5
     * @return int - сумма всех чисел, кратных 3 или 5, которые меньше переданного числа.
     * {@code int sum = multiplesOf3or5_cycle(10);} || 23
     * @throws IllegalArgumentException если число больше 95_935,
     *                                  так как в таком случае сумма превышает Integer.MAX_VALUE
     */
    public static int multiplesOf3or5_cycle(int number) {
        if (number <= 0) return 0;

        if (number > 95_935) {
            throw new IllegalArgumentException(SUM_GREATER_THAN_MAX);
        }

        int sum = 0;

        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }

    /**
     * Возвращает сумму всех чисел, кратных 3 или 5, которые меньше переданного числа (через stream api)
     *
     * @param number число, до которого (не включительно) мы ищем числа, кратные 3 или 5
     * @return int - сумма всех чисел, кратных 3 или 5, которые меньше переданного числа.
     * {@code int sum = multiplesOf3or5_cycle(10);} || 23
     * @throws IllegalArgumentException если число больше 95_935,
     *                                  так как в таком случае сумма превышает Integer.MAX_VALUE
     * @see IntStream
     */
    public static int multiplesOf3or5_stream(int number) {
        if (number <= 0) return 0;

        if (number > 95_935) {
            throw new IllegalArgumentException(SUM_GREATER_THAN_MAX);
        }
        return IntStream.range(0, number)
                .filter(n -> n % 3 == 0 || n % 5 == 0)
                .sum();
    }
}
