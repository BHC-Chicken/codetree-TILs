import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] size;

    static void union(int x, int y) {
        int findX = find(x);
        int findY = find(y);

        if(findX != findY) {
            arr[findX] = findY;
            size[findY] += size[findX];
        }
    }

    static int find(int x) {
        if(arr[x] == x) {

            return x;
        }

        return arr[x] = find(arr[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        size = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            int a = Integer.parseInt(st.nextToken());

            if(cmd.equals("x")) {
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            } else {
                int findSize = find(a);
                sb.append(size[findSize]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
