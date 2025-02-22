import java.util.*;

class Solution {
    
    private static int HIT = 1;
    private static int MISS = 5;
    
    
    public int solution(int cacheSize, String[] cities) {
        
        ArrayDeque<String> dq = new ArrayDeque<>();
        
        int answer =0;
        
        for(String city : cities)
        {
            city = city.toLowerCase();
            
            if(dq.contains(city))
            {
                answer += HIT;
                dq.remove(city);
                dq.addLast(city);
            }else
            {
                answer += MISS;
                dq.addLast(city);
                
                if(dq.size() > cacheSize)
                {
                    dq.pollFirst();
                }
            }
        }
        
        return answer;
}
}