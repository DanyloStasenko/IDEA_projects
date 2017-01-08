/*
	task from:
	http://codeforces.com/problemset/problem/439/A
	"Performance"
	Program is calculating how many jokes will be told during performance,
	if singer is resting 10 minutes after every song, and joke will take 5 minutes.
	
	Example:
		Input:
			3 30			(songs number = 3, performance duration = 30)
			2 2 1			(songs duration = {2, 2, 1})
		Output:
			5				(jokes number)
		
		Explanation:
		1st song = 2 min
		singer resting 10 min -> 2 jokes
		2nd song = 2 min
		singer resting 10 min -> 2 more jokes
		3rd song = 1 min
		there are 5 minutes freetime before performance ends, -> enough for 1 more joke
		total: 5 jokes
*/
	package codeforces_24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		int jokesCount = 0;
		int songCount = 0;
		int performanceTime = 0;
		ArrayList<Integer> songs = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
		Scanner scanner = new Scanner(input);
		
		songCount = scanner.nextInt();
		performanceTime = scanner.nextInt();
		
		scanner = new Scanner(System.in);
		
		for (int i = 0; i < songCount; i++) {
			songs.add(scanner.nextInt());
			performanceTime -= songs.get(i);
		}
		scanner.close();
		
		// jokes while singer is resting (10 minutes after every song = 2 jokes)
		jokesCount = ((songs.size() - 1) * 10) / 5;
		performanceTime -= jokesCount * 5;
		
		if (performanceTime >= 0) {
			jokesCount += performanceTime / 5;			// if they have more time
			System.out.println(jokesCount);
		}
		else{
			System.out.println("-1");
		}
	}
}
