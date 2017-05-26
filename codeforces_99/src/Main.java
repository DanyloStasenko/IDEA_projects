/*
    Task from:
    http://codeforces.com/problemset/problem/676/A?locale=en

    "Nicholas and Permutation"

    Nicholas has an array a that contains n distinct integers from 1 to n. In other words, Nicholas has a permutation
    of size n. Nicholas want the minimum element (integer 1) and the maximum element (integer n) to be as far as
    possible from each other. He wants to perform exactly one swap in order to maximize the distance between the
    minimum and the maximum elements. The distance between two elements is considered to be equal to the absolute
    difference between their positions.

    Input
    The first line of the input contains a single integer n (2 ≤ n ≤ 100) — the size of the permutation.
    The second line of the input contains n distinct integers a1, a2, ..., an (1 ≤ ai ≤ n), where ai is equal to the
    element at the i-th position.

    Output
    Print a single integer — the maximum possible distance between the minimum and the maximum elements Nicholas can
    achieve by performing exactly one swap.

    Examples
        input
                5
                4 5 1 3 2
        output
                3

        input
                7
                1 6 5 3 4 7 2
        output
                6

        input
                6
                6 5 4 3 2 1
        output
            5

    Note
        In the first sample, one may obtain the optimal answer by swapping elements 1 and 2.
        In the second sample, the minimum and the maximum elements will be located in the opposite ends of the array
        if we swap 7 and 2.
        In the third sample, the distance between the minimum and the maximum elements is already maximum possible,
        so we just perform some unnecessary swap, for example, one can swap 5 and 2.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(reader.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();

        Scanner scanner = new Scanner(reader.readLine());
        for (int i = 0; i < numbers; i++) {
            list.add(scanner.nextInt());
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int maxIndex = 0;
        int minIndex = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max){
                max = list.get(i);
                maxIndex = i;
            }
            if (list.get(i) < min){
                min = list.get(i);
                minIndex = i;
            }

        }

        int first = Integer.min(minIndex, maxIndex);
        int second = Integer.max(minIndex, maxIndex);

        if (list.size() - 1 - first > second){
            System.out.println(list.size() - 1 - first);
        } else {
            System.out.println(second);
        }
    }
}
