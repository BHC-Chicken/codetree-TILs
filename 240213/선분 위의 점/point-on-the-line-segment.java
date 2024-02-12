import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;

    static int upperCase(int x) {
        int left = 0;
        int right = n - 1;
        int index = n;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] > x) {
                index = Math.min(index, mid);

                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return index;
    }

    static int lowerCase(int x) {
        int left = 0;
        int right = n - 1;
        int index = n;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= x) {
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

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(upperCase(end) - lowerCase(start)).append("\n");
        }

        System.out.println(sb);
    }
}