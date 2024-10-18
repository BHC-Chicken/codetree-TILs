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

        int[] map = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(br.readLine());
            int left = 1;
            int right = n;
            boolean flag = true;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (map[mid] == find) {
                    flag = false;
                    sb.append(mid).append("\n");
                    break;
                }

                if (map[mid] < find) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (flag) {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}