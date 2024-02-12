import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static int a;
    static int b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = a; i <= b; i++) {
            int left = 1;
            int right = m;
            int count = 0;

            while (left <= right) {
                int mid = (left + right) / 2;
                count++;

                if (mid == i) {
                    max = Math.max(max, count);
                    min = Math.min(min, count);

                    break;
                }

                if (mid > i) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        System.out.println(min + " " + max);
    }
}