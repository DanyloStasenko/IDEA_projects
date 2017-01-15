/*	task from:
	http://codeforces.com/problemset/problem/461/A
	"Sum"
	
	Appleman and Toastman play a game. Initially Appleman gives one group of n numbers to the Toastman,
	then they start to complete the following tasks:
	- Each time Toastman gets a group of numbers, he sums up all the numbers and adds this sum to the score. 
	  Then he gives the group to the Appleman.
	- Each time Appleman gets a group consisting of a single number, he throws this group out.
	  Each time Appleman gets a group consisting of more than one number, he splits the group into 
	  two non-empty groups (he can do it in any way) and gives each of them to Toastman.
	After guys complete all the tasks they look at the score value. What is the maximum possible value of score they can get?
	
	Example:
		Input:
			3			(how many numbers?)
			3 1 5		
		Output:
			26
			
	Explanation:
	(1 + 3 + 5) + 1 + (3 + 5) + 3 + 5 = 26
*/

package codeforces_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int sum = 0;
		ArrayList<Integer> numbers = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int arrayLength = Integer.parseInt(reader.readLine());
		
		Scanner scanner = new Scanner(reader.readLine());
		for (int i = 0; i < arrayLength; i++) {
			numbers.add(scanner.nextInt());
		}
		scanner.close();
		
		bubbleSort(numbers);
		
		for (int i = 0; i < arrayLength; i++) {
			sum += getSum(numbers);
			if (numbers.size() == 1) {
				break;
			}
			sum += deleteMinimal(numbers);
		}
		System.out.println(sum);
		
	}
	
	static int getSum(ArrayList<Integer> list){
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}

		return sum;
	}
	
	static int deleteMinimal(ArrayList<Integer> list){
		
		return(list.remove(0));
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
