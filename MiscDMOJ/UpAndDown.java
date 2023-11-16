package Test.MiscDMOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpAndDown {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        byte a = Byte.parseByte(br.readLine());
        byte b = Byte.parseByte(br.readLine());
        byte c = Byte.parseByte(br.readLine());
        byte d = Byte.parseByte(br.readLine());
        short s = Short.parseShort(br.readLine());
        int displacementN = 0;
        int displacementB = 0;
        for (int i = 1; i <= s; i++) {
            if (i % (a + b) <= a && i % (c + d) <= c) {
                displacementN++;
                displacementB++;
            } else if (i % (a + b) <= a) {
                displacementN++;
            } else if (i % (c + d) <= c) {
                displacementB++;
            }
        }

        if (displacementN > displacementB) {
            System.out.println("Nikky");
        } else if (displacementB > displacementN) {
            System.out.println("Byron");
        } else {
            System.out.println("Tied");
        }
    }
}