package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AromaticNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int result = calculateAromaticNumberValue(input);
        System.out.println(result);
    }

    public static int calculateAromaticNumberValue(String input) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int totalValue = 0;
        int i = 0;

        while (i < input.length()) {
            char currentChar = input.charAt(i);
            int currentValue = Character.getNumericValue(currentChar);
            char romanSymbol = input.charAt(i + 1);

            if (i < input.length() - 2) {
                char nextRomanSymbol = input.charAt(i + 3);
                if (romanValues.get(nextRomanSymbol) > romanValues.get(romanSymbol)) {
                    totalValue -= currentValue * romanValues.get(romanSymbol);
                } else {
                    totalValue += currentValue * romanValues.get(romanSymbol);
                }
            } else {
                totalValue += currentValue * romanValues.get(romanSymbol);
            }

            i += 2;
        }

        return totalValue;
    }
}