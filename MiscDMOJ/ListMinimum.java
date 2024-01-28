package Test.MiscDMOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ListMinimum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Read the size of the list.
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt()); // Add elements to the list.
        }
        Collections.sort(list); // Sort the list.
        while (!list.isEmpty()) {
            System.out.println(list.remove(0)); // Print and remove the smallest element.
        }
        sc.close(); // Close the Scanner.
    }
}
