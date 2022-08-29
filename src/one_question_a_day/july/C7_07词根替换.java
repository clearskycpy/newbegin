package one_question_a_day.july;

import java.util.List;

public class C7_07词根替换 {
    /**
     * 第一种解法： 使用java api
     * @param dictionary
     * @param sentence
     * @return
     */
    public String replaceWords(List<String> dictionary, String sentence) {
        String[] strings = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            boolean is = false;
            for (String s : dictionary) {
                if (strings[i].indexOf(s) >= 0){
                    stringBuilder.append(s+ " ");
                    is = true;
                    break;
                }

            }
            if (is) continue;
            stringBuilder.append(strings[i] + " ");
        }
        return stringBuilder.toString().substring(0,stringBuilder.length()-1);
    }
}
