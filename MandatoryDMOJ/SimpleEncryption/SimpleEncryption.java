package Test.MandatoryDMOJ.SimpleEncryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SimpleEncryption {
    public static void main(String[] args) throws IOException {
        //create the buffered reader for input in the program
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // read the keyword and message
        String encryptor = br.readLine();
        // remove everything but A-Z and replace it with nothing
        String encrypting = br.readLine().replaceAll("[^A-Z]", "");
        // create a HashMap to store the shift value for each letter based on the keyword
        HashMap<Character, Integer> letterShiftValues = new HashMap<>();
        //iterate through all letters of the encryptor
        for (int i = 0; i < encryptor.length(); i++) {
            //set hashmap values for every inputted encryptor letter to the corresponding int value
            char currentChar = encryptor.charAt(i);
            int shiftValue = currentChar - 'A';
            letterShiftValues.put(currentChar, shiftValue);
        }
        // calculate the height of the block based on the length of the message and the
        // keyword while ensuring there is too much space rather than not enough (math.ceil)
        int blockHeight = (int) Math.ceil((double) encrypting.length() / encryptor.length());
        // create a 2d array resembling the block from dmoj which is the size of the minimum block and encryptor
        char[][] block = new char[blockHeight][encryptor.length()];
        // create the message block in the format from dmoj
        int index = 0;
        for (int i = 0; i < blockHeight; i++) {
            for (int j = 0; j < encryptor.length(); j++) {
                //fill the block array with a single encrypting letter until the length of the string is
                // surpassed by the index, therefore there are no more letters
                if (index < encrypting.length()) {
                    block[i][j] = encrypting.charAt(index++);
                } else {
                    block[i][j] = ' ';
                }
            }
        }
        // create new char array for the encrypted values
        char[] encryptedMessage = new char[encrypting.length()];
        int encryptedIndex = 0;
        // encrypt the message based on the keyword by iterating through the block array
        for (int i = 0; i < blockHeight; i++) {
            for (int j = 0; j < encryptor.length(); j++) {
                //find the int value for the shift
                int shift = letterShiftValues.get(encryptor.charAt(j));
                //get the current char in the loop
                char currentChar = block[i][j];
                //if the current char has a value, shift the value and assign the shifted value to the
                // changed block array value
                if (currentChar != ' ') {
                    int shiftedIndex = (currentChar - 'A' + shift) % 26;
                    block[i][j] = (char) ('A' + shiftedIndex);
                    encryptedMessage[encryptedIndex++] = block[i][j];
                }
            }
        }
        // print the encrypted message
        System.out.println(new String(encryptedMessage));
    }
}
