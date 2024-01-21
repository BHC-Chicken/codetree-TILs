import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int arrSize;
    static int destroyWall;
    static int[][] arr;
    static int[][] score;
    static boolean[][] visited;
    static Queue<Pair> queue = new LinkedList<>();
    static ArrayList<Pair> list = new ArrayList<>();
    static boolean[] oneVisited;
    static int startX;
    static int startY;
    static int goalX;
    static int goalY;
    static int min = Integer.MAX_VALUE;

    static void backTracking(int start) {
        if (start == destroyWall) {
            visited = new boolean[arrSize][arrSize];
            score = new int[arrSize][arrSize];
            push(startX, startY, 0);
            BFS();

            if (score[goalX][goalY] != 0) {
                min = Math.min(min, score[goalX][goalY]);
                if (min == (arrSize * arrSize) - list.size() + destroyWall) {
                    list = new ArrayList<>();
                }
            }

            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (!oneVisited[i]) {
                oneVisited[i] = true;
                Pair pair = list.get(i);
                arr[pair.x][pair.y] = 0;
                backTracking(start + 1);
                arr[pair.x][pair.y] = 1;
                oneVisited[i] = false;
            }

        }
    }

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
        visited[x][y] = true;
        score[x][y] = s;
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

        arrSize = Integer.parseInt(st.nextToken());
        destroyWall = Integer.parseInt(st.nextToken());

        arr = new int[arrSize][arrSize];

        for (int i = 0; i < arrSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arrSize; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;

                if (temp == 1) {
                    list.add(new Pair(i, j));
                }
            }
        }

        oneVisited = new boolean[list.size()];

        st = new StringTokenizer(br.readLine());

        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());

        goalX = Integer.parseInt(st.nextToken()) - 1;
        goalY = Integer.parseInt(st.nextToken()) - 1;

        backTracking(0);

        if (min <= 100000) {
            System.out.println(min);
        } else {
            System.out.println(-1);
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