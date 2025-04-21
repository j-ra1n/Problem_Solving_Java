import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        int idx1=0, idx2=0, idx3=0, idx4=0;
        int[] arr = new int[51];
        
        // idx1
       for(int i=0; i<n; i++)
       {
           String str = wallpaper[i];
           if(str.contains("#"))
           {
               idx1=i; 
               break;
           }
       }
        
        // idx2
        for(int i=0; i<n; i++)
        {
            String str = wallpaper[i];
            for(int j=0; j<m; j++)
            {
                if(str.charAt(j)=='#')
                {
                    arr[j]++;
                }
            }
        }
        
        for(int i=0; i<50; i++)
        {
            if(arr[i]>0)
            {
                idx2=i;
                break;
            }
        }
        
        // idx3
        for(int i=0; i<n; i++)
       {
           String str = wallpaper[i];
           if(str.contains("#"))
           {
               idx3=i; 
           }
       }
        
        // idx4
        for(int i=0; i<n; i++)
        {
            String str = wallpaper[i];
            for(int j=0; j<m; j++)
            {
                if(str.charAt(j)=='#'&& j > idx4)
                {
                    idx4=j;
                }
            }
        }
        

        answer[0] = idx1;
        answer[1] = idx2;
        answer[2] = idx3+1;
        answer[3] = idx4+1;
        
    
        return answer;
    }
}