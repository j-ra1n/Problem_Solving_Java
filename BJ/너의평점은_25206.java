import java.util.*;
import java.io.*;

class 너의평점은_25206 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        String[] str = new String[20];
        double credit = 0;
        double sum = 0;

        for (int i = 0; i < 20; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < 20; i++) {
            String[] s = str[i].split(" ");

            if (map.containsKey(s[2])) {
                sum += (map.get(s[2]) * Double.parseDouble(s[1]));
                credit += Double.parseDouble(s[1]);
            }

        }

        double average = sum / credit;

        System.out.printf("%.6f\n", average);

    }
}