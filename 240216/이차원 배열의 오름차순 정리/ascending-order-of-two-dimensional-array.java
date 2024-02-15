import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long n;
    static long k;

    static long find(long num) {
        long count = 0;
        for (int i = 1; i <= n; i++) {
            count += Math.min(num / i, n);
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Long.parseLong(br.readLine());

        long left = 1;
        long right = k;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long temp = find(mid);

            if (temp < k) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}