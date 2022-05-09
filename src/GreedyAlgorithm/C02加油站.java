package GreedyAlgorithm;
//在一条环路上有 n个加油站，其中第 i个加油站有汽油gas[i]升。
//        你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。
//        你从其中的一个加油站出发，开始时油箱为空。
//        给定两个整数数组 gas 和 cost ，如果你可以绕环路行驶一周，
//        则返回出发时加油站的编号，否则返回 -1 。
//        如果存在解，则 保证 它是 唯一 的。
public class C02加油站 {
    /**
     * 贪心求解
     * 先求出从每个地方出发的油耗分别是多少 --》 gas[i]-cost[i]  由于出发点正确的只会有一个
     * 正确的出发点会在经过负重油耗最大值  之前就先累积好填坑的油  所以我们应该找的出发点应该就是在
     * 解法er
     * 累积每个地方的存油 一旦出现负值，那么说明之前的所有地方都不能作为出发点 同时sum重新计数 出发点变成后面一个
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(cost.length == 1){
            return gas[0] - cost[0] < 0 ? -1 : 0;
        }
        int[] result = new int[cost.length];
        for (int i = 0; i < cost.length; i++) {
            result[i] = gas[i] - cost[i];
        }
        int sum = 0;
        int res = 0;
        int sum1 = 0;
        for (int i = 0; i < result.length; i++) {
            sum1 += result[i];
            sum+= result[i];
            if (sum < 0){
                sum = 0;
                res = i+1;
            }

        }
        return sum1 < 0 ? -1 : res;
    }
}
