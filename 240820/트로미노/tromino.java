import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;

    public static int[][][] shapes = new int[][][]{
            {{1, 1, 0},
             {1, 0, 0},
             {0, 0, 0}},

            {{1, 1, 0},
             {0, 1, 0},
             {0, 0, 0}},

            {{1, 0, 0},
             {1, 1, 0},
             {0, 0, 0}},

            {{0, 1, 0},
             {1, 1, 0},
             {0, 0, 0}},

            {{1, 1, 1},
             {0, 0, 0},
             {0, 0, 0}},

            {{1, 0, 0},
             {1, 0, 0},
             {1, 0, 0}},
    };
    
    public static int getMaxSum(int x, int y) {
        int maxSum = 0;

        for(int i = 0; i < 6; i++) {
            int sum = 0;
            boolean isPossible = true;
            
            for(int dx = 0; dx < 3; dx++)
                for(int dy = 0; dy < 3; dy++) {
                    if(shapes[i][dx][dy] == 0){
                        continue;
                    }
                    if(x + dx >= n || y + dy >= m) {
                        isPossible = false;
                    } else {
                        sum += map[x + dx][y + dy];
                    }
                }

            if(isPossible)
                maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                result = Math.max(result, getMaxSum(i, j));

        System.out.print(result);
    }
}