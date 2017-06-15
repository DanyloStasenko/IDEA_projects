public class Main {

    public static void main(String[] args) {

        Main m = new Main();
        for (int i = 0; i < 5 ; i++) {

            Cat cat = new Cat();
            System.out.println(i);
        }
        System.out.println("Finished!");
    }

   class Cat{
        Cat(){}
        private String name;
    }
}
