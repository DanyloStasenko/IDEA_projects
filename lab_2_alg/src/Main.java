public class Main {

    public static void main(String[] args) {
        List<Integer> list = new List<Integer>();

        System.out.println("List created:");
        System.out.println(list);

        for (int i = 0; i < 25; i++) {
            list.add(i);
        }

        System.out.println("Filling List:");
        System.out.println(list);

        for (int i = 0; i < 10; i++) {
            list.removeById(i);
        }

        System.out.println("Removing some values from List:");
        System.out.println(list);

    }
}
