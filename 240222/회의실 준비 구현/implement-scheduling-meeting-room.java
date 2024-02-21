import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(pairs);
        int result = 1;

        int temp = pairs[0].end;
        for (int i = 1; i < n; i++) {
            if (pairs[i].start < temp) {
                continue;
            }
            temp = pairs[i].end;

            result++;
        }

        System.out.println(result);
    }
}

class Pair implements Comparable<Pair> {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pair o) {
        return Integer.compare(this.end, o.end);
    }
}