class Solution {
    public String solution(String[] arr) {
        String answer = "";
        
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[i].length(); j++)
            {
                answer += arr[i].charAt(j);
            }
        }
        return answer;
    }
}