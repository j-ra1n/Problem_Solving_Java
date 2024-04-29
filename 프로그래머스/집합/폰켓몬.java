import java.util.*;

class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int n = nums.length;
        int k = n / 2;

        return Math.min(k, set.size());
    }
}