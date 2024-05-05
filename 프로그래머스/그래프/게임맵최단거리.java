import java.util.*;

class 게임맵최단거리 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n, m;
    static boolean[][] visited;
    static int[][] board;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int dist = 1;

    static int bfs(int x, int y) {
        Queue<Point> q = new ArrayDeque<>();

        q.add(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point cursor = q.poll();
            dist++;

            int a = cursor.x;
            int b = cursor.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = a + dx[dir];
                int ny = b + dy[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny] || board[nx][ny] == 0) {
                    continue;
                }

                board[nx][ny] = board[a][b] + 1;
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }

        return board[n - 1][m - 1];
    }

    public int solution(int[][] maps) {

        n = maps.length;
        m = maps[0].length;

        visited = new boolean[n][m];
        board = new int[n][m];

        board = maps;

        int answer = bfs(0, 0);
        return answer == 1 ? -1 : answer;
    }
}