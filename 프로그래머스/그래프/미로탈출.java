import java.util.*;

class 미로탈출 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static char[][] board;
    static int[][] dist;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int N, M;

    static int bfs(Point s, Point e) {
        dist = new int[N][M];
        Queue<Point> q = new ArrayDeque<>();

        dist[s.x][s.y] = 1;
        q.add(s);

        while (!q.isEmpty()) {
            Point now = q.poll();
            int a = now.x;
            int b = now.y;

            for (int dir = 0; dir < 4; dir++) {
                int nx = a + dx[dir];
                int ny = b + dy[dir];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
                if (dist[nx][ny] > 0 || board[nx][ny] == 'X') {
                    continue;
                }
                q.add(new Point(nx, ny));
                dist[nx][ny] = dist[a][b] + 1;

                if (nx == e.x && ny == e.y) {
                    return dist[e.x][e.y] - 1;
                }
            }
        }

        return -1;
    }

    public int solution(String[] maps) {

        N = maps.length;
        M = maps[0].length();

        board = new char[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = maps[i].toCharArray();
        }

        Point start = null, exit = null, lever = null;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 'S') {
                    start = new Point(i, j);
                } else if (board[i][j] == 'E') {
                    exit = new Point(i, j);
                } else if (board[i][j] == 'L') {
                    lever = new Point(i, j);
                }
            }
        }

        int startToLever = bfs(start, lever);
        int LeverToExit = bfs(lever, exit);

        if (startToLever == -1 || LeverToExit == -1) {
            return -1;
        }

        return startToLever + LeverToExit;
    }
}