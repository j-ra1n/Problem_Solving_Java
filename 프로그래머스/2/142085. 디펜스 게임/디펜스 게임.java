import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int answer =0;

        for(int i=0; i<enemy.length;i++)
        {
            pq.add(enemy[i]);
            
            if(k>0 && n < enemy[i])
            {
                n += pq.poll();
                k--;         
            }
            n-= enemy[i];
            
            if(n<0)
            {
                break;
            }
            answer++;
        }
        
        
        return answer;
    }
}