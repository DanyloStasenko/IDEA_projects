import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int numbersCount = 0;
        HashSet<Integer> numbers = new HashSet<Integer>();

        while (scanner.hasNext()){
            numbers.add(scanner.nextInt());
            numbersCount++;
        }

        System.out.println(numbersCount + "  numbers detected");
        System.out.println("There were:  " + numbers.size() + "  unique values");
        System.out.println("And  " + (numbersCount - numbers.size()) + "  repeatable values");
    }
}
