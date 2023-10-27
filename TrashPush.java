package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TrashPush {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short t = Short.parseShort(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // Number of unique fireworks
            int k = Integer.parseInt(st.nextToken()); // Maximum wrappers per trash can
            int trashCans = (n + k - 1) / k; // Calculate the number of trash cans needed
            System.out.println(trashCans);

        }
    }
}





