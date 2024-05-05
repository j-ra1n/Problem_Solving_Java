import java.io.*;
import java.util.*;

class 그림_1926 {

    static Queue<int[]> q = new LinkedList<>();

    static boolean[][] visited;

    static int[][] board;
    static int n, m;

    static int num, size;

    static int[] dx = { 1, -1, 0, 0 };

    static int[] dy = { 0, 0, 1, -1 };

    static void bfs(int x, int y) {

        int nowsize = 0;
        visited[x][y] = true;
        q.add(new int[] { x, y });

        while (!q.isEmpty()) {

            int[] cursor = q.poll();
            nowsize++;

            int a = cursor[0];
            int b = cursor[1];

            for (int i = 0; i < dx.length; i++) {

                int nx = a + dx[i];
                int ny = b + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (visited[nx][ny] || board[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                q.add(new int[] { nx, ny });
            }

        }

        size = Math.max(nowsize, size);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); // 새로운 행을 읽고 토큰화
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); // nextToken() 으로 하나씩가져옴
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!visited[i][j] && board[i][j] == 1) {
                    num++;
                    bfs(i, j);

                }
            }
        }

        System.out.println(num);
        System.out.println(size);

    }

}