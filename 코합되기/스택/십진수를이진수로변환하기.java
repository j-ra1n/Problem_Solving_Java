import java.util.*;

public class 십진수를이진수로변환하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int ten = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        while (ten > 0) {
            stack.push(ten % 2);
            ten /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }

}
