import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            treeSet.add(i);
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int remove = Integer.parseInt(st.nextToken());
            int result = 0;
            treeSet.remove(remove);

            Integer high = treeSet.higher(remove);
            Integer lower = treeSet.lower(remove);

            while (high != null) {
                int temp = high + 1;
                int length = 1;

                if (treeSet.contains(temp)) {
                    while (treeSet.contains(temp)) {
                        temp++;
                        length++;
                    }
                    result = Math.max(result, length);

                }
                high = treeSet.higher(temp);
            }

            while (lower != null) {
                int temp = lower - 1;
                int length = 1;

                if (treeSet.contains(temp)) {
                    while (treeSet.contains(temp)) {
                        temp--;
                        length++;
                    }
                    result = Math.max(result, length);

                }
                lower = treeSet.lower(temp);
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}