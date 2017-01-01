/*	task from:
	http://codeforces.com/contest/750/problem/B
	"North Pole"
	
	Program is checking is it available to visit N points and came back to the North Pole.
	
	Example:
		Input:
			5					(points to visit)
			7500 South		
			10000 East
			3500 North
			4444 West
			4000 North
		Output:
			YES
*/
package codeforces_19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		int pointsToVisit = 0;
		int NScoordinates = 0;	// 0 means North, 20000 means South

		ArrayList<String> directions = new ArrayList<>();
		ArrayList<Integer> values = new ArrayList<>();

		//System.out.println("Enter N (how many points) and than enter N command (value + direction)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		pointsToVisit = Integer.parseInt(reader.readLine());

		for (int i = 0; i < pointsToVisit; i++) {
			String input = reader.readLine();
			String [] array = input.split(" ");
			
			values.add(Integer.parseInt(array[0]));
			directions.add(array[1]);
		}

		for (int i = 0; i < pointsToVisit; i++) {
			int value = values.get(i);
			String direction = directions.get(i);
			
			// Unavailable to go in Northern direction
			if (NScoordinates == 0 && direction.equals("North")) {
				exit();
			}
			
			// Unavailable to go in Southern direction
			if (NScoordinates == 20000 && direction.equals("South")) {
				exit();
			}

			// Unavailable to go in Western or Eastern direction if we are at the North
			if (direction.equals("West") && NScoordinates == 0 || direction.equals("East") && NScoordinates == 0) {
				exit();
			}
			
			// Unavailable to go in Western or Eastern direction if we are at the South
			if (direction.equals("West") && NScoordinates == 20000 || direction.equals("East") && NScoordinates == 20000) {
				exit();
			}
			
			if (direction.equals("North")) {
				NScoordinates -= value;
			}

			if (direction.equals("South")) {
				NScoordinates += value;
			}

			if (NScoordinates < 0 || NScoordinates > 20000) {
				exit();
			}
		}
		
		if (NScoordinates == 0) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
	}
	
	public static void exit(){
		System.out.println("NO");
		System.exit(0);
	}
}
