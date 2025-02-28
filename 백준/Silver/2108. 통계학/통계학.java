import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        int sum = 0;

        int[] count = new int[8001];
        int max = 0;
        int mode = 0;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            count[arr[i] + 4000]++;

        }

        Arrays.sort(arr);

        for (int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                mode = i - 4000;
                max = count[i];
                flag = true;
            } else if (count[i] == max && flag == true) {
                mode = i - 4000;
                flag = false;
            }
        }

        System.out.println(Math.round((double) sum / n));
        System.out.println(arr[n / 2]);
        System.out.println(mode);
        System.out.println(arr[n - 1] - arr[0]);
    }
}
