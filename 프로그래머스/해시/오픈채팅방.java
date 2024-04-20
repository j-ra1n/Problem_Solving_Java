import java.util.*;

class 오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer = {};

        HashMap<String, String> msg = new HashMap<>();
        msg.put("Enter", "님이 들어왔습니다.");
        msg.put("Leave", "님이 나갔습니다.");

        HashMap<String, String> user = new HashMap<>();

        for (String s : record) {
            String[] str = s.split(" "); // 공백으로 구분
            if (str.length == 3) {
                user.put(str[1], str[2]);
            }
        }

        ArrayList<String> list = new ArrayList<>();

        for (String s : record) {
            String[] str = s.split(" ");

            if (msg.containsKey(str[0])) {
                list.add(user.get(str[1]) + msg.get(str[0]));
            }
        }
        return list.toArray(new String[0]); // List<String> -> String[]
    }
}