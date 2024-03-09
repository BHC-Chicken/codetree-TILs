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
        int result = 0;

        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if (!treeSet.contains(num)) {
                treeSet.add(num);
                result++;

                continue;
            }

            Integer ceiling = treeSet.ceiling(num);

            if (ceiling == null) {
                treeSet.add(num);
                result++;
            } else {
                if (ceiling == num) {
                    if (num - 1 <= 0) {
                        break;
                    } else {
                        treeSet.add(num - 1);
                        result++;
                    }
                } else {
                    if (ceiling - 1 <= 0) {
                        break;
                    } else {
                        treeSet.add(ceiling - 1);
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}