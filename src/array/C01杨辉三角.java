package array;

import java.util.ArrayList;
import java.util.List;

public class C01杨辉三角 {
    /**
     * 求一个行数为numRows 的杨辉三角
     *      思路一
     *      由于第n行的元素个数就是n个，所以可以建立一个数组存储 n * n
     *      并且可以推出
     *      arr[i][j] = arr[i-1][j-1] + arr[i-1][j] {中间部分}
     *      
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        int[][] target = new int[numRows][numRows];
        target[0][0] = 1;
        for (int i = 1; i < target.length; i++) {  //遍历层
            target[i][0] = 1;
            for (int j = 1; j < i+1; j++) {
                if(i == j) target[i][j] = 1;
                else target[i][j] = target[i-1][j-1] + target[i-1][j];
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = null;
        for (int i = 0; i < target.length; i++) {
//            遍历层
            temp = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                temp.add(target[i][j]);
            }
            list.add(temp);
        }
        return list;
    }

    /**
     * 用层序遍历的方式求解
     *  思路：
     *      和二叉树的层序遍历极为相似。就是通过上一层推导出下一层的值
     *      只要记录上一层即可
     * @param numRows
     * @return
     */
    /*public List<List<Integer>> generate2(int numRows) {
        
    }*/

}

