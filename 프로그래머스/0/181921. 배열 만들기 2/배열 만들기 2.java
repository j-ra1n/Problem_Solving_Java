import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        
        
        for(int i=l; i<=r; i++)
        {
            String num = String.valueOf(i);
            String[] nums = num.split("");
            int cnt=0;
            
            for(int j=0; j<num.length(); j++)
            {
                if(nums[j].equals("0")||nums[j].equals("5"))
                {
                    cnt++;
                }
            }
            if(cnt == num.length())
            {
                list.add(i);
            }
        }
        
        int[] answer = new int[list.size()];
        
        if (list.isEmpty()) 
        {
            return new int[] {-1};
        }
        
        for(int i=0; i<list.size(); i++)
        {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}