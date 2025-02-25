import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());


        String[] board = new String[row];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            board[i] = st.nextToken();
        }

        int sol = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                int cursol = getSolution(i, j, board);

                if (sol > cursol) {
                    sol = cursol;
                }
            }
        }

        System.out.println(sol);


    }

    public static int getSolution(int startrow, int startcol, String[] board) {
        String[] originBoard = {"WBWBWBWB", "BWBWBWBW"};

        int white = 0;
        for (int i = 0; i < 8; i++) {
            int row = startrow + i;
            for (int j = 0; j < 8; j++) {
                int col = startcol + j;
                if (board[row].charAt(col) != originBoard[row % 2].charAt(j)) {
                    white++;
                }
            }

        }

        return Math.min(white, 64 - white);
    }
}
