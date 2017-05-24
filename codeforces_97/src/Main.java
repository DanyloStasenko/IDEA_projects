/*
    Task from:
    http://codeforces.com/problemset/problem/535/A?locale=en

    "Tavas and Nafas"

    Today Tavas got his test result as an integer score and he wants to share it with his girlfriend, Nafas.
    His phone operating system is Tavdroid, and its keyboard doesn't have any digits! He wants to share his score
    with Nafas via text, so he has no choice but to send this number using words.
    He ate coffee mix without water again, so right now he's really messed up and can't think.
    Your task is to help him by telling him what to type.

    Input
    The first and only line of input contains an integer s (0 ≤ s ≤ 99), Tavas's score.

    Output
    In the first and only line of output, print a single string consisting only from English lowercase letters and
    hyphens ('-'). Do not use spaces.

    Examples
        input       6
        output      six

        input       99
        output      ninety-nine

        input       20
        output      twenty

    Note
        You can find all you need to know about English numerals in http://en.wikipedia.org/wiki/English_numerals .
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int number = Integer.parseInt(input);

        switch (number){
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            case 4:
                System.out.println("four");
                break;
            case 5:
                System.out.println("five");
                break;
            case 6:
                System.out.println("six");
                break;
            case 7:
                System.out.println("seven");
                break;
            case 8:
                System.out.println("eight");
                break;
            case 9:
                System.out.println("nine");
                break;
            case 10:
                System.out.println("ten");
                break;

            case 11:
                System.out.println("eleven");
                break;
            case 12:
                System.out.println("twelve");
                break;
            case 13:
                System.out.println("thirteen");
                break;
            case 14:
                System.out.println("fourteen");
                break;
            case 15:
                System.out.println("fifteen");
                break;
            case 16:
                System.out.println("sixteen");
                break;
            case 17:
                System.out.println("seventeen");
                break;
            case 18:
                System.out.println("eighteen");
                break;
            case 19:
                System.out.println("nineteen");
                break;

            case 20:
                System.out.println("twenty");
                break;
            case 30:
                System.out.println("thirty");
                break;
            case 40:
                System.out.println("forty");
                break;
            case 50:
                System.out.println("fifty");
                break;
            case 60:
                System.out.println("sixty");
                break;
            case 70:
                System.out.println("seventy");
                break;
            case 80:
                System.out.println("eighty");
                break;
            case 90:
                System.out.println("ninety");
                break;

            default:

                if (input.charAt(0) == '2'){
                    System.out.print("twenty");
                }
                if (input.charAt(0) == '3'){
                    System.out.print("thirty");
                }
                if (input.charAt(0) == '4'){
                    System.out.print("forty");
                }
                if (input.charAt(0) == '5'){
                    System.out.print("fifty");
                }
                if (input.charAt(0) == '6'){
                    System.out.print("sixty");
                }
                if (input.charAt(0) == '7'){
                    System.out.print("seventy");
                }
                if (input.charAt(0) == '8'){
                    System.out.print("eighty");
                }
                if (input.charAt(0) == '9'){
                    System.out.print("ninety");
                }

                System.out.print("-");

                if (input.charAt(1) == '1'){
                    System.out.print("one");
                }
                if (input.charAt(1) == '2'){
                    System.out.print("two");
                }
                if (input.charAt(1) == '3'){
                    System.out.print("three");
                }
                if (input.charAt(1) == '4'){
                    System.out.print("four");
                }
                if (input.charAt(1) == '5'){
                    System.out.print("five");
                }
                if (input.charAt(1) == '6'){
                    System.out.print("six");
                }
                if (input.charAt(1) == '7'){
                    System.out.print("seven");
                }
                if (input.charAt(1) == '8'){
                    System.out.print("eight");
                }
                if (input.charAt(1) == '9'){
                    System.out.print("nine");
                }
        }
    }
}
