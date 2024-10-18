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
                if (map[left] == find) {
                    flag = false;
                    sb.append(left).append("\n");
                    break;
                }

                if (map[left] < find) {
                    left++;
                } else {
                    right--;
                }
            }

            if (flag) {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}