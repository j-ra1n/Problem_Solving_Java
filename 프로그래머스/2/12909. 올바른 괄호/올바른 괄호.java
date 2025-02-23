import java.util.*;


class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            
            if(c == ')')
            {
                if(!stack.isEmpty())
                {
                    stack.pollLast();
                }else{
                    return false;
                }
                
            }else{
                stack.addLast(1);
            }
        }

        if(!stack.isEmpty())
        {
            return false;
        }

        return answer;
    }
}