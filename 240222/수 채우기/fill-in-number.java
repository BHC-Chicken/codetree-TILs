import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int result = 0;

        if (num / 2 == 0 || num / 5 == 0) {
            System.out.println(-1);

            return;
        }

        result += num / 5;
        num = num - (num / 5 * 5);

        if (num % 2 != 0) {
            result--;
            num += 5;
        }

        result += num / 2;
        num = num - (num / 2 * 2);

        if (num == 0) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}