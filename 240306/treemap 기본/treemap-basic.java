import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add":
                    treeMap.put(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
                    break;
                case "remove":
                    treeMap.remove(Long.parseLong(st.nextToken()));
                    break;
                case "find":
                    long temp = Long.parseLong(st.nextToken());
                    if (treeMap.containsKey(temp)) {
                        sb.append(treeMap.get(temp)).append("\n");
                    } else {
                        sb.append("None").append("\n");
                    }
                    break;
                case "print_list":
                    if (treeMap.isEmpty()) {
                        sb.append("None").append("\n");
                    } else {
                        for (Entry<Long, Long> entry : treeMap.entrySet()) {
                            sb.append(entry.getValue()).append(" ");
                        }
                        sb.append("\n");
                    }
            }
        }

        System.out.println(sb);

    }
}