import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int score = 0;

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr1);
        int index1 = 0;
        int index2 = 0;

        for (int i = 1; i <= n * 2; i++) {
            if (arr1[index2] != i) {
                arr2[index1++] = i;

            } else {
                index2++;

                if (index2 == n) {
                    index2 = (n - 1);
                }
            }
        }

        Arrays.sort(arr2);

        for (int i = 0; i < n; i++) {
            if (arr1[i] < arr2[i]) {
                score++;
            }
        }

        System.out.println(score);
    }
}