import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static class Node {
        int row, col;

        private Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static int[][] map;
    private static int[] rx = {0, 0, 1, -1};
    private static int[] ry = {1, -1, 0, 0};
    private static ArrayDeque<Node> virus = new ArrayDeque<>();
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                {
                    virus.addLast(new Node(i, j));
                }
            }
        }

        ArrayDeque<Node> block = new ArrayDeque<>();

        int answer = 0;

        for (int i = 0; i < N * M - 2; i++) {
            if (map[i / M][i % M] != 0) continue;
            block.addLast(new Node(i / M, i % M));

            for (int j = i + 1; j < N * M - 1; j++) {
                if (map[j / M][j % M] != 0) continue;
                block.addLast(new Node(j / M, j % M));

                for (int k = j + 1; k < N * M; k++) {
                    if (map[k / M][k % M] != 0) continue;
                    block.addLast(new Node(k / M, k % M));

                    answer = Math.max(answer, bfs(block));
                    block.pollLast();
                }
                block.pollLast();
            }
            block.pollLast();
        }

        System.out.println(answer);
    }

    private static int bfs(ArrayDeque<Node> block) {
        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        for (Node node : block) {
            copyMap[node.row][node.col] = 1;
        }

        ArrayDeque<Node> copyVirus = new ArrayDeque<>();

        for(Node node : virus)
        {
            copyVirus.addLast(node);
        }

        while (!copyVirus.isEmpty()) {
            Node now = copyVirus.pollFirst();

            for (int dir = 0; dir < 4; dir++) {
                int nr = now.row + rx[dir];
                int nc = now.col + ry[dir];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (copyMap[nr][nc] == 1) continue;

                if (copyMap[nr][nc] == 0) {
                    copyVirus.addLast(new Node(nr, nc));
                    copyMap[nr][nc] = 2;
                }
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
