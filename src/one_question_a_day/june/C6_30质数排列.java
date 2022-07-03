package one_question_a_day.june;

public class C6_30质数排列 {
    /**
     * 求1到n所有质数放在对应的质数索引（从1开始）上的排列方式
     *      思路
     *          由于质数的索引有多少个，那么质数的个数也有多少个，所以求质数的排列就是求质数的个数的阶乘。
     *          但是由于不是质数索引上面的位置上也存在变化，且变化也是阶乘
     * @param n
     * @return
     */
    public int numPrimeArrangements(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)){
                // 如果是质数就让计数器++
                count++;
            }
        }
        return (int)(factorial(count)*factorial(n-count)%1000000007);
    }

    /**
     * 判断n 是不是质数
     * @param n
     * @return
     */
    private boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i * i <= n ; i++) {
            if (n%i == 0) return false;
        }
        return true;
    }

    /**
     * 求n的阶乘
     * 在这一步就应该考虑到要使用long类型封装数据int无法满足，同时边乘边取模
     * @param n
     * @return
     */
    private long factorial(int n){
        long i = 1;
        for (int j = 2; j <= n; j++) {
            i *= j;
            i %= 1000000007;
        }
        return i;
    }
}
