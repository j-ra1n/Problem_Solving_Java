import java.util.*;

class Solution {
    
    
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        
        for(int i=0; i<prices.length; i++)
        {
            
            int index = prices[i];
            int next = 0;
            for(int j=i+1; j<prices.length; j++)
            {
                next++;
                if(index > prices[j])
                {
                    break;
                }
            }
            answer[i] = next;
        }
        
        //System.out.println(Arrays.toString(answer));
        
        
    
        return answer;
    }
}