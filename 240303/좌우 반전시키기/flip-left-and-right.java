import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] arr = br.readLine().replaceAll(" ", "").toCharArray();
        boolean reverse = false;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                count++;
                i++;

                if (i >= n) {
                    break;
                }

                arr[i] = arr[i] == '0' ? '1' : '0';
            }
        }

        if (arr[n - 1] == '0') {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}