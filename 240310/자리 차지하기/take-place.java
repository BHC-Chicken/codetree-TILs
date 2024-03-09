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

        for (int i = 1; i <= m; i++) {
            treeSet.add(i);
        }

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());

            if (treeSet.contains(num)) {
                treeSet.remove(num);
                result++;
            } else {
                Integer temp = treeSet.floor(num);

                if (temp == null) {
                    break;
                } else {
                    treeSet.remove(temp);
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}