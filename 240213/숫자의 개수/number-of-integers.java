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
            int target = Integer.parseInt(br.readLine());
            int left = 0;
            int right = n - 1;
            int lowerIndex = n;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] >= target) {

                    lowerIndex = Math.min(lowerIndex, mid);

                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            left = 0;
            right = n - 1;
            int upperIndex = n;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arr[mid] > target) {
                    upperIndex = Math.min(upperIndex, mid);

                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            sb.append(upperIndex - lowerIndex).append("\n");
        }

        System.out.println(sb);
    }
}