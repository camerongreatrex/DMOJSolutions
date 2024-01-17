package Test.MiscDMOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MedianMark {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int marksCount = Integer.parseInt(br.readLine());
        int[] marks = new int[marksCount];
        for (int i = 0; i < marksCount; i++) {
            marks[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(marks);

        double median;
        if (marksCount % 2 == 0) {
            // For even number of marks, average of middle two marks
            median = (marks[marksCount / 2 - 1] + marks[marksCount / 2]) / 2.0;
        } else {
            // For odd number of marks, middle mark
            median = marks[marksCount / 2];
        }

        // Round to nearest integer
        System.out.println((int) Math.round(median));
    }
}
