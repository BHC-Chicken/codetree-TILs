import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, Double> map = new TreeMap<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String word = br.readLine();

            map.put(word, map.getOrDefault(word, 0.0) + 1);
        }

        for (Entry<String, Double> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", (entry.getValue() / n) * 100)).append("\n");
        }

        System.out.println(sb);
    }
}