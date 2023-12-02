import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int num = 0;

        for (int i = 0; i < s.length(); i++) {
            num = num * 2 + (s.charAt(i) - '0');
        }

        sb.append(num);

        System.out.println(sb);
    }
}