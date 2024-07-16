class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        String[] str = my_string.split("");
        
        int num= my_string.length()-n;
        
        for(int i=num; i<my_string.length(); i++)
        {
            answer += "" + str[i];
        }
        return answer;
    }
}