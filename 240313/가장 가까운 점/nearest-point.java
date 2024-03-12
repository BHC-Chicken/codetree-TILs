import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    int x;
    int y;
    int sum;

    public Pair(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.sum == o.sum) {
            return this.x - this.y;
        } else if (this.x == this.y) {
            return this.y - o.y;
        }

        return this.sum - o.sum;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            queue.add(new Pair(x, y, Math.abs(x) + Math.abs(y)));
        }

        for (int i = 0; i < m; i++) {
            Pair pair = queue.poll();

            int x = pair.x + 2;
            int y = pair.y + 2;

            queue.add(new Pair(x, y, x + y));
        }

        Pair pair = queue.poll();

        System.out.println(pair.x + " " + pair.y);
    }
}