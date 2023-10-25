package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DistinctYears {
    public static void main(String[] args) throws IOException {
        //declare and initialize variables for the program
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //uses short to minimize memory usage for the inputs
        short year = Short.parseShort(br.readLine());
        int nextYear = year + 1;
        //keep increasing the year until a distinct year in found
        while (!hasDistinctDigits(nextYear)) {
            nextYear++;
        }
        //print the next distinct year
        System.out.println(nextYear);
    }

    // function to check if a year has distinct digits
    public static boolean hasDistinctDigits(int year) {
        String yearStr = String.valueOf(year);
        for (int i = 0; i < yearStr.length(); i++) {
            for (int j = i + 1; j < yearStr.length(); j++) {
                if (yearStr.charAt(i) == yearStr.charAt(j)) {
                    return false; // Digits are not distinct
                }
            }
        }
        return true; // digits are distinct
    }
}
