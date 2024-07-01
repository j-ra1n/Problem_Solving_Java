class Solution {
    public int solution(int a, int b) {
        
        String str1 = String.valueOf(a) + String.valueOf(b);
        String str2 = String.valueOf(b) + String.valueOf(a);
        
        int answer1 = Integer.parseInt(str1);
        int answer2 = Integer.parseInt(str2);
        
        if(answer1 > answer2)
        {
            return answer1;
        }else
        {
            return answer2;
        }
    }
}