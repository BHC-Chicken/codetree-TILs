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

class Tuple {
    int x1, x2, y1, y2;

    public Tuple(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}

public class Main {
    static int n;
    static int q;

    static Pair[] points = new Pair[1001];
    static Tuple[] query = new Tuple[100001];

    static TreeSet<Integer> treeSet = new TreeSet<>();
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static int[][] prefix;

    static int getLowerBound(int x) {
        if (treeSet.ceiling(x) != null) {
            return hashMap.get(treeSet.ceiling(x));
        }

        return treeSet.size() + 1;
    }

    static int getUpperBound(int x) {
        if (treeSet.floor(x) != null) {
            return hashMap.get(treeSet.floor(x));
        }

        return 0;
    }

    static int getSum(int x1, int y1, int x2, int y2) {
        return prefix[x2][y2] - prefix[x1 - 1][y2] - prefix[x2][y1 - 1] + prefix[x1 - 1][y1 - 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        prefix = new int[2 * n + 2][2 * n + 2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            points[i] = new Pair(x, y);

            treeSet.add(x);
            treeSet.add(y);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            query[i] = new Tuple(x1, y1, x2, y2);
        }

        int index = 1;

        for (Integer num : treeSet) {
            hashMap.put(num, index++);
        }

        for (int i = 0; i < n; i++) {
            int x = points[i].x;
            int y = points[i].y;

            int newX = hashMap.get(x);
            int newY = hashMap.get(y);

            prefix[newX][newY]++;
        }

        for (int i = 1; i <= index; i++) {
            for (int j = 1; j <= index; j++) {
                prefix[i][j] += prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            int x1 = query[i].x1;
            int y1 = query[i].y1;
            int x2 = query[i].x2;
            int y2 = query[i].y2;

            int newX1 = getLowerBound(x1);
            int newY1 = getLowerBound(y1);
            int newX2 = getUpperBound(x2);
            int newY2 = getUpperBound(y2);

            int sum = getSum(newX1, newY1, newX2, newY2);

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }
}