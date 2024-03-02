import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String init = br.readLine();
        String target = br.readLine();
        int count = 0;
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (init.charAt(i) != target.charAt(i)) {
                count++;
            } else {
                if (count > 0) {
                    result++;
                    count = 0;
                }
            }
        }

        System.out.println(result);
    }
}