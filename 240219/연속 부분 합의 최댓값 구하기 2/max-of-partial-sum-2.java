import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            result = Math.max(result, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        System.out.println(result);
    }
}