import java.util.*;

class 네트워크 {
    static int[][] computer;
    static boolean[] visited;

    static void dfs(int x) {
        visited[x] = true;

        for (int i = 0; i < computer[x].length; i++) {
            if (!visited[i] && computer[x][i] == 1) {
                dfs(i);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        int answer = 0;

        computer = computers;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }
}