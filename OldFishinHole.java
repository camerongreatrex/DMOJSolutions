package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OldFishinHole {
    public static void main(String[] args) throws IOException {
        //declare and initialize variables for the program
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //uses byte and short to minimize memory usage for the inputs
        byte troutValue = Byte.parseByte(br.readLine());
        byte pikeValue = Byte.parseByte(br.readLine());
        byte pickerelValue = Byte.parseByte(br.readLine());
        short maxPoints = Short.parseShort(br.readLine());
        short possiblityCount = 0;
        //for loop to calculate the different combinations to catch fish under the total points
        for(int i = 1; i <= maxPoints; i++) {
            if(troutValue*i <= maxPoints) {
                possiblityCount++;
            }
        }
        System.out.println(possiblityCount);
    }
}
