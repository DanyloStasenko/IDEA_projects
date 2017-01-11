/*	task from:
	http://codeforces.com/problemset/problem/489/B
	"Party"
	
	n boys and m girls will visit dancing party.
	However, the partners' dancing skill in each pair must differ by at most one.
	For each boy, we know his dancing skills. Similarly, for each girl we know her dancing skills.
	Write a code that can determine the largest possible number of pairs that can be formed from n boys and m girls.
	
	Example:
		Input:
			4					(n, boys)
			1 4 6 2				(boys skills)
			5					(m, girls)
			5 1 5 7 9			(girls skills)
		Output:
			3					(pairs)
*/
package codeforces_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int girlsNumber = 0;
		int boysNumber = 0;
		int pairs = 0;
		ArrayList<Integer> girls = new ArrayList<>();
		ArrayList<Integer> boys = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		boysNumber = Integer.parseInt(reader.readLine());
		Scanner scanner = new Scanner(reader.readLine());
		for (int i = 0; i < boysNumber; i++) {
			boys.add(scanner.nextInt());
		}
		scanner.close();
		
		girlsNumber = Integer.parseInt(reader.readLine());
		scanner = new Scanner(reader.readLine());
		for (int i = 0; i < girlsNumber; i++) {
			girls.add(scanner.nextInt());
		}
		scanner.close();
	
		// same skill
		for (int i = 0; i < boys.size(); i++) {
			for (int j = 0; j < girls.size(); j++) {
				if (boys.get(i) == girls.get(j)) {
					boys.set(i, -1);
					girls.set(j, -1);
					pairs++;
				}
			}
		}
		
		// different skill
		for (int i = 0; i < boys.size(); i++) {
			for (int j = 0; j < girls.size(); j++) {
				if (boys.get(i) == girls.get(j)+1 || boys.get(i) == girls.get(j)-1) {
					boys.set(i, -1);
					girls.set(j, -1);
					pairs++;
				}
			}
		}
		
		System.out.println(pairs);
	}
}
