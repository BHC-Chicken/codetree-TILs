import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n;
    static int q;
    static int[] prefix;
    static Pair[] pairs;
    static int[] points;
    static TreeSet<Integer> treeSet = new TreeSet<>();
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static int lowerBound(int i) {
        if (treeSet.ceiling(i) != null) {
            return hashMap.get(treeSet.ceiling(i));
        }

        return treeSet.size() + 1;
    }

    static int upperBound(int i) {
        if (treeSet.floor(i) != null) {
            return hashMap.get(treeSet.floor(i));
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        prefix = new int[n * 2 + 2];
        pairs = new Pair[100001];
        points = new int[n + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            treeSet.add(num);
            points[i] = num;
        }

        int index = 1;

        for (int i : treeSet) {
            hashMap.put(i, index++);
        }

        for (int i = 0; i < n; i++) {
            prefix[hashMap.get(points[i])]++;
        }

        for (int i = 1; i <= index; i++) {
            prefix[i] += prefix[i - 1];
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int newX = lowerBound(x);
            int newY = upperBound(y);
            sb.append(prefix[newY] - prefix[newX - 1]).append("\n");
        }

        System.out.println(sb);
    }
}