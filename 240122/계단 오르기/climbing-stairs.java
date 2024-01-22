import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] arr = new int[1001];

        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 1;

        for (int i = 5; i <= num; i++) {
            arr[i] = (arr[i - 2] + arr[i - 3]) % 10007;
        }

        System.out.println(arr[num]);
    }
}