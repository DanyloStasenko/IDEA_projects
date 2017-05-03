/*
    Task from:
    http://codeforces.com/problemset/problem/459/A?locale=en

    "Pashmak and Garden"

    Pashmak has fallen in love with an attractive girl called Parmida since one year ago...
    Today, Pashmak set up a meeting with his partner in a romantic garden. Unfortunately,
    Pashmak has forgotten where the garden is. But he remembers that the garden looks like
    a square with sides parallel to the coordinate axes. He also remembers that there is exactly
    one tree on each vertex of the square. Now, Pashmak knows the position of only two of the trees.
    Help him to find the position of two remaining ones.

    Input
    The first line contains four space-separated x1, y1, x2, y2 ( - 100 ≤ x1, y1, x2, y2 ≤ 100) integers,
    where x1 and y1 are coordinates of the first tree and x2 and y2 are coordinates of the second tree.
    It's guaranteed that the given points are distinct.

    Output
    If there is no solution to the problem, print -1. Otherwise print four space-separated integers
    x3, y3, x4, y4 that correspond to the coordinates of the two other trees.
    If there are several solutions you can output any of them.
    Note that x3, y3, x4, y4 must be in the range ( - 1000 ≤ x3, y3, x4, y4 ≤ 1000).

    Examples
        input       0 0 0 1
        output      1 0 1 1

        input       0 0 1 1
        output      0 1 1 0

        input       0 0 1 2
        output      -1
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int point1X;
        int point1Y;
        int point2X;
        int point2Y;
        int point3X;
        int point3Y;
        int point4X;
        int point4Y;

        point1X = scanner.nextInt();
        point1Y = scanner.nextInt();
        point2X = scanner.nextInt();
        point2Y = scanner.nextInt();

        int xDifference = point2X - point1X;
        int yDifference = point2Y - point1Y;

        if (xDifference != 0 && yDifference != 0 && xDifference != yDifference){
            System.out.println(-1);
            return;
        }

        if (xDifference != 0 && yDifference == 0){
            point3X = point1X;
            point3Y = point1Y + xDifference;

            point4X = point2X;
            point4Y = point2Y + xDifference;

            System.out.println(point3X + " " + point3Y + " " + point4X + " " + point4Y);
            return;
        }

        if (xDifference == 0 && yDifference != 0){
            point3Y = point2Y;
            point3X = point2X + yDifference;

            point4Y = point1Y;
            point4X = point1X + yDifference;

            System.out.println(point3X + " " + point3Y + " " + point4X + " " + point4Y);
            return;
        }

        if (xDifference == yDifference && xDifference != 0){
            point3X = point1X;
            point3Y = point1Y + yDifference;

            point4X = point1X + yDifference;
            point4Y = point1Y;

            System.out.println(point3X + " " + point3Y + " " + point4X + " " + point4Y);
            return;
        }

        if (xDifference == yDifference * -1){
            point3X = point1X;
            point3Y = point1Y - yDifference;

            point4X = point2X;
            point4Y = point2Y - yDifference;

            System.out.println(point3X + " " + point3Y + " " + point4X + " " + point4Y);
            return;
        }
    }
}
