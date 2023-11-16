package Test.MandatoryDMOJ.CellphoneMessaging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CellphoneMessagingFinal {
    /**
     * Created by Cameron Greatrex on 2023-10-13.
     * 
     * @author Cameron Greatrex
     */
    public static void main(String[] args) throws IOException {
        // declare and initialize variables for the program
        byte totalSeconds = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // collect input from buffered reader and put it into char array
        String message = br.readLine();
        char[] messageArray = message.toCharArray();
        // keeps the checks running until the user enters "halt"
        while (!message.equals("halt")) {
            // add 2 seconds if a letter is pressed after different letter on
            // the same keypad number and if the same key is pressed back-to-back
            // loops to length-1 to account for the error where i is the size of the array
            // and not the max index value
            for (byte i = 0; i < messageArray.length - 1; i++) {
                if ((messageArray[i] == 'a' || messageArray[i] == 'b' || messageArray[i] == 'c')
                        && (messageArray[i + 1] == 'a' || messageArray[i + 1] == 'b' || messageArray[i + 1] == 'c')) {
                    totalSeconds += 2;
                }
                if ((messageArray[i] == 'd' || messageArray[i] == 'e' || messageArray[i] == 'f')
                        && (messageArray[i + 1] == 'd' || messageArray[i + 1] == 'e' || messageArray[i + 1] == 'f')) {
                    totalSeconds += 2;
                }
                if ((messageArray[i] == 'g' || messageArray[i] == 'h' || messageArray[i] == 'i')
                        && (messageArray[i + 1] == 'g' || messageArray[i + 1] == 'h' || messageArray[i + 1] == 'i')) {
                    totalSeconds += 2;
                }
                if ((messageArray[i] == 'j' || messageArray[i] == 'k' || messageArray[i] == 'l')
                        && (messageArray[i + 1] == 'j' || messageArray[i + 1] == 'k' || messageArray[i + 1] == 'l')) {
                    totalSeconds += 2;
                }
                if ((messageArray[i] == 'm' || messageArray[i] == 'n' || messageArray[i] == 'o')
                        && (messageArray[i + 1] == 'm' || messageArray[i + 1] == 'n' || messageArray[i + 1] == 'o')) {
                    totalSeconds += 2;
                }
                if ((messageArray[i] == 'p' || messageArray[i] == 'q' || messageArray[i] == 'r'
                        || messageArray[i] == 's')
                        && (messageArray[i + 1] == 'p' || messageArray[i + 1] == 'q' || messageArray[i + 1] == 'r'
                                || messageArray[i + 1] == 's')) {
                    totalSeconds += 2;
                }
                if ((messageArray[i] == 't' || messageArray[i] == 'u' || messageArray[i] == 'v')
                        && (messageArray[i + 1] == 't' || messageArray[i + 1] == 'u' || messageArray[i + 1] == 'v')) {
                    totalSeconds += 2;
                }
                if ((messageArray[i] == 'w' || messageArray[i] == 'x' || messageArray[i] == 'y'
                        || messageArray[i] == 'z')
                        && (messageArray[i + 1] == 'w' || messageArray[i + 1] == 'x' || messageArray[i + 1] == 'y'
                                || messageArray[i + 1] == 'z')) {
                    totalSeconds += 2;
                }
            }

            // loop through all char's in the array and add the appropriate number of
            // seconds based of how many times a button is pressed for the letter
            for (byte i = 0; i < messageArray.length; i++) {
                // when a character only needs (x) press(es) to access it on the phone, add
                // (x) second(s) to totalSeconds
                if (messageArray[i] == 'a' || messageArray[i] == 'd' || messageArray[i] == 'g'
                        || messageArray[i] == 'j'
                        || messageArray[i] == 'm' || messageArray[i] == 'p' || messageArray[i] == 't'
                        || messageArray[i] == 'w') {
                    totalSeconds += 1;
                } else if (messageArray[i] == 'b' || messageArray[i] == 'e' || messageArray[i] == 'h'
                        || messageArray[i] == 'k'
                        || messageArray[i] == 'n' || messageArray[i] == 'q' || messageArray[i] == 'u'
                        || messageArray[i] == 'x') {
                    totalSeconds += 2;
                } else if (messageArray[i] == 'c' || messageArray[i] == 'f' || messageArray[i] == 'i'
                        || messageArray[i] == 'l'
                        || messageArray[i] == 'o' || messageArray[i] == 'r' || messageArray[i] == 'v'
                        || messageArray[i] == 'y') {
                    totalSeconds += 3;
                } else if (messageArray[i] == 's' || messageArray[i] == 'z') {
                    totalSeconds += 4;
                }
            }
            // print the total seconds and reset all variables to the pre-while loop state
            System.out.println(totalSeconds);
            totalSeconds = 0;
            message = br.readLine();
            messageArray = message.toCharArray();
        }
    }
}