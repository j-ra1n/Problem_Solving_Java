import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        int[] answer = new int[2];
        
        for(int i=0; i<gems.length; i++)
        {
            set.add(gems[i]);
        }
        
        int start =0;
        int len = Integer.MAX_VALUE;
        for (int end = 0; end < gems.length; end++) {
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
 
            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if(set.size()== map.size() && len > (end-start))
            {
                len = end - start;
                answer[0] = start+1;
                answer[1] = end+1;
            }
        }
    
        return answer;
    }
}