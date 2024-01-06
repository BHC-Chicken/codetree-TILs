import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<Integer> list;
    static int answer;

    public static void choose(int num) {
        if (num == n + 1) {
            beautiful();
            return;
        }

        for (int i = 1; i <= 4; i++) {
            list.add(i);
            choose(num + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void beautiful() {
        for (int i = 0; i < n; i += list.get(i)) {
            if (i + list.get(i) - 1 >= n) {
                return;
            }

            for (int j = i; j < i + list.get(i); j++) {
                if (list.get(j) != list.get(i)) {
                    return;
                }
            }
        }

        answer++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        choose(1);

        System.out.println(answer);
    }
}