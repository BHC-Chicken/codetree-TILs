import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static int r;
    static int c;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Pair> queue = new LinkedList<>();
    static int start;
    static int max;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }

        return !visited[x][y] && arr[x][y] < start;
    }

    static void push(int x, int y) {
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
                    push(newX, newY);

                    if (arr[newX][newY] > max) {
                        max = arr[newX][newY];
                        r = newX;
                        c = newY;
                    } else if (max == arr[newX][newY]) {
                        if (r > newX) {
                            r = newX;
                            c = newY;
                        } else if (r == newX && c > newY) {
                            c = newY;
                        }
                    }
                }
            }
        }

        start = max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        start = arr[r][c];

        for (int i = 0; i < k; i++) {
            max = 0;
            visited = new boolean[n][n];
            push(r,c);
            BFS();
        }

        System.out.println((r + 1) + " " + (c + 1));
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