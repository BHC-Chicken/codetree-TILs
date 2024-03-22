import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        String[] matches = new String[n];
        int[] L = new int[n];
        int[] R = new int[n];

        for (int i = 0; i < n; i++) {
            matches[i] = br.readLine();
        }

        String shapes = "PHS";

        for(int i = 0; i < 3; i++) {
            char shape = shapes.charAt(i);
            int count = 0;

            for (int j = 0; j < n; j++) {
                if(matches[j].equals(String.valueOf(shape))) {
                    count++;
                }

                L[j] = Math.max(L[j], count);
            }
        }

        for(int i = 0; i < 3; i++) {
            char shape = shapes.charAt(i);
            int count = 0;

            for (int j = n - 1; j >= 0; j--) {
                if(matches[j].equals(String.valueOf(shape))) {
                    count++;
                }

                R[j] = Math.max(R[j], count);
            }
        }

        for (int i = 0; i < n - 1;i++) {
            result = Math.max(result, L[i] + R[i + 1]);
        }

        System.out.println(result);
    }
}