import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


class Stone implements Comparable<Stone> {
    int start, end;

    Stone(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Stone o) {
        return this.end - o.end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        TreeSet<Integer> redSet = new TreeSet<>();
        for (int i = 0; i < c; i++) {
            redSet.add(Integer.parseInt(br.readLine()));
        }

        Stone[] blackStone = new Stone[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            blackStone[i] = new Stone(start, end);
        }

        Arrays.sort(blackStone);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int a = blackStone[i].end;
            int b = blackStone[i].start;

            if (redSet.ceiling(b) != null) {
                int temp = redSet.ceiling(b);

                if (temp <= a) {
                    count++;
                    redSet.remove(temp);
                }
            }
        }

        System.out.println(count);
    }
}