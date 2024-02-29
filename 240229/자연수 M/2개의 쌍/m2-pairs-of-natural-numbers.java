import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        long result = Long.MAX_VALUE;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int loop = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < loop; j++) {
                list.add(num);
            }
        }

        Collections.sort(list);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            result = Math.min(result, list.get(left) + list.get(right));
            left++;
            right--;
        }

        System.out.println(result);
    }
}