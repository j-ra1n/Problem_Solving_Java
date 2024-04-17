import java.util.*;

public class 두개의수로특정값만들기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];

        HashSet<Integer> hashset = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            if (hashset.contains(target - i)) {
                System.out.println("true");
                return;
            }

            hashset.add(i);
        }

        System.out.println("false");
    }

}
