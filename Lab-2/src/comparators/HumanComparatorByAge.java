package comparators;

import java.util.Comparator;

class HumanComparatorByAge implements Comparator<Human> {

    public int compare(Human a, Human b){
        return b.age - a.age;
    }
}
