import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        long[] arr = new long[1001];

        arr[0] = 0;
        arr[1] = 2;
        arr[2] = 7;
        arr[3] = 22;

        for (int i = 4; i <= num; i++) {
            arr[i] = (arr[i - 1] * 3 + arr[i - 2] - arr[i - 3]) % 1000000007;
        }

        System.out.println(arr[num]);
    }
}