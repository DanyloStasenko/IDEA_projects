/*
    Task from:
    http://codeforces.com/problemset/problem/567/A?locale=en

    "Lineland Mail"

    All cities of Lineland are located on the Ox coordinate axis. Thus, each city is associated with its position
    xi — a coordinate on the Ox axis. No two cities are located at a single point. Lineland residents love to send
    letters to each other. A person may send a letter only if the recipient lives in another city (because if they
    live in the same city, then it is easier to drop in). Strange but true, the cost of sending the letter is exactly
    equal to the distance between the sender's city and the recipient's city. For each city calculate two values ​​mini
    and maxi, where mini is the minimum cost of sending a letter from the i-th city to some other city, and maxi is
    the the maximum cost of sending a letter from the i-th city to some other city.

    Input
    The first line of the input contains integer n (2 ≤ n ≤ 105) — the number of cities in Lineland.
    The second line contains the sequence of n distinct integers x1, x2, ..., xn ( - 109 ≤ xi ≤ 109),
    where xi is the x-coordinate of the i-th city. All the xi's are distinct and follow in ascending order.

    Output
    Print n lines, the i-th line must contain two integers mini, maxi, separated by a space, where mini is the minimum
    cost of sending a letter from the i-th city, and maxi is the maximum cost of sending a letter from the i-th city.

    Examples
        input
                4
                -5 -2 2 7
        output
                3 12
                3 9
                4 7
                5 12

        input
                2
                -1 1
        output
                2 2
                2 2
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int citiesNumber = Integer.parseInt(reader.readLine());

        ArrayList<Integer> cities = new ArrayList<Integer>();
        Scanner scanner = new Scanner(reader.readLine());
        for (int i = 0; i < citiesNumber; i++) {
            cities.add(scanner.nextInt());
        }

        int distances[][] = new int[citiesNumber][citiesNumber];
        for (int i = 0; i < citiesNumber; i++) {
            for (int j = 0; j < citiesNumber; j++) {
                distances[i][j] = getDistance(cities.get(i), cities.get(j));
            }
        }

        /* it is not optimized algorythm
            for (Integer city : cities) {
                System.out.println(getMin(city, cities) + " " + getMax(city, cities));
            }
        */

        /* showing matrix with distances
            System.out.println();
            System.out.println();
            for (int i = 0; i < citiesNumber; i++) {
                for (int j = 0; j < citiesNumber; j++) {
                    System.out.print(buffer[i][j] + " ");
                }
                System.out.println();
            }
        */

        for (int i = 0; i < citiesNumber; i++) {
            System.out.println(getMinInRow(i, distances) + " " + getMaxInRow(i, distances));
        }
    }


    /* it is not optimized algorythm
        static int getMin(int currentCity, ArrayList<Integer> cities){
            int min = Integer.MAX_VALUE;
            for (Integer otherCity : cities) {
                if (getDistance(currentCity, otherCity) < min && getDistance(currentCity, otherCity) != 0){
                    min = getDistance(currentCity, otherCity);
                }
            }
            return min;
        }

        static int getMax(int currentCity, ArrayList<Integer> cities){
            int max = Integer.MIN_VALUE;
            for (Integer otherCity : cities) {
                if (getDistance(currentCity, otherCity) > max){
                    max = getDistance(currentCity, otherCity);
                }
            }
            return max;
        }
    */

    static int getDistance(int cityA, int cityB){
        int distance = cityA - cityB;
        if (distance < 0){
            distance = distance * (-1);
        }
        return distance;
    }

    static int getMinInRow(int rowIndex, int[][] array){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i][rowIndex] < min && array[i][rowIndex] != 0){
                min = array[i][rowIndex];
            }
        }
        return min;
    }

    static int getMaxInRow(int rowIndex, int[][] array){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i][rowIndex] > max){
                max = array[i][rowIndex];
            }
        }
        return max;
    }
}
