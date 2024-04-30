import java.util.*;

class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        LinkedHashMap<String, Character> map = new LinkedHashMap<>(); // HashSet으로 하면 될듯
        String str = words[0];
        map.put(str, str.charAt(str.length() - 1));

        for (int i = 1; i < words.length; i++) {

            str = words[i];
            char last = map.containsKey(words[i - 1]) ? map.get(words[i - 1]) : ' ';

            if (str.charAt(0) == last) {
                if (!map.containsKey(str)) { // 중복단어 없으면 삽입
                    map.put(str, str.charAt(str.length() - 1));

                } else { // 중복단어일때

                    answer[0] = (i % n) + 1;
                    answer[1] = (i / n) + 1;
                    break;

                }
            } else // 이전 단어랑 마지막 단어가 다를때
            {

                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;

            }

        }

        return answer;
    }
}