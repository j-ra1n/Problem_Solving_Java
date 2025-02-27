import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String ss = s.replaceAll("one", "1");
        ss = ss.replaceAll("two","2");
        ss = ss.replaceAll("three","3");
        ss = ss.replaceAll("four","4");
        ss = ss.replaceAll("five","5");
        ss = ss.replaceAll("six","6");
        ss = ss.replaceAll("seven","7");
        ss = ss.replaceAll("eight","8");
        ss = ss.replaceAll("nine","9");
        ss = ss.replaceAll("zero","0");
        

        return Integer.parseInt(ss);
    }
}