package one_question_a_day.april;

public class C4_12书写字符串的行数 {
    public int[] numberOfLines(int[] widths, String s) {
        char[] chars = s.toCharArray();
        int col = 1;
        int temp = 0;
        for (int i = 0; i < chars.length; i++) {
            temp +=widths[chars[i]-'a'];
            if (temp > 100){
                col++;
                temp = widths[chars[i]-'a'];
            }
        }
        int[] res = new int[2];
        res[0] = col;
        res[1] = temp;
        return res;
    }
}
