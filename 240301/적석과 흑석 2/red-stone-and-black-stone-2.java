import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        return this.x - o.x;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] red = new int[c];
        Pair[] black = new Pair[n];

        for (int i = 0; i < c; i++) {
            red[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            black[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(red);
        Arrays.sort(black);

        int redIndex = 0;
        int blackIndex = 0;
        int count = 0;

        while (redIndex < c && blackIndex < n) {
            if (red[redIndex] <= black[blackIndex].y) {
                count++;
                redIndex++;
                blackIndex++;
            } else {
                blackIndex++;
            }
        }

        System.out.println(count);
    }
}