import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            int target = Integer.parseInt(br.readLine());
            boolean success = false;
            int index = -1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] == target) {
                    sb.append(mid + 1).append("\n");
                    success = true;
                    break;
                }

                if (arr[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (!success) {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}