/*
    task from:
    http://codeforces.com/problemset/problem/285/C?locale=en

    "Building Permutation"

    Permutation p is an ordered set of integers p1,  p2,  ...,  pn, consisting of n distinct positive integers,
    each of them doesn't exceed n. We'll denote the i-th element of permutation p as pi. We'll call number
    n the size or the length of permutation p1,  p2,  ...,  pn. You have a sequence of integers a1, a2, ..., an.
    In one move, you are allowed to decrease or increase any number by one. Count the minimum number of
    moves, needed to build a permutation from this sequence.

    Input
    The first line contains integer n (1 ≤ n ≤ 3·105) — the size of the sought permutation.
    The second line contains n integers a1, a2, ..., an ( - 109 ≤ ai ≤ 109).

    Output
    Print a single number — the minimum number of moves.

    Please, do not use the %lld specifier to read or write 64-bit integers in С++. It is preferred to use
    the cin, cout streams or the %I64d specifier.

    Examples:

    Input:
            2
            3 0
    Output:
            2

    Input:
            3
            -1 -1 2
    Output:
            6

    Note
    In the first sample you should decrease the first number by one and then increase the second number by one.
    The resulting permutation is (2, 1).
    In the second sample you need 6 moves to build permutation (1, 3, 2).
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        ArrayList<Long> numbers = new ArrayList<Long>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());
        long maxNumbers = scanner.nextInt();

        long count = 0;
        scanner = new Scanner(reader.readLine());
        for (long i = 0; i < maxNumbers ; i++) {
            numbers.add(scanner.nextLong());
        }

        Collections.sort(numbers);

        long expected = 1;
        for (Long aLong : numbers) {
            while (aLong != expected){
                if (aLong < expected){
                    count += expected - aLong;
                    aLong += expected - aLong;
                }
                if (aLong > expected){
                    count += aLong - expected;
                    aLong -= aLong - expected;
                }
            }
            expected++;
        }
        System.out.println(count);
    }
}
