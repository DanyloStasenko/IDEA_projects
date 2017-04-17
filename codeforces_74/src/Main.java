/*
    Task from:
    http://codeforces.com/problemset/problem/711/A?locale=en

    "Bus to Udayland"

    ZS the Coder and Chris the Baboon are travelling to Udayland!
    To get there, they have to get on the special IOI bus.
    The IOI bus has n rows of seats. There are 4 seats in each row,
    and the seats are separated into pairs by a walkway.
    When ZS and Chris came, some places in the bus was already occupied.
    ZS and Chris are good friends. They insist to get a pair of neighbouring empty seats.
    Two seats are considered neighbouring if they are in the same row and in the same pair.
    Given the configuration of the bus, can you help ZS and Chris determine where they should sit?

    Input
    The first line of the input contains a single integer n (1 ≤ n ≤ 1000) — the number of rows of seats in the bus.
    Then, n lines follow. Each line contains exactly 5 characters, the first two of them denote the first pair
    of seats in the row, the third character denotes the walkway (it always equals '|') and the last two of
    them denote the second pair of seats in the row.
    Each character, except the walkway, equals to 'O' or to 'X'. 'O' denotes an empty seat,
    'X' denotes an occupied seat. See the sample cases for more details.

    Output
    If it is possible for Chris and ZS to sit at neighbouring empty seats, print "YES" (without quotes)
    in the first line. In the next n lines print the bus configuration, where the characters in the pair
    of seats for Chris and ZS is changed with characters '+'. Thus the configuration should differ from
    the input one by exactly two charaters (they should be equal to 'O' in the input and to '+' in the output).
    If there is no pair of seats for Chris and ZS, print "NO" (without quotes) in a single line.
    If there are multiple solutions, you may print any of them.

    Examples

    input
            6
            OO|OX
            XO|XX
            OX|OO
            XX|OX
            OO|OO
            OO|XX
    output
            YES
            ++|OX
            XO|XX
            OX|OO
            XX|OX
            OO|OO
            OO|XX

    input
            4
            XO|OX
            XO|XX
            OX|OX
            XX|OX
    output
            NO

    input
            5
            XX|XX
            XX|XX
            XO|OX
            XO|OO
            OX|XO
    output
            YES
            XX|XX
            XX|XX
            XO|OX
            XO|++
            OX|XO

    Note
        Note that the following is an incorrect configuration
        for the first sample case because the seats must be in the same pair.
        O+|+X
        XO|XX
        OX|OO
        XX|OX
        OO|OO
        OO|XX
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rows = Integer.parseInt(reader.readLine());

        boolean resultFound = false;

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < rows; i++) {
            String input = reader.readLine();

            if (input.charAt(0) == 'O' && input.charAt(1) == 'O' && !resultFound){
                StringBuilder builder = new StringBuilder(input);
                builder.setCharAt(0,'+');
                builder.setCharAt(1,'+');
                list.add(builder.toString());
                resultFound = true;
                continue;
            }

            if (input.charAt(3) == 'O' && input.charAt(4) == 'O' && !resultFound){
                StringBuilder builder = new StringBuilder(input);
                builder.setCharAt(3,'+');
                builder.setCharAt(4,'+');
                list.add(builder.toString());
                resultFound = true;
                continue;
            }

            list.add(input);
        }

        if (resultFound){
            System.out.println("YES");
            for (String s : list) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
}
