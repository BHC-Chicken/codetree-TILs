import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new int[4][n + 1];
        sum = new int[4][n + 1];

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());

            arr[num][i] = 1;
        }

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1) {
                    sum[i][j] = sum[i][j - 1] + 1;
                } else {
                    sum[i][j] = sum[i][j - 1];
                }
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int count1 = sum[1][e] - sum[1][s - 1];
            int count2 = sum[2][e] - sum[2][s - 1];
            int count3 = sum[3][e] - sum[3][s - 1];

            sb.append(count1).append(" ").append(count2).append(" ").append(count3).append("\n");
        }

        System.out.println(sb);
    }
}