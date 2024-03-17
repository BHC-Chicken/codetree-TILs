import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class Main {
    static void insertNext(Node origin, Node newNode) {
        newNode.prev = origin;
        newNode.next = origin.next;

        if (newNode.prev != null) {
            newNode.prev.next = newNode;
        }

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    static void insertPrev(Node origin, Node newNode) {
        newNode.next = origin;
        newNode.prev = origin.prev;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }

        if (newNode.prev != null) {
            newNode.prev.next = newNode;
        }
    }

    static void deleteNode(Node node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        }

        node.prev = null;
        node.next = null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());
        HashMap<Integer, Node> nodeHashMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            nodeHashMap.put(i, new Node(i));
        }

        int x = 0;
        int y = 0;
        Node node;
        Node newNode;
        Node originNode;

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1:
                    x = Integer.parseInt(st.nextToken());

                    deleteNode(nodeHashMap.get(x));

                    break;
                case 2:
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());

                    newNode = nodeHashMap.get(y);
                    originNode = nodeHashMap.get(x);

                    insertPrev(originNode, newNode);

                    break;

                case 3:
                    x = Integer.parseInt(st.nextToken());
                    y = Integer.parseInt(st.nextToken());

                    newNode = nodeHashMap.get(y);
                    originNode = nodeHashMap.get(x);

                    insertNext(originNode, newNode);

                    break;

                case 4:
                    x = Integer.parseInt(st.nextToken());

                    node = nodeHashMap.get(x);

                    if (node.prev != null) {
                        sb.append(node.prev.data);
                    } else {
                        sb.append(0);
                    }

                    sb.append(" ");

                    if (node.next != null) {
                        sb.append(node.next.data);
                    } else {
                        sb.append(0);
                    }

                    sb.append("\n");
            }
        }

        for (int i = 1; i <= n; i++) {
            Node eachNode = nodeHashMap.get(i);

            if (eachNode.next != null) {
                sb.append(eachNode.next.data).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}