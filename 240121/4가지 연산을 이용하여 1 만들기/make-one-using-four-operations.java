import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[N+4];
        int[] count = new int[N+4];
        Queue<Integer> queue = new LinkedList<>();

        visited[N] = true;
        queue.add(N);

        while(!queue.isEmpty()) {
            int num = queue.poll();

            if(num == 1) {
                System.out.println(count[1]);
                return;
            }

            if(num % 3 == 0 && !visited[num/3]) {
                visited[num/3] = true;
                queue.add(num/3);
                count[num/3] = count[num] + 1;
            }

            if(num % 2 == 0 && !visited[num/2]) {
                visited[num/2] = true;
                queue.add(num/2);
                count[num/2] = count[num] + 1;
            }

            if(num - 1 > 0 && !visited[num-1]) {
                visited[num-1] = true;
                queue.add(num-1);
                count[num-1] = count[num] + 1;
            }

            if(num + 1 < N+3 && !visited[num+1]) {
                visited[num+1] = true;
                queue.add(num+1);
                count[num+1] = count[num] + 1;
            }
        }
    }
}