package hoot100;

public class C02只出现过一次的数字 {
    /**
     * 位运算之求异或求解
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }



}
