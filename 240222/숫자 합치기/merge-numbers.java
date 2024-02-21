import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        while (st.hasMoreTokens()) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int result = 0;

        while (!queue.isEmpty()) {
            int a = queue.poll();
            int b = queue.poll();

            result += a + b;

            queue.add(a + b);

            if (queue.size() == 1) {
                break;
            }
        }

        System.out.println(result);
    }
}