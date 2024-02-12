import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long m;
    static long a;
    static long b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        for (long i = a; i <= b; i++) {
            long left = 1;
            long right = m;
            long count = 0;

            while (left <= right) {
                long mid = (left + right) / 2;
                count++;

                if (mid == i) {
                    max = Math.max(max, count);
                    min = Math.min(min, count);

                    break;
                }

                if (mid > i) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        System.out.println(min + " " + max);
    }
}