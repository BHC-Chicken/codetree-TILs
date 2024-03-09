import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = -1;

        for (int i = 0; i < n; i++) {
            treeSet.add(Integer.parseInt(br.readLine()));
        }

        ArrayList<Integer> list = new ArrayList<>(treeSet);

        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);

            for (int j = list.size() - 1; j >= 0; j--) {
                if (list.get(j) - temp >= m) {
                    result = list.get(j) - temp;
                } else {
                    break;
                }
            }
        }

        System.out.println(result);
    }
}