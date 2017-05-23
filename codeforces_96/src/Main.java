/*
    Task from:
    http://codeforces.com/problemset/problem/681/A?locale=en

    "A Good Contest"

    Codeforces user' handle color depends on his rating — it is red if his rating is greater or equal to 2400; it is
    orange if his rating is less than 2400 but greater or equal to 2200, etc. Each time participant takes part in a
    rated contest,his rating is changed depending on his performance. Anton wants the color of his handle to become red.
    He considers his performance in the rated contest to be good if he outscored some participant, whose handle was
    colored red before the contest and his rating has increased after it. Anton has written a program that analyses
    contest results and determines whether he performed good or not. Are you able to do the same?

    Input
    The first line of the input contains a single integer n (1 ≤ n ≤ 100) — the number of participants Anton has
    outscored in this contest. The next n lines describe participants results: the i-th of them consists of a
    participant handle namei and two integers beforei and afteri ( - 4000 ≤ beforei, afteri ≤ 4000) — participant's
    rating before and after the contest, respectively. Each handle is a non-empty string, consisting of no more than
    10 characters, which might be lowercase and uppercase English letters, digits, characters «_» and «-» characters.
    It is guaranteed that all handles are distinct.

    Output
    Print «YES» (quotes for clarity), if Anton has performed good in the contest and «NO» (quotes for clarity) otherwise.

    Examples
        input
                3
                Burunduk1 2526 2537
                BudAlNik 2084 2214
                subscriber 2833 2749
        output
                YES

        input
                3
                Applejack 2400 2400
                Fluttershy 2390 2431
                Pinkie_Pie -2500 -2450
        output
                NO

    Note
        In the first sample, Anton has outscored user with handle Burunduk1, whose handle was colored red before the
        contest and his rating has increased after the contest.
        In the second sample, Applejack's rating has not increased after the contest, while both Fluttershy's
        and Pinkie_Pie's handles were not colored red before the contest.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(reader.readLine());

        for (int i = 0; i < arraySize; i++) {
            String input[] = reader.readLine().split(" ");

            int before = Integer.parseInt(input[1]);
            int after = Integer.parseInt(input[2]);

            if (before >= 2400 && after > before){
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }
}
