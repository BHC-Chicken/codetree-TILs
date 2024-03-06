import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

class Pair {
    int now;
    HashSet<Integer> prev = new HashSet<>();

    public Pair(int now) {
        this.now = now;
        prev.add(now);
    }
}

class SwapPair {
    int a;
    int b;

    public SwapPair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    static Pair[] pairs;

    static void swap(int a, int b) {
        pairs[a].prev.add(b);
        pairs[b].prev.add(a);

        Pair temp = pairs[a];
        pairs[a] = pairs[b];
        pairs[b] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        pairs = new Pair[n + 1];
        SwapPair[] swapPairs = new SwapPair[k];

        for (int i = 1; i <= n; i++) {
            pairs[i] = new Pair(i);
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            swapPairs[i] = new SwapPair(a, b);
        }

        int index = 0;
        for (int i = 0; i < k * 3; i++) {
            swap(swapPairs[index].a, swapPairs[index].b);
            index++;

            if (index == k) {
                index = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            sb.append(pairs[i].prev.size()).append("\n");
        }

        System.out.println(sb);
    }
}