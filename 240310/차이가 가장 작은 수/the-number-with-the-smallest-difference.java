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
        int[] arr = new int[n];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            treeSet.add(num);
            arr[i] = num;
        }

        for (int i = 0; i < n; i++) {
            int x = arr[i];

            if (treeSet.ceiling(m + x) != null) {
                result = Math.min(result, treeSet.ceiling(m + x) - x);
            }

            if (treeSet.floor(x - m) != null) {
                result = Math.min(result, x - treeSet.floor(x - m));
            }
        }

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}