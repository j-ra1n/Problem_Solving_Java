import java.util.*;
import java.io.*;

public class Main {

    private static int N;
    private static int M;
    private static int X;
    private static int Y;
    private static int l;
    private static int count = 1;
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0}; // 북동남서
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        clean(X, Y, l);
        System.out.print(count);

    }

    private static void clean(int x, int y, int d) {

        map[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4; // 반시계 회전

            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                count++;
                clean(nx, ny, d);
                return;
            }
        }


        int back = (d + 2) % 4; // 반대 방향 후진
        int bx = x + dx[back];
        int by = y + dy[back];
        if (bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
            clean(bx, by, d);
        }
    }
}



