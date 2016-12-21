/*
	task from
	http://codeforces.com/problemset/problem/96/A
	
	Do we have seven same values in a row? (only '0000000' or '1111111')
*/
package codeforces_10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int thresold = 7;
		int zeroCount = 0;
		int oneCount = 0;
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Your string:");
		String userInput = reader.readLine();
		
		for (int i = 0; i < userInput.length(); i++) {
			if (userInput.charAt(i) == '0') {
				zeroCount++;
				oneCount = 0;
			}
			
			if (userInput.charAt(i) == '1') {
				oneCount++;
				zeroCount = 0;
			}
			
			if (zeroCount == thresold || oneCount == thresold) {
				System.out.println("YES");
				break;
			}
			
			if (i == userInput.length() - 1) {
				System.out.println("NO");
			}
		}
	}
}
