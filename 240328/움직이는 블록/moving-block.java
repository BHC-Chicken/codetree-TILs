import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);

        while (list.get(0) != list.get(list.size() - 1)) {
            int min = list.get(0);
            int max = list.get(list.size() - 1);

            list.set(0, min + 1);
            list.set(list.size() - 1, max - 1);

            count++;

            Collections.sort(list);
        }

        System.out.println(count);
    }
}