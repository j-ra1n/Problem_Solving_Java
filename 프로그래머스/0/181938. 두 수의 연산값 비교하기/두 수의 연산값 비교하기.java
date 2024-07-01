class Solution {
    public int solution(int a, int b) {
        
        String str1 = ""+a+b;
        String str2 = ""+(2*a*b);
        
        int answer = Math.max(Integer.parseInt(str1), Integer.parseInt(str2));
        return answer;
    }
}