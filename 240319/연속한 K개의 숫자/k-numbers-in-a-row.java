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

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int result = Integer.MAX_VALUE;
        int count = Integer.MAX_VALUE;

        sum = new int[n + 1];
        arr = new int[n + 1];

        sum[0] = 0;
        arr[0] = 0;

        for (int i = 0; i < b; i++) {
            arr[Integer.parseInt(br.readLine())] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 1) {
                sum[i] = sum[i - 1] + i;
            } else {
                sum[i] = sum[i - 1];
            }
        }


        for (int i = k; i <= n; i++) {
            int num = sum[i] - sum[i - k];

            if (result > num) {
                result = num;
                int temp = 0;

                for (int j = i - k + 1; j <= i; j++) {
                    if (arr[j] == 1) {
                        temp++;
                    }
                }

                count = Math.min(count, temp);
            }
        }

        System.out.println(count);
    }
}