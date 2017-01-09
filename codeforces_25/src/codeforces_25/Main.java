/*	task from:
	http://codeforces.com/problemset/problem/514/A?locale=en
	"Inversion"
	Program is inverting numbers, if inverted number will be less

	Examples:
		Input:	
			274545
		Output:
			224444

*/
package codeforces_25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		int zeroCount = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		StringBuilder stringBuilder = new StringBuilder(input);

		for (int i = 0; i < stringBuilder.length(); i++) {
			stringBuilder.setCharAt(i, invert(stringBuilder.charAt(i)));
			if (stringBuilder.charAt(i) == '0') {
				zeroCount++;
			}
		}
		
		// if all are zeros
		if (zeroCount == stringBuilder.length()) {
			System.out.println("0");
			System.exit(0);
		}
		
		// delete leading zeros
		boolean leadingZero = true;
		for (int i = 0; i < stringBuilder.length(); i++) {
			if (leadingZero && stringBuilder.charAt(i) == '0') {
				stringBuilder.deleteCharAt(0);
				i--;
			}
			else {
				leadingZero = false;
			}
		}
		
		System.out.println(stringBuilder);
	}

	static char invert(char c) {
		switch (c) {
		case '5':
			return '4';
		case '6':
			return '3';
		case '7':
			return '2';
		case '8':
			return '1';
		case '9':
			return '0';
		}
		return c;
	}

}
