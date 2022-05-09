package one_question_a_day.april;

public class C4_15语法分析器 {
    /*int index = 0;

    public NestedInteger deserialize(String s) {
        if (s.charAt(index) == '[') {
            index++;
            NestedInteger ni = new NestedInteger();
            while (s.charAt(index) != ']') {
                ni.add(deserialize(s));
                if (s.charAt(index) == ',') {
                    index++;
                }
            }
            index++;
            return ni;
        } else {
            boolean negative = false;
            if (s.charAt(index) == '-') {
                negative = true;
                index++;
            }
            int num = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index) - '0';
                index++;
            }
            if (negative) {
                num *= -1;
            }
            return new NestedInteger(num);
        }
    }*/

//    字符串相加
    public String addStrings(String num1, String num2) {
        /*int res = (int)Integer.parseInt(num1) +(int)Integer.parseInt(num2);
        return String.valueOf(res);*/
        StringBuilder str = new StringBuilder();
        int s = 0;
        for (int num1index = num1.length() ,num2index = num2.length() ; num1index >=0 || num2index>=0 || s>0 ;num1index--,num2index--) {
            if (num1index >= 0) s  += num1.charAt(num1index) - '0';
            if (num2index >= 0) s  += num2.charAt(num2index) - '0';
            str.append(s%10);
            s /= 10;
        }
        return str.reverse().toString();
    }
}
