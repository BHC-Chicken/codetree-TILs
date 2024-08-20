import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;

    public static int getArea(int k) {
        return k * k + (k + 1) * (k + 1);
    }

    public static int getNumOfGold(int row, int col, int k) {
        int numOfGold = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(row - i) + Math.abs(col - j) <= k) {
                    numOfGold += map[i][j];
                }
            }
        }

        return numOfGold;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                for (int k = 0; k <= 2 * (n - 1); k++) {
                    int numOfGold = getNumOfGold(row, col, k);

                    if (numOfGold * m >= getArea(k)) {
                        result = Math.max(result, numOfGold);
                    }
                }
            }
        }

        System.out.println(result);
    }
}