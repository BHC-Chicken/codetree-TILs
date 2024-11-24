import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        lineSol sol = new lineSol();
        sol.init();
        sol.solve();
    }
}

class lineSol {

    ArrayList<Pair> lineList;
    int[] vertex;
    int size, loop;

    public void solve() {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(vertex);
        for(Pair pair : lineList) {
            int lower = pair.x;
            int upper = pair.y;
            int res = upperBound(upper) - lowerBound(lower);
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    private int lowerBound(int target) {
        int left = 0, right = vertex.length-1, minIdx = vertex.length;
        while(left <= right) {
            int mid = (left+right)/2;
            if(target <= vertex[mid]) {
                right = mid - 1;
                minIdx = Math.min(mid, minIdx);
            }
            else {
                left = mid + 1;
            }
        }
        return minIdx;
    }

    private int upperBound(int target) {
        int left = 0, right = vertex.length-1, minIdx = vertex.length;
        while(left <= right) {
            int mid = (left+right)/2;
            if(target < vertex[mid]) {
                right = mid - 1;
                minIdx = Math.min(mid, minIdx);
            }
            else {
                left = mid + 1;
            }
        }
        return minIdx;
    }

    public void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        loop = Integer.parseInt(st.nextToken());

        vertex = new int[size];
        lineList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++) {
            vertex[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            lineList.add(new Pair(x, y));
        }
    }
}

class Pair {
    int x,y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}