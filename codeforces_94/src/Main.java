/*
    Task from:
    http://codeforces.com/problemset/problem/688/A?locale=en

    "Opponents"

    Arya has n opponents in the school. Each day he will fight with all opponents who are present this day.
    His opponents have some fighting plan that guarantees they will win, but implementing this plan requires
    presence of them all. That means if one day at least one of Arya's opponents is absent at the school,
    then Arya will beat all present opponents. Otherwise, if all opponents are present, then they will beat Arya.
    For each opponent Arya knows his schedule — whether or not he is going to present on each particular day.
    Tell him the maximum number of consecutive days that he will beat all present opponents.
    Note, that if some day there are no opponents present, Arya still considers he beats all the present opponents.

    Input
    The first line of the input contains two integers n and d (1 ≤ n, d ≤ 100) — the number of opponents and the number
    of days, respectively. The i-th of the following d lines contains a string of length n consisting of characters
    '0' and '1'. The j-th character of this string is '0' if the j-th opponent is going to be absent on the i-th day.

    Output
    Print the only integer — the maximum number of consecutive days that Arya will beat all present opponents.

    Examples
        input
                2 2
                10
                00
        output
                2

        input
                4 1
                0100
        output
                1

        input
                4 5
                1101
                1111
                0110
                1011
                1111
        output
                2
    Note
    In the first and the second samples, Arya will beat all present opponents each of the d days.
    In the third sample, Arya will beat his opponents on days 1, 3 and 4 and his opponents will beat him on days 2 and 5.
    Thus, the maximum number of consecutive winning days is 2, which happens on days 3 and 4.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int opponents = scanner.nextInt();              // length
        int days = scanner.nextInt();                   // strings

        int winDays = 0;
        int maxWinDays = 0;

        for (int i = 0; i < days; i++) {
            String input = reader.readLine();
            if (input.contains("0")){
                winDays++;
            } else {
                winDays = 0;
            }
            if (maxWinDays < winDays){
                maxWinDays = winDays;
            }
        }

        System.out.println(maxWinDays);
    }
}
