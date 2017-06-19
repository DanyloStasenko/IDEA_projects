/*
    Task from:
    http://codeforces.com/problemset/problem/129/A?locale=en

    "Cookies"

    Olga came to visit the twins Anna and Maria and saw that they have many cookies. The cookies are distributed into
    bags. As there are many cookies, Olga decided that it's no big deal if she steals a bag. However, she doesn't want
    the sisters to quarrel because of nothing when they divide the cookies. That's why Olga wants to steal a bag with
    cookies so that the number of cookies in the remaining bags was even, that is, so that Anna and Maria could evenly
    divide it into two (even 0 remaining cookies will do, just as any other even number). How many ways there are to
    steal exactly one cookie bag so that the total number of cookies in the remaining bags was even?

    Input
    The first line contains the only integer n (1 ≤ n ≤ 100) — the number of cookie bags Anna and Maria have.
    The second line contains n integers ai (1 ≤ ai ≤ 100) — the number of cookies in the i-th bag.

    Output
    Print in the only line the only number — the sought number of ways. If there are no such ways print 0.

    Examples
        input
                1
                1
        output
                1

        input
                10
                1 2 2 3 4 4 4 2 2 2
        output
                8

        input
                11
                2 2 2 2 2 2 2 2 2 2 99
        output
                1

    Note
        In the first sample Olga should take the only bag so that the twins ended up with the even number of cookies.
        In the second sample Olga can take any of five bags with two cookies or any of three bags with four cookies — 5 + 3 = 8 ways in total.
        In the third sample, no matter which bag with two cookies Olga chooses, the twins are left with 2 * 9 + 99 = 117 cookies.
        Thus, Olga has only one option: to take the bag with 99 cookies.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        int result = 0;
        int cookiesSum = 0;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cookiesCount = Integer.parseInt(reader.readLine());

        ArrayList<Integer> cookies = new ArrayList<Integer>();
        Scanner scanner = new Scanner(reader.readLine());

        for (int i = 0; i < cookiesCount; i++) {
            int current = scanner.nextInt();
            cookiesSum += current;
            cookies.add(current);
        }

        if (cookiesSum %2 == 0){
            for (Integer cookie : cookies) {
                if (cookie %2 == 0){
                    result++;
                }
            }
        } else if (cookiesSum %2 == 1){
            for (Integer cookie : cookies) {
                if (cookie %2 == 1){
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}
