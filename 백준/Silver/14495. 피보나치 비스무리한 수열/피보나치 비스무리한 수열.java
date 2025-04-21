import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());

        ArrayList<Long> arr = new ArrayList<>();

        arr.add(0L);
        arr.add(1L);
        arr.add(1L);
        arr.add(1L);

        if (n < 4) {
            System.out.println(1);
        } else {
            for (long i = 4; i < n; i++) {
                arr.add(arr.get((int) (i - 1)) + arr.get((int) (i - 3)));
            }

            System.out.println(arr.get((int) (n - 1)) + arr.get((int) (n - 3)));
        }

    }
}
