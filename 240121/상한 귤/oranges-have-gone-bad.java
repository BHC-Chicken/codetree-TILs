import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int arrSize;
    static int spoilOrange;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] time;
    static ArrayList<Pair> list = new ArrayList<>();
    static Queue<Pair> queue = new LinkedList<>();
    static int startX;
    static int startY;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < arrSize && y >= 0 && y < arrSize;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }

        return !visited[x][y];
    }

    static void push(int x, int y, int s) {
        visited[x][y] = true;
        queue.add(new Pair(x, y));
        time[x][y] = s;
        arr[x][y] = 2;
    }

    static void BFS() {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            startX = pair.x;
            startY = pair.y;

            for (int i = 0; i < 4; i++) {
                int newX = startX + dx[i];
                int newY = startY + dy[i];

                if (canGo(newX, newY) && arr[newX][newY] == 1) {
                    push(newX, newY, time[startX][startY] + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        arrSize = Integer.parseInt(st.nextToken());
        spoilOrange = Integer.parseInt(st.nextToken());

        arr = new int[arrSize][arrSize];
        visited = new boolean[arrSize][arrSize];
        time = new int[arrSize][arrSize];

        for (int i = 0; i < arrSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arrSize; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;

                if (temp == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }
        BFS();

        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize; j++) {
                if (arr[i][j] == 0) {
                    sb.append(-1);
                } else if (arr[i][j] == 1) {
                    sb.append(-2);
                } else if (arr[i][j] == 2) {
                    sb.append(time[i][j]);
                }
                sb.append(" ");
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