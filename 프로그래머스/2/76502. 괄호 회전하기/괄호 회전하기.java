import java.util.*;

class Solution {
    public int solution(String s) {

        ArrayList<Character> arr = new ArrayList<>();

        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr.add(c);
        }

        for (int j = 0; j < s.length(); j++) {
            Stack<Character> stack = new Stack<>();
            char a = arr.get(0);

            for (int i = 0; i < s.length(); i++) {
                char c = arr.get(i);

                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (c == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (c == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }

            if (stack.isEmpty()) {
                count++;
            }

            arr.remove(0);
            arr.add(a);
        }


        return count;
    }
}