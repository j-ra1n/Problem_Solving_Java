import java.util.*;

class 실패율 {
    public int[] solution(int N, int[] stages) {

        int[] person = new int[N + 2];
        for (int i = 0; i < stages.length; i++) {
            person[stages[i]]++;
        }

        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        for (int i = 1; i <= N; i++) {
            if (person[i] == 0) {
                fails.put(i, 0.0);
            } else {
                fails.put(i, person[i] / total);
                total -= person[i];
            }
        }

        int[] answer = fails.entrySet().stream().sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()))
                .mapToInt(HashMap.Entry::getKey).toArray();

        return answer;

        /*
         * List<Integer> list = new ArrayList<>(map.keySet());
         * 실패율을 기준으로 내림차순 정렬
         * list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
         * 
         * 리스트를 배열로 변환하여 반환
         * return list.stream().mapToInt(i -> i).toArray();
         * 
         * i -> i = Integer::intValue
         */
    }
}
