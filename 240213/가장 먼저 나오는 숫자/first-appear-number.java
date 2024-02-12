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
        int[] q = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            q[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int target = q[i];
            int left = 0;
            int right = n - 1;
            int lowerIndex = n;
            boolean success = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] == target) {
                    success = true;
                }

                if (arr[mid] >= target) {
                    lowerIndex = Math.min(lowerIndex, mid);

                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (!success) {
                sb.append(-1).append("\n");
            } else {
                sb.append(lowerIndex + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}