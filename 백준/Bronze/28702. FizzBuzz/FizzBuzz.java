import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = 0;
        String bf = "";
        for (int i = 3; i > 0; i--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            if (!str.equals("Fizz") && !str.equals("Buzz") && !str.equals("FizzBuzz")) {
                num = i;
                bf = str;
            }
        }

        int a = Integer.parseInt(bf) + num;

        if (a % 3 == 0 && a % 5 == 0) {
            System.out.print("FizzBuzz");
        } else if (a % 3 == 0 && a % 5 > 0) {
            System.out.print("Fizz");
        } else if (a % 3 > 0 && a % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(a);
        }
    }
}
