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
        short possibilityCount = 0;

        for (byte troutCount = 0; troutCount * troutValue <= maxPoints; troutCount++) {
            for (byte pikeCount = 0; pikeCount * pikeValue <= maxPoints; pikeCount++) {
                for (byte pickerelCount = 0; pickerelCount * pickerelValue <= maxPoints; pickerelCount++) {
                    int totalPoints = troutCount * troutValue + pikeCount * pikeValue + pickerelCount * pickerelValue;
                    if (totalPoints <= maxPoints && (troutCount > 0 || pikeCount > 0 || pickerelCount > 0)) {
                        possibilityCount++;
                        System.out.println(troutCount + " Brown Trout, " + pikeCount + " Northern Pike, " + pickerelCount + " Yellow Pickerel");
                    }
                }
            }
        }
        System.out.println("Number of ways to catch fish: " + possibilityCount);
    }
}

//        //trout points if only trouts
//        for (int i = troutValue, k = 1; i <= maxPoints; i += troutValue, k++) {
//            possiblityCount++;
//            System.out.println(k + " Brown Trout, 0 Northern Pike, 0 Yellow Pickerel");
//        }
//        //pike points if only pikes
//        for (int i = pikeValue, k = 1; i <= maxPoints; i += pikeValue, k++) {
//            possiblityCount++;
//            System.out.println("0 Brown trout, " + k + " Northern Pike, 0 Yellow Pickerel");
//        }
//        //pickerel points if only pikes
//        for (int i = pickerelValue, k = 1; i <= maxPoints; i += pickerelValue, k++) {
//            possiblityCount++;
//            System.out.println("0 Brown trout, 0 Northern Pike, " + k + " Yellow Pickerel");
//        }
//        System.out.println("Number of ways to catch fish: " + possiblityCount);
