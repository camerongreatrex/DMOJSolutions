package Test.MandatoryDMOJ.AbsolutelyAcidic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AbsolutelyAcidic {

    // Problem: does not handle correctly if all the numbers occur with the same frequency
    // i.e 10,6,1,8 the frequency of each number is 1, so the program mishandled this case, and printed 10 instead of 9


    public static void main(String[] args) throws IOException {
        // BufferedReader to read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Read the number of sensors
        int sensors = Integer.parseInt(br.readLine());
        // Hashmap to store the first sensor reading and the amount of times it occurs
        HashMap<Integer, Integer> numberFrequency = new HashMap<>();

        // Input sensor readings and update frequencies
        for (int i = 0; i < sensors; i++) {
            // Read the sensor reading
            int reading = Integer.parseInt(br.readLine());
            // If the reading is already in the hashmap, increment the frequency, if not, add it to the hashmap
            if (numberFrequency.containsKey(reading)) {
                numberFrequency.put(reading, numberFrequency.get(reading) + 1);
            } else {
                numberFrequency.put(reading, 1);
            }
        }

        // Variables and arraylists to store the highest and second highest frequency readings
        // and their frequencies i.e number is 10, and it occurs 3 times
        int highestFreq = 0;
        ArrayList<Integer> highestFreqReadings = new ArrayList<>();
        int secondHighestFreq = 0;
        ArrayList<Integer> secondHighestFreqReadings = new ArrayList<>();

        // Iterate through each entry in the hashmap
        for (Map.Entry<Integer, Integer> entry : numberFrequency.entrySet()) {
            int reading = entry.getKey(); // current reading
            int frequency = entry.getValue(); // frequency of current reading

            // Check if the current frequency is greater than the highest frequency found so far
            if (frequency > highestFreq) {
                // Update the second highest frequency and readings to the previous highest
                secondHighestFreq = highestFreq;
                secondHighestFreqReadings = new ArrayList<>(highestFreqReadings);

                // Update the highest frequency and readings
                highestFreq = frequency;
                highestFreqReadings.clear();
                highestFreqReadings.add(reading);
            } else if (frequency == highestFreq) {
                // If the frequency is equal to the highest frequency, add it to the highest frequency readings list
                highestFreqReadings.add(reading);
            } else if (frequency > secondHighestFreq) {
                // If the frequency is greater than the second highest frequency, update the second highest
                secondHighestFreq = frequency;
                secondHighestFreqReadings.clear();
                secondHighestFreqReadings.add(reading);
            } else if (frequency == secondHighestFreq) {
                // If the frequency is equal to the second highest, add it to the second highest frequency readings list
                secondHighestFreqReadings.add(reading);
            }
        }

        // Initialize variable to store the maximum absolute difference
        int maxDifference = 0;

        // Calculate the maximum absolute difference
        if (highestFreqReadings.size() == 1) {
            // If there is only one highest frequency reading, calculate the difference with each of the second highest frequency readings
            for (int reading : secondHighestFreqReadings) {
                maxDifference = Math.max(maxDifference, Math.abs(highestFreqReadings.get(0) - reading));
            }
        } else {
            // If there are multiple highest frequency readings, calculate the difference among them
            for (int i = 0; i < highestFreqReadings.size(); i++) {
                for (int j = i + 1; j < highestFreqReadings.size(); j++) {
                    maxDifference = Math.max(maxDifference, Math.abs(highestFreqReadings.get(i) - highestFreqReadings.get(j)));
                }
            }
        }

        // Output the result
        System.out.println(maxDifference);
    }
}