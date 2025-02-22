import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> dq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!dq.contains(num)) {
                dq.add(num);
            }
        }

        while(!dq.isEmpty()) {
            System.out.print(dq.poll());
            System.out.print(" ");
        }



    }
}
