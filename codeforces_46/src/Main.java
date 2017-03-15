/*
    Task from:
    http://codeforces.com/problemset/problem/545/C?locale=en

    "Woodcutters"

    Little Susie listens to fairy tales before bed every day.
    Today's fairy tale was about wood cutters and the little girl immediately started imagining the choppers cutting wood.
    She imagined the situation that is described below.

    There are n trees located along the road at points with coordinates x1, x2, ..., xn.
    Each tree has its height hi. Woodcutters can cut down a tree and fell it to the left or to the right.
    After that it occupies one of the segments [xi - hi, xi] or [xi;xi + hi].
    The tree that is not cut down occupies a single point with coordinate xi.
    Woodcutters can fell a tree if the segment to be occupied by the fallen tree doesn't contain any occupied point.
    The woodcutters want to process as many trees as possible, so Susie wonders, what is the maximum number of trees to fell.

    Input
    The first line contains integer n (1 ≤ n ≤ 10^5) — the number of trees.
    Next n lines contain pairs of integers xi, hi (1 ≤ xi, hi ≤ 109) — the coordinate and the height of the і-th tree.
    The pairs are given in the order of ascending xi. No two trees are located at the point with the same coordinate.

    Output
    Print a single number — the maximum number of trees that you can cut down by the given rules.

    Examples
        input
            5
            1 2
            2 1
            5 10
            10 9
            19 1
        output
            3

        input
            5
            1 2
            2 1
            5 10
            10 9
            20 1
        output
            4

    Note
    In the first sample you can fell the trees like that:
        fell the 1-st tree to the left — now it occupies segment [ - 1;1]
        fell the 2-nd tree to the right — now it occupies segment [2;3]
        leave the 3-rd tree — it occupies point 5
        leave the 4-th tree — it occupies point 10
        fell the 5-th tree to the right — now it occupies segment [19;20]

        In the second sample you can also fell 4-th tree to the right, after that it will occupy segment [10;19].
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(reader.readLine());

        int [] coordinates = new int [arraySize];
        int [] heights = new int [arraySize];

        int readyTrees = 0;
        int previousPosition = 0;
        int previousHeight = 0;
        int nextPosition;

        boolean isPreviousRight = false;

        for (int i = 0; i < arraySize ; i++) {
            Scanner scanner = new Scanner(reader.readLine());
            coordinates[i] = scanner.nextInt();
            heights[i] = scanner.nextInt();
        }

        for (int i = 0; i < arraySize; i++) {
            if (i == 0){
                readyTrees++;
                continue;
            }

            if (i == arraySize - 1){
                readyTrees++;
                continue;
            }

            if (isPreviousRight){
                previousPosition = previousPosition + previousHeight;
            }

            int currentPosition = coordinates[i];
            int currentHeight = heights[i];

            // try left
            if (currentPosition - currentHeight > previousPosition){
                readyTrees++;
                isPreviousRight = false;
                previousHeight = currentHeight;
                previousPosition = currentPosition;
                continue;
            }

            // try right
            nextPosition = coordinates[i + 1];
            if (currentPosition + currentHeight < nextPosition){
                readyTrees++;
                isPreviousRight = true;
                previousHeight = currentHeight;
                previousPosition = currentPosition;
                continue;
            }

            // skip
            isPreviousRight = false;
        }

        System.out.println(readyTrees);
    }
}
