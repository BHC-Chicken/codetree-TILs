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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(br.readLine()));
        }

        Integer left = treeSet.first();
        Integer right = treeSet.higher(m);

        if (right == null) {
            right = treeSet.last();
        }

        while (left <= right) {
            if (right - left >= m) {
                result = Math.min(result, right - left);

                left = treeSet.higher(left);

                if (left == null) {
                    break;
                }
            } else if (right - left < m) {
                right = treeSet.higher(right);

                if (right == null) {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}