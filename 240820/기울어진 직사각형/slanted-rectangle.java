import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};

    static boolean inRange(int x, int y, int z) {
        return x >= 0 && x < z && y >= 0 && y < z;
    }

    static int search(int x, int y) {
        int sum = 0;
        int temp = 0;
        int count = 1;
        int startX = x;
        int startY = y;

        for (int z = 1; z <= n; z++) {
            for (int i = 0; i < 4; i++) {
                if (inRange(x + dx[i], y + dy[i], z)) {
                    x += dx[i];
                    y += dy[i];
                    count++;
                } else {
                    break;
                }
                while (inRange(x, y, z)) {
                    temp += map[x][y];
                    x += dx[i];
                    y += dy[i];
                }
                x -= dx[i];
                y -= dy[i];
            }

            if (count >= 4 && x == startX && y == startY) {
                sum = Math.max(sum, temp);
            }
            temp = 0;
            count = 1;
            x = startX;
            y = startY;
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result = Math.max(result, search(i, j));
            }
        }

        System.out.println(result);
    }
}