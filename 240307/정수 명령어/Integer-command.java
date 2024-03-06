import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Integer> treeSet = new TreeSet<>();
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            int loop = Integer.parseInt(br.readLine());

            for (int j = 0; j < loop; j++) {
                st = new StringTokenizer(br.readLine());

                String command = st.nextToken();

                if (command.equals("I")) {
                    treeSet.add(Integer.parseInt(st.nextToken()));
                } else {
                    int num = Integer.parseInt(st.nextToken());

                    if (!treeSet.isEmpty()) {
                        if (num == 1) {
                            treeSet.remove(treeSet.last());
                        } else {
                            treeSet.remove(treeSet.first());
                        }
                    }
                }
            }

            if (treeSet.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(treeSet.last()).append(" ").append(treeSet.first()).append("\n");
            }
        }

        System.out.println(sb);
    }
}