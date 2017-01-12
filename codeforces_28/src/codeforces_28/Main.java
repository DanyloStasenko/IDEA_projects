/*	task from:
	http://codeforces.com/problemset/problem/349/A
	"Queue in cinema"
	
	The new movie has just been released! There are n people at the cinema box office 
	standing in a huge line. Each of them has a single 100, 50 or 25 dollar bill. 
	The ticket costs 25 dollars. Can the booking clerk sell a ticket to each person and give the change 
	if he initially has no money and sells the tickets strictly in the order people follow in the line?
	
	Example:
		Input:
			4					(people in queue)
			25 25 50 50			(their money)
		Output:
			YES
*/		

package codeforces_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) throws IOException{
		
		ArrayList<Integer> people = new ArrayList<>();
		ArrayList<Integer> cashRegister = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int queueLength = Integer.parseInt(reader.readLine());
		
		Scanner scanner = new Scanner(reader.readLine());
		for (int i = 0; i < queueLength; i++) {
			people.add(scanner.nextInt());
		}
		scanner.close();
		
		for (int i = 0; i < people.size(); i++) {
			buyTicket(people.get(i), cashRegister);
			if (i == people.size() - 1) {
				System.out.println("YES");
				System.exit(0);
			}
		}
		
		System.out.println("NO");
	}
	
	static void buyTicket(int cashIn, ArrayList<Integer> cashRegister){
		if (cashIn == 25) {
			cashRegister.add(cashIn);
		}
		
		if (cashIn == 50) {
			if (cashRegister.contains(25)) {
				cashRegister.remove("25");
				cashRegister.add(50);
			}
			else {
				System.out.println("NO");
				System.exit(0);
			}
		}
		
		int count25 = 0;
		if (cashIn == 100) {
			// how many 25?
			for (int i = 0; i < cashRegister.size(); i++) {
				if (cashRegister.get(i) == 25) {
					count25++;
				}
			}
			
			if (count25 >= 3) {
				cashRegister.add(100);
				cashRegister.remove("25");
				cashRegister.remove("25");
				cashRegister.remove("25");
			}
			
			else{
				System.out.println("NO");
				System.exit(0);
			}
		}
		
	}

}


