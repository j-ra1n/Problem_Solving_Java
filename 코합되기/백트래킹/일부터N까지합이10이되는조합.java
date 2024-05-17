import java.util.*;

public class 일부터N까지합이10이되는조합 {

    private static ArrayList<ArrayList<Integer>> result;

    private static int n;

    private static void backtrck(int sum, ArrayList<Integer> selectedNums, int start) {
        if (sum == 10) {
            result.add(selectedNums);
            return;
        }

        for (int i = start; i <= n; i++) {

            if (sum + i <= 10) {
                ArrayList<Integer> list = new ArrayList<>(selectedNums);
                list.add(i);

                backtrck(sum + i, list, i + 1);
            }

        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        result = new ArrayList<>();

        int N = sc.nextInt();

        n = N;

        backtrck(0, new ArrayList<>(), 1);

        System.out.println(result.toString());
    }

}
