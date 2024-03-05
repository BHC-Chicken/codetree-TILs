import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n];
        int result = 0;

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map1.put(arr[0][i] + arr[1][j], map1.getOrDefault(arr[0][i] + arr[1][j], 0) + 1);
                map2.put(arr[2][i] + arr[3][j], map2.getOrDefault(arr[2][i] + arr[3][j], 0) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int diff = -(entry.getKey());

            if (map2.containsKey(diff)) {
                result += map2.get(diff) * entry.getValue();
            }
        }

        System.out.println(result);
    }
}