import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long left = 1;
        long right = (long) Math.ceil(num);
        long result = -1;

        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid * (mid + 1) / 2 <= num) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}