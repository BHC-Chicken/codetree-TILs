import java.io.*;
import java.util.*;

public class Main {
    static long num;
    static long a;
    static long b;

    static int binarySearch(long target) {
        long left = 1;
        long right = num;
        int count = 1;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid == target) {
                return count; 
            }

            if (mid >= target) {
                right = mid - 1;
            
            } else {
                left = mid + 1;
            }

            count += 1;
        }

        return - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        num = Long.parseLong(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        long min = Long.MAX_VALUE;
        long max = -1;

        for (long i = a; i <= b; i++) {
            int search = binarySearch(i);

            min = Math.min(min, search);
            max = Math.max(max, search);
        }

        sb.append(min).append(" ").append(max);

        System.out.println(sb);
    }
}