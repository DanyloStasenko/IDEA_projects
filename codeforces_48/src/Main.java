/*
    Task from:
    http://codeforces.com/problemset/problem/609/A?locale=en

    "USB Flash Drives"

        Sean is trying to save a large file to a USB flash drive.
        He has n USB flash drives with capacities equal to a1, a2, ..., an megabytes.
        The file size is equal to m megabytes.
        Find the minimum number of USB flash drives needed to write Sean's file, if he can split the file between drives.

        Input
        The first line contains positive integer n (1 ≤ n ≤ 100) — the number of USB flash drives.
        The second line contains positive integer m (1 ≤ m ≤ 10^5) — the size of Sean's file.
        Each of the next n lines contains positive integer ai (1 ≤ ai ≤ 1000) — the sizes of USB flash drives in megabytes.
        It is guaranteed that the answer exists, i. e. the sum of all ai is not less than m.

        Output
        Print the minimum number of USB flash drives to write Sean's file, if he can split the file between drives.

        Examples
            input
                3
                5
                2
                1
                3
            output
                2

            input
                3
                6
                2
                3
                2
            output
                3

            input
                2
                5
                5
                10
            output
                1

            Note
            In the first example Sean needs only two USB flash drives — the first and the third.
            In the second example Sean needs all three USB flash drives.
            In the third example Sean needs only one USB flash drive and he can use any available USB flash drive — the first or the second.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cardNumber = Integer.parseInt(reader.readLine());
        int fileSize = Integer.parseInt(reader.readLine());

        ArrayList<Integer> cards = new ArrayList<Integer>();
        for (int i = 0; i < cardNumber; i++) {
            cards.add(Integer.parseInt(reader.readLine()));
        }

        Collections.sort(cards ,Collections.reverseOrder());

        int requiredCards = 0;
        while (fileSize > 0){
            fileSize = fileSize - cards.get(0);
            cards.remove(0);
            requiredCards++;
        }

        System.out.println(requiredCards);
    }
}
