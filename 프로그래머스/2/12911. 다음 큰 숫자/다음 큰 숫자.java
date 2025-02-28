import java.util.*;

class Solution {
    
    private static final int MAX = 1_000_000;
    public int solution(int n) {
        int answer = 0;
        
        String s = Integer.toBinaryString(n);
        
        int count =0;
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(c=='1')
            {
                count++;
            }
        }
        
        int acount=0;
        for(int i=1; i< MAX; i++)
        {
            acount=0;
            int ni = n+i;
            String a = Integer.toBinaryString(ni);
            
            for(int j=0; j<a.length(); j++)
            {
                char c = a.charAt(j);
                if(c=='1')
                {
                    acount++;
                }
                
            }
            
            if(count== acount)
            {
                answer = ni;
                break;
            }
            
        }
        return answer;
    }
}