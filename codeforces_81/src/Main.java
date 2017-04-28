/*
    Task from:
    http://codeforces.com/problemset/problem/448/A?locale=en

    "Rewards"

    Bizon the Champion is called the Champion for a reason.
    Bizon the Champion has recently got a present — a new glass cupboard with n shelves and
    he decided to put all his presents there. All the presents can be divided into two types:
    medals and cups. Bizon the Champion has a1 first prize cups, a2 second prize cups and a3 third prize cups.
    Besides, he has b1 first prize medals, b2 second prize medals and b3 third prize medals.
    Naturally, the rewards in the cupboard must look good, that's why Bizon the Champion decided to follow the rules:
        any shelf cannot contain both cups and medals at the same time;
        no shelf can contain more than five cups;
        no shelf can have more than ten medals.
    Help Bizon the Champion find out if we can put all the rewards so that all the conditions are fulfilled.

    Input
    The first line contains integers a1, a2 and a3 (0 ≤ a1, a2, a3 ≤ 100). The second line contains integers
    b1, b2 and b3 (0 ≤ b1, b2, b3 ≤ 100). The third line contains integer n (1 ≤ n ≤ 100).
    The numbers in the lines are separated by single spaces.

    Output
    Print "YES" (without the quotes) if all the rewards can be put on the shelves in the described manner.
    Otherwise, print "NO" (without the quotes).

    Examples
        input
                1 1 1
                1 1 1
                4
        output
                YES

        input
                1 1 3
                2 3 4
                2
        output
                YES

        input
                1 0 0
                1 0 0
                1
        output
                NO
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int cups = scanner.nextInt();
        cups += scanner.nextInt();
        cups += scanner.nextInt();

        scanner = new Scanner(reader.readLine());
        int medals = scanner.nextInt();
        medals += scanner.nextInt();
        medals += scanner.nextInt();

        int shelves = Integer.parseInt(reader.readLine());
        for (int i = 0; i < shelves; i++) {
            if (cups > 0){
                cups = cups - 5;
                continue;
            }
            if (medals > 0){
                medals = medals - 10;
                continue;
            }
        }

        if (cups > 0 || medals > 0){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}
