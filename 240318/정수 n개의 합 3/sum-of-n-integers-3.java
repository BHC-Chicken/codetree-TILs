import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int n;
    static int k;

    static boolean inRange(int x1, int y1) {
        return x1 <= n && y1 <= n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()) - 1;
        arr = new int[n + 1][n + 1];

        int result = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {

                if (inRange(i + k, j + k)) {
                    result = Math.max(result,
                            arr[i + k][j + k] - arr[i - 1][j + k] - arr[i + k][j - 1] + arr[i - 1][j - 1]);
                }

            }
        }

        System.out.println(result);
    }
}