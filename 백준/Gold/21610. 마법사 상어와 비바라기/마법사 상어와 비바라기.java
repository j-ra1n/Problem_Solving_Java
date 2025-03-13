import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    private static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    private static int[][] map;
    private static boolean[][] cloud;
    private static boolean[][] copyCloud;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        cloud = new boolean[N][N];
        copyCloud = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        StartCloud(N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            moveCloud(d, s);
            waterCopy();
            fadeCloud();
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result += map[i][j];
            }
        }

        System.out.println(result);

    }

    private static void StartCloud(int N) {
        cloud[N - 1][0] = true;
        cloud[N - 1][1] = true;
        cloud[N - 2][0] = true;
        cloud[N - 2][1] = true;
    }


    private static void moveCloud(int d, int s) {

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {

                if (cloud[x][y]) {
                    int nx = (x + (dx[d] + N) * s) % N;
                    int ny = (y + (dy[d] + N) * s) % N;

                    map[nx][ny]++;
                    copyCloud[nx][ny] = true;
                    cloud[x][y] = false;
                }
            }
        }
    }

    private static boolean bound(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }
        return true;
    }

    private static void waterCopy() {

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {

                if (copyCloud[x][y]) {
                    for (int dir = 2; dir <= 8; dir += 2) // 대각선
                    {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if (bound(nx, ny) && map[nx][ny] > 0) {
                            map[x][y]++;
                        }
                    }
                }
            }
        }
    }

    private static void fadeCloud() {

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {

                if (!copyCloud[x][y] && map[x][y] >= 2) {
                    map[x][y] -= 2;
                    cloud[x][y] = true;

                } else if (copyCloud[x][y]) {
                    copyCloud[x][y] = false;
                }
            }
        }
    }
}
