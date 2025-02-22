import java.util.*;


class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        
        int[][] answer = new int[rc.length][rc[0].length];
        
        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> right = new ArrayDeque<>();
        ArrayDeque<ArrayDeque<Integer>> mid = new ArrayDeque<>();
        
        for(int i=0 ; i<rc.length; i++)
        {
            left.addLast(rc[i][0]);
            ArrayDeque<Integer> midQueue = new ArrayDeque<>();
            
            for(int j=1; j<rc[0].length-1; j++)
            {
                midQueue.addLast(rc[i][j]);
            }
            mid.addLast(midQueue);
            right.addLast(rc[i][rc[i].length-1]);
        }
        
        for(String operation : operations)
        {
            if("ShiftRow".equals(operation))
            {
                left.addFirst(left.pollLast());
                mid.addFirst(mid.pollLast());
                right.addFirst(right.pollLast());
                
            }else{ // Rotate
                
                mid.peekFirst().addFirst(left.pollFirst());
                right.addFirst(mid.peekFirst().pollLast());
                
                mid.peekLast().addLast(right.pollLast());
                left.addLast(mid.peekLast().pollFirst());
            }
            
        }
        
        for(int i =0; i<rc.length; i++)
        {
            answer[i][0] = left.pollFirst();
            
            ArrayDeque<Integer> midQueue = mid.pollFirst();
            
            for(int j=1; j<rc[0].length-1; j++)
            {
                answer[i][j] = midQueue.pollFirst();
            }
            
            answer[i][answer[i].length-1] = right.pollFirst();
        }
        

        return answer;
    }
}