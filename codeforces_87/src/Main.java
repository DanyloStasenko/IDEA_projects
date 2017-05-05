/*
    Task from:
    http://codeforces.com/problemset/problem/733/A?locale=en

    "Grasshopper And the String"

    One day, the Grasshopper was jumping on the lawn and found a piece of paper with a string.
    Grasshopper became interested what is the minimum jump ability he should have in order to
    be able to reach the far end of the string, jumping only on vowels of the English alphabet.
    Jump ability is the maximum possible length of his jump.
    Formally, consider that at the begginning the Grasshopper is located directly in front of
    the leftmost character of the string. His goal is to reach the position right after the
    rightmost character of the string. In one jump the Grasshopper could jump to the right any
    distance from 1 to the value of his jump ability.
    The following letters are vowels: 'A', 'E', 'I', 'O', 'U' and 'Y'.

    Input
    The first line contains non-empty string consisting of capital English letters.
    It is guaranteed that the length of the string does not exceed 100.

    Output
    Print single integer a — the minimum jump ability of the Grasshopper (in the number of
    symbols) that is needed to overcome the given string, jumping only on vowels.

    Examples
        input       ABABBBACFEYUKOTT
        output      4

        input       AAA
        output      1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        // A', 'E', 'I', 'O', 'U' и 'Y'.
        int count  = 1;
        int maxCount  = 1;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'A'
                    || input.charAt(i) == 'E'
                    || input.charAt(i) == 'I'
                    || input.charAt(i) == 'O'
                    || input.charAt(i) == 'U'
                    || input.charAt(i) == 'Y'){
                count = 1;
            } else {
                count++;
            }

            if (maxCount < count){
                maxCount = count;
            }
        }

        if (!input.contains("A") && !input.contains("E") && !input.contains("I")
                && !input.contains("O") && !input.contains("U") && !input.contains("Y")){
            System.out.println(input.length() + 1);
            return;
        }

        System.out.println(maxCount);
    }
}
