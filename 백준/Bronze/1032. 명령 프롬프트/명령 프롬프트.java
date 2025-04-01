import java.io.*;
import java.util.*;

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        char[] pattern = br.readLine().toCharArray();

        for(int i=0; i< N-1; i++)
        {
            char[] file = br.readLine().toCharArray();

            for(int j=0; j<pattern.length; j++)
            {
                if(pattern[j] != file[j])
                {
                    pattern[j] = '?';
                }
            }
        }

        System.out.println(pattern);
    }
}
