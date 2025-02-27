import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        int[][] cop = new int[board.length][board[0].length];
        
        int[] arr = new int[board.length];
        
        for(int i=0;i< board.length; i++)
        {
            for(int j=0; j<board[0].length;j++)
            {
                cop[j][i] = board[i][j];
            }
        }
        

        
        for(int k=0; k< moves.length; k++)
        {
            int sel = moves[k] -1 ;

                for(int j=0; j<cop[0].length; j++)
                {
                    if(cop[sel][j] >0)
                    {
                        
                        if(stack.size()>0 && cop[sel][j]==stack.peekLast())
                        {
                            stack.pollLast();
                            answer+=2;
                        } else
                        {
                            stack.addLast(cop[sel][j]);
                        }
                        cop[sel][j] = 0;
                        break;
                    }
            }
            
            

            
            
            
        }
    
        
        System.out.print(stack);
        

        
        
        
        
        return answer;
    }
}