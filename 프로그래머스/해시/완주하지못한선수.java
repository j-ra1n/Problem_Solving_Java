import java.util.*;

class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < completion.length; i++) {
            hashmap.put(completion[i], hashmap.getOrDefault(completion[i], 0) + 1);
        }

        for (int i = 0; i < participant.length; i++) {
            if (hashmap.getOrDefault(participant[i], 0) == 0) {
                return participant[i];
            }

            hashmap.put(participant[i], hashmap.get(participant[i]) - 1);
        }

        return null;
    }
}