class Solution {
    
    private static final long MAX= 1_000_000_000;
    private static int N;
    private static int[] time;
    
    public long solution(int n, int[] times) {
        long left = 1;
        long right = MAX * MAX;
        
        N=n;
        time=times;
        
        while(left < right)
        {
            long mid = (left+right)/2;
          
            if(isPossible(mid))
            {
                right=mid;
            }else
            {
                left=mid+1;
            }
        }
        return left;
    }
    
    private static boolean isPossible(long num)
    {
        long n = N;
        
        
        for(int i : time)
        {
            n -= num / i;
        }
        
        return n <= 0;
    }
}