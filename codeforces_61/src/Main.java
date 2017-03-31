/*
    Task from:
    http://codeforces.com/problemset/problem/580/A?locale=en

    "Kefa and First Steps"

    Kefa decided to make some money doing business on the Internet for exactly n days.
    He knows that on the i-th day (1 ≤ i ≤ n) he makes ai money. Kefa loves progress,
    that's why he wants to know the length of the maximum non-decreasing subsegment in sequence ai.
    Let us remind you that the subsegment of the sequence is its continuous fragment.
    A subsegment of numbers is called non-decreasing if all numbers in it follow in the non-decreasing order.
    Help Kefa cope with this task!

    Input
    The first line contains integer n (1 ≤ n ≤ 10^5).
    The second line contains n integers a1,  a2,  ...,  an (1 ≤ ai ≤ 10^9).

    Output
    Print a single integer — the length of the maximum non-decreasing subsegment of sequence a.

    Examples
        input
                6
                2 2 1 3 4 1
        output
                3

        input
                3
                2 2 9
        output
                3

    Note
    In the first test the maximum non-decreasing subsegment is the numbers from the third to the fifth one.
    In the second test the maximum non-decreasing subsegment is the numbers from the first to the third one.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(reader.readLine());

        int previous = 0;
        int streak = 0;
        int maxStreak = 0;

        Scanner scanner = new Scanner(reader.readLine());
        for (int i = 0; i < numbers; i++) {
            int current = scanner.nextInt();

            if (current >= previous){
                streak++;
            }
            else streak = 1;

            if (streak > maxStreak){
                maxStreak = streak;
            }
            previous = current;
        }

        System.out.println(maxStreak);
    }
}
