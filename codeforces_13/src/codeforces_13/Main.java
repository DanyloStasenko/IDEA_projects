/*	task from:
	http://codeforces.com/problemset/problem/131/A
	"CapsLock"
	Program will fix input String if:
		- it is fully in upper case (like: "CAPSED STRING")
		- it is 'inverted' (first char is in lower case and all other characters are in upper case, like "iNVERTED STRING")
*/
package codeforces_13;

import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		boolean areAllCapsed = false;
		boolean isStringInverted = false;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Your String:");
		String inputString = scanner.nextLine();
		StringBuilder result = new StringBuilder(inputString);
		
		// check String for 'all characters are in upper case'
		for (int i = 0; i < inputString.length(); i++) {
			if (Character.isUpperCase(inputString.charAt(i))) {
				if (Character.isUpperCase(inputString.charAt(i))) {
					areAllCapsed = true;
				}
				else {
					areAllCapsed = false;
					break;
				}
			}
		}
		
		// check String for 'inversion'
		for (int i = 1; i < inputString.length(); i++) {
			if (Character.isLowerCase(inputString.charAt(0))) {
				if (Character.isUpperCase(inputString.charAt(i))) {
					isStringInverted = true;
				}
				else {
					isStringInverted = false;
					break;
				}
			}
		}
			
		if (areAllCapsed) {
			for (int i = 0; i < result.length(); i++) {
				result.setCharAt(i, Character.toLowerCase((inputString.charAt(i))));
			}
		}
		
		if (isStringInverted) {
			result.setCharAt(0, Character.toUpperCase((inputString.charAt(0))));
			for (int i = 1; i < result.length(); i++) {
				result.setCharAt(i, Character.toLowerCase((inputString.charAt(i))));
			}
		}
		
		System.out.println(result);
	}
}
