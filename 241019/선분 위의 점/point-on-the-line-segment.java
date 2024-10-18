import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] map;

    static int lower(int target) {
        int left = 1;
        int right = n;
        int index = n + 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (map[mid] >= target) {
                index = Math.min(index, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

    static int upper(int target) {
        int left = 1;
        int right = n;
        int index = n + 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (map[mid] > target) {
                index = Math.min(index, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int lower = lower(start);
            int upper = upper(end);

            sb.append(upper - lower).append("\n");
        }

        System.out.println(sb);
    }
}