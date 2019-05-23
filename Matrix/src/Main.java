import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private final static String INPUT = "input.txt";
    private final static String OUTPUT = "output.txt";
    private final static Pattern ROW_PATTERN = Pattern.compile("^(\\d+) (\\d+) (\\d+) (\\d+) (\\d+)$");

    public static void main(String[] args) throws IOException {
        // get matrix from file
        double[][] input = readMatrixFromFile();

        // todo: may be deleted: just printing matrix to console
        printMathix(input);

        // todo: after processing: printMathix(input);

        // writing matrix to file
        writeMatrix(input);
    }

    private static double[][] readMatrixFromFile() throws IOException {
        System.out.println("Reading from file with name [" + INPUT + "]");
        double[][] matrixFromFile = new double[5][5];

        // Searching for file
        File file = new File(INPUT);
        // Reading from file
        BufferedReader reader = new BufferedReader(new FileReader(file));

        // 5 means lines
        for (int i = 0; i < 5; i++){
            String input = reader.readLine();
            Matcher matcher = ROW_PATTERN.matcher(input);

            while (matcher.find()){
                for (int j = 0; j < 5; j++){
                    double first = Double.parseDouble(matcher.group(j + 1));
                    matrixFromFile[i][j] = first;
                }
            }
        }

        return matrixFromFile;
    }

    private static void printMathix(double matrix[][]){
        System.out.println("====== Printing martix ======");
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==============================");
    }

    private static void writeMatrix(double[][] matrix) {
        try {
            System.out.println("Creating file with name [" + OUTPUT + "]");
            BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT));

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    // bw.write(matrix[i][j] + ((j == matrix[i].length-1) ? "" : ","));
                    bw.write(matrix[i][j] + " ");
                }
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {}
    }
}