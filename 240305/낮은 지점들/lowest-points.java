import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Long, Long> map = new HashMap<>();
        StringTokenizer st;
        long result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            if (map.containsKey(x)) {
                map.put(x, Math.min(map.get(x), y));
            } else {
                map.put(x, y);
            }
        }

        for (long l : map.keySet()) {
            result += map.get(l);
        }

        System.out.println(result);
    }
}