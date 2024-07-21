import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static boolean circle;

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
            arr[findA] = findB;
        } else {
            circle = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= m ; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);

            if (circle) {
                System.out.println(i);

                return;
            }
        }

        System.out.println("happy");
    }
}