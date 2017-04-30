/*
    Task from:
    http://codeforces.com/problemset/problem/716/A?locale=en

    "Crazy Computer"

    ZS the Coder is coding on a crazy computer.
    If you don't type in a word for a c consecutive seconds, everything you typed disappear!
    More formally, if you typed a word at second a and then the next word at second b, then if b - a ≤ c,
    just the new word is appended to other words on the screen. If b - a > c, then everything on the screen
    disappears and after that the word you have typed appears on the screen.
    For example, if c = 5 and you typed words at seconds 1, 3, 8, 14, 19, 20 then at the second 8 there
    will be 3 words on the screen. After that, everything disappears at the second 13 because nothing was typed.
    At the seconds 14 and 19 another two words are typed, and finally, at the second 20,
    one more word is typed, and a total of 3 words remain on the screen.
    You're given the times when ZS the Coder typed the words.
    Determine how many words remain on the screen after he finished typing everything.

    Input
    The first line contains two integers n and c (1 ≤ n ≤ 100 000, 1 ≤ c ≤ 109) — the number of words
    ZS the Coder typed and the crazy computer delay respectively.
    The next line contains n integers t1, t2, ..., tn (1 ≤ t1 < t2 < ... < tn ≤ 10^9),
    where ti denotes the second when ZS the Coder typed the i-th word.

    Output
    Print a single positive integer, the number of words that remain on the screen after all n words was typed,
    in other words, at the second tn.

    Examples
        input
                6 5
                1 3 8 14 19 20
        output
                3

        input
                6 1
                1 3 5 7 9 10
        output
                2

    Note
        The first sample is already explained in the problem statement.
        For the second sample, after typing the first word at the second 1,
        it disappears because the next word is typed at the second 3 and 3 - 1 > 1.
        Similarly, only 1 word will remain at the second 9. Then, a word is typed at the second 10,
        so there will be two words on the screen, as the old word won't disappear because 10 - 9 ≤ 1.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int wordsNumber = scanner.nextInt();
        int delay = scanner.nextInt();

        scanner = new Scanner(reader.readLine());

        int words = 1;
        int currentTime = 0;

        for (int i = 0; i < wordsNumber; i++) {
            int nextTime = scanner.nextInt();

            if (nextTime - currentTime > delay){
                words = 1;
            } else {
                words++;
            }

            currentTime = nextTime;
        }

        if (words > wordsNumber){
            System.out.println(wordsNumber);
            System.exit(0);
        }
        System.out.println(words);
    }
}
