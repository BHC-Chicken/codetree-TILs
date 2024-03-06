import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int aNum = Integer.parseInt(st.nextToken());
        int bNum = Integer.parseInt(st.nextToken());

        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        int[] arr1 = new int[aNum];
        int[] arr2 = new int[bNum];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aNum; i++) {
            int temp = Integer.parseInt(st.nextToken());

            hashSet1.add(temp);
            arr1[i] = temp;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bNum; i++) {
            int temp = Integer.parseInt(st.nextToken());

            hashSet2.add(temp);
            arr2[i] = temp;
        }

        for (int i : arr2) {
            hashSet1.remove(i);
        }

        for (int i : arr1) {
            hashSet2.remove(i);
        }

        hashSet1.addAll(hashSet2);

        System.out.println(hashSet1.size());
    }
}