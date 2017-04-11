/*
    Task from:
    http://codeforces.com/problemset/problem/540/A?locale=en

    "Combination Lock"

    Scrooge McDuck keeps his most treasured savings in a home safe with a combination lock.
    Each time he wants to put there the treasures that he's earned fair and square, he has to open the lock.
    The combination lock is represented by n rotating disks with digits from 0 to 9 written on them.
    Scrooge McDuck has to turn some disks so that the combination of digits on the disks forms a secret combination.
    In one move, he can rotate one disk one digit forwards or backwards.
    In particular, in one move he can go from digit 0 to digit 9 and vice versa.
    What minimum number of actions does he need for that?

    Input
    The first line contains a single integer n (1 ≤ n ≤ 1000) — the number of disks on the combination lock.
    The second line contains a string of n digits — the original state of the disks.
    The third line contains a string of n digits — Scrooge McDuck's combination that opens the lock.

    Output
    Print a single integer — the minimum number of moves Scrooge McDuck needs to open the lock.

    Examples
        input
                5
                82195
                64723
        output
                13

        Note
        In the sample he needs 13 moves:
            1 disk: 8 - 7 - 6               (2)
            2 disk: 2 - 3 - 4               (2)
            3 disk: 1 - 0 - 9 - 8 - 7       (4)
            4 disk: 9 - 0 - 1 - 2           (3)
            5 disk: 5 - 4 - 3               (2)

           (2 + 3 + 4 + 3 + 2 = 13)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numbers = Integer.parseInt(reader.readLine());
        int steps = 0;

        String current = reader.readLine();
        String required = reader.readLine();

        for (int i = 0; i < numbers; i++) {
            int currentNumber = Character.getNumericValue(current.charAt(i));
            int requiredNumber = Character.getNumericValue(required.charAt(i));

            steps += getSteps(currentNumber, requiredNumber);
        }
        System.out.println(steps);

    }

    static int getSteps(int current, int required){
        int bigger = Integer.max(current, required);
        int lower = Integer.min(current, required);
        if (bigger - lower > 5){
            return  10 - (bigger - lower);
        }
        return bigger - lower;
    }
}
