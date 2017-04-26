/*
    By Danylo Stasenko
    Description:
        This simple program reverses each word in the input line.
        Words must be separated by a space.

    Examples:
        input:   dog eat cow
        output:  god tae woc

        input:   asdfasd ew rq 1234
        output:  dsafdsa we qr 4321

        input:   123 456 7 7890
        output:  321 654 7 0987
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String buffer = "";
        String output = "";

        for (int i = 0; i < input.length(); i++) {
            // if this character is not 'space' - add this character to buffer
            if (input.charAt(i) != ' '){
                buffer += input.charAt(i);
            }

            // if this character is 'space' - add reverted buffer to output and clear buffer
            if (input.charAt(i) == ' '){
                for (int j = buffer.length() - 1; j >= 0; j--) {
                    output += buffer.charAt(j);
                }
                output += " ";      // don't forget to add space between words
                buffer = "";        // and clear buffer
            }

            // if it is last character - clear buffer and add it to output
            if (i == input.length() - 1){
                for (int j = buffer.length() - 1; j >= 0; j--) {
                    output += buffer.charAt(j);
                }
            }
        }

        System.out.println(output);
    }
}
