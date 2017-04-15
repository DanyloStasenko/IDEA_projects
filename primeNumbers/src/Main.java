import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws IOException {
        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long number = Long.parseLong(reader.readLine());
        */

         long number = 600851475143L;

        boolean resultFound = false;
        while (!resultFound){
            resultFound = isPrime(number);
            if (!resultFound){
                number--;
            }
        }
        System.out.println(number);
    }

    static boolean isPrime(long number) {
        // 1 is not prime
        if (number == 1){
            return false;
        }
        // We sort out possible dividers from 2 to sqrt(n)
        for (long divider = 2; divider * divider <= number; divider++){
            // If it is divided completely, number is composite
            if (number % divider == 0){
                return false;
            }
        }
        // If not trivial divisors, number is composite
        return true;
    }
}




