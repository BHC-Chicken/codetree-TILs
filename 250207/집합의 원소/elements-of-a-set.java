import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;

    static void union(int x , int y) {
        int findX = find(x);
        int findY = find(y);

        arr[findX] = findY;
    }

    static int find(int x) {
        if(arr[x] == x) {
            return x;
        }

        int f = find(arr[x]);
        arr[x] = f;

        return f;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(cmd == 0) {
                union(a, b);
            } else {
                if(arr[a] == arr[b]) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}