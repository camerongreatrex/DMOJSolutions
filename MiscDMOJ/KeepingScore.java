package Test.MiscDMOJ;

import java.util.Scanner;

public class KeepingScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        char[] splitString = inputString.toCharArray();
        int totalPoints = 0;
        int clubs = 0, diamonds = 0, hearts = 0, spades = 0;
        int[] suitLength = new int[4];

        for (int i = 0; i < splitString.length; i++) {
            if (splitString[i] == 'C') {
                suitLength[0] = i;
            }
            if (splitString[i] == 'D') {
                suitLength[1] = i;
            }
            if (splitString[i] == 'H') {
                suitLength[2] = i;
            }
            if (splitString[i] == 'S') {
                suitLength[3] = i;
            }
        }
        System.out.println("Cards Dealt             Points");
        System.out.print("Clubs ");
        int clubsCount = suitLength[1] - suitLength[0] - 1;
        for (int i = suitLength[0] + 1; i < suitLength[1]; i++) {
            System.out.print(splitString[i] + " ");
            switch (splitString[i]) {
                case 'A':
                    clubs += 4;
                    break;
                case 'K':
                    clubs += 3;
                    break;
                case 'Q':
                    clubs += 2;
                    break;
                case 'J':
                    clubs += 1;
                    break;
            }
        }
        clubs += calculateVoidSingletonDoubleton(clubsCount);

        System.out.println("        " + clubs);

        System.out.print("Diamonds ");
        int diamondsCount = suitLength[2] - suitLength[1] - 1;
        for (int i = suitLength[1] + 1; i < suitLength[2]; i++) {
            System.out.print(splitString[i] + " ");
            switch (splitString[i]) {
                case 'A':
                    diamonds += 4;
                    break;
                case 'K':
                    diamonds += 3;
                    break;
                case 'Q':
                    diamonds += 2;
                    break;
                case 'J':
                    diamonds += 1;
                    break;
            }
        }
        diamonds += calculateVoidSingletonDoubleton(diamondsCount);

        System.out.println("        " + diamonds);

        // Similar calculations for hearts
        System.out.print("Hearts ");
        int heartsCount = suitLength[3] - suitLength[2] - 1;
        for (int i = suitLength[2] + 1; i < suitLength[3]; i++) {
            System.out.print(splitString[i] + " ");
            switch (splitString[i]) {
                case 'A':
                    hearts += 4;
                    break;
                case 'K':
                    hearts += 3;
                    break;
                case 'Q':
                    hearts += 2;
                    break;
                case 'J':
                    hearts += 1;
                    break;
            }
        }
        hearts += calculateVoidSingletonDoubleton(heartsCount);

        System.out.println("        " + hearts);

        // Similar calculations for spades
        System.out.print("Spades ");
        int spadesCount = splitString.length - suitLength[3] - 1;
        for (int i = suitLength[3] + 1; i < splitString.length; i++) {
            System.out.print(splitString[i] + " ");
            switch (splitString[i]) {
                case 'A':
                    spades += 4;
                    break;
                case 'K':
                    spades += 3;
                    break;
                case 'Q':
                    spades += 2;
                    break;
                case 'J':
                    spades += 1;
                    break;
            }
        }
        spades += calculateVoidSingletonDoubleton(spadesCount);

        System.out.println("        " + spades);

        totalPoints += clubs + diamonds + hearts + spades;
        System.out.println("                Total " + totalPoints);
    }

    // Function to calculate void, singleton, doubleton
    public static int calculateVoidSingletonDoubleton(int count) {
        if (count == 0) {
            return 3; // Void
        } else if (count == 1) {
            return 2; // Singleton
        } else if (count == 2) {
            return 1; // Doubleton
        } else {
            return 0; // No void, singleton, or doubleton
        }
    }
}
