import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int[] size;

    static int find(int a) {
        if (a == arr[a]) {
            return a;
        }

        return arr[a] = find(arr[a]);
    }

    static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA != findB) {
            if (size[findA] < size[findB]) {
                int temp = findA;
                findA = findB;
                findB = temp;
            }
            arr[findB] = findA;
            size[findA] += size[findB];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = 0;
            if (st.hasMoreTokens()) {
                b = Integer.parseInt(st.nextToken());
            }

            if (cmd.equals("x")) {
                union(a, b);
            } else {
                int root = find(a);
                sb.append(size[root]).append("\n");
            }
        }

        System.out.println(sb);
    }
}