import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Pair implements Comparable<Pair> {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.x == o.x) {
            return Integer.compare(this.y, o.y);
        }

        return Integer.compare(this.x, o.x);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Pair> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            treeSet.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            Pair pair = treeSet.ceiling(new Pair(num, 0));

            if (pair == null) {
                sb.append("-1 -1").append("\n");
            } else {
                sb.append(pair.x).append(" ").append(pair.y).append("\n");

                treeSet.remove(pair);
            }
        }

        System.out.println(sb);
    }
}