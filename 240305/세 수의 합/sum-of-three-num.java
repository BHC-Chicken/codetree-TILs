import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long[] arr = new long[n];
        int result = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(st.nextToken());

            arr[i] = num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], -1);
            } else {
                map.put(arr[i], map.get(arr[i]) -1);
            }

            for (int j = 0; j < i; j++) {
                if(map.containsKey(k - arr[i] - arr[j])) {
                    result += map.get(k - arr[i] - arr[j]);
                }
            }
        }

        System.out.println(result);
    }
}