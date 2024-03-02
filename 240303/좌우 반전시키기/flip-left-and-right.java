import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().replaceAll(" ", "").toCharArray();
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == '0') {
                count++;

                arr[i] = arr[i] == '0' ? '1' : '0';
                if (i + 1 < n) {
                    arr[i + 1] = arr[i + 1] == '0' ? '1' : '0';
                }
            }
        }

        if (arr[n - 1] == '0') {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}