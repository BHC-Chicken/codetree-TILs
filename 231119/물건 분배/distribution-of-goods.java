import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        int count = 0;

        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

            list.add(size);
        }

        list.sort(Collections.reverseOrder());

        for (int i = 0;i < k; i++) {
            count++;

            n -= list.get(i);

            if (n <= 0) {
                break;
            }
        }

        System.out.println(count);
    }
}