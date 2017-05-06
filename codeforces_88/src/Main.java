import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // http://codeforces.com/problemset/problem/471/A?locale=ru
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        StringBuilder inputStringBuilder = new StringBuilder(inputString);

        ArrayList<Integer> sticks = new ArrayList<Integer>();
        Scanner scanner = new Scanner(inputString);
        for (int i = 0; i < 6; i++) {
            sticks.add(scanner.nextInt());
        }

        for (Integer stick : sticks) {
            for (int i = 0; i < inputString.length() - 1; i++) {
                int legs = 0;
                if (stick == Character.getNumericValue(inputString.charAt(i))){
                    legs++;
                }

                if (legs == 4){
                    sticks.remove(stick);
                    sticks.remove(stick);
                    sticks.remove(stick);
                    sticks.remove(stick);

                    int head = sticks.get(0);
                    int body = sticks.get(1);

                    if (body > head){
                        int temp = head;


                    }
                }
            }

        }

    }
}
