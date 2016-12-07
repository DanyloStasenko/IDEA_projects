/* created by Danylo Stasenko 
 * https://github.com/DanyloStasenko
 * 
 * original:
 * https://gist.github.com/mkozakov/59af0fd5bddbed1a0399
 * 
 * Program is solving next problem:
 * How many water should be stored after rain, if array values means
 * wall-height of special "construction" in two-dimensional space.
 * 
 * 
 * 	Example:
 *  Array length = 8 
 * 	Input values = 0  1  0  2  0  0  2  0	
 * 	So, such 'construction' will look like that:
 * 	         __ 
 *          |  |      __
 *     __   |  |     |  |
 *    |  |  |  |     |  |  
 *  ^^^^^^^^^^^^^^^^^^^^^^^
 *   0  1  0  3  0  0  2  0 	// height (input values)
 *   
 *   
 *   And expected result here = 5.
 *       	 __ 
 *          |  |      __
 * 	   __   |  |+1 +1|  |
 *    |  |+1|  |+1 +1|  |  
 *  ^^^^^^^^^^^^^^^^^^^^^^^
 *   
 *  Have fun! :)
 *  
 *  P.S. negative values will be as '0'
 *  
 */

package rain;

import java.util.Scanner;

public class Main {
	static Scanner scanner = new Scanner(System.in);

	
	public static int[] createArray() {
		System.out.print("Enter array size: ");
		int[] array = new int[Integer.parseInt(scanner.nextLine())];
		System.out.println("Perfect. Now enter " + array.length + " values: ");
		
		for (int i = 0; i < array.length; i++) {
			System.out.print(String.format("%d) array[%d]: ", (i + 1), i));
			array[i] = Integer.parseInt(scanner.nextLine());
		}

		scanner.close();
		return array;
	}

	
	public static void main(String[] args) {
		try {
			System.out.println("Result: " + Calculator.calculateResult(createArray()));
		} catch (Exception e) {
			System.out.println("Error. Only positive numbers (or 0) are allowed. Program will be closed.");
			e.printStackTrace();
		}
	}
}