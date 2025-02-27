import java.util.*;
class Solution {
    public int[] solution(String s) {
        
        
        String ss= s.substring(2, s.length()-2).replace("},{" , " "); 
        String[] str = ss.split(" ");
        int[] answer = new int[str.length];
        HashSet<Integer> set = new HashSet<>();
        
        Arrays.sort(str, (o1,o2) -> (o1.length()-o2.length()));
        
        for(int i=0; i<str.length;i++)
        {
            String[] sss = str[i].split(",");
            
            for(String a : sss)
            {
                int num = Integer.parseInt(a.trim());
                
                if(set.contains(num))
                {
                    continue;
                } else
                {
                    set.add(num);
                    answer[i] = num;
                }
            }
        }
        return answer;
    }
}