import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;

    static boolean isPossible(int maxDiv) {
        int part = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] < maxDiv) {
                return false;
            }
            int num = arr[i];

            while (num >= maxDiv) {
                num -= maxDiv;
                part++;
            }
        }

        return part >= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int minValue = Integer.MAX_VALUE;
        int result = 0;

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            minValue = Math.min(minValue, arr[i]);
        }

        int left = 1;
        int right = minValue;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (isPossible(mid)) {
                left = mid + 1;
                result = Math.max(result, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}