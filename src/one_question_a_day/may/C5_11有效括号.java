package one_question_a_day.may;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class C5_11有效括号 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 思路 ：
     *      使用单调栈存储数据 存储一半括号 建议存储 左括号  当出现右括号与之匹配 就消去一半括号
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack=new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if (stack.isEmpty()||c==')'&&stack.pop()!='('||c==']'&&stack.pop()!='['||c=='}'&&stack.pop()!='{'){return false;}

        }return stack.isEmpty();
    }
}
