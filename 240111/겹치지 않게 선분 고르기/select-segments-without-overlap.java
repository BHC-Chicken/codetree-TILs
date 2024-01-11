import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Pair[] pairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // 선분들을 끝점(x2)를 기준으로 오름차순 정렬
        Arrays.sort(pairs);

        int answer = 0;
        int lastEnd = 0;
        for (int i = 0; i < n; i++) {
            // 현재 선분의 시작점이 이전 선분의 끝점보다 크거나 같으면 이 선분을 선택
            if (pairs[i].x1 > lastEnd) {
                answer++;
                lastEnd = pairs[i].x2;
            }
        }

        System.out.println(answer);
    }
}

class Pair implements Comparable<Pair> {
    int x1;
    int x2;

    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Pair o) {
        // 끝점이 같을 경우 시작점이 큰 순으로 정렬
        if (this.x2 == o.x2) {
            return o.x1 - this.x1;
        } else {
            return this.x2 - o.x2;  // 끝점을 기준으로 오름차순 정렬
        }
    }
}