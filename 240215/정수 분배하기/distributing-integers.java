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
            part += arr[i] / maxDiv;
        }

        return part >= m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int result = 0;

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int left = 1;
        int right = 100000;

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