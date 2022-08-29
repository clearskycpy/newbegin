package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C06得分计算 {
    public static void main(String[] args) {

    }
    public static String getSuccess(int[] nums,int[] q,int c){
        int sum1 = 0;
        int sum2 = 0;
        int tq = 0;
        for (int i = 0; i < nums.length; i++) {
            tq += q[i];
            int t = nums[i] - tq*c;
            if (t>0){
                sum1 += t;
            }
        }
        int tq2 = 0;
        for (int i = nums.length-1; i >= 0 ; i--) {
            tq2 += q[i];
            int t = nums[i] - tq2*c;
            if (t>0){
                sum2 += t;
            }
        }
        return sum1 > sum2 ? "sum1" :"sum2";
    }
}
