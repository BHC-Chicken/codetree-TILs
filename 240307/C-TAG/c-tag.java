import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 0;

        String[] arr1 = new String[n];
        String[] arr2 = new String[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            arr2[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                for (int k = j + 1; k < m; k++) {
                    HashSet<String> hashSet = new HashSet<>();
                    boolean success = true;

                    for (int l = 0; l < n; l++) {
                        hashSet.add(arr1[l].substring(i, i + 1) + arr1[l].substring(j, j + 1) + arr1[l].substring(k,
                                k + 1));
                    }

                    for (int l = 0; l < n; l++) {
                        if (hashSet.contains(
                                arr2[l].substring(i, i + 1) + arr2[l].substring(j, j + 1) + arr2[l].substring(k,
                                        k + 1))) {
                            success = false;
                            break;
                        }
                    }

                    if (success) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }
}