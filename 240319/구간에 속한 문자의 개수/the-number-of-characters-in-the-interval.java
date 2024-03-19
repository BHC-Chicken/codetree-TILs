import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Triple {
    int a;
    int b;
    int c;

    public Triple(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    static Triple[][] triples;

    static void newTriple(String s, int i, int j) {
        int a = triples[i - 1][j].a + triples[i][j - 1].a - triples[i - 1][j - 1].a;
        int b = triples[i - 1][j].b + triples[i][j - 1].b - triples[i - 1][j - 1].b;
        int c = triples[i - 1][j].c + triples[i][j - 1].c - triples[i - 1][j - 1].c;

        if (s.equals("a")) {
            a++;
        } else if (s.equals("b")) {
            b++;
        } else if (s.equals("c")) {
            c++;
        }

        triples[i][j] = new Triple(a, b, c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        triples = new Triple[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            triples[0][i] = new Triple(0, 0, 0);
        }

        for (int i = 0; i <= n; i++) {
            triples[i][0] = new Triple(0, 0, 0);
        }

        for (int i = 1; i <= n; i++) {
            String[] token = br.readLine().split("");
            int index = 0;
            for (int j = 1; j <= m; j++) {
                String s = token[index++];

                newTriple(s, i, j);
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            sb.append((triples[r2][c2].a - triples[r1 - 1][c2].a - triples[r2][c1 - 1].a + triples[r1 - 1][c1 - 1].a))
                    .append(" ")
                    .append((triples[r2][c2].b - triples[r1 - 1][c2].b - triples[r2][c1 - 1].b + triples[r1 - 1][c1
                            - 1].b))
                    .append(" ")
                    .append((triples[r2][c2].c - triples[r1 - 1][c2].c - triples[r2][c1 - 1].c + triples[r1 - 1][c1
                            - 1].c))
                    .append("\n");
        }

        System.out.println(sb);
    }
}