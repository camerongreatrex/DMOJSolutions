package Test.MandatoryDMOJ.SimpleEncryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleEncryptionFinal {
    public static void main(String[] args) throws IOException {
        // create the buffered reader for input in the program
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // read the keyword and message
        String encryptor = br.readLine().trim();
        // remove everything but A-Z and replace it with nothing
        String encrypting = br.readLine().trim().replaceAll("[^A-Z]", "");
        // calculate the height of the block based on the length of the message and the
        // keyword while ensuring there is too much space rather than not enough (math.ceil)
        int blockHeight = (int) Math.ceil((double) encrypting.length() / encryptor.length());
        //index that doesn't change in the loop, but when the current char changes
        int index = 0;
        // encrypt the message based on the keyword by iterating through the block array
        for (int i = 0; i < blockHeight; i++) {
            for (int j = 0; j < encryptor.length(); j++) {
                // fill the block array with a single encrypting letter until the length of the string is
                // surpassed by the index, therefore there are no more letters
                if (index < encrypting.length()) {
                    // current char is the non-encrypted user inputted value at a certain index
                    char currentChar = encrypting.charAt(index++);
                    // calculate the shift value based on the current letter of the encryptor
                    int shift = encryptor.charAt(j) - 'A';
                    // find the int value of the shift to add to make the new encrypted value
                    int shiftedIndex = (currentChar - 'A' + shift) % 26;
                    // encrypt the character by shifting its ASCII value
                    char encryptedChar = (char) ('A' + shiftedIndex);
                    // print the encrypted character
                    System.out.print(encryptedChar);
                }
            }
        }
    }
}