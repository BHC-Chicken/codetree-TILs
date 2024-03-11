import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Pair implements Comparable<Pair> {
    int index;
    int diff;

    public Pair(int index, int diff) {
        this.index = index;
        this.diff = diff;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.diff == o.diff) {
            return this.index - o.index;
        }

        return this.diff - o.diff;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Pair> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            treeSet.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            int index = 0;
            int diff = 0;

            switch (cmd) {
                case "ad":
                    index = Integer.parseInt(st.nextToken());
                    diff = Integer.parseInt(st.nextToken());
                    treeSet.add(new Pair(index, diff));

                    break;
                case "sv":
                    index = Integer.parseInt(st.nextToken());
                    diff = Integer.parseInt(st.nextToken());
                    treeSet.remove(new Pair(index, diff));

                    break;
                case "rc":
                    diff = Integer.parseInt(st.nextToken());
                    Pair pair;
                    if (diff == 1) {
                        pair = treeSet.last();
                    } else {
                        pair = treeSet.first();
                    }
                    sb.append(pair.index).append("\n");
            }
        }

        System.out.println(sb);
    }
}