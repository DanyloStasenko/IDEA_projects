import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final int N = 15;

    public static void main(String[] args) {

        /*
        Варіант 1
        використовуючи статичні методи класу Collections, і здійснюючи контрольний висновок по кожному пункту.
        1. Створіть масив з N чисел (згенеруйте за допомогою PGenerator).
        2. На основі масиву створіть список List.
        3. Відсортуйте список в натуральному порядку (за зростанням)
        4. Перемішайте список.
        5. Виконайте циклічний зсув на 2 елементи.
        6. Залиште в списку тільки дублюючі елементи.
        7. Отримайте масив зі списку та виведіть елементи його у консоль.
        */

        // 1, 2 - Generated numbers
        List<Integer> list = new ArrayList<>(PGenerator.getRandomNumbers(N));
        System.out.println("1, 2: Initial list: " + list);

        // 3 - Natural order
        list.sort(Comparator.naturalOrder());
        System.out.println("3: Natural order: " + list);

        // 4 - Shuffle
        Collections.shuffle(list, new Random());
        System.out.println("4: Shuffled: " + list);

        // 5 - Сyclic shift
        System.out.println("5: Shifted: " + cyclicShift(list));

        // 6 - Only duplicates
        leaveDuplicatesOnly(list);
        System.out.println("6: Duplicates only: " + list);

        // 7 - To array
        Integer[] items = list.toArray(new Integer[list.size()]);
        System.out.println("7: Array: " + Stream.of(items)
                .map(String::valueOf)
                .collect(Collectors.joining(" - ")));
    }

    private static void leaveDuplicatesOnly(List<Integer> list){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : list) {
            if (map.containsKey(number)){
                int value = map.get(number);
                value++;
                map.put(number, value);
            } else {
                map.put(number, 1);
            }
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1){
                list.removeIf(o -> o.equals(key));
            }
        }

        // System.out.println("Debug: keys: " + map.keySet());
        // System.out.println("Debug: map: " + map);
    }

    private static List<Integer> cyclicShift(List<Integer> list){
        List<Integer> shifted = new ArrayList<>();
        for (int i = 2; i < list.size(); i++){
            shifted.add(list.get(i));
        }
        shifted.add(list.get(0));
        shifted.add(list.get(1));

        return shifted;
    }
}
