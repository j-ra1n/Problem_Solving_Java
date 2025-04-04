import java.util.*;
import java.io.*;

public class Main {

    private static int M;
    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N + 1];
        arr[0] = true;
        arr[1] = true;

        for (int i = 2; i * i <= N; i++) {
            if (!arr[i]) {
                for (int j = i * i; j <= N; j += i) {
                    arr[j] = true;
                }
            }
        }

        for(int i=M; i<=N; i++)
        {
            if(!arr[i])
            {
                System.out.println(i);
            }
        }
    }
}
