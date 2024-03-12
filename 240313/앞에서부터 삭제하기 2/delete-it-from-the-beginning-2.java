import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        double result = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= n - 2; i++) {
            ArrayList<Integer> garbage = new ArrayList<>(list);
            double avg = 0;

            for (int j = 0; j < i; j++) {
                list.remove(0);
            }

            PriorityQueue<Integer> queue = new PriorityQueue<>(list);

            int temp = queue.poll();
            int size = queue.size();

            for (int j = 0; j < size; j++) {
                avg += queue.poll();
            }

            result = Math.max(result, avg/size);

            list = new ArrayList<>(garbage);
        }

        System.out.printf("%.2f%n", result);
    }
}