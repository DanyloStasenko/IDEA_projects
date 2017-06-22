/*
    Task from:
    http://codeforces.com/problemset/problem/602/A?locale=en

    "Two Bases"

    After seeing the "ALL YOUR BASE ARE BELONG TO US" meme for the first time, numbers X and Y realised that they have
    different bases, which complicated their relations. You're given a number X represented in base bx and a number
    Y represented in base by. Compare those two numbers.

    Input
    The first line of the input contains two space-separated integers n and bx (1 ≤ n ≤ 10, 2 ≤ bx ≤ 40), where n is the
    number of digits in the bx-based representation of X. The second line contains n space-separated integers
    x1, x2, ..., xn (0 ≤ xi < bx) — the digits of X. They are given in the order from the most significant digit to the
    least significant one. The following two lines describe Y in the same way: the third line contains two
    space-separated integers m and by (1 ≤ m ≤ 10, 2 ≤ by ≤ 40, bx ≠ by), where m is the number of digits in the by-based
    representation of Y, and the fourth line contains m space-separated integers y1, y2, ..., ym (0 ≤ yi < by)
    — the digits of Y. There will be no leading zeroes. Both X and Y will be positive. All digits of both numbers
     are given in the standard decimal numeral system.

    Output
    Output a single character (quotes for clarity):
        '<' if X < Y
        '>' if X > Y
        '=' if X = Y

    Examples
        input
                6 2
                1 0 1 1 1 1
                2 10
                4 7
        output
                =

        input
                3 3
                1 0 2
                2 5
                2 4
        output
                <

        input
                7 16
                15 15 4 0 0 7 10
                7 9
                4 8 0 3 1 5 0
        output
                >

    Note
        In the first sample, X = 1011112 = 4710 = Y.
        In the second sample, X = 1023 = 215 and Y = 245 = 1123, thus X < Y.
        In the third sample,  and Y = 48031509. We may notice that X starts with much larger digits and bx is much
        larger than by, so X is clearly larger than Y.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        long first = 0;
        int firstNumbers = scanner.nextInt();
        int firstBase = scanner.nextInt();

        scanner = new Scanner(reader.readLine());
        int [] numbersFirst = new int[firstNumbers];
        for (int i = 0; i < firstNumbers; i++) {
            numbersFirst[i] = scanner.nextInt();
        }

        for (int i = numbersFirst.length - 1, weight = 0; i >= 0; i--, weight++) {
            first += numbersFirst[i] * Math.pow(firstBase, weight);
        }


        scanner = new Scanner(reader.readLine());
        long second = 0;
        int secondNumbers = scanner.nextInt();
        int secondBase = scanner.nextInt();

        scanner = new Scanner(reader.readLine());
        int [] numbersSecond = new int[secondNumbers];
        for (int i = 0; i < secondNumbers; i++) {
            numbersSecond[i] = scanner.nextInt();
        }

        for (int i = numbersSecond.length - 1, weight = 0; i >= 0; i--, weight++) {
            second += numbersSecond[i] * Math.pow(secondBase, weight);
        }

        if (first < second){
            System.out.println("<");
        } else if (first > second){
            System.out.println(">");
        } else {
            System.out.println("=");
        }
    }
}
