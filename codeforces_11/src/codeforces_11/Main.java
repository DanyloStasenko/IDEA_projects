/*	
 	task from:
	http://codeforces.com/problemset/problem/266/A
	"Colors"
	
*/
package codeforces_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		int result = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter N (row lenght) and than enter N values");
		String loopCount = reader.readLine();
		String userInput = reader.readLine();
		
		char previous = userInput.charAt(0);
		for (int i = 1; i < Integer.parseInt(loopCount); i++) {
			if (userInput.charAt(i) == previous) {
				result++;
				
			}
			previous = userInput.charAt(i);
			
		}
		
		System.out.println(result);
		
	}
	
}
