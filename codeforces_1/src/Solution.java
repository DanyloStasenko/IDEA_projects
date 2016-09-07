import java.util.Scanner;

/**
 * Created by Admin on 07.09.2016.
 */

    // task from http://codeforces.com/contest/1/problem/A

    /*
    We need to cover rectangle area using the minimum number of square blocks.
    rectangle area = n * m
    block area = a * a
     */

public class Solution
{
    static int calculateNumber(double rectLength, double rectWidth, double blockSide)
    {
        // rounding VALUES to bigger
        double realLength = Math.ceil(rectLength/blockSide);
        double realWidth = Math.ceil(rectWidth/blockSide);
        double number = realLength * realWidth;
        return (int)number;
    }

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        try
        {
            // Entering values
            System.out.println("Enter Length: (double, > 0)");
            double length = Double.parseDouble(scanner.next());
            System.out.println("Enter Width: (double, > 0)");
            double width = Double.parseDouble(scanner.next());
            System.out.println("Enter tile size: (length = width) (double, > 0)");
            double size = Double.parseDouble(scanner.next());

            // Check arguments: - all must be > 0
            if (length <= 0 || width <= 0 || size <= 0)
                throw new IllegalArgumentException("Bad value");

            // Showing result
            System.out.println("We need at least "+calculateNumber(length, width, size)+" square blocks to cover area with length = "+length+", width = "+width);
        }

        catch (Exception e)
        {
           e.printStackTrace();
        }
    }
}