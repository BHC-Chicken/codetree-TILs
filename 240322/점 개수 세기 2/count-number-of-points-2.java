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
        return this.x - o.x;
    }
}

public class Main {
    static Pair[] pairs1;
    static Pair[] pairs2;
    static TreeSet<Integer> treeSetX = new TreeSet<>();
    static TreeSet<Integer> treeSetY = new TreeSet<>();
    static TreeSet<Pair> pairTreeSet = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        pairs1 = new Pair[q + 1];
        pairs2 = new Pair[q + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            treeSetX.add(x);
            treeSetY.add(y);
            pairTreeSet.add(new Pair(x, y));
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            pairs1[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            pairs2[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < q; i++) {
            int count = 0;

            int x1, x2, y1, y2;

            if (treeSetX.ceiling(pairs1[i].x) != null) {
                x1 = treeSetX.ceiling(pairs1[i].x);
            } else {
                x1 = treeSetX.first();
            }

            if (treeSetY.ceiling(pairs1[i].y) != null) {
                y1 = treeSetY.ceiling(pairs1[i].y);
            } else {
                y1 = treeSetY.first();
            }

            if (treeSetX.floor(pairs2[i].x) != null) {
                x2 = treeSetX.floor(pairs2[i].x);
            } else {
                x2 = treeSetX.last();
            }

            if (treeSetY.floor(pairs2[i].y) != null) {
                y2 = treeSetY.floor(pairs2[i].y);
            } else {
                y2 = treeSetY.last();
            }

            for (Pair pair : pairTreeSet) {
                if (pair.x >= x1 && pair.x <= x2 && pair.y >= y1 && pair.y <= y2) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}