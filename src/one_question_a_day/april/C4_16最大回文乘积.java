package one_question_a_day.april;

public class C4_16最大回文乘积 {
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        //等于1 的时候就是9
        // 不等于1的时候 乘积的结果就是 2n位数
        int max = (int) Math.pow(10, n) - 1;   // 从最大值枚举
        for (int i = max; i >= 0; i--) {
            long num = i, t = i;
            // 构造回文数
            while (t != 0) {
                num = num * 10 + (t % 10);
                t /= 10;
            }
            for (long j = max; j * j >= num; j--) {
                if (num % j == 0) return (int)(num % 1337);
            }
        }
        return -1;
    }
    static int[] ans = new int[]{9,987,123,597,677,1218,877,475};
    public int largestPalindrome2(int n) {
        return ans[n - 1];
    }
    public int largestPalindrome3(int n) {
        if (n == 1) return 9;
        if (n == 2) return 987;
        if (n == 3) return 123;
        if (n == 4) return 597;
        if (n == 5) return 677;
        if (n == 6) return 1218;
        if (n == 7) return 877;
        if (n == 8) return 475;
        else {
            return -1;
        }
    }
}
