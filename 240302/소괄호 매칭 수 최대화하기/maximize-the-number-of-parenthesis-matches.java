import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Pair implements Comparable<Pair> {
    int front;
    int back;

    public Pair(int front, int back) {
        this.front = front;
        this.back = back;
    }

    @Override
    public int compareTo(Pair o) {
        return o.front * this.back - this.front * o.back;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;

        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            int front = 0;
            int back = 0;
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    front++;
                } else {
                    back++;

                    answer += front;
                }
            }

            pairs[i] = new Pair(front, back);
        }

        Arrays.sort(pairs);

        int openSum = 0;
        for (int i = 0; i < n; i++) {
            answer += (long) openSum * pairs[i].back;

            openSum += pairs[i].front;
        }

        System.out.println(answer);
    }
}