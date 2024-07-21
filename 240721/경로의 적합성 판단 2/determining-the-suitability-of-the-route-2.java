import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[] arr;
    static int[] nums;

    static int find(int x) {
        if (arr[x] == x) {
            return x;
        }

        return arr[x] = find(arr[x]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        arr[fa] = fb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        st = new StringTokenizer(br.readLine());

        int root = find(1);

        for (int i = 2; i <= k; i++) {
            if (root != find(i)) {
                System.out.println(0);

                return;
            }
        }

        System.out.println(1);
    }
}