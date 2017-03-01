/*
        task from:
        http://codeforces.com/problemset/problem/320/A?locale=en

        "Magic Numbers"

        A magic number is a number formed by concatenation of numbers 1, 14 and 144.
        We can use each of these numbers any number of times.
        Therefore 14144, 141414 and 1411 are magic numbers but 1444, 514 and 414 are not.

        You're given a number. Determine if it is a magic number or not.

        Input
        The first line of input contains an integer n, (1 ≤ n ≤ 109). This number doesn't contain leading zeros.

        Output
        Print "YES" if n is a magic number or print "NO" if it's not.

            Examples:
                Input:      114114
                Output:     YES

                Input:      1111
                Output:     YES

                Input:      441231
                Output:     NO
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if (deleteCharacters(reader.readLine()).length() == 0){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    static String deleteCharacters(String input){
        for (int i = 0; i < input.length() ; i++) {

            // deleting '144'
            if (input.contains("144")){
                if(input.regionMatches(i, "144", 0, 3)){
                    StringBuilder builder = new StringBuilder(input);
                    return deleteCharacters(builder.delete(i, i+3).toString());
                }
            }

            // deleting '14'
            if (input.contains("14")){
                if(input.regionMatches(i, "14", 0, 2)){
                    StringBuilder builder = new StringBuilder(input);
                    return deleteCharacters(builder.delete(i, i+2).toString());
                }
            }

            // deleting '1'
            if (input.contains("1")){
                if(input.regionMatches(i, "1", 0, 1)){
                    StringBuilder builder = new StringBuilder(input);
                    return deleteCharacters(builder.delete(i, i+1).toString());
                }
            }
        }

        return input;
    }
}
