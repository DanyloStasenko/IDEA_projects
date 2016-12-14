/*
	 Task from:
	 http://codeforces.com/problemset/problem/282/A
	 
	 We have one variable - X = 0, and it can be incremented or decremented, depended from input values.
	 
		 Input values:
		 	4 (how many commands?)
		 	++X
		 	++X
		 	X--
		 	++X
	 	Output:
	 		X=2
*/

package codeforces_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int x = 0;
		int commandCount = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String userInput = null;
		
		System.out.println("Enter how many commands should be processed:");
		commandCount = Integer.parseInt(reader.readLine());
		
		System.out.println(String.format("Now enter: %d commands. X = %d", commandCount, x));
		
		for (int i = 0; i < commandCount; i++) {
			userInput = reader.readLine();
			
			if (userInput.equalsIgnoreCase("x++") || userInput.equalsIgnoreCase("++x")) {
				x++;
			}
			
			else if (userInput.equalsIgnoreCase("x--") || userInput.equalsIgnoreCase("--x")) {
				x--;
			}
			
			else if (!userInput.equalsIgnoreCase("x--") || !userInput.equalsIgnoreCase("--x")) { 
				System.out.println("Unknown command. Program will be closed");
				System.exit(0);
			}
			
		}
		
		System.out.println("Result: X = " + x);
	}
}