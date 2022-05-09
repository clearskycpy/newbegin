package GreedyAlgorithm;

public class C04柠檬水找零 {
    /**
     * 遍历数组 将数组当前位置小于20的面值保存。对面值进行处理
     * 处理不了直接返回false
     * 如果成功退出循环 返回true
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int fine = 0 ;
        int ten = 0 ;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5 ){   // 结账的时候是5
                fine++;
            }else if (bills[i] == 10 ){  // 结账的时候是 10
                ten++;
                if (fine >0){
                    fine--;
                }else return false;

            }else {
//                结账的时候是20
                if (ten > 0 ){ // 有10 的时候
                    ten--;
                    if (fine <= 0) return false;
                    fine--;
                }else {
//                    只有五的时候
                    if (fine < 3) return false;
                    fine -= 3;
                }
            }
        }
        return true;
    }
}
