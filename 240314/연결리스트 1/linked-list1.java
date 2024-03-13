import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
    String data;
    Node next;
    Node prev;

    public Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Main {
    static Node origin;

    static void insertNext(String s) {
        Node node = new Node(s);

        node.prev = origin;
        node.next = origin.next;

        if (node.prev != null) {
            node.prev.next = node;
        }

        if (node.next != null) {
            node.next.prev = node;
        }
    }

    static void insertPrev(String s) {
        Node node = new Node(s);

        node.next = origin;
        node.prev = origin.prev;

        if (node.next != null) {
            node.next.prev = node;
        }

        if (node.prev != null) {
            node.prev.next = node;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        origin = new Node(br.readLine());

        int loop = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            switch (num) {
                case 1:
                    insertPrev(st.nextToken());
                    break;
                case 2:
                    insertNext(st.nextToken());
                    break;
                case 3:
                    if (origin.prev != null) {
                        origin = origin.prev;
                    }
                    break;
                case 4:
                    if (origin.next != null) {
                        origin = origin.next;
                    }
            }
            if (origin.prev == null) {
                sb.append("(Null) ");
            } else {
                sb.append(origin.prev.data).append(" ");
            }
            sb.append(origin.data).append(" ");
            if (origin.next == null) {
                sb.append("(Null)");
            } else {
                sb.append(origin.next.data);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}