import java.util.*;

class Solution {
    
    public static class Stone
    {
        int idx, val;
        
        public Stone(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    
    public int solution(int[] stones, int k) {
        
        PriorityQueue<Stone> pq = new PriorityQueue<>((o1,o2) -> Integer.compare(o2.val, o1.val));
        
        int i;
        for(i=0; i<k; i++)
        {
            pq.add(new Stone(i, stones[i]));
        }
        
        int answer = pq.peek().val;
        
        while(i<stones.length)
        {
            pq.add(new Stone(i, stones[i]));
            i++;
            
            while(pq.peek().idx < i-k)
            {
                pq.poll();
            }
            
            answer = Math.min(answer, pq.peek().val);
        }
        
        return answer;
    }
}