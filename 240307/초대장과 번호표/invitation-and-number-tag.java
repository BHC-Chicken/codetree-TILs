import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);

        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            HashSet<Integer> temp = new HashSet<>();

            for (int j = 0; j < num; j++) {
                temp.add(Integer.parseInt(st.nextToken()));
            }

            for (int t : hashSet) {
                temp.remove(t);
            }

            if (temp.size() == 1) {
                hashSet.addAll(temp);
            }
        }

        System.out.println(hashSet.size());
    }
}