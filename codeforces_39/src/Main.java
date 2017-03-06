/*
    task from:
    http://codeforces.com/problemset/problem/34/B?locale=en

    "Sale"

        Once Bob got to a sale of old TV sets. There were n TV sets at that sale.
        TV set with index i costs ai bellars. Some TV sets have a negative price
        — their owners are ready to pay Bob if he buys their useless apparatus.
        Bob can «buy» any TV sets he wants. Though he's very strong, Bob can carry
        at most m TV sets, and he has no desire to go to the sale for the second time.
        Please, help Bob find out the maximum sum of money that he can earn.

        Input
        The first line contains two space-separated integers n and m (1 ≤ m ≤ n ≤ 100)
        — amount of TV sets at the sale, and amount of TV sets that Bob can carry.
        The following line contains n space-separated integers ai ( - 1000 ≤ ai ≤ 1000)
        — prices of the TV sets.

        Output
        Output the only number — the maximum sum of money that Bob can earn,
        given that he can carry at most m TV sets.


        Examples:

        Input:
                5 3
               -6 0 35 -2 4
        Output:
                8


        Input:
                4 2
                7 0 0 -7
        Output:
                7
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Scanner scanner = new Scanner(input);

        int itemsToSell = scanner.nextInt();
        int availableToTransport = scanner.nextInt();
        int earnedMoney = 0;

        scanner = new Scanner(reader.readLine());
        ArrayList<Integer> allItems = new ArrayList<Integer>();
        for (int i = 0; i < itemsToSell; i++) {
            allItems.add(scanner.nextInt());
        }

        bubbleSort(allItems);

        for (Integer item : allItems) {
            if (availableToTransport > 0){
                if (item < 0){
                    availableToTransport--;
                    earnedMoney += item;
                }
            }
        }
        System.out.println(earnedMoney * -1);
    }

    public static void bubbleSort(ArrayList<Integer> arrayList) {

        for (int i = arrayList.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (arrayList.get(j) > arrayList.get(j + 1)) {
                    int temp = arrayList.get(j);
                    arrayList.set(j, arrayList.get(j + 1));
                    arrayList.set(j + 1, temp);
                }
            }
        }
    }
}
