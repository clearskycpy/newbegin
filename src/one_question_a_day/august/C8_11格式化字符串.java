package one_question_a_day.august;

import java.util.LinkedList;
import java.util.Queue;

public class C8_11格式化字符串 {

    public String reformat(String s) {
        int countChar = 0;
        Queue<Character> charactersStr = new LinkedList<>();
        Queue<Character> charactersNum = new LinkedList<>();
        for (char c : s.toCharArray()){
            if ( c >= 'a' && c <='z' ){
                countChar++;
                charactersStr.add(c);
            }else {
                charactersNum.add(c);
            }
        }
        int countNum = s.length() - countChar;
//        表示无法形成
        if (Math.abs(countChar - countNum) > 1 ) return "";
//      进行拼接
        StringBuilder sb = new StringBuilder();
        if (countChar > countNum){
            for (int i = 0; i < s.length(); i++) {
                if (i%2 == 0){
                    sb.append(charactersStr.poll());
                }else {
                    sb.append(charactersNum.poll());
                }
            }
        }else {
            for (int i = 0; i < s.length(); i++) {
                if (i%2 == 1){
                    sb.append(charactersStr.poll());
                }else {
                    sb.append(charactersNum.poll());
                }
            }
        }
        return sb.toString();

    }
}
