import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.naturalOrder;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 8, 2, 1, 10, 6, 3, 9, 12, 11));
        Stream<Integer> stream = list.stream();
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x + " " + y);
        findMinMax(stream, naturalOrder(), biConsumer);
        stream.close();
        evenNumbers(list);
    }

    // задание 1
    public static <T> void findMinMax(Stream<? extends T> stream,
                                      Comparator<? super T> order,
                                      BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.sorted(order).collect(Collectors.toList());
        if (!list.isEmpty()) {
            T max = list.stream().max((Comparator<? super T>) naturalOrder().reversed()).get();
            T min = list.stream().min((Comparator<? super T>) naturalOrder().reversed()).get();
            minMaxConsumer.accept(min, max);
        } else {
            minMaxConsumer.accept(null, null);
        }

    }
    // задание 2
    public static void evenNumbers (List<Integer> list) {
        // выводит количество четных чисел
        System.out.println(list.stream()
                .filter(x -> x % 2 == 0)
                .count());
        // выводит четные числа
        list.stream()
                .filter(x -> x % 2 == 0)
                .forEach(System.out::println);

    }

}
