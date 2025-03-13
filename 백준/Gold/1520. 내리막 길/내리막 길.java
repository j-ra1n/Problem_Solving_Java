import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] rx = {0, 0, 1, -1};
    private static int[] ry = {1, -1, 0, 0};
    private static int[][] map;
    private static int[][] count;
    private static int N;
    private static int M;

    private static class Node {
        int r, c;

        private Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        count = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                count[i][j] = -1;
            }
        }

        count[N - 1][M - 1] = 1;
        dfs(new Node(0, 0));

        System.out.println(count[0][0]);
    }

    private static int dfs(Node node) {

        if (count[node.r][node.c] > -1) return count[node.r][node.c];

        count[node.r][node.c] = 0;

        for (int dir = 0; dir < 4; dir++) {
            int nx = node.r + rx[dir];
            int ny = node.c + ry[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            if (map[node.r][node.c] > map[nx][ny]) {
                count[node.r][node.c] += dfs(new Node(nx, ny));
            }
        }

        return count[node.r][node.c];
    }
}
