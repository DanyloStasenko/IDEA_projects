/*	task from:
	http://codeforces.com/problemset/problem/158/B
	"Taxi"

	Program is calculating minimal number of cars to carry all passengers.
	Passengers are groups of people and they can't be separated.
	Group may include 1,2,3 or 4 peoples.
	Car capacity is 4, so it is unavailable to carry more than 4 passengers,
	but there are no problems to carry more than one group if totally it will be <= 4 passengers.
	____________________________________________________________________
		
		Example:
		Input:
			5						(how many groups)
			1 2 4 3 3				(how many people are in every group)
		Output: (results)
			4						(4, 3+1, 3, 2+1)
	____________________________________________________________________
		
		Example 2:
		Input:
			8
			2 3 4 4 2 1 3 1
		Output:
			5						(4, 4, 3+1, 3+1, 2+2)
	____________________________________________________________________
*/
package codeforces_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		int oneMemberGroups = 0;
		int twoMemberGroups = 0;
		int threeMemberGroups = 0;
		int completedGroups = 0;			// 4-Member groups
		int totalPeople = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter N (how many groups) and than enter N values:");
		int groupCount = Integer.parseInt(reader.readLine());
		String groupValues = reader.readLine();
		
		for (int i = 0; groupCount > 0; i++) {
			if (groupValues.charAt(i) == '1') {
				oneMemberGroups++;
				groupCount--;
				totalPeople = totalPeople + 1;
			}
			if (groupValues.charAt(i) == '2') {
				twoMemberGroups++;
				groupCount--;
				totalPeople = totalPeople + 2;
			}
			if (groupValues.charAt(i) == '3') {
				threeMemberGroups++;
				groupCount--;
				totalPeople = totalPeople + 3;
			}
			if (groupValues.charAt(i) == '4') {
				completedGroups++;
				groupCount--;
			}
		}
		
		while (totalPeople > 0) {
			// 3+1
			if (threeMemberGroups > 0 && oneMemberGroups > 0) {
				completedGroups++;
				threeMemberGroups--;
				oneMemberGroups--;
				totalPeople = totalPeople - 4;
				continue;
			}
			
			// only 3
			if (threeMemberGroups > 0) {
				completedGroups++;
				threeMemberGroups--;
				totalPeople = totalPeople - 3;
				continue;
			}
			
			// 2+2
			if (twoMemberGroups >= 2) {
				completedGroups++;
				twoMemberGroups = twoMemberGroups-2;
				totalPeople = totalPeople - 4;
				continue;
			}
			
			// 2+1
			if (twoMemberGroups == 1 && oneMemberGroups > 0) {
				completedGroups++;
				oneMemberGroups--;
				twoMemberGroups--;
				totalPeople = totalPeople - 3;
				if (oneMemberGroups > 0) {
					oneMemberGroups--;
					totalPeople--;
				}
				continue;
			}
			
			// only 2
			if (twoMemberGroups == 1) {
				completedGroups++;
				twoMemberGroups--;
				totalPeople = totalPeople - 2;
				continue;
			}
			
			// 1+1+1+1
			if (oneMemberGroups >= 4) {
				completedGroups++;
				oneMemberGroups = oneMemberGroups-4;
				totalPeople = totalPeople - 4;
				continue;
			}
			
			// other 1 (<4)
			if (oneMemberGroups > 0 && oneMemberGroups < 4) {
				completedGroups++;
				totalPeople -= oneMemberGroups;
				continue;
			}
		}
		
		System.out.println(completedGroups);
	}
}
