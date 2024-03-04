import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> numberMap = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int index = 1;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, index);
            numberMap.put(index++, s);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            if (97 <= s.charAt(0) && s.charAt(0) <= 122) {
                sb.append(map.get(s)).append("\n");
            } else {
                sb.append(numberMap.get(Integer.parseInt(s))).append("\n");
            }
        }

        System.out.println(sb);
    }
}