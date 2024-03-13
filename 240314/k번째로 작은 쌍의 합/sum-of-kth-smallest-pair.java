import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    int first;
    int second;
    int value;

    public Pair(int first, int second, int value) {
        this.first = first;
        this.second = second;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.value != o.value) {
            return this.value - o.value;
        } else if (this.first != o.first) {
            return this.first - o.first;
        } else {
            return this.second - o.second;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < n; i++) {
            pq.add(new Pair(i, 0, arr1[i] + arr2[0]));
        }

        for (int i = 0; i < k - 1; i++) {
            Pair pair = pq.poll();

            int first = pair.first;
            int second = pair.second;

            second++;

            if (second < m) {
                pq.add(new Pair(first, second, arr1[first] + arr2[second]));
            }
        }

        System.out.println(pq.peek().value);
    }
}