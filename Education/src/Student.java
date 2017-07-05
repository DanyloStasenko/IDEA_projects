
public class Student
{
    // поля
    String firstName;
    String surName;
    int age;
    static int id;

    public Student()
    {
        firstName = "default";
        surName = "default";
        age = 5;
    }


    Student(String p1)
    {
        this.firstName = p1;

        System.out.println("1 parameter");
        printAll();
    }

    Student(String p1, String p2)
    {
        this.firstName = p1;
        this.surName = p2;

        System.out.println("2 parameter");
        printAll();
    }

    Student(String p1, String p2, int p3)
    {
        this.firstName = p1;
        this.surName = p2;
        this.age = p3;

        System.out.println("3 parameter");
        printAll();
    }


    void initialize(String p1, String p2, int p3)
    {
        this.firstName = p1;
        surName = p2;
        age = p3;

        System.out.println("student was initialized");
    }

    void printAll()
    {
        System.out.println("I am student:");
        System.out.println(firstName);
        System.out.println(surName);
        System.out.println(age);
    }


    int f(int value)
    {
        int result = value++;
        int a = value;
        return a;

    }
}
