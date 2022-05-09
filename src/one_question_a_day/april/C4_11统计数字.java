package one_question_a_day.april;

public class C4_11统计数字 {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)return 1;
        if(n == 1)return 10;
        int sum = 10;
        for (int i = 1; i < n; i++) {
            sum *= 10;
        }
        int count = 0;
        for (int i = 0; i < sum; i++) {
            if (isI(i)){
                count++;
            }
        }
        return count;
    }

    private boolean isI(int i) {
        char[] chars = String.valueOf(i).toCharArray();
//        判断每个位置都不相等
        int[] is = new int[10];
        for (int j = 0; j < chars.length; j++) {
            if (is[chars[j] - '0'] == -1){
                return false;
            }
            is[chars[j] - '0']--;
        }
        return  true;
    }
}
