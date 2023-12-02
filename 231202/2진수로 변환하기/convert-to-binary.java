import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int count = 0;
        int[] arr = new int[20];
        int n = Integer.parseInt(br.readLine());

        while (true) {
            if (n < 2) {
                arr[count++] = n;
                break;
            }

            arr[count++] = n % 2;
            n /= 2;
        }

        for (int i = count - 1; i >=  0 ; i--) {
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}