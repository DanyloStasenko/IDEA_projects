package numbers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PGenerator {

    private static final ArrayList<Integer> PRIME_NUMBERS = new ArrayList<>(100);

    static {
        int currentNumber = 1;
        while (PRIME_NUMBERS.size() != 100){
            BigInteger bigInteger = BigInteger.valueOf(currentNumber);
            boolean probablePrime = bigInteger.isProbablePrime((int) Math.log(currentNumber));
            if (probablePrime){
                PRIME_NUMBERS.add(currentNumber);
            }
            currentNumber++;
        }

        // System.out.println("Init complete:" + PRIME_NUMBERS);
    }

    public static int getRandomNumber(){
        return PRIME_NUMBERS.get(getRandom());
    }

    public static List<Integer> getRandomNumbers(int size){
        List<Integer> numbers = new LinkedList<Integer>();

        while (numbers.size() != size){
            numbers.add(getRandomNumber());
        }
        return numbers;
    }

    public static int getRandom() {
        double v = (Math.random() * (99)) + 1;
        return (int) v;
    }
}
