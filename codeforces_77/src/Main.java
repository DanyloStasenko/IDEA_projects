/*
    Task from:
    http://codeforces.com/problemset/problem/599/A

    "Patrick and Shopping"

    Today Patrick waits for a visit from his friend Spongebob.
    To prepare for the visit, Patrick needs to buy some goodies in two stores located near his house.
    There is a d1 meter long road between his house and the first shop and a d2 meter long road between
    his house and the second shop. Also, there is a road of length d3 directly connecting these two shops
    to each other. Help Patrick calculate the minimum distance that he needs to walk in order to go
    to both shops and return to his house. Patrick always starts at his house.
    He should visit both shops moving only along the three existing roads and return back to his house.
    He doesn't mind visiting the same shop or passing the same road multiple times.
    The only goal is to minimize the total distance traveled.

    Input
    The first line of the input contains three integers d1, d2, d3 (1 ≤ d1, d2, d3 ≤ 10^8) — the lengths of the paths.
    d1 is the length of the path connecting Patrick's house and the first shop;
    d2 is the length of the path connecting Patrick's house and the second shop;
    d3 is the length of the path connecting both shops.

    Output
    Print the minimum distance that Patrick will have to walk in order to visit both shops and return to his house.

    Examples
        input
                10 20 30
        output
                60

        input
                1 1 5
        output
                4

    Note
        The first sample optimal routes is: house - first shop - second shop - house.
        In the second sample one of the optimal routes is: house - first shop - house - second shop - house.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int toFirstShop = scanner.nextInt();
        int toSecondShop = scanner.nextInt();
        int betweenShops = scanner.nextInt();

        int result = toFirstShop + toSecondShop + betweenShops;

        if (toFirstShop * 2 + betweenShops * 2 < result){
            result = toFirstShop * 2 + betweenShops * 2;
        }

        if (toSecondShop * 2 + betweenShops * 2 < result){
            result = toSecondShop * 2 + betweenShops * 2;
        }

        if (toSecondShop * 2 + toFirstShop * 2 < result){
            result = toSecondShop * 2 + toFirstShop * 2;
        }

        System.out.println(result);
    }
}
