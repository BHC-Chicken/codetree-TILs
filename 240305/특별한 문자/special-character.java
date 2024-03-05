import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Pair {
    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Character, Pair> map = new HashMap<>();
        String word = br.readLine();

        for (int i = 0; i < word.length(); i++) {
            if (map.containsKey(word.charAt(i))) {
                Pair pair = map.get(word.charAt(i));
                pair.a++;
                map.put(word.charAt(i), pair);
            } else {
                map.put(word.charAt(i), new Pair(1, i));
            }
        }

        List<Map.Entry<Character, Pair>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comparator<Entry<Character, Pair>>() {
            @Override
            public int compare(Entry<Character, Pair> o1, Entry<Character, Pair> o2) {
                if (o1.getValue().a == o2.getValue().a) {
                    return o1.getValue().b - o2.getValue().b;
                }

                return o1.getValue().a - o2.getValue().a;
            }
        });

        if (list.get(0).getValue().a == 1) {
            System.out.println(list.get(0).getKey());
        } else {
            System.out.println("None");
        }
    }
}