import java.util.*;

class Solution {
    public int solution(int[] nums) {
     
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++)
        {
            set.add(nums[i]);
        }
        
        int len = nums.length/2;
        
        if(len<=set.size())
        {
            return len;
        }else
        {
            return set.size();
        }
     
    }
}