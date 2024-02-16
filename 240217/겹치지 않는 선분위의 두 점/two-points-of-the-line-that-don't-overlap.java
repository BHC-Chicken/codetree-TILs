import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Line[] lines = new Line[m];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = new Line(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        Arrays.sort(lines, (a, b) -> Long.compare(a.x1, b.x1));

        long left = 0;
        long right = lines[m - 1].x2;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int i = 0; i < m; i++) {
                long temp = lines[i].x2 - lines[i].x1;

                if (temp >= mid) {
                    while (temp >= 0) {
                        temp -= mid;
                        count++;
                    }
                } else if (temp == 0) {
                    count++;
                }
            }

            if (count >= n) {
                left = mid + 1;
                result = Math.max(result, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }
}

class Line {
    long x1;
    long x2;

    public Line(long x1, long x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}