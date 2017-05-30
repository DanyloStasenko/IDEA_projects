/*
    Task from:
    http://codeforces.com/problemset/problem/334/A?locale=en

    "Candy Bags"

    Gerald has n younger brothers and their number happens to be even. One day he bought n2 candy bags.
    One bag has one candy, one bag has two candies, one bag has three candies and so on. In fact,
    for each integer k from 1 to n2 he has exactly one bag with k candies.
    Help him give n bags of candies to each brother so that all brothers got the same number of candies.

    Input
    The single line contains a single integer n (n is even, 2 ≤ n ≤ 100) — the number of Gerald's brothers.

    Output
    Let's assume that Gerald indexes his brothers with numbers from 1 to n.
    You need to print n lines, on the i-th line print n integers — the numbers of candies in the bags
    for the i-th brother. Naturally, all these numbers should be distinct and be within limits from 1 to n2.
    You can print the numbers in the lines in any order.
    It is guaranteed that the solution exists at the given limits.

    Examples
        input
                2
        output
                1 4
                2 3

    Note
        The sample shows Gerald's actions if he has two brothers.
        In this case, his bags contain 1, 2, 3 and 4 candies.
        He can give the bags with 1 and 4 candies to one brother and the bags with 2 and 3 to the other brother.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int brothers = Integer.parseInt(reader.readLine());

        int [] candys = new int [brothers * brothers];

        int sumOfCandys = 0;
        for (int i = 1; i <= candys.length; i++) {
            candys[i - 1] = i;
            sumOfCandys += i;
        }

        int candysForEachBrother = sumOfCandys / brothers;

        for (int brotherCount = 0; brotherCount < brothers; brotherCount++) {
            int requiredForCurrentBrother = candysForEachBrother;
            while (requiredForCurrentBrother > 0){
                for (int i = candys.length - 1; i >= 0; i--) {
                    if (requiredForCurrentBrother - candys[i] >= 0 && candys[i] != 0){
                        requiredForCurrentBrother = requiredForCurrentBrother - candys[i];
                        System.out.print(candys[i] + " ");
                        candys[i] = 0;
                    }
                }
                System.out.println();
            }
        }
    }
}
