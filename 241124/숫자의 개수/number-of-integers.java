import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomBoundSol Sol = new CustomBoundSol();
        Sol.init();
        Sol.solve();
    }
}

class CustomBoundSol {
    
    BufferedReader br;
    int[] arr;
    int size, loop;

    public void solve() throws IOException {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < loop; i++) {
            int target = Integer.parseInt(br.readLine());
            int maxIdx = maxBound(target);
            int minIdx = minBound(target);
            sb.append(maxIdx-minIdx).append("\n");
        }
        System.out.print(sb);
    }

    private int maxBound(int target) {
        int left = 0;
        int right = arr.length-1;
        int maxIdx = arr.length;
        while(left<=right) {
            int mid = (left+right)/2;
            if(target < arr[mid]) {
                right = mid-1;
                maxIdx = Math.min(maxIdx, mid);
            }
            else {
                left = mid+1;
            }
        }
        return maxIdx;
    }

    private int minBound(int target) {
        int left = 0;
        int right = arr.length-1;
        int maxIdx = arr.length;
        while(left<=right) {
            int mid = (left+right)/2;
            if(target <= arr[mid]) {
                right = mid-1;
                maxIdx = Math.min(maxIdx, mid);
            }
            else {
                left = mid + 1;
            }
        }
        return maxIdx;
    }

    public void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        loop = Integer.parseInt(st.nextToken());
        arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}