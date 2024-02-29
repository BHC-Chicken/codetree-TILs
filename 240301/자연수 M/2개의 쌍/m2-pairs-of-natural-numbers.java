import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Pair implements Comparable<Pair> {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Pair o) {
        return this.y - o.y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Pair> list = new ArrayList<>();
        long result = Long.MIN_VALUE;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Pair(x, y));
        }

        Collections.sort(list);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            result = Math.max(result, list.get(left).y + list.get(right).y);

            if (list.get(left).x > list.get(right).x) {
                list.get(left).x -= list.get(right).x;
                right--;
            } else if (list.get(right).x > list.get(left).x){
                list.get(right).x -= list.get(left).x;
                left++;
            } else {
                left++;
                right--;
            }
        }

        System.out.println(result);
    }
}