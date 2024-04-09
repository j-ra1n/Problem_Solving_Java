import java.util.*;

class 배열정렬하기 {

    private static int[] solution(int arr[]) {

        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int numbers[] = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        int sortedNumbers[] = solution(numbers);

        sc.close();

        System.out.println(Arrays.toString(sortedNumbers));
    }

}
