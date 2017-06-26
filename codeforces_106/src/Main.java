/*
    Task from:
    http://codeforces.com/problemset/problem/591/B?locale=en

    "Rebranding"

    The name of one small but proud corporation consists of n lowercase English letters. The Corporation has decided to
    try rebranding — an active marketing strategy, that includes a set of measures to change either the brand (both for
    the company and the goods it produces) or its components: the name, the logo, the slogan. They decided to start with
    the name. For this purpose the corporation has consecutively hired m designers. Once a company hires the i-th
    designer, he immediately contributes to the creation of a new corporation name as follows: he takes the newest
    version of the name and replaces all the letters xi by yi, and all the letters yi by xi. This results in the new
    version. It is possible that some of these letters do no occur in the string. It may also happen that xi coincides
    with yi. The version of the name received after the work of the last designer becomes the new name of the corporation.
    Manager Arkady has recently got a job in this company, but is already soaked in the spirit of teamwork and is very
    worried about the success of the rebranding. Naturally, he can't wait to find out what is the new name the
    Corporation will receive. Satisfy Arkady's curiosity and tell him the final version of the name.

    Input
    The first line of the input contains two integers n and m (1 ≤ n, m ≤ 200 000) — the length of the initial name and
    the number of designers hired, respectively. The second line consists of n lowercase English letters and represents
    the original name of the corporation. Next m lines contain the descriptions of the designers' actions: the i-th of
    them contains two space-separated lowercase English letters xi and yi.

    Output
    Print the new name of the corporation.

    Examples
        input
                6 1
                police
                p m
        output
                molice

        input
                11 6
                abacabadaba
                a b
                b c
                a d
                e g
                f a
                b b
        output
                cdcbcdcfcdc

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int letters = scanner.nextInt();
        int designers = scanner.nextInt();

        StringBuilder builder = new StringBuilder(reader.readLine());

        for (int i = 0; i < designers; i++) {
            String input = reader.readLine();

            char oldChar = input.charAt(0);
            char newChar = input.charAt(2);

            for (int j = 0; j < builder.length(); j++) {

                if (builder.charAt(j) == oldChar){
                    builder.setCharAt(j, newChar);
                    continue;
                }
                if (builder.charAt(j) == newChar){
                    builder.setCharAt(j, oldChar);
                }
            }

        }
        System.out.println(builder.toString());
    }
}
