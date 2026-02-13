# Java Katas Cheatsheet

## Stream API
- `Collectors.joining(", ")` — объединить строки
- `map(String::toLowerCase)` — привести к нижнему регистру
- `filter(Objects::nonNull)` — убрать null

## Optional
- `orElse("default")` — значение или дефолт
- `orElseGet(() -> compute())` — ленивая версия
- `ifPresentOrElse()` — Java 9+

## Запомнить!
- Задача X: решение через IntStream.range()
- Задача Y: частотная мапа через Collectors.counting()