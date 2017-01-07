/*	
 	task from:
	http://codeforces.com/problemset/problem/149/A
	"Flower"
	
	Program is calculating minimal month count, required for flower to grow to some value
	
	Example:
		Input:
			10 								(reqired value)
			1 2 3 4 5 6 7 8 9 10 11 12		(monthlyIncrease)
		Output:
			1								(1 month is enough)
*/
package codeforces_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int minimalMonthCount = 0;
		ArrayList<Integer> monthlyIncrease = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int requiredIncrease = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < 12; i++) {
			monthlyIncrease.add(scanner.nextInt());
		}
		
		scanner.close();
		bubbleSort(monthlyIncrease);
		
		while (monthlyIncrease.size() > 0) {
			if (requiredIncrease > 0) {
				requiredIncrease -= monthlyIncrease.get(monthlyIncrease.size()-1);
				monthlyIncrease.remove(monthlyIncrease.size()-1);
				minimalMonthCount++;
			}
			if (requiredIncrease <= 0) {
				break;
			}
		}
		
		if (requiredIncrease > 0) {
			System.out.println("Unavailalbe");
		}
		else{
			System.out.println(minimalMonthCount);
		}
		
		
	}

	public static void bubbleSort(ArrayList<Integer> arrayList) {

		for (int i = arrayList.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {

				if (arrayList.get(j) > arrayList.get(j + 1)) {
					int temp = arrayList.get(j);
					arrayList.set(j, arrayList.get(j + 1));
					arrayList.set(j + 1, temp);
				}
			}
		}
	}
	
}
