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

        int[][] matrix = new int[rows][columns];
        int pieces = 0;

        rows--;
        columns--;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!rowContainsStrawberry(matrix, i, columns) || !columnContainsStrawberry(matrix, j, rows)){
                    if (matrix[i][j] != 9){
                        matrix[i][j] = 9; // label
                        pieces++;
                    }
                }
            }

        }

        /*for (int i = 0; i < rows; i++) {
            String input = reader.readLine();
            for (int j = 0; j < columns; j++) {
                if (input.charAt(j) == 'S'){
                    matrix[i][j] = 0;
                }
                if (input.charAt(j) == '.'){
                    matrix[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                if (!rowContainsStrawberry(matrix, i, columns)){
                    if (matrix[i][j] != 9){
                        matrix[i][j] = 9; // label
                        pieces++;
                    }
                }
            }
        }*/


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!columnContainsStrawberry(matrix, i, columns)){
                    if (matrix[i][j] != 9){
                        matrix[i][j] = 9; // label
                        pieces++;
                    }
                }
            }
        }

        System.out.println(pieces);
    }

    static boolean rowContainsStrawberry(int[][] array, int rowNumber, int columnCount){
        for (int i = 0; i < columnCount; i++) {
            if (array[rowNumber][i] == 0){
                return true;
            }
        }
        return false;
    }

    static boolean columnContainsStrawberry(int[][] array, int columnNumber, int rowCount){
        for (int i = 0; i < rowCount; i++) {
            if (array[columnNumber][i] == 0){
                return true;
            }
        }
        return false;
    }
}
