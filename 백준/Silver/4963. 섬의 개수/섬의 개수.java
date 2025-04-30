import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    private static int[] dy = {1, -1, 0, 1, -1, 0, 1, -1};
    private static int[][] board;
    private static boolean[][] visited;
    private static int cnt;
    private static int w;
    private static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            board = new int[h][w];
            visited = new boolean[h][w];
            cnt = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }


    }

    private static void dfs(int i, int j) {

        for (int dir = 0; dir < 8; dir++) {
            int nx = i + dx[dir];
            int ny = j + dy[dir];

            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if (visited[nx][ny] || board[nx][ny] == 0) continue;

            visited[nx][ny] = true;

            dfs(nx, ny);
        }
    }
}
