/*	task from:
	http://codeforces.com/problemset/problem/467/A
	"Rooms"
	
	George has recently entered the University. George has a friend Alex who has also entered the university. 
	Now they are moving into a dormitory. George and Alex want to live in the same room. 
	The dormitory has n rooms in total. At the moment the i-th room has pi people living in it and the room can
	accommodate qi people in total (pi ≤ qi). Your task is to count how many rooms has free place for both George and Alex.
	
	Example:
		Input:
			3			(total rooms)
			1 2			(2 - 1 = 1 free)
			2 2			(2 - 2 = 0 free)
			1 3			(3 - 1 = 2 free)
		Output:
			1			(only 1 room has >= 2 free places)
*/
package codeforces_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int totalRooms = 0;
		int availableRooms = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		totalRooms = Integer.parseInt(reader.readLine());
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < totalRooms; i++) {
			int peoplesInRoom = scanner.nextInt();
			int roomCapacity = scanner.nextInt();
			int freePlaces = roomCapacity - peoplesInRoom;
			if (freePlaces >= 2) {
				availableRooms++;
			}
		}
		scanner.close();
		
		System.out.println(availableRooms);
		
	}

}
