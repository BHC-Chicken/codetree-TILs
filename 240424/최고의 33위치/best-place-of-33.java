import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int result = Integer.MIN_VALUE;
    static int n;

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static void search(int x, int y) {
        int count = 0;

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }

        result = Math.max(result, count);
    }

    ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!inRange(i + 2, j + 2)) {
                    continue;
                }
                search(i, j);
            }
        }

        System.out.println(result);
    }
}