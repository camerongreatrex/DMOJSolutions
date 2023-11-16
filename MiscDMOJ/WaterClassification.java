package Test.MiscDMOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaterClassification {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short t = Short.parseShort(br.readLine());
        if(t <= 0) {
            System.out.println("S");
        } else if(t > 0 && t < 100) {
            System.out.println("L");
        } else if(t>=100) {
            System.out.println("G");
        }
    }
    
}
