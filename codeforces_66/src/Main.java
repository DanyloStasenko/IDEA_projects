/*
    Task from:
    http://codeforces.com/problemset/problem/705/A?locale=en

    "Hulk"

    Dr. Bruce Banner hates his enemies (like others don't).
    As we all know, he can barely talk when he turns into the incredible Hulk.
    That's why he asked you to help him to express his feelings.
    Hulk likes the Inception so much, and like that his feelings are complicated.
    They have n layers. The first layer is hate, second one is love, third one is hate and so on...
    For example if n = 1, then his feeling is "I hate it"
    or if n = 2 it's "I hate that I love it",
    and if n = 3 it's "I hate that I love that I hate it" and so on.
    Please help Dr. Banner.

    Input
    The only line of the input contains a single integer n (1 ≤ n ≤ 100) — the number of layers of love and hate.

    Output
    Print Dr.Banner's feeling in one line.

    Examples
        input   1
        output  I hate it

        input   2
        output  I hate that I love it

        input   3
        output  I hate that I love that I hate it
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int levels = Integer.parseInt(reader.readLine());

        for (int i = 0; i < levels; i++) {
            if (i % 2 == 0){
                System.out.print("I hate ");
                if (i == levels - 1){
                    System.out.print("it");
                } else {
                    System.out.print("that ");
                }
            }

            if (i % 2 == 1){
                System.out.print("I love ");
                if (i == levels - 1){
                    System.out.print("it");
                } else {
                    System.out.print("that ");
                }
            }
        }
    }
}
