import java.util.*;
class Solution {
    
    private static class Open
    {
        String uid, cmd;
        
        public Open(String uid, String cmd)
        {
            this.uid=uid;
            this.cmd=cmd;
        }
    }
    
    public String[] solution(String[] record) {
        
        
        HashMap<String, String> map = new HashMap<>();
        ArrayList<Open> op = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();
        
        String[] answer = new String[record.length];
        
        for(int i=0; i<record.length; i++)
        {
            String[] str = record[i].split(" ");
            op.add(new Open(str[1], str[0]));
            
            if(str[0].equals("Enter"))
            {
                map.put(str[1], str[2]);
            }else if(str[0].equals("Change"))
            {
                map.put(str[1], str[2]);
            }
        }
        
        for(int i=0; i<op.size(); i++)
        {
            if(op.get(i).cmd.equals("Enter"))
            {
                ans.add(map.get(op.get(i).uid)+"님이 들어왔습니다.");
            }else if(op.get(i).cmd.equals("Leave"))
            {
                ans.add(map.get(op.get(i).uid)+"님이 나갔습니다."); 
            }
        }
        
        
        return ans.toArray(new String[0]);
    }
}