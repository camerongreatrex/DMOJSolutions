package Test.MiscDMOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlpacaShapes {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num[] = new int[2];
        String[] strNums;
        strNums = br.readLine().split(" ");
        for (int i = 0; i < strNums.length; i++) {
            num[i] = Integer.parseInt(strNums[i]);
        }
        if (Math.pow(num[0], 2) > 3.14 * Math.pow(num[1], 2)) {
            System.out.println("SQUARE");
        } else if (Math.pow(num[0], 2) < 3.14 * Math.pow(num[1], 2)) {
            System.out.println("CIRCLE");
        }
    }
}
