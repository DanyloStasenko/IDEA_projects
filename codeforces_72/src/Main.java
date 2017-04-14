/*
    Task from:
    http://codeforces.com/problemset/problem/443/A?locale=en

    "Anton and Letters"

    Recently, Anton has found a set. The set consists of small English letters.
    Anton carefully wrote out all the letters from the set in one line, separated by a comma.
    He also added an opening curved bracket at the beginning of the line
    and a closing curved bracket at the end of the line.
    Unfortunately, from time to time Anton would forget writing some letter and write it again.
    He asks you to count the total number of distinct letters in his set.

    Input
    The first and the single line contains the set of letters. The length of the line doesn't exceed 1000. It is guaranteed that the line starts from an opening curved bracket and ends with a closing curved bracket. Between them, small English letters are listed, separated by a comma. Each comma is followed by a space.

    Output
    Print a single number — the number of distinct letters in Anton's set.

    Examples
        input   {a, b, c}
        output  3

        input   {b, a, b, a}
        output  2

        input   {}
        output  0
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) != '{' && input.charAt(i) != '}' && input.charAt(i) != ' ' && input.charAt(i) != ','){
                set.add(input.charAt(i));
            }

        }
        System.out.println(set.size());
    }
}
