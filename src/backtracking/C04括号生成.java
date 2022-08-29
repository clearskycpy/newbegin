package backtracking;

import java.util.*;

public class C04括号生成 {
    /**
     * 表示n 对括号的排序方式有几种
     * 思路 先递归所有的括号的排序方式，在使用一个函数判断括号是否匹配
     * @param n
     * @return
     */

    String[] temp = {"(",")"};
    List<String> list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 1){
             list.add("()");
             return list;
        }
        StringBuilder stringBuilder = new StringBuilder();
        backtracking(2*n, stringBuilder);
        return list;
    }

    private void backtracking(int len, StringBuilder stringBuilder) {
        if (len == stringBuilder.length()){
            String str = stringBuilder.toString();
            if (isStr(str)){
                list.add(str);
                return;
            }else {
                return;
            }
        }

        for (int i = 0; i < 2; i++) {
            stringBuilder.append(temp[i]);
            backtracking(len,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }

    private boolean isStr(String str) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push(str.charAt(i));
            else if (!stack.empty() && str.charAt(i) == ')'){
                stack.pop();
            }else {
                return false;
            }
        }
        if (stack.empty()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        C04括号生成 c04括号生成 = new C04括号生成();
        System.out.println(c04括号生成.isStr("(())"));

    }
    public List<String> generateParenthesis2(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        if (n == 0)
            return result.get(0);
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }

            }
            result.add(temp);
        }
        return result.get(n);
    }
}
