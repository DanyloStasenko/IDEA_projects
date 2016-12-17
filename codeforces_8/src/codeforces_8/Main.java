/*
 	"Tram"
	Task from:
	http://codeforces.com/problemset/problem/116/A
	
	We have tram line with X stops, and on every stop some passengers
	can get OUT of the tram, and some passengers can get IN.
	Program is calculating minimalTramCapacity, that is enough to carry all passengers.
	
	Example:
	Input values:
		4			(how many stops are on the line)
		0 3			(0 out, 3 in, current = 3)
		2 5			(2 out, 5 in, current = 6)
		4 2			(4 out, 2 in, current = 4)
		4 0			(4 out, 0 in, current = 0)
	
	Output (results):
		6
	
*/

package codeforces_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int stopsCount = 0;
		int currentPassengers = 0;
		int maximalPassengers = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter stops number:");
		stopsCount = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < stopsCount; i++) {
			String userInput = reader.readLine();
			int output = Integer.parseInt(userInput.substring(0, userInput.indexOf(" ")));
			int input = Integer.parseInt(userInput.substring(userInput.indexOf(" ") + 1));
			
			currentPassengers = currentPassengers - output;
			currentPassengers = currentPassengers + input;
			
			if (currentPassengers > maximalPassengers) {
				maximalPassengers = currentPassengers;
			}
		}
		System.out.println(maximalPassengers);
	}
}
