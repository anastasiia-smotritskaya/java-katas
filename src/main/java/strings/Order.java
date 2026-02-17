package strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static utils.ErrorMessages.NULL_OR_EMPTY_STRING;

/**
 * Your order, please
 * Метод осуществляет сортировку заданной строки. Каждое слово в строке будет содержать одну цифру.
 * Эта цифра указывает позицию, которую слово должно занимать в результате.
 * Цифры могут быть от 1 до 9. Таким образом, цифра 1 означает, что слово должно быть первым (а не 0).
 * Если входная строка пустая, нужно вернуть пустую строку.
 * Слова во входной строке всегда содержат только корректные последовательные цифры
 * (то есть цифры не пропущены и не повторяются).
 * "is2 Thi1s T4est 3a"  :  "Thi1s is2 3a T4est"
 * "4of Fo1r pe6ople g3ood th5e the2"  :  "Fo1r the2 g3ood 4of th5e pe6ople"
 */
public class Order {
    /**
     * Your order, please via for-loop
     *
     * @param words массив слов, в каждом из которых есть цифра - порядковый номер
     * @return String отсортированную строку
     * @throws IllegalArgumentException если words null или empty
     * {@code String sorted = order_cycle("is2 Thi1s T4est 3a");}  // "Thi1s is2 3a T4est"
     */
    public static String order_cycle(String words) {
        if (words == null || words.isEmpty()) throw new IllegalArgumentException(NULL_OR_EMPTY_STRING);

        String[] array = words.split(" ");
        Map<Integer, String> orderedWords = new TreeMap<>();
        StringBuilder result = new StringBuilder();

        for (String currentWord : array) {
            char[] currentWordLetters = currentWord.toCharArray();

            for (char currentLetter : currentWordLetters) {
                if (Character.isDigit(currentLetter)) {
                    orderedWords.put((int) currentLetter, currentWord);
                }
            }
        }

        for (int number : orderedWords.keySet()) {
            result.append(orderedWords.get(number)).append(" ");
        }
        return result.toString().trim();
    }

    /**
     * Your order, please via stream api
     * Arrays.stream() — превращает массив в поток строк Stream(String)
     * s.replaceAll("\\D", "") - заменяет все, что не цифра, на ничто
     * Integer.valueOf(...) - превращает в число
     * Comparator.comparing(...) - создает компаратор, который сравнивает по извлеченной цифре
     * .reduce() - собирает обратно в строку через пробел (возвращает Optional)
     *
     * @param words массив слов, в каждом из которых есть цифра - порядковый номер
     * @return String отсортированную строку
     * @throws IllegalArgumentException если words null или empty
     * {@code String sorted = order_stream("is2 Thi1s T4est 3a");}  // "Thi1s is2 3a T4est"
     */
    public static String order_stream(String words) {
        if (words == null || words.isEmpty()) throw new IllegalArgumentException(NULL_OR_EMPTY_STRING);

        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
                .reduce((a, b) -> a + " " + b).get();
    }
}
