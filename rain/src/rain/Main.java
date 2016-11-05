package rain;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);
	
	
	public static int[] createArray() {

		System.out.print("Enter array size: ");

		int[] myArray = new int[Integer.parseInt(scanner.nextLine())];

		System.out.println("Perfect. Now enter " + myArray.length + " values");
		for (int i = 0; i < myArray.length; i++) {
			System.out.print("array[" + i + "]: ");
			myArray[i] = Integer.parseInt(scanner.nextLine());
		}

		scanner.close();
		return myArray;
	}

	public static void main(String[] args) {
		System.out.println("Result: " + Calculator.calculateResult(createArray()));
	}
}