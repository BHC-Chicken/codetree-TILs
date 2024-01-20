import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static int[][] score;
    static boolean[][] visited;
    static Queue<Pair> queue = new LinkedList<>();

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }

        return !visited[x][y] && arr[x][y] != 0;
    }

    static void push(int x, int y, int s) {
        score[x][y] = s;
        visited[x][y] = true;
        queue.add(new Pair(x, y));
    }

    static void BFS() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    push(newX, newY, score[x][y] + 1);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        score = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        push(0, 0, 0);
        BFS();
        int result = score[n - 1][m - 1];

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}