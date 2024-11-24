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
    int size, start, end;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public void solve() {
        StringBuilder sb = new StringBuilder();
        for(int time = start; time <= end; time++) {
            int cnt = gameStart(time);
            min = Math.min(min, cnt);
            max = Math.max(max, cnt);
        }
        sb.append(min+1).append(" ").append(max+1);
        System.out.print(sb);
    }

    private int gameStart(int target) {
        int left = 1, right = end, cnt = 0;
        while(left<=right) {
            int mid = (left+right)/2;
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
        size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }
}