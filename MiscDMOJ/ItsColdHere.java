package Test.MiscDMOJ;

import java.util.Scanner;

public class ItsColdHere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String coldestCity = "";
        int lowestTemperature = Integer.MAX_VALUE;

        while (scanner.hasNext()) {
            String city = scanner.next();
            int temperature = scanner.nextInt();

            if (temperature < lowestTemperature) {
                lowestTemperature = temperature;
                coldestCity = city;
            }

            if (city.equals("Waterloo")) {
                break;
            }
        }

        System.out.println(coldestCity);
        scanner.close();
    }
}