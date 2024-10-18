import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());

        long left = 1;
        long right = 2000000000;

        long maxNum = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid * (mid + 1) / 2 <= num) {
                left = mid + 1;
                maxNum = Math.max(maxNum, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(maxNum);
    }
}