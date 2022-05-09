package GreedyAlgorithm;

import javax.swing.plaf.basic.BasicGraphicsUtils;

public class C03分发糖果 {
    /*n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

    你需要按照以下要求，给这些孩子分发糖果：

    每个孩子至少分配到 1 个糖果。
    相邻两个孩子评分更高的孩子会获得更多的糖果。
    请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。*/

    public static void main(String[] args) {
        C03分发糖果 c03分发糖果 = new C03分发糖果();
        int candy = c03分发糖果.candy(new int[]{1, 0, 2});
        System.out.println(candy);

    }
    /**
     * 贪心思路
     * 假定第一个孩子的糖果数量为 1
     * 局部最优： 右孩子比左孩子成绩高的的情况 右孩子的糖果数量为gree[i] + 1
     * 再分析左孩子比右孩子积分高的情况 此时就有两种可能 Math.max(gree[i],gree[i+1]+1)
     * 全局最优 成绩高的孩子糖果多
     * 在比较第二次的时候需要才用从后往前遍历 。 才可以利用到上一次比较的数据
     * 采用了两次贪心
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] gree = new int[ratings.length]; // 对应位置的小朋友的糖果数量
        gree[0] = 1;
        for (int i = 1; i < gree.length; i++) {
            if (ratings[i] > ratings[i-1]){
                gree[i] = gree[i-1]+1;  //   局部最优： 右孩子比左孩子成绩高的的情况 右孩子的糖果数量为gree[i] +
            }else {
                gree[i] = 1;
            }
        }
        for (int i = ratings.length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]){
                gree[i] = Math.max(gree[i] ,gree[i+1]+1);
            }
        }
        int sum = 0;
        for (int i = 0; i < gree.length ; i++) {
            sum += gree[i];
        }
        return sum;
    }
}
