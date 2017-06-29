/*
    Task from:
    http://codeforces.com/problemset/problem/678/A?locale=en

    "Johny Likes Numbers"

    Johny likes numbers n and k very much. Now Johny wants to find the smallest integer x greater than n, so it is
    divisible by the number k.

    Input
    The only line contains two integers n and k (1 ≤ n, k ≤ 109).

    Output
    Print the smallest integer x > n, so it is divisible by the number k.

    Examples
        input
                5 3
        output
                6

        input
                25 13
        output
                26

        input
                26 13
        output
                39
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        if (k > n){
            System.out.println(k);
            return;
        }

        int difference = n - k;
        int add = k - difference;
        int result = n + add;


        if (result == n){
            result = result + k;
        }

        System.out.println(result);
    }
}
