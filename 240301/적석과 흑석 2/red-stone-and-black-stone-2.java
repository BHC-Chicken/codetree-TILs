import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Stone {
    int start, end;

    Stone(int start, int end) {
        this.start = start;
        this.end = end;
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

        Arrays.sort(blackStone, (o1, o2) -> o1.start - o2.start);

        int count = 0;
        for (int i = 0; i < n; i++) {
            Integer red = redSet.ceiling(blackStone[i].start);

            if (red != null && red <= blackStone[i].end) {
                count++;
                redSet.remove(red);
            }
        }

        System.out.println(count);
    }
}