/*
    Task from:
    http://codeforces.com/problemset/problem/787/A?locale=en

    "The Monster"

    A monster is chasing after Rick and Morty on another planet.
    They're so frightened that sometimes they scream. More accurately,
    Rick screams at times b, b + a, b + 2a, b + 3a, ... and Morty screams at times d, d + c, d + 2c, d + 3c, ....
    The Monster will catch them if at any point they scream at the same time,
    so it wants to know when it will catch them (the first time they scream at the same time)
    or that they will never scream at the same time.

    Input
    The first line of input contains two integers a and b (1 ≤ a, b ≤ 100).
    The second line contains two integers c and d (1 ≤ c, d ≤ 100).

    Output
    Print the first time Rick and Morty will scream at the same time, or  - 1 if they will never scream at the same time.

    Examples
        input   20 2
                9 19
        output  82

        input   2 1
                16 12
        output  -1

    Note
    In the first sample testcase, Rick's 5th scream and Morty's 8th time are at time 82.
    In the second sample testcase, all Rick's screams will be at odd times and Morty's will be at even times,
    so they will never scream at the same time.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int rikiStep = scanner.nextInt();
        int rikiStart = scanner.nextInt();

        scanner = new Scanner(reader.readLine());

        int mortyStep = scanner.nextInt();
        int mortyStart = scanner.nextInt();

        HashSet<Integer> rikiSteps = new HashSet<Integer>();

        for (int i = 0; i < 100; i++) {
            rikiSteps.add(rikiStart + rikiStep * i);
        }

        for (int i = 0; i < 100; i++) {
            if (rikiSteps.contains(mortyStart + mortyStep * i)){
                System.out.println(mortyStart + mortyStep * i);
                return;
            }
        }

        System.out.println("-1");
    }
}
