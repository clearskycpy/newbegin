package one_question_a_day.july;

public class C7_03最小整数 {
    /**
     * 如何找到重新排列的最大整数，要大于n的最小 这个解法只能求解小于int最大值的数
     * 1234  1230 1045 
     * 1243  1302 4015
     * 54674839876
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {
        if (n <= 10) return -1;
        long maxN = getMax(n);
        if (maxN == -1) return -1;
        for (long i = n +1; i <= maxN; i++) {
            if (getMax(i) == maxN){
                return (int) i;
            }
        }
        return (int) maxN;
    }
    private long getMax(long n){
        if (n <= 10) return -1;
        long temp = n;
        int[] nums = new int[10]; // 将每一位都存储起来
//        将每一位上面的数字都存储进来
        while (n > 0){
            long index = n%10;
            nums[(int) index]++;
            n /= 10;
        }
//        先装填第一位
        long res = 0;
        for (int i = nums.length -1; i >= 0 ; i--) {
            if (nums[i] > 0){
                res = i;
                nums[i]--;
                break;
            }
        }
        for (int i = nums.length -1; i >= 0 ; i--) {
            while (nums[i] > 0){
                res = (res*10) + i;
                nums[i]--;
            }
        }
        return res > temp ? res : -1;
    }
}

