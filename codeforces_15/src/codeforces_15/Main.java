/*	task from:
	http://codeforces.com/problemset/problem/160/A
	"Coins"
	Program is calculating minimal coins number, which sum is greater than all others coins sum
	
		Example:
		Input:
			5					(how many coins)
			100	30 30 20 19		(coins values)
		Output: (result)
			1 					(one coin with value = 100 is greater than 30+30+20+19 = 99)
*/

package codeforces_15;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		int mySum = 0;
		int myBrothersSum = 0;
		int myCoinsCount = 0;

		ArrayList<Integer> values = new ArrayList<>();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter N (how many values) and than enter N values:");
		int number = scanner.nextInt();

		for (int i = 0; i < number; i++) {
			values.add(scanner.nextInt());
		}
		
		scanner.close();

		bubbleSort(values);

		while (values.size() > 0) {
			
			mySum += values.get(values.size() - 1);				// mySum += greatest
			values.remove(values.size() - 1);					// remove greatest value
			myCoinsCount++;										// it means myCoinsCount++
			
			for (int j : values) {								// calculate myBrothersSum
				myBrothersSum += j;
			}
			if (mySum > myBrothersSum) {
				break;
			}
			myBrothersSum = 0;
		}

		System.out.println(myCoinsCount);
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
