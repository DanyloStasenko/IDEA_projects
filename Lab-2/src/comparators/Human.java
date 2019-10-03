package comparators;

import java.util.Objects;

public class Human implements Comparable<Human>{

    public String firstName;
    public String lastName;
    public int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age &&
                Objects.equals(firstName, human.firstName) &&
                Objects.equals(lastName, human.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public int compareTo (Human o) {int rez;
        if (this.equals (o)) return 0;
        rez = firstName.compareToIgnoreCase (o.firstName);
        if (rez != 0) {
            return rez;
        }
        rez = lastName.compareToIgnoreCase (o.lastName);
        if (rez != 0) {
            return rez;
        }
        else return age - o.age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " " + age;
    }
}
