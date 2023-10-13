package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class KoalaKonundrum {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        char[] wordArray = br.readLine().toCharArray();
        HashMap<Character, Integer> letterCountMap = new HashMap<>();
        int oddCount = 0;
        if (wordArray.length <= size) {
            for (char c : wordArray) {
                letterCountMap.put(c, letterCountMap.getOrDefault(c, 0) + 1);
            }
            for (int count : letterCountMap.values()) {
                if (count % 2 != 0) {
                    oddCount++;
                }
            }
            System.out.println(Math.max(1, oddCount));
        }
    }
}
