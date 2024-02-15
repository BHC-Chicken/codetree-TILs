import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long isPossible(long num) {
        return num - num / 3 - num / 5 + num / 15;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long left = 1;
        long right = 2000000000;
        long result = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (isPossible(mid) >= n) {
                right = mid - 1;
                result = Math.min(result, mid);
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}