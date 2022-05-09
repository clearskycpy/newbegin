package one_question_a_day.april;
/*给你一个 m x n 的整数网格 accounts ，其中 accounts[i][j] 是第 i位客户在第 j 家银行托管的资产数量。
返回最富有客户所拥有的 资产总量 。
客户的 资产总量 就是他们在各家银行托管的资产数量之和。最富有客户就是 资产总量 最大的客户。
累积求和
分别求i位客人的资产*/
public class C4_14资产总量 {
    public int maximumWealth(int[][] accounts) {
//        条件判断
        int res = 0;
        for (int i = 0; i < accounts.length; i++) {
            int sum= 0;
            for (int j = 0; j < accounts[0].length; j++) {
                sum += accounts[i][j];
            }
            res = Math.max(res,sum);
        }
        return res;
    }
}
