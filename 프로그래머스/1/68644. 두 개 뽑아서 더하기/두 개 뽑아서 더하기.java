import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        HashSet<Integer> n = new HashSet<>();
        
        for(int i=0; i<numbers.length; i++)
        {
            int num = numbers[i];
            for(int j=i+1; j<numbers.length; j++)
            {
                n.add(num+numbers[j]);
            }
        }
        
        int[] answer = new int[n.size()];
        
        Integer[] arr = n.toArray(new Integer[0]);
        
        return Arrays.stream(arr).sorted().mapToInt(Integer::intValue).toArray();
    }
}