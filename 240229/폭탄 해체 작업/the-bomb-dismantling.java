import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
            return this.score - o.score;
        }

        return this.time - o.time;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Bomb[] bombs = new Bomb[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            bombs[i] = new Bomb(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(bombs);
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int bombIndex = n - 1;

        for (int i = n - 1; i >= 1 ; i--) {

            while (bombIndex >= 0 && bombs[bombIndex].time >= i) {
                priorityQueue.add(-bombs[bombIndex].score);
                bombIndex--;
            }

            if (!priorityQueue.isEmpty()) {
                answer += -priorityQueue.poll();
            }
        }

        System.out.println(answer);
    }
}