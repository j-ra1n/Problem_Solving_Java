import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int k;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[k];

        long left = 0;
        long right = 0;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }


        while (left <= right) {
            long mid = (left + right) / 2;

            if(isPossible(mid) >= n)
            {
                left = mid + 1;
            }else
            {
                right = mid - 1;
            }
        }

        System.out.println(right);

    }

    private static long isPossible(long n) {
        if(n==0) return Long.MAX_VALUE;
        long sum =0;
        for(int i=0; i<k; i++)
        {
            sum += (arr[i] / n);
        }

        return sum;
    }

}
