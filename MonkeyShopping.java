package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MonkeyShopping {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num[] = new int[4];
        String[] strNums;
        strNums = br.readLine().split(" ");
        for (int i = 0; i < strNums.length; i++) {
            num[i] = Integer.parseInt(strNums[i]);
        }
        if (num[0] >= num[1] && num[2] >= num[3]) {
            System.out.println("Stay home");
        } else if (num[0] < num[1] && num[2] < num[3]) {
            System.out.println("Go to the department store");
        } else if (num[0] < num[1] && num[2] >= num[3]) {
            System.out.println("Go to the grocery store");
        } else if (num[2] < num[3] && num[0] >= num[1]) {
            System.out.println("Go to the pharmacy");
        }
    }
}
