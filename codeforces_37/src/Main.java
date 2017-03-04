/*
    task from:
    http://codeforces.com/problemset/problem/381/A?locale=en

    "Card game"

        Sereja and Dima play a game. The rules of the game are very simple.
        The players have n cards in a row. Each card contains a number,
        all numbers on the cards are distinct. The players take turns,
        Sereja moves first. During his turn a player can take one card:
        either the leftmost card in a row, or the rightmost one.
        The game ends when there is no more cards.
        The player who has the maximum sum of numbers on his cards
        by the end of the game, wins.

        Sereja and Dima are being greedy.
        Each of them chooses the card with the larger number during his move.
        Inna is a friend of Sereja and Dima. She knows which strategy the guys are using,
        so she wants to determine the final score, given the initial state of the game. Help her.

        Input
        The first line contains integer n (1 ≤ n ≤ 1000) — the number of cards on the table.
        The second line contains space-separated numbers on the cards from left to right.
        The numbers on the cards are distinct integers from 1 to 1000.

        Output
        On a single line, print two integers.
        The first number is the number of Sereja's points at the end of the game,
        the second number is the number of Dima's points at the end of the game.


        Examples:

        Input:      4
                    4 1 2 10
        Output:     12 5


        Input:      7
                    1 2 3 4 5 6 7
        Output:     16 12
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        ArrayList<Integer> cards = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cardsCount = Integer.parseInt(reader.readLine());
        Scanner scanner = new Scanner(reader.readLine());

        for (int i = 0; i < cardsCount ; i++) {
            cards.add(scanner.nextInt());
        }

        int sergeySum = 0;
        int dimaSum = 0;

        while (!cards.isEmpty()){
            sergeySum += currentCourse(cards);
            if (!cards.isEmpty()){
                dimaSum += currentCourse(cards);
            }
        }

        System.out.println(sergeySum + " " + dimaSum);
    }

    public static int currentCourse(ArrayList<Integer> cards){
        int sum = 0;
        if (cards.get(0) >= cards.get(cards.size() - 1)){
            sum += cards.get(0);
            cards.remove(0);
        }
        else if (cards.get(0) < cards.get(cards.size() - 1)){
            sum += cards.get(cards.size() - 1);
            cards.remove(cards.size() - 1);
        }
        return sum;
    }
}
