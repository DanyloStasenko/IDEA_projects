/*
    Task from:
    http://codeforces.com/problemset/problem/734/B?locale=en

    "Anton and Digits"

    Recently Anton found a box with digits in his room.
    There are k2 digits 2, k3 digits 3, k5 digits 5 and k6 digits 6.
    Anton's favorite integers are 32 and 256. He decided to compose this integers from digits he has.
    He wants to make the sum of these integers as large as possible. Help him solve this task!
    Each digit can be used no more than once, i.e. the composed integers should contain no more than
    k2 digits 2, k3 digits 3 and so on. Of course, unused digits are not counted in the sum.

    Input
    The only line of the input contains four integers k2, k3, k5 and k6 — the number of digits
    2, 3, 5 and 6 respectively (0 ≤ k2, k3, k5, k6 ≤ 5·106).

    Output
    Print one integer — maximum possible sum of Anton's favorite integers that can be composed using digits from the box.

    Examples
        input   5 1 3 4
        output  800

        input   1 1 1 1
        output  256

    Note
    In the first sample, there are five digits 2, one digit 3, three digits 5 and four digits 6.
    Anton can compose three integers 256 and one integer 32 to achieve the value 256 + 256 + 256 + 32 = 800.
    Note, that there is one unused integer 2 and one unused integer 6. They are not counted in the answer.
    In the second sample, the optimal answer is to create on integer 256, thus the answer is 256.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int twoCount = scanner.nextInt();
        int threeCount  = scanner.nextInt();
        int fiveCount  = scanner.nextInt();
        int sixCount  = scanner.nextInt();

        int sum = 0;

        while (twoCount > 0 && fiveCount > 0 && sixCount > 0){
            sum += 256;
            twoCount--;
            fiveCount--;
            sixCount--;
        }
        while (threeCount > 0 && twoCount > 0){
            sum += 32;
            threeCount--;
            twoCount--;
        }

        System.out.println(sum);
    }
}
