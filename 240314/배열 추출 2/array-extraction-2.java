import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Pair implements Comparable<Pair> {
    int num;
    int abs;

    public Pair(int num, int abs) {
        this.num = num;
        this.abs = abs;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.abs == o.abs) {
            return this.num - o.num;
        }

        return this.abs - o.abs;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                queue.add(new Pair(num, Math.abs(num)));
            } else {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll().num).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}