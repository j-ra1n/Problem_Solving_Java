import java.util.*;

class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";

        ArrayDeque<String> deq1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> deq2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goaldeq = new ArrayDeque<>(Arrays.asList(goal));

        while (!goaldeq.isEmpty()) {

            if (!deq1.isEmpty() && deq1.getFirst().equals(goaldeq.peekFirst())) {

                deq1.pollFirst();
                goaldeq.pollFirst();

            } else if (!deq2.isEmpty() && deq2.getFirst().equals(goaldeq.peekFirst())) {

                deq2.pollFirst();
                goaldeq.pollFirst();

            } else {
                break;
            }

        }

        if (goaldeq.isEmpty()) {
            answer = "Yes";

        } else {
            answer = "No";
        }

        return answer;
    }
}