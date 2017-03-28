/*
    Task from:
    http://codeforces.com/problemset/problem/318/A?locale=en

    "Even Odds"

    Being a nonconformist, Volodya is displeased with the current state of things, particularly with the order of
    natural numbers (natural number is positive integer number). He is determined to rearrange them. But there are
    too many natural numbers, so Volodya decided to start with the first n. He writes down the following sequence
    of numbers: firstly all odd integers from 1 to n (in ascending order), then all even integers from 1 to n
    (also in ascending order). Help our hero to find out which number will stand at the position number k.

    Input
    The only line of input contains integers n and k (1 ≤ k ≤ n ≤ 10^12).
    Please, do not use the %lld specifier to read or write 64-bit integers in C++.
    It is preferred to use the cin, cout streams or the %I64d specifier.

    Output
    Print the number that will stand at the position number k after Volodya's manipulations.

    Examples
        input   10 3
        output  5

        input   7 7
        output  6

    Note
    In the first sample Volodya's sequence will look like this: {1, 3, 5, 7, 9, 2, 4, 6, 8, 10}.
    The third place in the sequence is therefore occupied by the number 5.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());
        long max = scanner.nextLong();
        long pos = scanner.nextLong();
        long odd;               // % 2 == 1

        if (max % 2 == 0){
            odd = max / 2;
        } else {
            odd = max / 2 + 1;
        }

        if (pos > odd){
            pos = pos - odd;
            System.out.println(2 * pos);
        } else {
            System.out.println(2 * pos - 1);
        }
    }
}
