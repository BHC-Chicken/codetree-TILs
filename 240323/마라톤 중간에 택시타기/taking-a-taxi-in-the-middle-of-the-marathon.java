import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] arr = new Pair[n];
        Pair[] lArr = new Pair[n];
        Pair[] rArr = new Pair[n];

        int result = Integer.MAX_VALUE;

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[i] = new Pair(x, y);
        }

        for (int i = 0; i < n; i++) {
            lArr[i] = new Pair(0, 0);
            rArr[i] = new Pair(0, 0);
        }

        lArr[0] = new Pair(0, 0);
        rArr[n - 1] = new Pair(0, 0);

        for (int i = 1; i < n; i++) {
            Pair prevPair = arr[i - 1];
            Pair nowPair = arr[i];

            lArr[i] = new Pair(Math.abs(prevPair.x - nowPair.x) + lArr[i - 1].x,
                    Math.abs(prevPair.y - nowPair.y) + lArr[i - 1].y);
        }

        for (int i = n - 2; i >= 0; i--) {
            Pair prevPair = arr[i + 1];
            Pair nowPair = arr[i];

            rArr[i] = new Pair(Math.abs(prevPair.x - nowPair.x) + rArr[i + 1].x,
                    Math.abs(prevPair.y - nowPair.y) + rArr[i + 1].y);
        }

        for (int i = 1; i < n - 2; i++) {
            int tempX = lArr[i - 1].x + rArr[i + 1].x + Math.abs(arr[i + 1].x - arr[i - 1].x);
            int tempY = lArr[i - 1].y + rArr[i + 1].y + Math.abs(arr[i + 1].y - arr[i - 1].y);

            result = Math.min(result, tempX + tempY);
        }

        System.out.println(result);
    }
}