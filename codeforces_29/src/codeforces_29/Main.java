/*	task from:
	http://codeforces.com/problemset/problem/507/A
	"Music"
	
	Amr is a young coder who likes music a lot. He always wanted to learn how to play music
	but he was busy coding so he got an idea. Amr has n instruments, it takes A(i) days
	to learn i-th instrument. Being busy, Amr dedicated k days to learn how to play the maximum
	possible number of instruments. Amr asked for your help to distribute his free days between
	instruments so that he can achieve his goal.
	
	Example:
		Input:
			5 6				(5 instruments, 6 days)
			4 3 1 1 2		(days required to play on each instrument)
		Output:
			3				(played instruments)
			3 4 5 			(their indexes)
*/
package codeforces_29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int instrumentCount = 0;
		int availableDays = 0;
		ArrayList<Integer> instruments = new ArrayList<>();
		ArrayList<Integer> successful = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner scanner = new Scanner(reader.readLine());
		instrumentCount = scanner.nextInt();
		availableDays = scanner.nextInt();
		scanner.close();
		
		scanner = new Scanner(reader.readLine());
		for (int i = 0; i < instrumentCount; i++) {
			instruments.add(scanner.nextInt());
		}
		scanner.close();
		
		for (int i = 0; i < instruments.size(); i++) {
			int minValue = getMinValue(instruments);
			int minIndex = getIndex(instruments, minValue);
			if (availableDays - minValue >= 0) {
				availableDays -= minValue;
				instruments.set(minIndex, -1);
				successful.add(minIndex + 1);
			}
		}
		
		if (successful.size() > 0) {
			System.out.println(successful.size());
			for (Integer integer : successful) {
				System.out.print(integer + " ");
			}
		}
		else {
			System.out.println(0);
		}
		
	}
	
	static int getMinValue(ArrayList<Integer> instruments){
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < instruments.size(); i++) {
			if (instruments.get(i) < min && instruments.get(i) > 0) {
				min = instruments.get(i);
			}
		}
		return min;
	}
	
	static int getIndex(ArrayList<Integer> instruments, int value){
		for (int i = 0; i < instruments.size(); i++) {
			if (instruments.get(i) == value) {
				instruments.set(i, -1);
				return i;
			}
		}
		return -1;
	}
}
