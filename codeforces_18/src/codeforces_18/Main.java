/*	task from
	http://codeforces.com/contest/750/problem/A
	"Party"
	
	Program is calculating how many tasks will be solved before party starts
*/
package codeforces_18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {

		int totalMinutes = 240;
		int minutesToGetToTheParty = 0;
		int totalTasks;

		System.out.println("Enter 2 numbers: totalTasks and minutesToGetToTheParty");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		Scanner scanner = new Scanner(input);

		totalTasks = scanner.nextInt();
		minutesToGetToTheParty = scanner.nextInt();

		totalMinutes = totalMinutes - minutesToGetToTheParty;

		int result = 0;

		for (int i = 1; i <= totalTasks; i++) {
			if (i * 5 <= totalMinutes) {
				result++;
				totalMinutes = totalMinutes - i * 5;
			}
		}

		System.out.println(result);
		scanner.close();
	}
}
