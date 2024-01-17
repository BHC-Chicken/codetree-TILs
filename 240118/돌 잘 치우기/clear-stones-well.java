import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int arrSize;
    static int startAmount;
    static int stone;
    static int[][] arr;
    static boolean[][] visited;
    static boolean[] startPointVisited;
    static ArrayList<Pair> stoneList = new ArrayList<>();
    static Queue<Pair> queue = new LinkedList<>();
    static Pair[] startPoint;
    static int count;
    static int temp;
    static int one;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < arrSize && y >= 0 && y < arrSize;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }

        return !visited[x][y] && arr[x][y] != 1;
    }

    static void push(int x, int y) {
        visited[x][y] = true;
        queue.add(new Pair(x, y));
    }

    static void backTracking(int num) {
        temp = 0;
        if (num == stone) {
            visited = new boolean[arrSize][arrSize];
            for (int i = 0; i < stone; i++) {
                queue.add(startPoint[i]);
                BFS();
            }
            count = Math.max(count, temp);

            return;
        }

        for (int i = 0; i < one; i++) {
            if (!startPointVisited[i]) {
                Pair pair = stoneList.get(i);
                startPointVisited[i] = true;
                arr[pair.x][pair.y] = 0;
                backTracking(num + 1);
                arr[pair.x][pair.y] = 1;
                startPointVisited[i] = false;
            }
        }
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
                    temp++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arrSize = Integer.parseInt(st.nextToken());
        startAmount = Integer.parseInt(st.nextToken());
        stone = Integer.parseInt(st.nextToken());
        arr = new int[arrSize][arrSize];

        for (int i = 0; i < arrSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arrSize; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    stoneList.add(new Pair(i, j));
                }
            }
        }

        startPoint = new Pair[stone];
        one = stoneList.size();
        startPointVisited = new boolean[one];

        for (int i = 0; i < stone; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            Pair pair = new Pair(x, y);
            startPoint[i] = pair;
        }

        backTracking(0);

        System.out.println(count);
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