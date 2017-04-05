/*
    Task from:
    http://codeforces.com/problemset/problem/228/A?locale=en

    "Is your horseshoe on the other hoof?"

    Valera the Horse is going to the party with friends.
    He has been following the fashion trends for a while,
    and he knows that it is very popular to wear all horseshoes of different color.
    Valera has got four horseshoes left from the last year, but maybe some of them have the same color.
    In this case he needs to go to the store and buy some few more horseshoes,
    not to lose face in front of his stylish comrades.
    Fortunately, the store sells horseshoes of all colors under the sun and Valera
    has enough money to buy any four of them. However, in order to save the money,
    he would like to spend as little money as possible, so you need to help Valera
    and determine what is the minimum number of horseshoes he needs to buy to wear
    four horseshoes of different colors to a party.

    Input
    The first line contains four space-separated integers s1, s2, s3, s4
    (1 ≤ s1, s2, s3, s4 ≤ 10^9) — the colors of horseshoes Valera has.
    Consider all possible colors indexed with integers.

    Output
    Print a single integer — the minimum number of horseshoes Valera needs to buy.

    Examples
        input    1 7 3 3
        output   1

        input    7 7 7 7
        output   3

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

        HashSet<Integer> colors = new HashSet<Integer>();

        for (int i = 0; i < 4; i++) {
            colors.add(scanner.nextInt());
        }

        int different = colors.size();
        int result = 0;

        while (different != 4){
            result++;
            different++;
        }

        System.out.println(result);
    }
}
