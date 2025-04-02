import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String line;
        while ((line = br.readLine()) != null) {
            int[] count = new int[4];
            char[] arr;
            arr = line.toCharArray();

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] >= 'a' && arr[i] <= 'z') count[0]++;
                if (arr[i] >= 'A' && arr[i] <= 'Z') count[1]++;
                if (arr[i] >= '0' && arr[i] <= '9') count[2]++;
                if (arr[i] == ' ') count[3]++;
            }
            System.out.println(count[0] + " " + count[1] + " " + count[2] + " " + count[3]);
        }

    }
}
