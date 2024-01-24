import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;

    public static int maximizeMinValue() {
        int N = arr.length;
        int[][] dp = new int[N][N];
        dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.max(Math.min(dp[i - 1][0], arr[i][0]), dp[i][0]);
            dp[0][i] = Math.max(Math.min(dp[0][i - 1], arr[0][i]), dp[0][i]);
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.max(
                        Math.min(dp[i - 1][j], arr[i][j]),
                        Math.min(dp[i][j - 1], arr[i][j])
                );
            }
        }

        return dp[N - 1][N - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(maximizeMinValue());
    }
}