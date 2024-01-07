import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Position> positions = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static int n;
    static int oneCount;
    static int result = Integer.MIN_VALUE;

    static void bomb1(int x, int y, int[][] arr) {
        if (inRange(x + 1, y)) {
            arr[x + 1][y] = 1;
        }
        if (inRange(x + 2, y)) {
            arr[x + 2][y] = 1;
        }
        if (inRange(x - 1, y)) {
            arr[x - 1][y] = 1;
        }

        if (inRange(x - 2, y)) {
            arr[x - 2][y] = 1;
        }
    }

    static void bomb2(int x, int y, int[][] arr) {
        if (inRange(x, y + 1)) {
            arr[x][y + 1] = 1;
        }
        if (inRange(x, y - 1)) {
            arr[x][y - 1] = 1;
        }
        if (inRange(x - 1, y)) {
            arr[x - 1][y] = 1;
        }
        if (inRange(x + 1, y)) {
            arr[x + 1][y] = 1;
        }
    }

    static void bomb3(int x, int y, int[][] arr) {
        if (inRange(x - 1, y + 1)) {
            arr[x - 1][y + 1] = 1;
        }
        if (inRange(x - 1, y - 1)) {
            arr[x - 1][y - 1] = 1;
        }
        if (inRange(x + 1, y + 1)) {
            arr[x + 1][y + 1] = 1;
        }
        if (inRange(x + 1, y - 1)) {
            arr[x + 1][y - 1] = 1;
        }
    }

    static void choose(int currentNum) {
        if (oneCount + 1 == currentNum) {
            int tempResult = bomb();
            result = Math.max(result, tempResult);

            return;
        }

        for (int i = 1; i <= 3; i++) {
            list.add(i);
            choose(currentNum + 1);
            list.remove(list.size() - 1);
        }
    }

    static int bomb() {
        int[][] arr = new int[n][n];
        for (int i = 0; i < oneCount; i++) {
            Position pos = positions.get(i);
            int x = pos.x;
            int y = pos.y;

            arr[x][y] = 1;

            if (list.get(i) == 1) {
                bomb1(x, y, arr);
            } else if (list.get(i) == 2) {
                bomb2(x, y, arr);
            } else if (list.get(i) == 3) {
                bomb3(x, y, arr);
            }
        }

        return countOne(arr);
    }

    static public int countOne(int[][] arr) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    static public boolean inRange(int x, int y) {
        return x < n && x >= 0 && y >= 0 && y < n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());

                if (temp == 1) {
                    oneCount++;
                    positions.add(new Position(i, j));
                }
            }
        }
        choose(1);

        System.out.println(result);
    }
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}