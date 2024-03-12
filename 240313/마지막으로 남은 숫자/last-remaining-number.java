import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            queue.add(-Integer.parseInt(st.nextToken()));
        }

        while (queue.size() > 1) {
            int num1 = -queue.poll();
            int num2 = -queue.poll();
            int sum = Math.abs(num1 - num2);

            if (sum == 0) {
                continue;
            }

            queue.add(sum);
        }

        if (queue.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(queue.poll());
        }
    }
}