import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();
        StringTokenizer st;

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add":
                    hashSet.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    hashSet.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "find":
                    if (hashSet.contains(Integer.parseInt(st.nextToken()))) {
                        sb.append("true");
                    } else {
                        sb.append("false");
                    }
                    sb.append("\n");

                    break;
            }
        }

        System.out.println(sb);
    }
}