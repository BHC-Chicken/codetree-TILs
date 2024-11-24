import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        GameSol sol = new GameSol();
        sol.init();
        sol.solve();
    }
}

class GameSol {
    long size, start, end;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public void solve() {
        StringBuilder sb = new StringBuilder();
        for(long time = start; time <= end; time++) {
            int cnt = gameStart(time);
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        }
        sb.append(min).append(" ").append(max);
        System.out.print(sb);
    }

    private int gameStart(long target) {
        long left = 1, right = size;
        int cnt = 0;
        while(left<=right) {
            long mid = (left+right)/2;
            cnt++;
            /* 맞췄으면 횟수 반환 */
            if(target == mid) {
                return cnt;
            }
            /* mid값 조정 */
            if(target < mid) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());
    }
}