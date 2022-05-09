package one_question_a_day.april;

public class C4_28奇偶排序 {
    public int[] sortArrayByParity(int[] nums) {
//        将偶数 放在前面 奇数放在后面  单指针
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            if (nums[start]%2 == 1){
//                和最后面的一个元素交换位置
                swap(start,end ,nums);
                end--;
            }else {
                start++;
            }
        }
        return nums;
    }

    private void swap(int start, int end, int[] nums) {
        int x = nums[start];
        nums[start] = nums[end];
        nums[end] = x;
    }
}
