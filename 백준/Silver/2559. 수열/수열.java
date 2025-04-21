import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] num = new int[n];
        int[] prefix = new int[n + 1];


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            num[i] = a;
        }

        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] + num[i - 1];
        }

        int max = Integer.MIN_VALUE;
        for (int i = k; i < n + 1; i++) {
            int sum = prefix[i] - prefix[i - k];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
