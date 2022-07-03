package one_question_a_day.june;

public class C6_25粉刷房子 {
    public int minCost(int[][] costs) {
        int len = costs.length - 1;
        if(costs.length >= 1) {
            for (int i = 1; i <= len; i++) {
//              [[17,2,17],[16,16,5],[14,3,19]]
                costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
                costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
                costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
            }
        }
        return Math.min(costs[len][0],Math.min(costs[len][1],costs[len][2]));
    }
}
