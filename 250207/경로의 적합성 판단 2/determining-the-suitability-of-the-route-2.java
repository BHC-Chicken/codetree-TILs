import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;

    static void union(int x, int y) {
        int findX = find(x);
        int findY = find(y);

        arr[findX] = arr[findY];
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

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }

        boolean flag = true;
        String[] input = br.readLine().split(" ");

        for(int i = 0; i < k - 1; i++) {
            int a = Integer.parseInt(input[i]);
            int b = Integer.parseInt(input[i + 1]);

            if(find(a) != find(b)) {
                flag = false;

                break;
            }
        }

        if(flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}