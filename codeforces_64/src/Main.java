/*
    Task from:
    http://codeforces.com/problemset/problem/784/F?locale=en

    "Crunching Numbers Just for You"

    You are developing a new feature for the website which sells airline tickets:
    being able to sort tickets by price! You have already extracted the tickets'
    prices, so there's just the last step to be done...
    You are given an array of integers. Sort it in non-descending order.

    Input
    The input consists of a single line of space-separated integers.
    The first number is n (1 ≤ n ≤ 10) — the size of the array.
    The following n numbers are the elements of the array (1 ≤ ai ≤ 100).

    Output
    Output space-separated elements of the sorted array.

    Example
        input
            3 3 1 2
        output
            1 2 3

        Note
        Remember, this is a very important feature, and you have to make sure the customers appreciate it!

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> values = new ArrayList<Integer>();

        Scanner scanner = new Scanner(reader.readLine());
        int numbers = scanner.nextInt();
        for (int i = 0; i < numbers; i++) {
            values.add(scanner.nextInt());
        }

        Collections.sort(values);

        for (int i = 0; i < values.size(); i++) {
            System.out.print(values.get(i));

            if (values.size() > 2 && i != values.size() - 1){
                System.out.print(" ");
            }
        }
    }
}
