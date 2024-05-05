import java.io.*;
import java.util.*;

public class 안전영역_2468 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Point> q = new ArrayDeque<>();
    static int[][] board;
    static boolean[][] visited;
    static int N;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    static void bfs(int x, int y, int wH) {
        visited[x][y] = true;

        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point cursor = q.poll();
            int a = cursor.x;
            int b = cursor.y;

            for (int dir = 0; dir < 4; dir++) {

                int nx = a + dx[dir];
                int ny = b + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                if (board[nx][ny] <= wH || visited[nx][ny]) {
                    continue;
                }

                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int maxSz = 0, size = 0, maxH = 0;

        visited = new boolean[N][N];
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] > maxH) {
                    maxH = board[i][j];
                }
            }
        }

        for (int wH = 0; wH <= maxH; wH++) {
            visited = new boolean[N][N];
            size = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (!visited[i][j] && board[i][j] > wH) {
                        bfs(i, j, wH);
                        size++;
                    }
                }
            }
            maxSz = Math.max(maxSz, size);
        }

        System.out.println(maxSz);
    }
}
