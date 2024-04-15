import java.util.*;

class 나누어떨어지는숫자배열 {
    public int[] solution(int[] arr, int divisor) {

        List<Integer> conv = new ArrayList<>();

        Arrays.sort(arr);

        if (divisor == 1) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0 && divisor <= arr[i]) {
                conv.add(arr[i]);
            }
        }

        if (conv.isEmpty()) {
            int[] ans = { -1 };
            return ans;
        }

        Collections.sort(conv);

        int[] ans = conv.stream().mapToInt(i -> i).toArray();

        return ans;

        /*
         * int[] answer = Arrays.stream(arr).filter(i -> i % divisor == 0).toArray();
         * if(answer.length == 0) answer = new int[] {-1};
         * Arrays.sort(answer);
         * return answer;
         * 
         * .filter로 쉽게 가능
         */
    }
}