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

    int[] arr, targetArr;
    int size, loop;

    public void solve() {
        binarySearch();
    }

    private void binarySearch() {
        StringBuilder sb = new StringBuilder();
        for(int target : targetArr) {
            int left = 0, right = arr.length-1, minIdx = arr.length;
            boolean flag = false;
            while(left<=right) {
                int mid = (left+right)/2;
                if(target == arr[mid]) flag = true;
                if(target <= arr[mid]) {
                    right = mid - 1;
                    minIdx = Math.min(minIdx, mid);
                }
                else {
                    left = mid + 1;
                }
            }
            if(flag) sb.append(minIdx+1).append("\n");
            else sb.append(-1).append("\n");
        }
        System.out.print(sb);
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        loop = Integer.parseInt(st.nextToken());

        arr = new int[size];
        targetArr = new int[loop];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < loop; i++) {
            targetArr[i] = Integer.parseInt(st.nextToken());
        }
    }
}