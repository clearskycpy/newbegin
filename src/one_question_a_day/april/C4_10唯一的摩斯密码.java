package one_question_a_day.april;

import java.util.HashSet;
import java.util.Set;

public class C4_10唯一的摩斯密码 {
    /**
     * 把所有拼接好的串放入set集合里面。保证不可重复所以能得到种数
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] strs = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> res = new HashSet<>();
        for (String s :
                words) {
            StringBuilder ss = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                ss.append(strs[c-'a']);
            }
            res.add(ss.toString());
        }
        return res.size();
    }
}
