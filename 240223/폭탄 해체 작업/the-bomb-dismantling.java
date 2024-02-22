import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Bomb[] bombs = new Bomb[n];
        int score = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            bombs[i] = new Bomb(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(bombs);

        int time = 0;

        for (Bomb b : bombs) {
            if (b.time != time) {
                score += b.score;
                time = b.time;
            }
        }

        System.out.println(score);
    }
}

class Bomb implements Comparable<Bomb> {
    int score;
    int time;

    public Bomb(int score, int time) {
        this.score = score;
        this.time = time;
    }

    @Override
    public int compareTo(Bomb o) {
        if (this.time == o.time) {
            return o.score - this.score;
        }
        return this.time - o.time;
    }
}