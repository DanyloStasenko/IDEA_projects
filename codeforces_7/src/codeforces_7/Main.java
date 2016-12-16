/*
	Task from:
	http://codeforces.com/problemset/problem/71/A
	String shortener.
 	We have array of Strings. If some String is larger than 10 characters,
 	we should shorten it to 4 characters: 
 	first character - how many characters are between first and last? - last character
 	
 	Example:
	Input values:
	 	4 		(array size)
	 	word
		localization
		internationalization
		pneumonoultramicroscopicsilicovolcanoconiosis
 	Output (result):
 		word
		l10n
		i18n
		p43s
*/

package codeforces_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> strings = new ArrayList<String>();
		
		System.out.println("Enter N (array size), and than enter N strings:");
		String userInput = reader.readLine();
		for (int i = 0; i < Integer.parseInt(userInput); i++) {
			strings.add(reader.readLine());
		}
		
		for (String string : strings) {
			if (string.length() > 10) {
				String result = "";
				result = result + string.charAt(0);
				result = result + (string.length()-2);
				result = result + string.charAt(string.length()-1);
				System.out.println(result);
			}
			else {
				System.out.println(string);
			}
		}
	}
}