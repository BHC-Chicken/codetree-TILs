import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));

            if (pq.size() < 3) {
                sb.append(-1).append("\n");
            } else {
                long a = pq.poll();
                long b = pq.poll();
                long c = pq.poll();

                sb.append(a * b * c).append("\n");

                pq.add(a);
                pq.add(b);
                pq.add(c);
            }
        }
        System.out.println(sb);
    }
}