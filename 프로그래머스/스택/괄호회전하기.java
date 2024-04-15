import java.util.*;

class 괄호회전하기 {
    public int solution(String s) {

        int answer = 0;
        int len = s.length();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            stack.clear();
            for (int j = 0; j < len; j++) {

                if (stack.isEmpty()) {
                    stack.push(s.charAt(j));
                } else if (stack.peek() == '(' && s.charAt(j) == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && s.charAt(j) == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && s.charAt(j) == '}') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(j));
                }

            }

            if (stack.isEmpty()) {
                answer++;
            }

            char c = s.charAt(0);

            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(0);
            sb.append(c);
            s = sb.toString();
        }
        return answer;
    }
}
