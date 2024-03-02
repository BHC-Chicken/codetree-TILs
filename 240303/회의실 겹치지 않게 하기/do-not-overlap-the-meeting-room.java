import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Pair implements Comparable<Pair> {
    int start;
    int end;

    public Pair(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Pair o) {
        return this.end - o.end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            pairs[i] = new Pair(start, end);
        }

        Arrays.sort(pairs);

        int count = 1;
        int prev = pairs[0].end;

        for (int i = 1; i < n; i++) {
            if (pairs[i].start < prev) {
                continue;
            }

            prev = pairs[i].end;
            count++;
        }

        System.out.println(n - count);
    }
}