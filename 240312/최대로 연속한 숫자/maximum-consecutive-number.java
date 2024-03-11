import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Tuple implements Comparable<Tuple> {
    int start;
    int end;
    int length;

    public Tuple(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }


    @Override
    public int compareTo(Tuple o) {
        if (this.length != o.length) {
            return o.length - this.length;
        } else if (this.start != o.start) {
            return this.start - o.start;
        } else {
            return this.end - o.end;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        TreeSet<Tuple> tuples = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        treeSet.add(-1);
        treeSet.add(n + 1);

        tuples.add(new Tuple(-1, n + 1, n + 1));

        for (int i = 0; i < m; i++) {
            int remove = Integer.parseInt(st.nextToken());
            treeSet.add(remove);

            Integer high = treeSet.higher(remove);
            Integer lower = treeSet.lower(remove);

            tuples.remove(new Tuple(lower, high, high - lower - 1));
            tuples.add(new Tuple(remove, high, high - remove - 1));
            tuples.add(new Tuple(lower, remove, remove - lower - 1));

            sb.append(tuples.first().length).append("\n");
        }

        System.out.println(sb);
    }
}