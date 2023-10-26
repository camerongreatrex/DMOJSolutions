package Test;

import java.util.Scanner;

public class NumberOnePet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] totalPoints = new int[5];

        for (int i = 0; i < 5; i++) {
            int[] grades = new int[4];
            for (int j = 0; j < 4; j++) {
                grades[j] = scanner.nextInt();
            }

            for (int j = 0; j < 4; j++) {
                totalPoints[i] += grades[j];
            }
        }

        int winner = 0;
        int maxPoints = totalPoints[0];

        for (int i = 1; i < 5; i++) {
            if (totalPoints[i] > maxPoints) {
                winner = i;
                maxPoints = totalPoints[i];
            }
        }

        System.out.println((winner + 1) + " " + maxPoints);
    }
}