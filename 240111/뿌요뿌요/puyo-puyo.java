import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int maxBlock;
    static int maxBombBlock;
    static int bombTemp;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static boolean canGo(int x, int y, int currentNum) {
        if (!inRange(x, y)) {
            return false;
        }

        return !visited[x][y] && arr[x][y] == currentNum;
    }

    static void DFS(int startX, int startY, int currentNum) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};


        for (int i = 0; i < 4; i++) {
            int newX = startX + dx[i];
            int newY = startY + dy[i];

            if (canGo(newX, newY, currentNum)) {
                visited[newX][newY] = true;
                DFS(newX, newY, currentNum);
                bombTemp++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bombTemp = 1;
                int currentNum = arr[i][j];
                if (!visited[i][j]) {
                    if (!canGo(i, j, currentNum)) {
                        continue;
                    }
                }
                visited[i][j] = true;
                DFS(i, j, currentNum);
                if (bombTemp >= 4) {
                    maxBombBlock++;
                }
                maxBlock = Math.max(bombTemp, maxBlock);
            }
        }

        System.out.println(maxBombBlock + " " + maxBlock);
    }
}