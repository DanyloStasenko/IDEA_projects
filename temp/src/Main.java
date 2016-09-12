import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

    static int findHowManyRowsWithSum(int[][] array, int rowSum)
    {
        int rowSumCount = 0;
        for (int i = 0; i < array.length ; i++)
        {
            if (rowSum == rowSum(array, i))
            {
                rowSumCount++;
            }
        }
        return rowSumCount;
    }




    static int findHowManyColumnsWithSum(int[][] array, int columnSum)
    {
        int columnSumCount = 0;
        for (int i = 0; i < array.length ; i++)
        {
            if (columnSum == columnSum(array, i))
            {
                columnSumCount++;
            }
        }
        return columnSumCount;
    }



    static int findRowIndexBySum(int[][] array, int rowSum)
    {
        int searchedRow = -1;
        for (int i = 0; i < array.length ; i++)
        {
            if (rowSum == rowSum(array, i))
            {
                searchedRow = i;
            }
        }
        return searchedRow;
    }

    static int findColumnIndexBySum(int[][] array, int columnSum)
    {
        int searchedColumn = -1;
        for (int i = 0; i < array.length ; i++)
        {
            if (columnSum == columnSum(array, i))
            {
                searchedColumn = i;
            }
        }
        return searchedColumn;
    }



    // rowSum
    static int rowSum(int[][] array, int rawID)
    {
        int result = 0;
        int length = array.length;

        for (int i = 0; i < length ; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if (rawID == i)
                    result += array[i][j];
            }
        }
        return result;
    }


    // columnSum
    static int columnSum(int[][] array, int columnID)
    {
        int result = 0;
        int length = array.length;

        for (int i = 0; i < length ; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if (columnID == j)
                    result += array[i][j];
            }
        }
        return result;
    }

    // diag sum

    static int mainDiagSum(int[][] array)
    {
        int result = 0;

        for (int i = 0; i < array.length ; i++)
        {
            for (int j = 0; j < array.length ; j++)
            {
                if (i == j)
                    result += array[i][j];
            }
        }

        return result;
    }

    static int max(int value1, int value2)
    {
        if (value1 > value2)
        {
            return value1;
        }
        else return value2;
    }

    public static void main(String[] args) throws IOException
    {

            boolean resultNotExists = false;
            int searchedNumberProperties[] = new int[3];


            BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));


            // ---------------------- I N P U T ----------------------


            System.out.println("Enter SIZE:");
            int arraySize = Integer.parseInt(reader.readLine());
            int matrix[][] = new int[arraySize][arraySize];


            System.out.println("Now enter matrix:");
            for (int i = 0; i < arraySize; i++)
            {
                String ui = reader.readLine();
                String[] strings = ui.split("\\s+");
                for (int j = 0; j < arraySize; j++)
                {
                    matrix[i][j] = Integer.parseInt(strings[j]);
                }
            }


        // testing
        int greaterRowSum = 0;
        int lessRowSum = 0;

        for (int i = 0; i < arraySize ; i++)
        {
            if (greaterRowSum < rowSum(matrix,i))
                greaterRowSum = rowSum(matrix, i);
        }

        lessRowSum = greaterRowSum;
        for (int i = 0; i < arraySize ; i++)
        {
            if (lessRowSum > rowSum(matrix,i))
                lessRowSum = rowSum(matrix, i);
        }


        for (int i = 0; i < arraySize ; i++)
        {
            System.out.println("ROW sum: "+i+" = "+rowSum(matrix, i));
            System.out.println("COLUMN sum: "+i+" = "+columnSum(matrix, i));
        }
        System.out.println("Main diag sum: "+mainDiagSum(matrix));
        System.out.println("Greater row sum:"+greaterRowSum);
        System.out.println("Less row sum:"+lessRowSum);

















       /* import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

*//**
 * Created by Admin on 08.09.2016.
 *//*
        public class Solution
        {
            // task from http://codeforces.com/problemset/problem/711/B

    *//*
    1) Find minimal, maximal ROW_SUM, and row with minimal sum
    2) Find minimal, maximal COLUMN_SUM, and column with minamal sum
    3) Find DIAG_SUM, if DIAG1 != DIAG2, and IF value[MIN+RAW][MIN_COLUMN] != DIAG_differrnce - false
     *//*


            static int max(int value1, int value2)
            {
                if (value1 > value2)
                    return value1;

                else
                    return value2;
            }

            static int min(int value1, int value2)
            {
                if (value1 < value2)
                    return value1;

                else
                    return value2;
            }

            // rowSum
            static int rowSum(int[][] array, int rawID)
            {
                int result = 0;
                int length = array.length;

                for (int i = 0; i < length ; i++)
                {
                    for (int j = 0; j < length; j++)
                    {
                        if (rawID == i)
                            result += array[i][j];
                    }
                }
                return result;
            }


            // columnSum
            static int columnSum(int[][] array, int columnID)
            {
                int result = 0;
                int length = array.length;

                for (int i = 0; i < length ; i++)
                {
                    for (int j = 0; j < length; j++)
                    {
                        if (columnID == j)
                            result += array[i][j];
                    }
                }
                return result;
            }

            // diag sum

            static int mainDiagSum(int[][] array)
            {
                int result = 0;

                for (int i = 0; i < array.length ; i++)
                {
                    for (int j = 0; j < array.length ; j++)
                    {
                        if (i == j)
                            result += array[i][j];
                    }
                }

                return result;
            }

            static int otherDiagSum(int[][] array)
            {
                int result = 0;

                for (int i = 0; i < array.length ; i++)
                {
                    result += array[i][array.length-1-i];
                }

                return result;
            }





            // checking
            static int findRowsWithSum(int[][] array, int searchedValue)
            {
                int rowSumCount = 0;
                for (int i = 0; i < array.length ; i++)
                {
                    if (searchedValue == rowSum(array, i))
                        rowSumCount++;
                }
                return rowSumCount;
            }




            static int findColumnsWithSum(int[][] array, int searchedValue)
            {
                int columnSumCount = 0;
                for (int i = 0; i < array.length ; i++)
                {
                    if (searchedValue == columnSum(array, i))
                        columnSumCount++;
                }
                return columnSumCount;
            }



            static int findRowBySum(int[][] array, int searchedValue)
            {
                int searchedRow = -1;
                for (int i = 0; i < array.length ; i++)
                {
                    if (searchedValue == rowSum(array, i))
                        searchedRow = i;
                }
                return searchedRow;
            }

            static int findColumnBySum(int[][] array, int searchedValue)
            {
                int searchedColumn = -1;
                for (int i = 0; i < array.length ; i++)
                {
                    if (searchedValue == columnSum(array, i))
                        searchedColumn =  i;
                }
                return searchedColumn;
            }

            static boolean valueOnMain(int[][] array)
            {
                boolean result = false;
                for (int i = 0; i < array.length ; i++)
                {
                    for (int j = 0; j < array.length ; j++)
                    {
                        if (i == j && array[i][j] == 0)
                            result = true;
                    }
                }
                return result;
            }

            static boolean valueOnOther(int[][] array)
            {
                boolean result = false;
                for (int i = 0; i < array.length ; i++)
                {

                    if ( array[i][array.length-i-1] == 0)
                        result = true;

                }
                return result;
            }



// ---------------------------------- M A I N ------------------------------------------

            public static void main(String[] args) throws IOException
            {
                boolean resultNotExists = false;
                BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));

                int searchedNumberProperties[] = new int[3];


                // ---------------------- I N P U T ----------------------


                System.out.println("Enter SIZE:");
                int arraySize = Integer.parseInt(reader.readLine());
                int matrix[][] = new int[arraySize][arraySize];


                System.out.println("Now enter matrix:");
                for (int i = 0; i < arraySize ; i++)
                {
                    String ui = reader.readLine();
                    String[] strings = ui.split("\\s+");
                    for (int j = 0; j < arraySize; j++)
                    {
                        matrix[i][j] = Integer.parseInt(strings[j]);
                    }
                }


                // ---------------------- C H E C K     R O W S   ----------------------


                // FIND ROW WITH MAXIMAL SUM
                int greaterSum = 0;
                for (int i = 0; i < arraySize ; i++)
                {
                    if (greaterSum < rowSum(matrix, i))
                    {
                        greaterSum = rowSum(matrix, i);
                    }
                }

                // FIND ROW WITH MINIMAL SUM
                int lessSum = 0;
                for (int i = 0; i < arraySize ; i++)
                {
                    if (lessSum > rowSum(matrix, i))
                    {
                        lessSum = rowSum(matrix, i);
                    }
                }

                if (findRowsWithSum(matrix, lessSum) != 1 || findRowsWithSum(matrix, greaterSum) != arraySize-1)
                    resultNotExists = true;



                int rowDifference = greaterSum - lessSum; // value
                int valueRowID = findRowBySum(matrix, lessSum);


                // ---------------------- C H E C K     C O L U M N S   ----------------------


                // FIND COLUMN WITH MAXIMAL SUM

                greaterSum = 0;
                for (int i = 0; i < arraySize ; i++)
                {
                    if (greaterSum < columnSum(matrix, i))
                    {
                        greaterSum = columnSum(matrix, i);
                    }
                }

                // FIND COLUMN WITH MINIMAL SUM
                lessSum = 0;
                for (int i = 0; i < arraySize ; i++)
                {
                    if (lessSum > columnSum(matrix, i))
                    {
                        lessSum = columnSum(matrix, i);
                    }
                }

                //check
                if (findColumnsWithSum(matrix, lessSum) != 1 || findColumnsWithSum(matrix, greaterSum) != arraySize-1)
                    resultNotExists = true;

                int columnDifference = greaterSum - lessSum; // value

                if (columnDifference != rowDifference)
                    resultNotExists = true;

                // find value [row][column]


                int valueColumnID = findColumnBySum(matrix, lessSum);

                searchedNumberProperties[0] = valueRowID;
                searchedNumberProperties[1] = valueColumnID;
                searchedNumberProperties[2] = columnDifference;

                //check diags

                int d1 = mainDiagSum(matrix);
                int d2 = otherDiagSum(matrix);

                boolean isValueOnMain = valueOnMain(matrix);
                boolean isValueOnOther = valueOnOther(matrix);
                boolean isValueOnMainAndOnOther = false;

                if (isValueOnMain && isValueOnOther)
                    isValueOnMainAndOnOther = true;

                if (isValueOnMainAndOnOther == true)
                {
                    if (d1 != d2)
                    {
                        resultNotExists = true;
                    }
                }

                int max = max(d1, d2);
                int min = min(d1, d2);

                int difference = max-min;


                if (isValueOnMainAndOnOther == false)
                {


                    if (isValueOnMain == true && difference != columnDifference)
                    {
                        resultNotExists = true;
                    }

                    if (isValueOnOther == true && difference != columnDifference)
                    {
                        resultNotExists = true;
                    }
                }






                if (resultNotExists == true)
                {
                    System.out.println("Value not exists");
                }
                else
                    System.out.println(columnDifference);

                System.out.println(searchedNumberProperties[0]);
                System.out.println(searchedNumberProperties[1]);
                System.out.println(searchedNumberProperties[2]);

                System.out.println(columnDifference);




        *//*

        // OUTPUT
        for (int i = 0; i < arraySize ; i++)
        {
            for (int j = 0; j < arraySize ; j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        *//*

            }
        }
*/
























    }
}
