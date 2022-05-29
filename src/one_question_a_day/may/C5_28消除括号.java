package one_question_a_day.may;

import java.util.LinkedList;
import java.util.Queue;

public class C5_28消除括号 {
    /**
     *  使用一个单调找 存储 左括号 遇到会 使栈空的 左括号 不进行存储
     *  (()())
     *  当栈内不为空的时候 才可以像str后面追加 括号 ，如果为空 不追加 （最外层括号应该消除）
     * @param string
     * @return
     */
    public String deleteKH(String string){
        Queue<Character> list= new LinkedList<>();
        StringBuilder str = new StringBuilder();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if('(' == chars[i] && !list.isEmpty()){
                list.add('(');
                str.append('(');
            }else if(')' == chars[i]){
                list.poll();
                if (!list.isEmpty()){
                    str.append(')');
                }
            }else {
                list.add('(');
            }
        }
        return str.toString();
    }
}
