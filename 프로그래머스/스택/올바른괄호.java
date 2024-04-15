import java.util.*;

class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack<>();

        if (s.charAt(0) == ')') {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push("(");
            } else {
                if (!stack.isEmpty())
                    stack.pop();
            }
        }

        if (stack.isEmpty()) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}