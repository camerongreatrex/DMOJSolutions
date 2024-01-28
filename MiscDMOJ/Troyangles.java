package Test.MiscDMOJ;

import java.util.Scanner;

public class Troyangles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the remaining newline

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim().replaceAll(" ", "");
            grid[i] = line.toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count += countTrianglesAt(grid, i, j, n);
            }
        }

        System.out.println(count);
    }

    private static int countTrianglesAt(char[][] grid, int row, int col, int n) {
        int count = 0;
        for (int h = 1; h + row <= n; h++) {
            if (isTriangle(grid, row, col, h)) {
                count++;
            } else {
                break; // No larger triangle possible at this point
            }
        }
        return count;
    }

    private static boolean isTriangle(char[][] grid, int row, int col, int height) {
        for (int i = 0; i < height; i++) {
            int start = col - i;
            int end = col + i;
            if (start < 0 || end >= grid.length) return false;
            for (int j = start; j <= end; j++) {
                if (grid[row + i][j] != '#') return false;
            }
        }
        return true;
    }
}