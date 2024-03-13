import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class People implements Comparable<People> {
    int waitNumber;
    int arrival;
    int stay;
    int leave;

    public People(int waitNumber, int arrival, int stay, int leave) {
        this.waitNumber = waitNumber;
        this.arrival = arrival;
        this.stay = stay;
        this.leave = leave;
    }

    @Override
    public int compareTo(People o) {

        return this.arrival - o.arrival;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<People> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int result = 0;

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int arrival = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            People people = new People(i, arrival, time, arrival + time);
            queue.add(people);
        }

        People people = queue.poll();
        int currentTime = people.leave;

        while (!queue.isEmpty()) {
            ArrayList<People> peoples = new ArrayList<>();
            while (true) {
                if (queue.isEmpty()) {
                    break;
                }
                if (queue.peek().arrival <= currentTime) {
                    peoples.add(queue.poll());
                } else if (peoples.isEmpty()){
                    currentTime = queue.poll().leave;
                } else {
                    break;
                }
            }

            peoples.sort((a, b) -> {
                return a.waitNumber - b.waitNumber;
            });

            int size = peoples.size();

            for (int i = 0; i < size; i++) {
                People temp = peoples.get(i);
                int wait = currentTime - temp.arrival;
                currentTime += temp.stay;

                result = Math.max(result, wait);
            }
        }

        System.out.println(result);
    }
}