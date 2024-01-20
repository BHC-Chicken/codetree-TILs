import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] score;
    static boolean[][] visited;
    static Queue<Pair> queue = new LinkedList<>();

    static int r1;
    static int c1;
    static int r2;
    static int c2;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }

        return !visited[x][y];
    }

    static void push(int x, int y, int s) {
        score[x][y] = s;
        visited[x][y] = true;
        queue.add(new Pair(x, y));
    }

    static void BFS() {
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (canGo(newX, newY)) {
                    push(newX, newY, score[x][y] + 1);
                    if (newX == r2 && newY == c2) {
                        break;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        r1 = Integer.parseInt(st.nextToken()) - 1;
        c1 = Integer.parseInt(st.nextToken()) - 1;
        r2 = Integer.parseInt(st.nextToken()) - 1;
        c2 = Integer.parseInt(st.nextToken()) - 1;

        score = new int[n][n];
        visited = new boolean[n][n];

        push(r1, c1, 0);
        BFS();

        int result = score[r2][c2];

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