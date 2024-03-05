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

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<List<Integer>, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) >= 'a' && word.charAt(j) <= 'z') {
                    list.add(word.charAt(j) - 'a');
                } else {
                    list.add(word.charAt(j) - 'A');
                }
            }

            Collections.sort(list);

            map.put(list, map.getOrDefault(list, 0) + 1);
        }

        List<Map.Entry<List<Integer>, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(new Comparator<Entry<List<Integer>, Integer>>() {
            @Override
            public int compare(Entry<List<Integer>, Integer> o1, Entry<List<Integer>, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        System.out.println(list.get(0).getValue());
    }
}