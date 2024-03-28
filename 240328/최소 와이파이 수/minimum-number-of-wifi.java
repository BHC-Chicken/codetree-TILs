import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];

        int count = 0;
        int result = 0;
        int oneCount = 0;

        if (n <= m) {
            System.out.println(1);

            return;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            if (num == 1) {
                oneCount++;
            }
        }

        if (m == 0) {
            System.out.println(oneCount);

            return;
        }

        boolean check = false;

        for (int i = 1; i <= n ; i++) {
            if (arr[i] == 1 && !check) {
                count++;
                check = true;
            } else {
                if (count == m + 1) {
                    result++;
                    i += (count - 1);

                    check = false;
                    count = 0;
                }
                count++;
            }
        }

        System.out.println(result);
    }
}