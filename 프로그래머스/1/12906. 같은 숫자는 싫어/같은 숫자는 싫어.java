import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Queue<Integer> q = new LinkedList<>();
        
        int before = 10;
        for(int i=0;i<arr.length; i++)
        {
            if(before != arr[i])
            {
                q.add(arr[i]);
            }
            before = arr[i];
        }
        
        int[] answer = new int[q.size()];
        
        int index =0;
        while(!q.isEmpty())
        {
            answer[index++] = q.poll();
        }
       
        return answer;
    }
}