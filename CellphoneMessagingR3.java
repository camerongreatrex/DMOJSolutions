package Test;

import java.util.Scanner;

public class CellphoneMessagingR3 {
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
    public static Scanner sc;
    public static String message;
    public static char[] messageArray;
    public static boolean hasPause;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        message = sc.nextLine();
        messageArray = message.toCharArray();
        while (!message.equals("halt")) {
            addPause();
            // loop through all numbers in the array and find the appropriate number of
            // buttonSeconds and pauseSeconds
            for (int i = 0; i < messageArray.length; i++) {
                // if (x) character only needs (x) press to access it on the phone, add (x)
                // second to buttonSeconds
                if (messageArray[i] == 'a' || messageArray[i] == 'd' || messageArray[i] == 'g'
                        || messageArray[i] == 'j'
                        || messageArray[i] == 'm' || messageArray[i] == 'p' || messageArray[i] == 't'
                        || messageArray[i] == 'w') {
                    buttonSeconds += 1;
                } else if (messageArray[i] == 'b' || messageArray[i] == 'e' || messageArray[i] == 'h'
                        || messageArray[i] == 'k'
                        || messageArray[i] == 'n' || messageArray[i] == 'q' || messageArray[i] == 'u'
                        || messageArray[i] == 'x') {
                    buttonSeconds += 2;
                } else if (messageArray[i] == 'c' || messageArray[i] == 'f' || messageArray[i] == 'i'
                        || messageArray[i] == 'l'
                        || messageArray[i] == 'o' || messageArray[i] == 'r' || messageArray[i] == 'v'
                        || messageArray[i] == 'y') {
                    buttonSeconds += 3;
                } else if (messageArray[i] == 's' || messageArray[i] == 'z') {
                    buttonSeconds += 4;
                }
            }
            // calculate and print total seconds
            totalSeconds = pauseSeconds + buttonSeconds;
            System.out.println(totalSeconds);
            // reset variables and ask for the next message and add it to the array
            buttonSeconds = 0;
            pauseSeconds = 0;
            hasPause = false;
            message = sc.nextLine();
            messageArray = message.toCharArray();
        }
    }

    /**
     * adds pauseSeconds if a letter is pressed after different letter on the same
     * keypad number and if the same key is pressed back-to-back
     */
    public static void addPause() {
        for (int i = 0; i < messageArray.length - 1; i++) {
            if ((messageArray[i] == 'a' || messageArray[i] == 'b' || messageArray[i] == 'c')
                    && (messageArray[i + 1] == 'a' || messageArray[i + 1] == 'b' || messageArray[i + 1] == 'c')) {
                pauseSeconds += 2;
            } else if ((messageArray[i] == 'd' || messageArray[i] == 'e' || messageArray[i] == 'f')
                    && (messageArray[i + 1] == 'd' || messageArray[i + 1] == 'e' || messageArray[i + 1] == 'f')) {
                pauseSeconds += 2;
            } else if ((messageArray[i] == 'g' || messageArray[i] == 'j' || messageArray[i] == 'i')
                    && (messageArray[i + 1] == 'g' || messageArray[i + 1] == 'j' || messageArray[i + 1] == 'i')) {
                pauseSeconds += 2;
            } else if ((messageArray[i] == 'j' || messageArray[i] == 'k' || messageArray[i] == 'l')
                    && (messageArray[i + 1] == 'j' || messageArray[i + 1] == 'k' || messageArray[i + 1] == 'l')) {
                pauseSeconds += 2;
            } else if ((messageArray[i] == 'm' || messageArray[i] == 'n' || messageArray[i] == 'o')
                    && (messageArray[i + 1] == 'm' || messageArray[i + 1] == 'n' || messageArray[i + 1] == 'o')) {
                pauseSeconds += 2;
            } else if ((messageArray[i] == 'p' || messageArray[i] == 'q' || messageArray[i] == 'r'
                    || messageArray[i] == 's')
                    && (messageArray[i + 1] == 'p' || messageArray[i + 1] == 'q' || messageArray[i + 1] == 'r'
                    || messageArray[i + 1] == 's')) {
                pauseSeconds += 2;
            } else if ((messageArray[i] == 't' || messageArray[i] == 'u' || messageArray[i] == 'v')
                    && (messageArray[i + 1] == 't' || messageArray[i + 1] == 'u' || messageArray[i + 1] == 'v')) {
                pauseSeconds += 2;
            } else if ((messageArray[i] == 'w' || messageArray[i] == 'x' || messageArray[i] == 'y'
                    || messageArray[i] == 'z')
                    && (messageArray[i + 1] == 'w' || messageArray[i + 1] == 'x' || messageArray[i + 1] == 'y'
                    || messageArray[i + 1] == 'z')) {
                pauseSeconds += 2;
            }

        }
    }
}