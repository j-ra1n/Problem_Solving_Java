import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] number = new int[n];
        int[] result = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = n - 1; i >= 0; i--) {
            int num = Integer.parseInt(st.nextToken());
            number[i] = num;
        }

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && stack.peekLast() <= number[i]) {
                stack.pollLast();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
               result[i] = stack.peekLast();
            }
            stack.addLast(number[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            bw.write(result[i] + " ");
        }

        bw.flush();

    }
}
