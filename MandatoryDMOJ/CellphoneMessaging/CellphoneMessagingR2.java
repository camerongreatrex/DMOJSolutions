package Test.MandatoryDMOJ.CellphoneMessaging;

import java.util.Scanner;

public class CellphoneMessagingR2 {
    /**
     * Created by Cameron Greatrex on 2023-10-13.
     *
     * @author Cameron Greatrex
     */

    // variables decalared as static so they can be accessed by other methods but
    // initizalized in main method - good practice you told me to do
    public static int pauseSeconds;
    public static int pressSeconds;
    public static int buttonSeconds;
    public static int totalSeconds;
    public static Scanner sc = new Scanner(System.in);
    public static String message = sc.nextLine();
    public static char[] messageArray = message.toCharArray();

    public static void main(String[] args) {
        while (!message.equals("halt")) {
            // loop through all numbers in the array and find the appropriate number of
            // buttonSeconds and pauseSeconds
            for (int i = 0; i < messageArray.length; i++) {
                checkPauseSeconds();
                // if (x) character only needs one press to access it on the phone, add one
                // second to buttonSeconds
                if (messageArray[i] == 'a' || messageArray[i] == 'd' || messageArray[i] == 'g'
                        || messageArray[i] == 'j'
                        || messageArray[i] == 'm' || messageArray[i] == 'p' || messageArray[i] == 't'
                        || messageArray[i] == 'w') {
                    buttonSeconds += 1;
                    // if (x) character needs two presses to access it on the phone, add two
                    // seconds to buttonSeconds
                } else if (messageArray[i] == 'b' || messageArray[i] == 'e' || messageArray[i] == 'h'
                        || messageArray[i] == 'k'
                        || messageArray[i] == 'n' || messageArray[i] == 'q' || messageArray[i] == 'u'
                        || messageArray[i] == 'x') {
                    buttonSeconds += 2;
                    // loop to add pause seconds if one of the keys here are pressed
                    // if (x) character needs three presses to access it on the phone, add three
                    // seconds to buttonSeconds
                } else if (messageArray[i] == 'c' || messageArray[i] == 'f' || messageArray[i] == 'i'
                        || messageArray[i] == 'l'
                        || messageArray[i] == 'o' || messageArray[i] == 'r' || messageArray[i] == 'v'
                        || messageArray[i] == 'y') {
                    buttonSeconds += 3;
                    // loop to add pause seconds if one of the keys here are pressed
                    // if (x) character needs 4 presses to access it on the phone, add four
                    // second to buttonSeconds
                } else if (messageArray[i] == 's' || messageArray[i] == 'z') {
                    buttonSeconds += 4;
                    // loop to add pause seconds if one of the keys here are pressed
                }
            }
            // calculate total seconds, print total seconds, and reset both variables
            totalSeconds = pauseSeconds + buttonSeconds;
            System.out.println(totalSeconds);
            buttonSeconds = 0;
            pauseSeconds = 0;
            // read next message and add it to the array
            message = sc.nextLine();
            messageArray = message.toCharArray();
        }
    }

    /**
     * calculates the amount of pause seconds by comparing each character to the
     * next one
     */
    public static void checkPauseSeconds() {
        for (int i = 0; i < messageArray.length - 1; i++) {
            if (messageArray[i] == messageArray[i + 1]) {
                pauseSeconds += 2;
            }
        }
    }
}