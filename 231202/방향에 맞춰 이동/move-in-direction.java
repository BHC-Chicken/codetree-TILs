import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            String dir = st.nextToken();
            int num = Integer.parseInt(st.nextToken());

            if (dir.equals("N")) {
                startX += dx[3] * num;
                startY += dy[3] * num;
            } else if (dir.equals("S")) {
                startX += dx[1] * num;
                startY += dy[1] * num;
            } else if (dir.equals("W")) {
                startX += dx[2] * num;
                startY += dy[2] * num;
            } else if (dir.equals("E")) {
                startX += dx[0] * num;
                startY += dy[0] * num;
            }
        }

        System.out.println(startX + " " + startY);
    }
}