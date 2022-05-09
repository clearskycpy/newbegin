package one_question_a_day.april;

public class C4_22旋转函数 {
    public int maxRotateFunction(int[] nums) {
        /*旋转函数        运行超时 采用的枚举
        * 就是 */
        if (nums.length == 1) return 0;
        int res = Integer.MIN_VALUE;
        int i = 0;
        while (i < nums.length){
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                int index = j + i ;
                sum += nums[j]*(index% nums.length);
            }
            res = Math.max(res,sum);
            i++;
        }
        return res;
    }
}
