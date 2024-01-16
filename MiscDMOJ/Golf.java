package Test.MiscDMOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Golf {
    public static void main(String[] args) throws IOException {
        // Set up a BufferedReader to read from the standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read the distance from the tee to the hole
        int holeDistance = Integer.parseInt(br.readLine());

        // Read the number of clubs
        int clubCount = Integer.parseInt(br.readLine());

        // Create a map to store the distance each club can hit
        HashMap<Integer, Integer> clubMap = new HashMap<>();

        // Read the distance for each club and store it in the clubMap
        for (int i = 0; i < clubCount; i++) {
            int clubDistance = Integer.parseInt(br.readLine());
            clubMap.put(i, clubDistance);
        }

        // Create an array to store the minimum strokes needed to reach each distance
        int[] strokes = new int[holeDistance + 1];

        // Initialize the array with Integer.MAX_VALUE for all distances except 0
        // 0 distance requires 0 strokes
        for (int i = 1; i <= holeDistance; i++) {
            strokes[i] = Integer.MAX_VALUE;
        }
        strokes[0] = 0;

        // Dynamic programming approach to fill the strokes array
        for (int i = 1; i <= holeDistance; i++) {
            for (int j = 0; j < clubCount; j++) {
                // Get the distance that can be hit by the current club
                int clubDistance = clubMap.get(j);

                // Check if it's possible to reach the current distance using this club
                // If so, update the strokes array with the minimum number of strokes required
                if (clubDistance <= i && strokes[i - clubDistance] != Integer.MAX_VALUE) {
                    strokes[i] = Math.min(strokes[i], strokes[i - clubDistance] + 1);
                }
            }
        }

        // Check the number of strokes required to reach the hole distance
        // If it's not Integer.MAX_VALUE, it means the hole can be reached
        // Otherwise, acknowledge defeat
        if (strokes[holeDistance] != Integer.MAX_VALUE) {
            System.out.println("Roberta wins in " + strokes[holeDistance] + " strokes.");
        } else {
            System.out.println("Roberta acknowledges defeat.");
        }
    }
}
