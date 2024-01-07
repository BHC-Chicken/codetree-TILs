import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer = 1;
    static int n;
    static ArrayList<Integer> list = new ArrayList<>();
    static Pair[] pairs;

    static void choose(int currentNum, int num) {
        if (currentNum == num) {
            if (line()) {
                answer = Math.max(answer, num);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            list.add(i);
            choose(currentNum + 1, num);
            list.remove(list.size() - 1);
        }
    }

    static boolean line() {
        for (int i = 0; i < list.size() - 1; i++) {
            int x2 = pairs[list.get(i)].x2;

            if (pairs[list.get(i + 1)].x1 <= x2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(1);
            
            return;
        }
        StringTokenizer st;
        pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(pairs);

        for (int i = 2; i <= n; i++) {
            choose(0, i);
        }

        System.out.println(answer);
    }
}

class Pair implements Comparable<Pair> {
    int x1;
    int x2;

    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.x1, o.x1);
    }
}