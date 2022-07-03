package stack_and_queue;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == s.charAt(i)){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        stack.forEach(character -> sb.append(character));
        return sb.toString();
    }
}
