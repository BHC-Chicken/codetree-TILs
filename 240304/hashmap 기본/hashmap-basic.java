import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {
                case "add" :
                    map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                    break;
                case "remove" :
                    map.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "find" :
                    int num = Integer.parseInt(st.nextToken());

                    if (map.containsKey(num)) {
                        sb.append(map.get(num)).append("\n");
                    } else {
                        sb.append("None").append("\n");
                    }
            }
        }

        System.out.println(sb);
    }
}