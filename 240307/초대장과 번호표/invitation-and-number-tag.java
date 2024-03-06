import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int answer = 0;

        ArrayList<Integer>[] people = new ArrayList[n];
        HashSet<Integer>[] group = new HashSet[g];

        Queue<Integer> queue = new LinkedList<>();
        boolean[] invite = new boolean[n];

        for (int i = 0; i < n; i++) {
            people[i] = new ArrayList<>();
        }

        for (int i = 0; i < g; i++) {
            group[i] = new HashSet<>();
        }

        for (int i = 0; i < g; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            for (int j = 0; j < num; j++) {
                int p = Integer.parseInt(st.nextToken()) - 1;
                group[i].add(p);
                people[p].add(i);
            }
        }

        queue.add(0);
        invite[0] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            answer++;

            for (int i = 0; i < people[curr].size(); i++) {
                int groupNumber = people[curr].get(i);

                group[groupNumber].remove(curr);

                if (group[groupNumber].size() == 1) {
                    int person = new ArrayList<>(group[groupNumber]).get(0);

                    if (!invite[person]) {
                        invite[person] = true;
                        queue.add(person);
                    }
                }
            }
        }

        System.out.println(answer);
    }
}