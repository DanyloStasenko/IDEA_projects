/*
    Task from:
    http://codeforces.com/problemset/problem/519/C

    Print the maximum number of teams that can be formed.
    Team should consist from 2 seniors + 1 junior OR 2 juniors + 1 senior
    Input string - 2 numbers: juniorNumber and seniorNumber

    Examples:
    Input:
        2 6
    Output:
        2               (S+J+J)(S+J+J)

    Input:
        4 5
    Output:
        3               (S+J+J)(S+J+J)(J+S+S)

*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int juniors;
        int seniors;
        int formedTeams = 0;

        Scanner scanner = new Scanner(System.in);
        seniors = scanner.nextInt();
        juniors = scanner.nextInt();

        System.out.println(formTeam(seniors, juniors, formedTeams));
    }

    static int formTeam(int seniors, int juniors, int teams){
        if(seniors <= 1 && juniors <= 1 || seniors == 0 || juniors == 0){
            return teams;
        }
        if (juniors <= seniors){
            seniors = seniors - 2;
            juniors = juniors - 1;
            teams++;
            return formTeam(seniors, juniors, teams);
        }
        if (seniors <= juniors){
            seniors = seniors - 1;
            juniors = juniors - 2;
            teams++;
            return formTeam(seniors, juniors, teams);
        }
        return teams;
    }
}
