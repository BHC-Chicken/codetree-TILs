import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        double m = Integer.parseInt(st.nextToken());

        Jewelry[] arr = new Jewelry[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            arr[i] = new Jewelry(w, v, (double) v / w);
        }

        double result = 0;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            if (m - arr[i].weight > 0) {
                m -= arr[i].weight;
                result += arr[i].value;
            } else {
                double temp = m / arr[i].weight;
                result += arr[i].value * temp;

                break;
            }
        }

        result = (double) Math.round(result * 1000) /1000;
        System.out.printf("%.3f%n", result);
    }
}

class Jewelry implements Comparable<Jewelry> {
    int weight;
    int value;
    double valueForWeight;

    public Jewelry(int weight, int value, double valueForWeight) {
        this.weight = weight;
        this.value = value;
        this.valueForWeight = valueForWeight;
    }

    @Override
    public int compareTo(Jewelry o) {
        if (this.valueForWeight == o.valueForWeight) {
            return o.value - this.value;
        }

        return Double.compare(o.valueForWeight, this.valueForWeight);
    }
}