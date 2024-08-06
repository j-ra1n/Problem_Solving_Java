import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
       
        List<int[]>[] adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            adj[a].add(new int[] {b, c});
            adj[b].add(new int[] {a, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.add(new int[] {1, 0});

        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (int[] neighbor : adj[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[] {v, dist[v]});
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }

        return answer;
    }
}