import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> treeSet = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add":
                    treeSet.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    treeSet.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "find":
                    if (treeSet.contains(Integer.parseInt(st.nextToken()))) {
                        sb.append("true").append("\n");
                    } else {
                        sb.append("false").append("\n");
                    }
                    break;
                case "lower_bound":
                    Integer temp1 = treeSet.floor(Integer.parseInt(st.nextToken()));

                    if (temp1 != null) {
                        sb.append(temp1).append("\n");
                    } else {
                        sb.append("None").append("\n");
                    }
                    break;
                case "upper_bound":
                    Integer temp2 = treeSet.ceiling(Integer.parseInt(st.nextToken()));

                    if (temp2!= null) {
                        sb.append(temp2).append("\n");
                    } else {
                        sb.append("None").append("\n");
                    }
                    break;
                case "largest":
                    if (treeSet.isEmpty()) {
                        sb.append("None").append("\n");
                    } else {
                        sb.append(treeSet.last()).append("\n");
                    }
                    break;
                case "smallest":
                    if (treeSet.isEmpty()) {
                    sb.append("None").append("\n");
                } else {
                    sb.append(treeSet.first()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}