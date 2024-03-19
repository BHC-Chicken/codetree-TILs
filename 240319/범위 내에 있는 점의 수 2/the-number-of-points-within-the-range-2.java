import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        sum = new int[1000001];
        arr = new int[1000001];

        sum[0] = 0;
        arr[0] = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[num] = 1;
        }

        if (arr[0] == 1) {
            sum[0] = 1;
        }

        for (int i = 1; i <= 1000000; i++) {
            if (arr[i] == 1) {
                sum[i] = sum[i - 1] + 1;
            } else {
                sum[i] = sum[i - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (s == 0) {
                sb.append(sum[e]).append("\n");
            } else {
                sb.append(sum[e] - sum[s - 1]).append("\n");
            }
        }

        System.out.println(sb);
    }
}