/*	task from:
	http://codeforces.com/problemset/problem/339/A
	"Math simplification"
	
	Program is reordering numbers (from lowest to highest) is string to make it more simple.
	
	Example (input):		1+3+2+1+2+3+3+2+1+1+1
	Results (output):		1+1+1+1+1+2+2+2+3+3+3
*/

package codeforces_12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		int oneCount = 0;
		int twoCount = 0;
		int threeCount = 0;
		String result = "";

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Your string: (only 1,2 or 3 values are allowed)");
		String input = reader.readLine();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '1') {
				oneCount++;
			}
			if (input.charAt(i) == '2') {
				twoCount++;
			}
			if (input.charAt(i) == '3') {
				threeCount++;
			}
		}

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '1' || input.charAt(i) == '2' || input.charAt(i) == '3') {
				if (oneCount != 0) {
					result += "1";
					oneCount--;
					continue;
				}
				if (twoCount != 0) {
					result += "2";
					twoCount--;
					continue;
				}
				if (threeCount != 0) {
					result += "3";
					threeCount--;
					continue;
				}
			}

			if (input.charAt(i) == '+') {
				result += "+";
			}
		}
		
		System.out.println(result);
	}
}
