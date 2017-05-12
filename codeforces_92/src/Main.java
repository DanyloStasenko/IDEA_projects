/*
    Task from:
    http://codeforces.com/problemset/problem/151/A?locale=en

    "Soft Drinking"

    This winter is so cold in Nvodsk!
    A group of n friends decided to buy k bottles of a soft drink called "Take-It-Light" to warm up a bit.
    Each bottle has l milliliters of the drink. Also they bought c limes and cut each of them into d slices.
    After that they found p grams of salt. To make a toast, each friend needs nl milliliters of the drink,
    a slice of lime and np grams of salt. The friends want to make as many toasts as they can, provided
    they all drink the same amount. How many toasts can each friend make?

    Input
    The first and only line contains positive integers n, k, l, c, d, p, nl, np, not exceeding 1000
    and no less than 1. The numbers are separated by exactly one space.

    Output
    Print a single integer — the number of toasts each friend can make.

    Examples
        input   3 4 5 10 8 100 3 1
        output  2

        input   5 100 10 1 19 90 4 3
        output  3

        input   10 1000 1000 25 23 1 50 1
        output  0

    Note
    A comment to the first sample:
    Overall the friends have 4 * 5 = 20 milliliters of the drink, it is enough to make 20 / 3 = 6 toasts.
    The limes are enough for 10 * 8 = 80 toasts and the salt is enough for 100 / 1 = 100 toasts.
    However, there are 3 friends in the group, so the answer is min(6, 80, 100) / 3 = 2.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int friends = scanner.nextInt();
        int bottles = scanner.nextInt();
        int mililitersInBottle = scanner.nextInt();
        int limes = scanner.nextInt();
        int limePieces = scanner.nextInt();
        int salt = scanner.nextInt();
        int milisPerFriend = scanner.nextInt();
        int saltPerFriend = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();

        int drunkLimit = (bottles * mililitersInBottle / milisPerFriend);
        int limeLimit = limes * limePieces;
        int saltLimit = salt / saltPerFriend;

        if (drunkLimit / friends < 1 || limeLimit / friends < 1 || saltLimit / friends < 1){
            System.out.println(0);
        } else {

            list.add(drunkLimit / friends);
            list.add(limeLimit / friends);
            list.add(saltLimit / friends);

            int min = Integer.MAX_VALUE;

            for (Integer integer : list) {
                if (integer < min) {
                    min = integer;
                }
            }

            System.out.println(min);
        }
    }
}
