/*
    task from:
    http://codeforces.com/contest/651/problem/B?locale=en

    "Beautiful Paintings"

    There are n pictures delivered for the new exhibition.
    The i-th painting has beauty ai. We know that a visitor becomes happy
    every time he passes from a painting to a more beautiful one.
    We are allowed to arranged pictures in any order. What is the maximum possible
    number of times the visitor may become happy while passing all pictures
    from first to last? In other words, we are allowed to rearrange elements of a in any order.
    What is the maximum possible number of indices i (1 ≤ i ≤ n - 1), such that ai + 1 > ai.

    Input
    The first line of the input contains integer n (1 ≤ n ≤ 1000) — the number of painting.
    The second line contains the sequence a1, a2, ..., an (1 ≤ ai ≤ 1000), where ai means the beauty of the i-th painting.

    Output
    Print one integer — the maximum possible number of neighbouring pairs, such that ai + 1 > ai, after the optimal rearrangement.

    Examples:
    Input:
            5
            20 30 10 50 40
    Output:
            4


    Input:
            4
            200 100 100 200
    Output:
            2

    Note
    In the first sample, the optimal order is: 10, 20, 30, 40, 50.
    In the second sample, the optimal order is: 100, 200, 100, 200.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        ArrayList<Integer> pictures = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int picturesCount = Integer.parseInt(reader.readLine());
        Scanner scanner = new Scanner(reader.readLine());

        for (int i = 0; i < picturesCount; i++) {
            pictures.add(scanner.nextInt());
        }

        int deletedItems = 0;
        int deletions = 0;
        while (!pictures.isEmpty()){
            int tempDeletedItems = delete(pictures);
            if (tempDeletedItems == 0){
                break;
            }
            deletedItems += tempDeletedItems;
            deletions++;
        }

        System.out.println(deletedItems - deletions);
    }

    public static int delete(ArrayList<Integer> pictures){
        HashSet<Integer> processingSet = new HashSet<Integer>();
        for (Integer picture : pictures) {
            if (!processingSet.contains(picture)){
                processingSet.add(picture);
            }
        }

        int deletedItems = processingSet.size();
        for (Integer integer : processingSet) {
            pictures.remove(integer);
        }
        return deletedItems;
    }
}
