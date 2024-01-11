package Test.MandatoryDMOJ.AbsolutelyAcidic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbsolutelyAcidic {

    public static void main(String[] args) throws IOException {

        //TODO: simple test cases from dmoj do not work, the test case 4 does not work and prints 408

        // BufferedReader to read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Read the number of sensors
        int sensors = Integer.parseInt(br.readLine());
        // Arrays to store sensor readings and their frequencies
        int[] readings = new int[sensors];
        int[] frequencies = new int[1001]; // Assuming readings are in the range [0, 1000]

        // Input sensor readings and update frequencies
        for (int i = 0; i < sensors; i++) {
            readings[i] = Integer.parseInt(br.readLine());
            frequencies[readings[i]]++;
        }

        // Variables to store the most and second most frequent readings
        int mostFrequentReading = -1;
        int secondMostFrequentReading = -1;

        // Find the most and second most frequent readings
        for (int i = 0; i < frequencies.length; i++) {
            // Most frequent reading
            if (mostFrequentReading == -1 || frequencies[i] > frequencies[mostFrequentReading]) {
                secondMostFrequentReading = mostFrequentReading;
                mostFrequentReading = i;
                // Second most frequent reading
            } else if (secondMostFrequentReading == -1 || frequencies[i] > frequencies[secondMostFrequentReading]) {
                secondMostFrequentReading = i;
            }
        }

        // Calculate and print the absolute difference
        System.out.println(Math.abs(mostFrequentReading - secondMostFrequentReading));
    }
}
