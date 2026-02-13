package stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Locale.filter;
import static utils.ErrorMessages.NO_NUMBER_WITH_ODD_COUNT;

/**
 * Возвращает число, которое повторяется в массиве нечетное количество раз
 * Даны две реализации:
 * 1) через цикл for (findIt_cycle)
 * 2) через stream api (findIt_stream)
 */
public class FindOdd {
    /**
     * Возвращает число, которое повторяется в массиве нечетное количество раз (через цикл for)
     *
     * @param a массив, в котором мы ищем число, повторяющееся нечетное количество раз
     * @return int число, которое повторяется в массиве нечетное количество раз
     * @code {int number = findIt_cycle(new int[]{1, 1, 2});}  // 2
     */
    public static int findIt_cycle(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int j : a) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) % 2 != 0) {
                result = key;
            }
        }
        return result;
    }

    /**
     * Возвращает число, которое повторяется в массиве нечетное количество раз (через stream api)
     *
     * @param a массив, в котором мы ищем число, повторяющееся нечетное количество раз
     * @return int число, которое повторяется в массиве нечетное количество раз
     * @code {int number = findIt_stream(new int[]{1, 1, 2});}  // 2
     * Arrays.stream(a) - преобразует массив int[] в поток IntStream
     * boxed() - превращает IntStream (примитивы) в Stream<Integer> (объекты),
     * т.к. groupingBy работает только с объектами
     * Function.identity() - говорит: «ключом будет сам элемент» (x → x)
     * entrySet().stream() - Берём все записи из мапы (Set<Map.Entry<Integer, Long>>) и превращаем в поток.
     * Теперь каждый элемент потока — это пара (число, количество).
     * filter(entry -> entry.getValue() % 2 == 1) - Оставляем только те записи, у которых количество нечётное.
     * map(Map.Entry::getKey) - Из каждой записи берём только ключ (само число).
     * findFirst() - Берём первый элемент потока. Возвращает Optional.
     */
    public static int findIt_stream(int[] a) {
        return Arrays.stream(a)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() % 2 == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_NUMBER_WITH_ODD_COUNT));
    }
}
