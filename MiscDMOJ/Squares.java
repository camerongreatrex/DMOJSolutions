package Test.MiscDMOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Squares {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        short tiles = Short.parseShort(br.readLine());
        short maxSideLength = 0;
        if (Math.sqrt(tiles) % 1 != 0) {
            maxSideLength = (short) Math.round(Math.ceil(Math.sqrt(tiles) - 1));
            System.out.println("The largest square has side length " + maxSideLength + ".");
        } else {
            maxSideLength = (short) Math.sqrt(tiles);
            System.out.println("The largest square has side length " + maxSideLength + ".");
        }



        //OPTIMAL SOLUTION
//        Scanner sc = new Scanner(System.in);
//        short tiles = sc.nextShort();
//        short maxSideLength = (short) Math.sqrt(tiles);
//        System.out.print("The largest square has side length " + (maxSideLength) + ".");
    }
}
