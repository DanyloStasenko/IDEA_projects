package comparators;

import java.util.Comparator;

class HumanComparatorByLName implements Comparator<Human> {

    public int compare(Human a, Human b){
        return a.lastName.compareTo(b.lastName);
    }
}
