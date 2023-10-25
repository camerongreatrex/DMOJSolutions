package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class APlusBWarmup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr= new int[2];
        String[] s1 = s.split(" ");
        for(int i=0;i<2;i++)
        {
            arr[i]=Integer.parseInt(s1[i]);
        }
        System.out.println("" + arr[0]+arr[1]);
    }
}