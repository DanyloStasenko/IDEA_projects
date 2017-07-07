public class Main {

    public static void main(String[] args) {

        System.out.println(getOne());
    }

    static int getOne() {
        try {
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return 45;
    }
}
