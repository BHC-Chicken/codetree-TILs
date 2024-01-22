import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        long[] dp = new long[1001];

        dp[0] = 1;
        dp[1] = 2;

        for(int i = 2; i <= num; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3) % 1000000007;
            for(int j = i - 3; j >= 0; j--) {
                dp[i] = (dp[i] + (dp[j] * 2) % 1000000007) % 1000000007;
            }
        }

        System.out.println(dp[num]);
    }
}