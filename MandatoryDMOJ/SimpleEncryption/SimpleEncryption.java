package Test.MandatoryDMOJ.SimpleEncryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SimpleEncryption {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // read the keyword and message
        String encryptor = br.readLine();
        // remove everything but A-Z and replace it with nothing
        String encrypting = br.readLine().replaceAll("[^A-Z]", "");

        // calculate the height of the block based on the length of the message and the
        // keyword
        int blockHeight = (int) Math.ceil((double) encrypting.length() / encryptor.length());
        // create a 2d array resembling the block from dmoj which is the size of the minimum block and encryptor
        char[][] block = new char[blockHeight][encryptor.length()];

        // create the message block in the format from dmoj
        int index = 0;
        for (int i = 0; i < blockHeight; i++) {
            for (int j = 0; j < encryptor.length(); j++) {
                block[i][j] = (index < encrypting.length()) ? encrypting.charAt(index++) : ' ';
            }
        }

        // display the block
        for (char[] row : block) {
            for (char c : row) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }

        br.close();
    }
}
