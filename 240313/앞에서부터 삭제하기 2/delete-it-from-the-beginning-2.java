import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        double result = 0;
        double prevResult = 0;
        double avg = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.remove(0);
        queue.addAll(list);
        int temp = queue.poll();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            prevResult += queue.poll();
        }

        result = prevResult / size;
        list.add(0, temp);

        for (int i = 2; i < n - 2; i++) {
            ArrayList<Integer> garbage = new ArrayList<>(list);

            for (int j = 0; j < i; j++) {
                list.remove(0);
            }

            queue = new PriorityQueue<>(list);
            temp = queue.poll();
            size = queue.size();

            prevResult -= temp;

            result = Math.max(result, prevResult/size);

            list = new ArrayList<>(garbage);
        }

        System.out.printf("%.2f%n", result);
    }
}