import java.util.*;

class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {

        int[] arr = new int[progresses.length];
        ArrayDeque<Integer> deq = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            for (int j = 1; j <= 100; j++) {

                if (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                    if (progresses[i] >= 100) {
                        arr[i] = j;
                    }
                }
            }
        }

        int cnt = 0;
        int maxDay = arr[0];

        for (int i = 0; i < progresses.length; i++) {
            if (arr[i] <= maxDay) {
                cnt++;
            } else {
                deq.addLast(cnt);
                cnt = 1;
                maxDay = arr[i];
            }
        }

        deq.addLast(cnt);

        return deq.stream().mapToInt(i -> i).toArray();
    }
}