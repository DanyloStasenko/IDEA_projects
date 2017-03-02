/*
        task from:
        http://codeforces.com/problemset/problem/702/A?locale=en

        "Maximum Increase"

        You are given array consisting of n integers.
        Your task is to find the maximum length of an increasing subarray of the given array.
        A subarray is the sequence of consecutive elements of the array.
        Subarray is called increasing if each element of this subarray strictly greater than previous.

        Input
        The first line contains single positive integer n (1 ≤ n ≤ 105) — the number of integers.
        The second line contains n positive integers a1, a2, ..., an (1 ≤ ai ≤ 109).

        Output
        Print the maximum length of an increasing subarray of the given array.

        Examples:

            Input:      5
                        1 7 2 11 15
            Output:     3


            Input:      6
                        100 100 100 100 100 100
            Output:     1


            Input:      3
                        1 2 3
            Output:     3
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int [] numbers = new int [Integer.parseInt(reader.readLine())];
        Scanner scanner = new Scanner(reader.readLine());

        for (int i = 0; i < numbers.length ; i++) {
            numbers [i] = scanner.nextInt();
        }

        int maxStreak = 1;
        int currentStreak = 1;
        int thisNumber = numbers[0];

        for (int i = 1; i < numbers.length; i++) {

            // check numbers
            if (numbers [i] > thisNumber){
                currentStreak++;
                thisNumber = numbers[i];
            }

            else if (numbers [i] < thisNumber){
                currentStreak = 1;
                thisNumber = numbers[i];
            }

            // check streaks
            if (currentStreak > maxStreak){
                maxStreak = currentStreak;
            }
        }

        System.out.println(maxStreak);
    }
}
