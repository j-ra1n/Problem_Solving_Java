import java.util.*;

public class 요세푸스문제 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        ArrayDeque<Integer> deq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deq.addLast(i);
        }

        while (deq.size() > 1) {
            for (int i = 0; i < K - 1; i++) {

                deq.addLast(deq.pollFirst());
            }
            deq.pollFirst();
        }

        System.out.println(deq.getFirst());

    }
}
