/*
 	task from:
 	http://codeforces.com/problemset/problem/469/A
 	"Game Levels"
 	
 	There are N levels in the game, and there are 2 players: playerX and playerY.
 	Each player can finish some levels.
 	Program is checking, is it available to complete all game levels if players will play together.
 	
 	Example:
 		Input:
	 		15 				(how many levels)
	 		1 2 3 4 5		(levels that can be finished by playerX)
	 		6 7 8 9 10		(levels that can be finished by playerY)
 		Output:
 			NO
 */

package codeforces_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		ArrayList<Integer> gameLevels = new ArrayList<>();
		ArrayList<Integer> completedByX = new ArrayList<>();
		ArrayList<Integer> completedByY = new ArrayList<>();
		
		System.out.println("Enter N (how many levels), and then enter 2 Strings: availableForX, and availableForY:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int levelNumber = Integer.parseInt(reader.readLine());
		
		for (int i = 1; i < levelNumber + 1; i++) {
			gameLevels.add(i);
		}

		Scanner scanner = new Scanner(reader.readLine());
		while (scanner.hasNext()) {
			completedByX.add(scanner.nextInt());
		}
		scanner = new Scanner(reader.readLine());
		while (scanner.hasNext()) {
			completedByY.add(scanner.nextInt());
		}
		scanner.close();
		
		gameLevels.removeAll(completedByX);
		gameLevels.removeAll(completedByY);
		
		if (gameLevels.isEmpty()) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
	}
}
