package Test.MiscDMOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contest6Problem8 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine()), y = Integer.parseInt(br.readLine());
        System.out.println(x*y);
    }
}
