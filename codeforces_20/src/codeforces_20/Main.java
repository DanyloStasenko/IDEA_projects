/*	
 	task from:
	http://codeforces.com/problemset/problem/230/A
	"Dragons"
	
	Program is answering next question: is it available to complete
	all game levels?
	If current dragonStrength < currentHeroStrength ---> currentHeroStrength += bonusStrength.
	
	Example:
		Input:
			2 3			(2 levels, currentHeroStrength = 3)
			1 99		(1st level: enemyStrength = 1, bonusStrength = 99)
			100 0		(2nd level: currentHeroStrength = 3+99 > 100 ---> GameCompleted)
		Output:
			YES
*/
package codeforces_20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		int levelNumber;
		int currentHeroStrength;
		int enemyStrength;
		int bonusStrength;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputString = reader.readLine().split(" ");
		levelNumber = Integer.parseInt(inputString[0]);
		currentHeroStrength = Integer.parseInt(inputString[1]);

		for (int i = 0; i < levelNumber; i++) {
			String[] data = reader.readLine().split(" ");
			enemyStrength = Integer.parseInt(data[0]);
			bonusStrength = Integer.parseInt(data[1]);

			if (Integer.parseInt(data[0]) < currentHeroStrength) {
				currentHeroStrength += Integer.parseInt(data[1]);
				
				if (i == levelNumber - 1) {
					System.out.println("YES");
				}
				continue;
			}
			
			else {
				System.out.println("NO");
				System.exit(0);
			}
		}
	}
}
