/*
	Task from:
 	http://codeforces.com/problemset/problem/50/A
 	
 	We have domino-field with size N x M and unlimited domino-blocks (size 1x2)
 	How many domino-blocks can be placed on this field?
 	
	Input values:
	 	3 3 (means field size 3x3)
 	Output (result):
 		4
*/

package codeforces_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int dominoArea = 2;
		int width;
		int height;
		int fieldArea; 				// width * height
		int unusedFields;			// field area % 2
		
		System.out.println("Enter field size: (2 numbers, seperated by space, like: 3 3)");
		
		// get width and height
		String userInput = reader.readLine();
		height = Integer.parseInt(userInput.substring(0, userInput.indexOf(" ")));
		width = Integer.parseInt(userInput.substring(userInput.indexOf(" ") + 1, userInput.length()));
		
		// calculate result
		fieldArea = width * height;
		unusedFields = fieldArea % 2;
		int result = (fieldArea - (unusedFields)) / dominoArea;
		
		System.out.println(result);
	}
}