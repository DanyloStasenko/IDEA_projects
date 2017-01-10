/*	task from:
	http://codeforces.com/problemset/problem/701/A
	"Cards"
	
	Here are n cards (n is even) in the deck. Each card has a positive integer written on it.
	n / 2 people will play new card game. At the beginning of the game each player gets two cards,
	each card is given to exactly one player.

	Find the way to distribute cards such that the sum of values written of the cards will be equal for each player.
	It is guaranteed that it is always possible.

	Example:
		Input:
			6					(n, how many cards)
			1 5 7 4 4 3			(card values)
		Output:					(card indexes:)
			1 3					(1st player: 1st card - "1" and 3rd card "7", sum = 1+7 = 8)
			2 6					(2nd player: 2nd card - "5" and 6th card "3", sum = 5+3 = 8)
			4 5					(3rd player: 4th card - "4" and 5th card "4", sum = 4+4 = 8)

*/
package codeforces_26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int cardCount = 0;
		int cardSum = 0;
		int cardPairs;
		ArrayList<Integer> cards = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		cardCount = Integer.parseInt(reader.readLine());
		
		Scanner scanner = new Scanner(reader.readLine());
		for (int i = 0; i < cardCount; i++) {
			cards.add(scanner.nextInt());
			cardSum += cards.get(i);
		}
		scanner.close();
		
		cardPairs = cardCount / 2;
		int pairSum = cardSum / cardPairs;
		
		while(cardSum > 0){
			int firstCard = getRandomCard(cards);
			int secondCard = pairSum - firstCard;
			System.out.println(getCardByValue(firstCard, cards) + " " + getCardByValue(secondCard, cards));
			cardSum -= pairSum;
		}
	}
	
	static int getCardByValue(int value, ArrayList<Integer> cards){
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i) == value) {
				cards.set(i, -1);
				return i + 1;
			}
		}
		return -1;
	}
	
	static int getRandomCard(ArrayList<Integer> cards){
		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i) > 0) {
				return cards.get(i);
			}
		}
		return -1;
	}
}
