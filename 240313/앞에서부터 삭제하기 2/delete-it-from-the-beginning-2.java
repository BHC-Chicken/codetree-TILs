import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        double sum = 0;
        double result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        queue.add(arr[n - 1]);
        sum += arr[n - 1];

        for (int i = n - 2; i >= 1; i--) {
            queue.add(arr[i]);
            sum += arr[i];

            double avg = (sum - queue.peek()) / (n - i - 1);

            result = Math.max(avg, result);
        }

        System.out.printf("%.2f", result);
    }
}