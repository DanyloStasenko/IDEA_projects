/*
    Task from:
    http://codeforces.com/problemset/problem/466/A

    "Cheap Travel"

    Ann has recently started commuting by subway.
    We know that a one ride subway ticket costs a rubles.
    Besides, Ann found out that she can buy a special ticket for m rides (she can buy it several times).
    It costs b rubles. Ann did the math; she will need to use subway n times. Help Ann,
    tell her what is the minimum sum of money she will have to spend to make n rides?

    Input
    The single line contains four space-separated integers n, m, a, b (1 ≤ n, m, a, b ≤ 1000) — the number
    of rides Ann has planned, the number of rides covered by the m ride ticket,
    the price of a one ride ticket and the price of an m ride ticket.

    Output
    Print a single integer — the minimum sum in rubles that Ann will need to spend.

    Examples
        input   6 2 1 2
        output  6

        input   5 2 2 3
        output  8

        Note
        In the first sample one of the optimal solutions is: each time buy a one ride ticket.
        There are other optimal solutions. For example, buy three m ride tickets.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());
        int trips = scanner.nextInt();
        int tripsInTicket = scanner.nextInt();
        int tripPrice = scanner.nextInt();
        int ticketPrice = scanner.nextInt();

        int money = 0;

        while (trips >= 0){
            if (ticketPrice / tripsInTicket < tripPrice && trips >= tripsInTicket){
                trips = trips - tripsInTicket;
                money += ticketPrice;
                continue;
            }
            if (trips < tripsInTicket && tripPrice * trips > ticketPrice){
                money += ticketPrice;
                trips = trips - tripsInTicket;
                System.out.println(money);
                return;
            } else {
                money += trips * tripPrice;
                System.out.println(money);
                return;
            }

        }



        System.out.println(money);
    }
}
