package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SlotMachines {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // inputs and scanners for the amount of quarters in her jar and machine 1-3
        // time since last won
        // variable to track the total amount of martha's plays
        short quarters = Short.parseShort(br.readLine()), machine1 = Short.parseShort(br.readLine()), machine2 = Short.parseShort(br.readLine()), machine3 = Short.parseShort(br.readLine()), totalPlays = 0;
        // keeps looping until she runs out of quarters (quarters >=1)
        while (quarters >= 1) {
            // adds a play since last won
            machine1 += 1;
            // subtracts a quarter because of the play
            quarters -= 1;
            // adds a total play
            totalPlays += 1;
            // if the machine has been played 35 times since the last win, it will pay out
            // the quarters and reset the plays since last won
            if (machine1 == 35) {
                quarters += 30;
                machine1 = 0;
            }
            // if she has no quarters, it will exit the loop and got to the print because
            // she is broke
            if (quarters == 0) {
                break;
            }
            // if still going, the machine 2 will add a play since last win
            machine2 += 1;
            // subtracts a quarter spent to play
            quarters -= 1;
            // adds a total play
            totalPlays += 1;
            // if the machine has been played 100 times since last win, it will payout and
            // reset the time since last won to 0
            if (machine2 == 100) {
                quarters += 60;
                machine2 = 0;
            }
            // if she has no quarters, it will exit the loop and move to the print statement
            if (quarters == 0) {
                break;
            }
            // if still going again, the program will add a time since won to machine 3
            machine3 += 1;
            // subtracts a quarter because of one being spent to play
            quarters -= 1;
            // adds a total play
            totalPlays += 1;
            // if the machine has been played 10 times since last win, it will payout and
            // reset the time since last win to 0
            if (machine3 == 10) {
                quarters += 9;
                machine3 = 0;
            }
            // if her quaters are 0, the program will exit the loop and go on to print
            if (quarters == 0) {
                break;
            }
        }
        // once out of the loop because she is broke, it will print how many plays it
        // took until martha is broke
        System.out.println("Martha plays " + totalPlays + " times before going broke.");
    }

}