import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        int sum =0;
        for(int i=0; i<works.length; i++)
        {
            sum+= works[i];
        } 
        if(n> sum)
        {
            return 0;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++)
        {
            pq.add(works[i]);
        }

        
        while(true)
        {
            if(n==0) break;
            if(pq.isEmpty()) break;
            
            int num = pq.poll();
            num -= 1;
            if(num > 0)
            {
                pq.add(num);
            }
            n--;
        }
        
        System.out.print(pq);
    
        while(!pq.isEmpty())
        {
            int a = pq.poll();
            answer += a*a;
        }
        
        return answer;
    }
}