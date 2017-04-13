/*
    Task from:
    http://codeforces.com/problemset/problem/492/A?locale=en

    "Vanya and Cubes"

    Vanya got n cubes. He decided to build a pyramid from them.
    Vanya wants to build the pyramid as follows: the top level of the pyramid must consist of 1 cube,
    the second level must consist of 1 + 2 = 3 cubes, the third level must have 1 + 2 + 3 = 6 cubes, and so on.
    Thus, the i-th level of the pyramid must have 1 + 2 + ... + (i - 1) + i cubes.
    Vanya wants to know what is the maximum height of the pyramid that he can make using the given cubes.

    Input
    The first line contains integer n (1 ≤ n ≤ 104) — the number of cubes given to Vanya.

    Output
    Print the maximum possible height of the pyramid in the single line.

    Examples
        input   1
        output  1

        input   25
        output  4
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int blocks = Integer.parseInt(reader.readLine());

        int blocksForCurrentLevel = 0;
        int level = 0;
        for (int i = 1; blocks > 0; i++) {
            blocksForCurrentLevel += i;
            if (blocksForCurrentLevel <= blocks){
                blocks -= blocksForCurrentLevel;
                level++;
            } else {break;}
        }
        System.out.println(level);
    }
}
