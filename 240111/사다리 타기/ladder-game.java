import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 11;

    public static int n, m;

    static ArrayList<Pair> lines = new ArrayList<>();
    static ArrayList<Pair> selectedLines = new ArrayList<>();

    public static int ans = INT_MAX;

    public static boolean possible() {

        int[] num1 = new int[MAX_N];
        int[] num2 = new int[MAX_N];
        for(int i = 0; i < n; i++)
            num1[i] = num2[i] = i;

        swap(num1, lines);
        swap(num2, selectedLines);

        for(int i = 0; i < n; i++)
            if(num1[i] != num2[i])
                return false;

        return true;
    }

    private static void swap(int[] num1, ArrayList<Pair> lines) {
        for (Pair line : lines) {
            int idx = line.y;
            int tmp = num1[idx];

            num1[idx] = num1[idx + 1];
            num1[idx + 1] = tmp;
        }
    }

    public static void findMinLines(int cnt) {
        if(cnt == m) {
            if(possible())
                ans = Math.min(ans, selectedLines.size());
            return;
        }

        selectedLines.add(lines.get(cnt));
        findMinLines(cnt + 1);
        selectedLines.remove(selectedLines.size() - 1);

        findMinLines(cnt + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            lines.add(new Pair(b, a - 1));
        }

        Collections.sort(lines);

        findMinLines(0);

        System.out.print(ans);
    }
}

class Pair implements Comparable<Pair> {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Pair b) {
        if(x != b.x) return x - b.x;
        return y - b.y;
    }
}