/*
    Task from:
    http://codeforces.com/problemset/problem/389/A?locale=en

    "Fox and Number Game"

    Fox Ciel is playing a game with numbers now.
    Ciel has n positive integers: x1, x2, ..., xn.
    She can do the following operation as many times as needed: select two different indexes i and j
    such that xi > xj hold, and then apply assignment xi = xi - xj.
    The goal is to make the sum of all numbers as small as possible.
    Please help Ciel to find this minimal sum.

    Input
    The first line contains an integer n (2 ≤ n ≤ 100).
    Then the second line contains n integers: x1, x2, ..., xn (1 ≤ xi ≤ 100).

    Output
    Output a single integer — the required minimal sum.

    Examples:

        Input:  2
                1 2
        Output: 2


        Input:  3
                2 4 6
        Output: 6


        Input:  2
                12 18
        Output: 12


        Input:  5
                45 12 27 30 18
        Output: 15

        Note:
        In the first example the optimal way is to do the assignment: x2 = x2 - x1.
        In the second example the optimal sequence of operations is: x3 = x3 - x2, x2 = x2 - x1.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(reader.readLine());
        Scanner scanner = new Scanner(reader.readLine());

        for (int i = 0; i < arraySize ; i++) {
            numbers.add(scanner.nextInt());
        }

        deleteAllAvailableValues(numbers);

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }

    static int deleteAllAvailableValues(ArrayList<Integer> list){
        if (list.size() >= 2){
            Collections.sort(list);

            // getting max value
            int max = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > max){
                    max = list.get(i);
                }
            }

            // getting 2nd max value
            int less = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) > less && list.get(i) < max){
                    less = list.get(i);
                }
            }

            // breaking only when 2nd max value not found (it means that ALL values in list == max value)
            if (less == 0){
                return 0;
            }

            int thisInt = max - less;
            list.set(list.size() - 1, thisInt);
            deleteAllAvailableValues(list);
        }
        return 0;
    }
}
