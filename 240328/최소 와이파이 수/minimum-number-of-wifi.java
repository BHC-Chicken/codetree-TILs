import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int result = 0;
        int one = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            
            if (num == 1) {
                one++;
            }
        }
        
        if (m == 0) {
            System.out.println(one);
            
            return;
        }

        boolean check = false;
        boolean resultCheck = false;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 1 && !check && !resultCheck) {
                check = true;
                count++;
            } else if (check) {
                count++;
            } else if (resultCheck) {
                count--;

                if (count == 0) {
                    resultCheck = false;
                }
            }

            if (count == m + 1) {
                result++;
                count--;
                resultCheck = true;
                check = false;
            }
        }

        System.out.println(result);
    }
}