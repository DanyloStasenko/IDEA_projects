package comparators;

import java.util.*;

public class ComparatorTest {
    /*
    1. Розробіть клас Human, що має поля:Ім'я, Прізвище, Вік
    2. Напишіть клас компаратора HumanComparatorByLName, що порівнює дві людини тільки по Прізвищу.
    3. У перевірочному класі створіть власну колекцію на основі HashSet, включивши в неї мінімум п’ять людей.
    4. У перевірочному класі створіть колекцію LinkedHashSet на основі існуючої колекції s.
    5. У перевірочному класі створіть колекцію TreeSet на основі існуючої колекції s.
    6. У перевірочному класі необхідно створити порожню колекцію TreeSet з компаратором HumanComparatorByLName
    7. У перевірочному класі необхідно створити порожню колекцію TreeSet з компаратором за віком.
    */
    public static void main(String[] args) {
        // 1: Human
        Human a = new Human("Name", "A", 999);
        Human b = new Human("Test", "B", 11);
        System.out.println("1: Human: " + a + ", " + b); // 1: Human: Name A 999, Test B 11

        // 2: Comparator
        HumanComparatorByLName testComarator = new HumanComparatorByLName();
        System.out.println("2: Comparator: " +testComarator.compare(a, b)); // 2: Comparator: -1

        // 3: HashSet. When iterating through a HashSet the order is unpredictable.
        Set<Human> set = new HashSet<Human>();
        set.add (new Human ( "Andriy", "Wolf", 25));
        set.add (new Human ( "Rita", "Kitter", 24));
        set.add (new Human ( "Peter", "Petrenko", 31));
        set.add (new Human ( "Ivan", "Ivanenko", 15));
        set.add (new Human ( "Roman", "Romanenko", 55));
        System.out.println("3: Hash-set: " + set);  // 3: Hash-set: [Ivan Ivanenko 15, Rita Kitter 24, Roman Romanenko 55, Andriy Wolf 25, Peter Petrenko 31]

        // 4: Linked hash-set: While a LinkedHashSet lets us iterate through the elements in the order in which they were inserted
        LinkedHashSet<Human> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.addAll(set);
        System.out.println("4: Linked hash-set: " + linkedHashSet); // 4: Linked hash-set: [Ivan Ivanenko 15, Rita Kitter 24, Roman Romanenko 55, Andriy Wolf 25, Peter Petrenko 31]

        // 5: Tree-set: is typically implemented as a red-black tree. A HashSet is typically a lot faster than a TreeSet
        TreeSet<Human> treeSet = new TreeSet<Human>();
        treeSet.addAll(set);
        System.out.println("5: Tree-set: " + treeSet);  // 5: Tree-set: [Andriy Wolf 25, Ivan Ivanenko 15, Peter Petrenko 31, Rita Kitter 24, Roman Romanenko 55]

        // 6: Tree-set by lname:
        HumanComparatorByLName comparatorByLName = new HumanComparatorByLName();
        TreeSet<Human> treeSetByLname = new TreeSet<Human>(comparatorByLName);
        treeSetByLname.addAll(set);
        System.out.println("6: Tree-set by lname: " + treeSetByLname);  // 6: Tree-set by lname: [Ivan Ivanenko 15, Rita Kitter 24, Peter Petrenko 31, Roman Romanenko 55, Andriy Wolf 25]

        // 7: Tree-set by age:
        HumanComparatorByAge comparatorByAge = new HumanComparatorByAge();
        TreeSet<Human> treeSetByAge = new TreeSet<Human>(comparatorByAge);
        treeSetByAge.addAll(set);
        System.out.println("7: Tree-set by age: " + treeSetByAge);  // 7: Tree-set by age: [Roman Romanenko 55, Peter Petrenko 31, Andriy Wolf 25, Rita Kitter 24, Ivan Ivanenko 15]
    }
}
