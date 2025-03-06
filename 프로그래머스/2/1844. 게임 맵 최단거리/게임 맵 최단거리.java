import java.util.*;
class Solution {
    
    private static int[] rx = {1,-1,0,0};
    private static int[] ry = {0,0,1,-1};
    
    private static int[][] dist;
    private static boolean[][] visited;
    
    private static class Node{
        int row, col;
        
        private Node(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int N = maps.length;
        int M = maps[0].length;
        
        
        dist = new int[N][M];
        dist[0][0] = 1;
        visited = new boolean[N][M];
        
        ArrayDeque<Node> q = new ArrayDeque<>();
        
        q.addLast(new Node(0,0));
        visited[0][0] = true;
        
        while(!q.isEmpty())
        {
            Node now = q.pollFirst();
            
            for(int dir=0; dir<4; dir++)
            {
                int nr = now.row + rx[dir];
                int nc = now.col + ry[dir];
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr][nc] == 0) continue;
                
                if(!visited[nr][nc])
                {
                    q.addLast(new Node(nr,nc));
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[now.row][now.col] + 1;
                }
                
            }
        }
        
        if(dist[N-1][M-1]==0)
        {
            return -1;
        }
        
        return dist[N-1][M-1];
    }
}