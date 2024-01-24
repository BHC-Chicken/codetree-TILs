import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] dp;
    static int n;

    static void init() {
        dp[0][n - 1] = arr[0][n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[0][i] = dp[0][i + 1] + arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            dp[i][n - 1] = dp[i - 1][n - 1] + arr[i][n - 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        init();

        for (int i = 1; i < n; i++) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j + 1]) + arr[i][j];
            }
        }

        int result = Integer.MAX_VALUE;
        int y = 0;

        for (int i = 0; i < n; i++) {
            if (result > dp[n - 1][i]) {
                result = dp[n - 1][i];
                y = i;
            }
        }

        System.out.println(dp[n - 1][0]);
    }
}