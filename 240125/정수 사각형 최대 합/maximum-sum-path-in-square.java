import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] dp;
    static int n;

    static void init() {
        dp[0][0] = arr[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }

        for (int i = 1; i < n; i++) {
            dp[i][i] = dp[i - 1][i - 1] + arr[i][i];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
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
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j-1], dp[i - 1][j]) + arr[i][j];
            }
        }
        int result = -1;
        int y = 0;

        for (int i = 0; i < n; i++) {
            if (result < dp[n - 1][i]) {
                result = dp[n - 1][i];
                y = i;
            }
        }
        y++;
        for (int i = y; i < n; i++) {
            result += arr[n - 1][i];
        }

        System.out.println(result);

    }
}