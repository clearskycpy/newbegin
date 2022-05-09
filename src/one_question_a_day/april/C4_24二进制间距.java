package one_question_a_day.april;

public class C4_24二进制间距 {
    public int binaryGap(int n) {
//        十进制转换成二进制
        String s = Integer.toString(n, 2);
        int index = -1;  // 上一个1 的位置
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1'){
                if (index == -1){
                    index = i;
                }else {
                    res = Math.max(i - index,res);
                    index = i;
                }
            }
        }
        return res;
    }
}
