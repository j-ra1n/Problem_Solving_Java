import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String,Integer> map = new HashMap<>();
        
        int len = clothes.length;
        
        
        for(int i=0; i<len; i++)
        {
            String str = clothes[i][1];
            map.put(str, map.getOrDefault(str,1)+1);
        }
        
        Collection<Integer> vals = map.values();
        
        System.out.println(map);
        System.out.println(vals);
        
        for(int val : vals) {
            answer *= val;
        }

        return answer-1;
    }
}