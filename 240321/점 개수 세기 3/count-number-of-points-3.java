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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        Pair[] pairs = new Pair[100001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int index = 1;
        for (Integer num : treeSet) {
            map.put(num, index);
            index++;
        }

        for (int i = 0; i < q; i++) {
            int x = map.get(pairs[i].x);
            int y = map.get(pairs[i].y);

            sb.append(y - x + 1).append("\n");
        }

        System.out.println(sb);
    }
}