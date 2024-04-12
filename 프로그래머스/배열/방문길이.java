import java.util.*;

class 방문길이 {
    static int[] move(char c) {
        int[] mov = new int[2];
        if (c == 'U') {
            mov = new int[] { 0, 1 };
            return mov;
        } else if (c == 'D') {
            mov = new int[] { 0, -1 };
            return mov;
        } else if (c == 'R') {
            mov = new int[] { 1, 0 };
            return mov;
        } else {
            mov = new int[] { -1, 0 };
            return mov;
        }
    }

    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;

        Set<String> visitedPaths = new HashSet<>();

        for (int i = 0; i < dirs.length(); i++) {
            int[] area = move(dirs.charAt(i));
            int nx = x + area[0];
            int ny = y + area[1];

            if (nx > 5 || ny > 5 || nx < -5 || ny < -5) {
                continue;
            }
            String vis = "(" + x + "," + y + ")" + ",(" + nx + "," + ny + ")";
            String vis2 = "(" + nx + "," + ny + ")" + ",(" + x + "," + y + ")";

            if (!visitedPaths.contains(vis) && !visitedPaths.contains(vis2)) {
                visitedPaths.add(vis);
                answer++;
            }

            x = nx;
            y = ny;
        }

        return answer;
    }

}