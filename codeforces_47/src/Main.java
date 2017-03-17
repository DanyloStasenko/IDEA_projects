/*
    Task from:
    http://codeforces.com/problemset/problem/41/A?locale=en

    "Translation"

    The translation from the Berland language into the Birland language is not an easy task.
    Those languages are very similar: a berlandish word differs from a birlandish word with the same meaning a little:
    it is spelled (and pronounced) reversely. For example, a Berlandish word code corresponds to a Birlandish word edoc.
    However, it's easy to make a mistake during the «translation».
    Vasya translated word s from Berlandish into Birlandish as t.
    Help him: find out if he translated the word correctly.

    Input
    The first line contains word s, the second line contains word t. The words consist of lowercase Latin letters. The input data do not consist unnecessary spaces. The words are not empty and their lengths do not exceed 100 symbols.

    Output
    If the word t is a word s, written reversely, print YES, otherwise print NO.

    Examples:

    input
        code
        edoc
    output
        YES

    input
        abb
        aba
    output
        NO

    input
        code
        code
    output
        NO
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String original = reader.readLine();
        String translation = reader.readLine();

        if (original.length() != translation.length()){
            System.out.println("NO");
            System.exit(0);
        }

        int matched = 0;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == translation.charAt(translation.length() - i - 1)){
                matched++;
            }
        }

        if (matched == translation.length()){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}
