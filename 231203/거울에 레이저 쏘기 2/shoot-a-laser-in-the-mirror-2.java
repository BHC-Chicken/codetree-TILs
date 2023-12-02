import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static String[][] arr;
    static int n;
    static int x;
    static int y;
    static int now;

    static void startSide(int start) {
        if (start < n) {
            now = 0;
            x = 0;
            y = start;
        } else if (start < n * 2) {
            now = 1;
            x = start - n;
            y = n - 1;

        } else if (start < n * 3) {
            now = 2;
            x = n - 1;
            y = Math.abs((start % n) - (n - 1));
        } else {
            now = 3;
            x = Math.abs((start % n) - (n - 1));
            y = 0;
        }
    }


    static int slashMove(int now) {
        if (now == 0) {
            return 1;
        } else if (now == 3) {
            return 2;
        } else if (now == 1) {
            return 0;
        } else {
            return 3;
        }
    }

    static boolean range(int x, int y) {
        return x >= n || y >= n || x < 0 || y < 0;
    }

    static int backSlashMove(int now) {
        if (now == 0) {
            return 3;
        } else if (now == 1) {
            return 2;
        } else if (now == 3) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new String[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = String.valueOf(s.charAt(j));
            }
        }

        int start = Integer.parseInt(br.readLine()) - 1;

        startSide(start);
        boolean loop = true;

        while (loop) {
            String dir = arr[x][y];

            if (dir.equals("/")) {
                now = slashMove(now);
            } else {
                now = backSlashMove(now);
            }

            x += dx[now];
            y += dy[now];

            count++;
            loop = !range(x, y);
        }

        System.out.println(count);
    }
}