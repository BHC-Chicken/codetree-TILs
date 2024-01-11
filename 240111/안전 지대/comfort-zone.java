import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;
    static int maxHeight;
    static int result;
    static int result2;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static boolean canGo(int x, int y, int height) {
        if (!inRange(x, y)) {
            return false;
        }

        return !visited[x][y] && arr[x][y] > height;
    }

    static void DFS(int x, int y, int height) {
        int[] dx = new int[]{1, 0, 0, -1};
        int[] dy = new int[]{0, 1, -1, 0};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (canGo(newX, newY, height)) {
                visited[newX][newY] = true;
                DFS(newX, newY, height);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                maxHeight = Math.max(maxHeight, arr[i][j]);
            }
        }

        if (maxHeight == 1) {
            System.out.println(1 + " " + 0);

            return;
        }

        for (int i = 1; i <= maxHeight; i++) {
            visited = new boolean[n][m];
            int temp = 0;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (!visited[j][k]) {
                        if (!canGo(j, k, i)) {
                            visited[j][k] = true;
                            continue;
                        }
                        visited[j][k] = true;
                        temp++;
                        DFS(j, k, i);
                    }
                }
            }

            if (temp > result) {
                result = temp;
                result2 = i;
            }
        }

        System.out.println(result2 + " " + result);
    }
}