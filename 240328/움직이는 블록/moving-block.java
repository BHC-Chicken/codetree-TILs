import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int total = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);

            total += num;
        }

        int avg = total / list.size();

        for (int i : list) {
            if (i > avg) {
                count += i - avg;
            }
        }

        System.out.println(count);
    }
}