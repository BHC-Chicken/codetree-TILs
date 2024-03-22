import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        TreeSet<Integer> treeSetX = new TreeSet<>();
        TreeSet<Integer> treeSetY = new TreeSet<>();
        TreeSet<Pair> pairTreeSet = new TreeSet<>();

        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Pair[] pairs1 = new Pair[q + 1];
        Pair[] pairs2 = new Pair[q + 1];

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

        int index = 1;
        for (Integer num : treeSetX) {
            mapX.put(num, index);
            index++;
        }

        index = 1;
        for (Integer num : treeSetY) {
            mapY.put(num, index);
            index++;
        }

        for (int i = 0; i < q; i++) {
            int count = 0;
            int x1 = treeSetX.ceiling(pairs1[i].x);
            int y1 = treeSetY.ceiling(pairs1[i].y);

            int x2 = treeSetX.floor(pairs2[i].x);
            int y2 = treeSetY.floor(pairs2[i].y);

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