/*
    Task from:
    http://codeforces.com/problemset/problem/615/A?locale=en

    "Bulbs"

    Vasya wants to turn on Christmas lights consisting of m bulbs.
    Initially, all bulbs are turned off. There are n buttons, each of them is connected to some set of bulbs.
    Vasya can press any of these buttons. When the button is pressed, it turns on all the bulbs it's connected to.
    Can Vasya light up all the bulbs? If Vasya presses the button such that some bulbs connected to it are already
    turned on, they do not change their state, i.e. remain turned on.

    Input
    The first line of the input contains integers n and m (1 ≤ n, m ≤ 100) — the number of buttons and the number
    of bulbs respectively. Each of the next n lines contains xi (0 ≤ xi ≤ m) — the number of bulbs that are turned
    on by the i-th button, and then xi numbers yij (1 ≤ yij ≤ m) — the numbers of these bulbs.

    Output
    If it's possible to turn on all m bulbs print "YES", otherwise print "NO".

    Examples
        input
                3 4
                2 1 4
                3 1 3 1
                1 2
        output
                YES

        input
                3 3
                1 1
                1 2
                1 1
        output
                NO

    Note
        In the first sample you can press each button once and turn on all the bulbs.
        In the 2 sample it is impossible to turn on the 3-rd lamp.
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

        int buttons = scanner.nextInt();
        int lampsCount = scanner.nextInt();

        HashSet<Integer> lamps = new HashSet<Integer>(lampsCount);

        for (int i = 1; i <= lampsCount; i++) {
            lamps.add(i);
        }

        for (int i = 0; i < buttons; i++) {
            scanner = new Scanner(reader.readLine());
            int lampsInRow = scanner.nextInt();
            for (int j = 0; j < lampsInRow; j++) {
                int currentLamp = scanner.nextInt();
                if (lamps.contains(currentLamp)){
                    lamps.remove(currentLamp);
                }
            }
        }

        if (lamps.isEmpty()){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
