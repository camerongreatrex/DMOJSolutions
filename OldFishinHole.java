package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Cameron Greatrex on 2023-10-23.
 *
 * @author Cameron Greatrex
 */

public class OldFishinHole {
    public static void main(String[] args) throws IOException {
        //declare and initialize variables for the program
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //uses byte and short to minimize memory usage for the inputs
        byte troutValue = Byte.parseByte(br.readLine());
        byte pikeValue = Byte.parseByte(br.readLine());
        byte pickerelValue = Byte.parseByte(br.readLine());
        byte maxPoints = Byte.parseByte(br.readLine());
        short possibilityCount = 0;
        // for loops for each fish to make sure the amount times value doesn't exceed max points
        for (byte troutCount = 0; troutCount * troutValue <= maxPoints; troutCount++) {
            for (byte pikeCount = 0; pikeCount * pikeValue <= maxPoints; pikeCount++) {
                for (byte pickerelCount = 0; pickerelCount * pickerelValue <= maxPoints; pickerelCount++) {
                    // adds the total points up from the first loop
                    short totalPoints = (short) (troutCount * troutValue + pikeCount * pikeValue + pickerelCount * pickerelValue);
                    // then checks if it is less than the max points allowed and if the counts are more than 0 (so it doesn't print 0 of all fish as an option
                    if (totalPoints <= maxPoints && (troutCount > 0 || pikeCount > 0 || pickerelCount > 0)) {
                        //increase the possibility count because they fit the question's criteria
                        possibilityCount++;
                        // print the amount of each trout in the current combination
                        System.out.println(troutCount + " Brown Trout, " + pikeCount + " Northern Pike, " + pickerelCount + " Yellow Pickerel");
                    }
                }
            }
        }
        //print the overall number of ways to catch fish
        System.out.println("Number of ways to catch fish: " + possibilityCount);
    }
}
