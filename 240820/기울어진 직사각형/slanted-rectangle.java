import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;

    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static int getScore(int x, int y, int k, int l) {
        int[] moveNum = new int[]{k, l, k, l};
        int sumOfNums = 0;

        for(int d = 0; d < 4; d++)
            for(int q = 0; q < moveNum[d]; q++) {
                x += dx[d];
                y += dy[d];

                if(!inRange(x, y)) {
                    return 0;
                }

                sumOfNums += map[x][y];
            }

        return sumOfNums;
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

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                for(int k = 1; k < n; k++)
                    for(int l = 1; l < n; l++)
                        result = Math.max(result, getScore(i, j, k, l));

        System.out.println(result);
    }
}