package random;

public class C05最大整数 {
    public int nextGreaterElement(int n) {
        if (n <= 10) return -1;
        int temp = n;
        int[] nums = new int[10]; // 将每一位都存储起来
//        将每一位上面的数字都存储进来
        while (n > 0){
            int index = n%10;
            nums[index]++;
            n /= 10;
        }
//        先装填第一位
        int res = 0;
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
