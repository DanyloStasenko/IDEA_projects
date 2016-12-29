/*		
	task from:
	http://codeforces.com/problemset/problem/122/A
 		
	"Hello"
	
	Program is checking, does inputString contain otherString.
	
	Example:
		Input:
			h  12asd321  e  1231fsda23  l  123fasdf12  l  12dafsa312  o
 		Output:
 			true
 			
		Input:
			helo hell hleh hele hlle eleh
		Output:
			false
 */

package codeforces_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		String expected = "hello";
		
		System.out.println("Enter Your String:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		
		System.out.println(check(input, expected, 0, 0));
	}

	static boolean check(String input, String expected, int startIndex, int charIndex)
	{
		for (int i = startIndex; i < input.length(); i++) {
			if (input.charAt(i) == expected.charAt(charIndex)) {	
				if (charIndex == expected.length()-1) {				
					return true;
				}
				return check(input, expected, ++i, ++charIndex);
			}
		}
		return false;
	}
}
