/*
    task from:
    http://codeforces.com/problemset/problem/779/B?locale=en

    "Weird Rounding"

    Polycarp is crazy about round numbers. He especially likes the numbers divisible by 10^k.
    In the given number of n Polycarp wants to remove the least number of digits to get a number that is divisible by 10^k.
    For example, if k = 3, in the number 30020 it is enough to delete a single digit (2).
    In this case, the result is 3000 that is divisible by 103 = 1000.

    Write a program that prints the minimum number of digits to be deleted from the given integer number n,
    so that the result is divisible by 10^k. The result should not start with the unnecessary leading zero
    (i.e., zero can start only the number 0, which is required to be written as exactly one digit).
    It is guaranteed that the answer exists.

    Input
    The only line of the input contains two integer numbers n and k (0 ≤ n ≤ 2 000 000 000, 1 ≤ k ≤ 9).
    It is guaranteed that the answer exists. All numbers in the input are written in traditional
    notation of integers, that is, without any extra leading zeros.

    Output
    Print w — the required minimal number of digits to erase. After removing the appropriate w digits from the number n,
    the result should have a value that is divisible by 10^k. The result can start with digit 0 in the single case
    (the result is zero and written by exactly the only digit 0).

    Examples:
        Input:      30020 3
        Output:     1

        Input:      100 9
        Output:     2

        Input:      10203049 2
        Output:     3

        Note: In the example 2 you can remove two digits: 1 and any 0. The result is number 0 which is divisible by any number.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Scanner scanner = new Scanner(input);

        int number = scanner.nextInt();
        int requiredZeros = scanner.nextInt();

        // get digitsCount
        int tempNumber = number;
        int numberDigitsCount = 0;
        while (tempNumber > 0) {
            tempNumber = tempNumber / 10;
            numberDigitsCount++;
        }

        int deletedDigits = 0;
        while (number % Math.pow(10, requiredZeros) != 0) {

            if (number < Math.pow(10, requiredZeros)) {
                numberDigitsCount = numberDigitsCount - 1;
                System.out.println("Result from brake: " + numberDigitsCount);
                System.exit(0);
            }

            if (number % 10 != 0) {
                deletedDigits++;
                number = number / 10;
                continue;
            }

            if (number % 10 == 0) {
                number = number / 10;
                requiredZeros--;
            }
        }

        System.out.println("Result: " + deletedDigits);
    }
}