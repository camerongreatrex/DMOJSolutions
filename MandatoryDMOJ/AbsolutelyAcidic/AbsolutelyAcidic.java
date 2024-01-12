package Test.MandatoryDMOJ.AbsolutelyAcidic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AbsolutelyAcidic {

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

        // Variables to store the most and second most frequent readings
        int mostFrequentReading = 0;
        int secondMostFrequentReading = 0;

        // Find the most and second most frequent readings
        for (int i = 0; i < sensors; i++) {

        }

        // Calculate and print the absolute difference
        System.out.println(Math.abs(mostFrequentReading - secondMostFrequentReading));
    }
}
