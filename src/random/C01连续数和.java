package random;

import java.util.ArrayList;
import java.util.List;

public class C01连续数和 {
   /* 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

    序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
    输入：target = 9
    输出：[[2,3,4],[4,5]]*/
   /*public int[][] findContinuousSequence(int target) {
//       当这个数对n求余数为0 也就是能整除的时候 就可以由n 向两边扩散 扩散多为 target/n*2
       List<int[]> voc = new ArrayList<>();
       if (target%2 == 1){
           voc.add(new int[]{target/2 , (target/2)+1});
       }
       for (int i = 3; i < target; i++) {
           if (target%i == 0){

           }
       }*错误题解/

    /**
     * 暴力枚举
     * @param target
     * @return
     */
    public int[][] findContinuousSequence2(int target) {
        int i = (target/2) + 1 ;
        List<int[]> voc = new ArrayList<>();
        for (int j = 1; j <= i; j++) {
            int sum = 0;
            for (int k = j; k <= i; k++) {
                sum += k;
                if (sum > target){
                    break;
                }
                if (sum == target){
                    int[] res = new int[k-j+1];
                    for (int l = j; l <= k; l++) {
                        res[l-j] = l;
                    }
                    voc.add(res);
                    break;
                }
            }
        }
        return  voc.toArray(new int[voc.size()][]);
    }
}
