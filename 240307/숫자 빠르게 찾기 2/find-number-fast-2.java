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

        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            Integer temp = treeSet.ceiling(Integer.parseInt(br.readLine()));

            if (temp != null) {
                sb.append(temp).append("\n");
            } else {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}