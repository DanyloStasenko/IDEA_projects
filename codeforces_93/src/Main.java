/*
    Task from:
    http://codeforces.com/problemset/problem/330/A?locale=en

    "Cakeminator"

    You are given a rectangular cake, represented as an r × c grid.
    Each cell either has an evil strawberry, or is empty. For example, a 3 × 4 cake may look as follows:
            0 0 0 0
            0 0 0 0
            0 0 0 0
    The cakeminator is going to eat the cake! Each time he eats, he chooses a row or a column that does not contain
    any evil strawberries and contains at least one cake cell that has not been eaten before, and eats all the cake
    cells there. He may decide to eat any number of times.
    Please output the maximum number of cake cells that the cakeminator can eat.

    Input
    The first line contains two integers r and c (2 ≤ r, c ≤ 10), denoting the number of rows and the number of columns
    of the cake. The next r lines each contains c characters — the j-th character of the i-th line denotes the
    content of the cell at row i and column j, and is either one of these:
    '.' character denotes a cake cell with no evil strawberry;
    'S' character denotes a cake cell with an evil strawberry.

    Output
    Output the maximum number of cake cells that the cakeminator can eat.

    Examples
        input
                3 4
                S...
                ....
                ..S.
        output
                8

    Note
    For the first example, one possible way to eat the maximum number of cake cells is as follows (perform 3 eats).
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(reader.readLine());

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        char[][] cells = new char[rows][columns];
        int result = 0;

        for (int i = 0; i < rows; i++) {
            String input = reader.readLine();
            for (int j = 0; j < columns; j++) {
                cells[i][j] = input.charAt(j);
            }
        }

        // if  (currentRow doesn't contain strawberry OR currentColumn doesn't contain strawberry){result++;}
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!rowContainsStrawberry(cells, i, columns) || !columnContainsStrawberry(cells, j, rows)){
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    static boolean rowContainsStrawberry(char[][] array, int rowNumber, int columnCount){
        for (int i = 0; i < columnCount; i++) {
            if (array[rowNumber][i] == 'S'){
                return true;
            }
        }
        return false;
    }

    static boolean columnContainsStrawberry(char[][] array, int columnNumber, int rowCount){
        for (int i = 0; i < rowCount; i++) {
            if (array[i][columnNumber] == 'S'){
                return true;
            }
        }
        return false;
    }
}
