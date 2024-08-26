import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static int[][] board;

    static void draw(int x1, int y1, int x2, int y2) {
        for(int i = x1; i <= x2; i++)
            for(int j = y1; j <= y2; j++)
                board[i][j]++;
    }

    static boolean checkBoard() {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                if(board[i][j] >= 2) {
                    return true;   
                }
        
        return false;
    }

    static boolean overlapped(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        board = new int[n][m];

        draw(x1, y1, x2, y2);
        draw(x3, y3, x4, y4);

        return checkBoard();
    }

    static int rectSum(int x1, int y1, int x2, int y2) {
        int sumOfNums = 0;
        
        for(int i = x1; i <= x2; i++)
            for(int j = y1; j <= y2; j++) {
                sumOfNums += map[i][j];
            }

        return sumOfNums;
    }

    static int findMaxSum(int x1, int y1, int x2, int y2) {
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                for(int k = i; k < n; k++)
                    for(int l = j; l < m; l++) {
                        if(!overlapped(x1, y1, x2, y2, i, j, k, l))
                            maxSum = Math.max(maxSum, rectSum(x1, y1, x2, y2) + rectSum(i, j, k, l));
                    }

        return maxSum;
    }

    static int maxSum() {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        max = Math.max(max, findMaxSum(i,j,k,l));
                    }
                }
            }
        }

        return max;
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

        System.out.println(maxSum());
    }
}