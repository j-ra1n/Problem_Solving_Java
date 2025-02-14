import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] numarr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int val = sc.nextInt();
            numarr[i] = (val + numarr[i - 1]);
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            System.out.println(numarr[end] - numarr[start - 1]);
        }

    }
}