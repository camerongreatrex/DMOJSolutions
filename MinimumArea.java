package Test;

import java.util.Scanner;

public class MinimumArea {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] points = new int[n][2];

        // read the coordinates of the points
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        int minSquareArea = Integer.MAX_VALUE;

        // iterate through all pairs of points
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                // calculate the side length of the square to cover these two points
                int sideLength = Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
                // calculate the area of the square
                int squareArea = sideLength * sideLength;
                // update the minimum square area
                minSquareArea = Math.min(minSquareArea, squareArea);
            }
        }

        // Output the minimum square area
        System.out.println(minSquareArea);
    }
}