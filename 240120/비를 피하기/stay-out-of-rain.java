import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int arrSize;
    static int human;
    static int space;
    static int[][] arr;
    static Pair[] pairs;
    static Queue<Pair> queue = new LinkedList<>();
    static boolean[][] visited;
    static int[][] time;
    static int[][] tempTime;
    static int currentX;
    static int currentY;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < arrSize && y >= 0 && y < arrSize;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }

        return !visited[x][y] && arr[x][y] != 1;
    }

    static void push(int x, int y, int s) {
        tempTime[x][y] = s;
        visited[x][y] = true;
        queue.add(new Pair(x, y));
    }

    static void BFS() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean success = false;

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();

            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 4; i++) {
                int newX = dx[i] + x;
                int newY = dy[i] + y;

                if (canGo(newX, newY)) {
                    push(newX, newY, tempTime[x][y] + 1);
                    if (arr[newX][newY] == 3) {
                        time[currentX][currentY] = tempTime[newX][newY];
                        queue = new LinkedList<>();
                        success = true;
                        break;
                    }
                }
            }
        }

        if (!success) {
            time[currentX][currentY] = -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        arrSize = Integer.parseInt(st.nextToken());
        human = Integer.parseInt(st.nextToken());
        space = Integer.parseInt(st.nextToken());

        arr = new int[arrSize][arrSize];
        pairs = new Pair[human];
        time = new int[arrSize][arrSize];
        int index = 0;

        for (int i = 0; i < arrSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arrSize; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if (temp == 2) {
                    pairs[index++] = new Pair(i, j);
                }
            }
        }

        for (Pair p : pairs) {
            tempTime = new int[arrSize][arrSize];
            visited = new boolean[arrSize][arrSize];
            queue.add(p);
            currentX = p.x;
            currentY = p.y;
            BFS();
        }

        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                sb.append(time[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
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