package stack_and_queue;

import java.util.Stack;

/**
 * 逆波兰表达式也是一种对栈的运用，每次遇到新的运算符的时候计算最后面两位，然后放到最后
 * 所以根据这个逻辑，我们可以用栈存储数字，遇到了运算符就弹栈出来计算，然后计算好了再压栈，所以栈中的数据类型应该选Integer类型
 * 遇到数字直接添加，遇到算术运算符进行计算
 */
public class C01逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if ("+".equals(tokens[i])){
                int temp = stack.pop();
                int temp2 = stack.pop();
                stack.add(temp2 + temp);
                continue;
            }else if ("-".equals(tokens[i])){
                int temp = stack.pop();
                int temp2 = stack.pop();
                stack.add(temp2 - temp);
                continue;
            }else if ("*".equals(tokens[i])){
                int temp = stack.pop();
                int temp2 = stack.pop();
                stack.add(temp2 * temp);
                continue;
            }else if ("/".equals(tokens[i])){
                int temp = stack.pop();
                int temp2 = stack.pop();
                stack.add(temp2 / temp);
                continue;
            }else {
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
