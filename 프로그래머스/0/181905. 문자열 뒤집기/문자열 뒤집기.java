class Solution {
    public String solution(String my_string, int s, int e) {
        String answer = my_string.substring(s,e+1);
        String reverse ="";
        
        for(int i=answer.length()-1; i>=0; i--)
        {
            reverse +=answer.charAt(i);
        }
        
        my_string = my_string.replace(answer,reverse);
        
        return my_string;
    }
}