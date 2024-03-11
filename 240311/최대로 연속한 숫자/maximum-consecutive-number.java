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

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int remove = Integer.parseInt(st.nextToken());
            treeSet.add(remove);
            int result = 0;

            Integer high = treeSet.higher(remove);
            Integer lower = treeSet.lower(remove);

            if (high == null) {
                result = Math.max(result, n - remove);
            } else {
                while (true) {
                    Integer temp = treeSet.higher(high);

                    if (temp == null) {

                        result = Math.max(result, n - high);
                        break;
                    }
                    result = Math.max(result, (temp - 1) - high);

                    high = temp;
                }
            }

            if (lower == null) {
                result = Math.max(result, Math.abs(-remove));
            } else {
                while (true) {
                    Integer temp = treeSet.lower(lower);

                    if (temp == null) {
                        result = Math.max(result, Math.abs(-lower));

                        break;
                    }

                    result = Math.max(result, remove - (temp + 1));

                    lower = temp;
                }
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}