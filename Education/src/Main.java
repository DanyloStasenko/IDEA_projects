public class Main
{
    public String number = "one"; // ПОЛЕ КЛАСУ, АТРИБУТ КЛАСУ, ЗМІННА КЛАСУ


    public static void main(String[] args)
    {
        System.out.println("Hello World!");                      // 1)

        Student     s1      =   new     Student();                         // no param
        int[]       array    =  new     int[3];


        Student student2 = new Student("vasya");                  // 1 param
                student2.printAll();

        Student student3 = new Student("vasya", "kolya");        // 2 param


        Student student4 = new Student("vasya", "kolya", 4);        // 2 param


        System.out.println(student2.f(5));

        //student.initialize("Vaasya", "Ivanow", 15);
        //student.printAll();
    }
}
