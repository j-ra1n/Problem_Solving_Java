class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int num=0;
        int left=10;
        int right=12;
        
        for(int i=0; i<numbers.length; i++)
        {
            num = numbers[i];
            if(numbers[i]==0) num = 11;
            
            if(num==1 || num==4 || num==7)
            {
                answer+="L";
                left=num;
            }else if(num==3 || num==6 || num==9)
            {
                answer+="R";
                right=num;
            } else{
                
                int l = Math.abs(num-left)/3 + Math.abs(num-left)%3;
                int r = Math.abs(num-right)/3 + Math.abs(num-right)%3;
                
                if(l==r)
                {
                    if(hand.equals("right"))
                    {
                        answer+="R";
                        right=num;
                    }else
                    {
                        answer+="L";
                        left=num;
                    }
                } else if(l>r)
                {
                    answer+="R";
                    right=num;
                }else
                {
                    answer+="L";
                    left=num;
                }
                
            }
                
        }
        
        return answer;
    }
}