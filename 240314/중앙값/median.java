import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> min = new PriorityQueue<>();
            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= m; i++) {
                int num = Integer.parseInt(st.nextToken());

                if (max.size() == min.size()) {
                    max.add(num);
                } else {
                    min.add(num);
                }

                if (!max.isEmpty() && !min.isEmpty()) {
                    if (max.peek() > min.peek()) {
                        int temp = max.poll();
                        max.add(min.poll());
                        min.add(temp);
                    }
                }

                if (i % 2 == 1) {
                    sb.append(max.peek()).append(" ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}