package Test.MiscDMOJ;

import java.util.Scanner;
import java.lang.Math;

public class Cookies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }

        double maxDiameter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = Math.sqrt(Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2));
                if (distance > maxDiameter) {
                    maxDiameter = distance;
                }
            }
        }

        System.out.printf("%.2f\n", maxDiameter);
        scanner.close();
    }
}
