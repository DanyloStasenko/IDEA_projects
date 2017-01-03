/*	
 	task from:
	http://codeforces.com/problemset/problem/490/A
	"Teams"
	
	Program is calculating how many teams will be completed.
	Completed command means that there are at least 1 programmer, 1 mathematician and 1 sportsman.
	
	Example:
		Input:
			7					(how many people)
			1 3 1 3 2 1 2		(1 = programmer, 2 = mathematician, 3 = sportsman)
		Output:
			2					(2 teams will be completed)
			1 5 2				(programmerIndex, mathematicianIndex, sportsmanIndex)
			3 7 4				(programmerIndex, mathematicianIndex, sportsmanIndex)
*/	

package codeforces_21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int totalPupils = 0;
		int readyTeams = 0;
		int programmers = 0;
		int mathematicans = 0;
		int sportsmens = 0;
		ArrayList<Integer> pupils = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		totalPupils = Integer.parseInt(reader.readLine());
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < totalPupils; i++) {
			int input = scanner.nextInt();
			if (input == 1) {
				programmers++;
			}
			if (input == 2) {
				mathematicans++;
			}
			if (input == 3) {
				sportsmens++;
			}
			pupils.add(input);
		}
		
		scanner.close();
		readyTeams = min(programmers, mathematicans, sportsmens);
		System.out.println(readyTeams);
		
		for (int i = 0; i < readyTeams; i++) {
			System.out.print(getAndDeleteFromList(1, pupils) + " ");
			System.out.print(getAndDeleteFromList(2, pupils) + " ");
			System.out.print(getAndDeleteFromList(3, pupils));
			System.out.println();
		}
	}
	
	static int min(int a, int b, int c){
		if (a < b && a < c) {
			return a;
		}
		if (b < a && b < c) {
			return b;
		}
		return c;
	}
	
	static int getAndDeleteFromList(int value, ArrayList<Integer> list){
		for (int i = 0; i < list.size(); i++) {
			if (value == list.get(i)) {
				list.set(i, 9);					// 9 means that guy is already in team
				return i+1;
			}
		}
		return 0;
	}
}
