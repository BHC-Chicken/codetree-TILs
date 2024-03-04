import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb =  new StringBuilder();
        HashMap<Long, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Long, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(new Comparator<Entry<Long, Integer>>() {
            @Override
            public int compare(Entry<Long, Integer> o1, Entry<Long, Integer> o2) {
                if (Objects.equals(o2.getValue(), o1.getValue())) {
                    return o2.getKey().compareTo(o1.getKey());
                }

                return o2.getValue().compareTo(o1.getValue());
            }
        });
        int index = 0;

        for (Entry<Long, Integer> entry : list) {
            index++;
            sb.append(entry.getKey()).append(" ");

            if (index == k) {
                break;
            }
        }

        System.out.println(sb);
    }
}