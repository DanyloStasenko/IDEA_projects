/*	
	"Team"
 	task from:
	http://codeforces.com/problemset/problem/231/A
	
	We have team, which consists from 3 members:
	We have N tasks, that should be done by this team.
	If at least 2 people in this team knew how to do task - this task will be done.
	Program is calculating how many tasks will be done by this team.
	
	Example:
	Input:
	3			(how many tasks)
	1 1 0		(here 2 members are sure that they knew how to do it, so task will be done)
	1 1 1		(here 3 members are sure that they knew how to do it, so task will be done)
	1 0 0		(here 1 member is sure that he knows how to do it, so task can't be done)
	
	Output (results):
	2			(tasks, that will be done)
	
*/
package codeforces_9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int result = 0;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter task number:");
		int taskNumber = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < taskNumber; i++) {
			
			int tempResult = 0;
			String userInput = reader.readLine();
			
			for (int j = 0; j < 5; j++) {
				if (userInput.charAt(j) == '1') {
					tempResult++;
				}
			}
			
			if (tempResult >= 2) {
				result++;
			}
			
		}
		System.out.println(result);
	}
}
