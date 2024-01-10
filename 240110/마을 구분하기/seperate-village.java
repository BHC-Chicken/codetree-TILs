import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int village;
    static int[][] arr;
    static boolean[][] visited;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static boolean inRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static boolean canGo(int x, int y) {
        if (!inRange(x, y)) {
            return false;
        }

        return !visited[x][y] && arr[x][y] != 0;
    }

    static void DFS(int x, int y, int num) {
        int[] dx = new int[]{1, 0, 0, -1};
        int[] dy = new int[]{0, 1, -1, 0};

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (canGo(newX, newY)) {
                visited[newX][newY] = true;
                map.put(num, map.getOrDefault(num, 1) + 1);
                DFS(newX, newY, num);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int listCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (!canGo(i, j)) {
                        visited[i][j] = true;
                        continue;
                    }
                    visited[i][j] = true;
                    village++;
                    map.put(listCount, 1);
                    DFS(i, j, listCount);
                    listCount++;
                }
            }
        }

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        StringBuilder sb = new StringBuilder();
        sb.append(village).append("\n");

        for (Map.Entry<Integer, Integer> value : list) {
            sb.append(value.getValue()).append("\n");
        }

        System.out.println(sb);
    }
}