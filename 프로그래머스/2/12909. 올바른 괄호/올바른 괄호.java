import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        Stack<Character> st = new Stack<>();

       char[] c = new char[s.length()];
        
        for(int i=0; i<s.length(); i++)
        {
            c[i] = s.charAt(i);
        }
        
        
        if(c[0]==')')
        {
            return false;
        }
        
        int open =0, close=0, cnt=0;
        for(int i=0; i<c.length; i++)
        {
        
            if(c[i]=='(')
            {
                st.push('(');
                open++;
                cnt++;
            }else
            {
                if(open>0)
                {
                    st.push(')');
                    open--;
                    close++;
                }
            }
        }
        
        if(cnt==close)
        {
            return true;
        }else
        {
            return false;
        }
    }
}