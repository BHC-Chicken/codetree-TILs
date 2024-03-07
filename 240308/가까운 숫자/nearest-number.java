import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        int result = Integer.MAX_VALUE;

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        treeSet.add(0);

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            treeSet.add(temp);

            Integer max = treeSet.higher(temp);
            Integer min = treeSet.lower(temp);

            if (max != null && min != null) {
                result = Math.min(result, Math.min(max - temp, temp - min));
            } else if (max == null && min != null) {
                result = Math.min(result, temp - min);
            } else {
                result = Math.min(result, max - temp);
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}