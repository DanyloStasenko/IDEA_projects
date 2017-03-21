/*.
    Task from:
    http://codeforces.com/problemset/problem/546/A?locale=en

    "Soldier and Bananas"

    A soldier wants to buy w bananas in the shop.
    He has to pay k dollars for the first banana, 2k dollars for the second one and so on
   (in other words, he has to pay i·k dollars for the i-th banana).
    He has n dollars. How many dollars does he have to borrow from his friend soldier to buy w bananas?

    Input
    The first line contains three positive integers k, n, w (1  ≤  k, w  ≤  1000, 0 ≤ n ≤ 109),
    the cost of the first banana, initial number of dollars the soldier has and number of bananas he wants.

    Output
    Output one integer — the amount of dollars that the soldier must borrow from his friend.
    If he doesn't have to borrow money, output 0.

    Examples
        input       3 17 4
        output      13

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int firstBananaPrice = scanner.nextInt();
        int money = scanner.nextInt();
        int bananasToBuy = scanner.nextInt();

        int index = 1;
        int currentBananaPrice;
        while (bananasToBuy != 0){
            currentBananaPrice = firstBananaPrice * index;
            money = money - currentBananaPrice;
            index++;
            bananasToBuy--;
        }

        if (money >= 0){
            System.out.println("0");
        }
        else {
            System.out.println(money * -1);
        }
    }
}
