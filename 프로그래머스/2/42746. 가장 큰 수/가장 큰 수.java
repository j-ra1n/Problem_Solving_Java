import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        
        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int number : numbers)
        {
            list.add(String.valueOf(number));
        }
        
        Collections.sort(list, (o1, o2) ->{
            
            int a = Integer.parseInt(o1+o2);
            int b = Integer.parseInt(o2+o1);
            
            return Integer.compare(b,a);
        });
        
        for(int i=0; i<numbers.length;i++)
        {
            if(list.get(0).equals("0"))
            {
                return "0";
            }
            
            sb.append(list.get(i));
        }
        
        return sb.toString();

    }
}