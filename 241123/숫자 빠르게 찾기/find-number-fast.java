import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BSol sol = new BSol();
        sol.init();
        sol.solve();
    }
}

class BSol {
    int[] arr;
    int size = 0, loop = 0;
    StringBuilder sb;
    BufferedReader br;

    public void solve() throws IOException {
        for(int i = 0; i < loop; i++) {
            int target = Integer.parseInt(br.readLine());
            int left = 0, right = arr.length-1;
            boolean flag = false;
            while(left <= right) {
                int mid = (left+right)/2;
                /* 값 발견 */
                if(arr[mid] == target) {
                    sb.append(mid+1).append("\n");
                    flag = true;
                    break;
                }
                if(arr[mid] < target) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
            if(!flag) sb.append(-1).append("\n");
        }
        System.out.println(sb);
    }

    public void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        size = Integer.parseInt(st.nextToken());
        loop = Integer.parseInt(st.nextToken());
        arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) {
            int node = Integer.parseInt(st.nextToken());
            arr[i] = node;
        }
    }
}