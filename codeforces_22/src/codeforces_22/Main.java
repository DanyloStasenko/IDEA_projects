/*	task from:
	http://codeforces.com/problemset/problem/556/A
	"10"
	
	Program is deleting every '10' from input String and calculating its length.
	
	Example:
		Input:
			101010
		Output:
			0
			
		Input:
			111000101
		Output:
			1
*/

package codeforces_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder input = new StringBuilder(reader.readLine());
		
		System.out.println(delete(input));
	}
	
	static int delete(StringBuilder input){
		for (int i = 0; i < input.length()-1; i++) {
			if (input.charAt(i) == '1' && input.charAt(i+1) == '0') {
				input.deleteCharAt(i);			// deleting '1', length decreased, so now '0' is on this position
				input.deleteCharAt(i);			// deleting '0'
				return delete(input);
			}
		}
		return input.length();
	}
}
