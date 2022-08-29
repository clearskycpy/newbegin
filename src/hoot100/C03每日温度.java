package hoot100;

import java.util.Stack;

public class C03每日温度 {
    /*给定一个整数数组temperatures，表示每天的温度，
    返回一个数组answer，其中answer[i]是指对于第 i 天，
    下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。
    输入: temperatures = [73,74,75,71,69,72,76,73]
                   输出: [1, 1 ,4 , 2, 1 ,1, 0, 0]

    思路：
        这个题目用单调栈去做还是有一定的思想深度的，要考虑到
        如果新来的元素比当前栈顶元素大的情况，那么就要把之前的元素弹出，并且，由于是顺序遍历的，那么此时栈顶的元素遇到的也就是第一个比他大的元素
        如果比栈顶元素小或者等于的情况，就直接加进去，然后继续往后面遍历，如果找不到更大的元素，那么就不用出栈了，也就是这个位置上取0即可
        如果可以出栈那么一定是有后面比前面温度高的时候的
*/


    public int[] dailyTemperatures(int[] temperatures) {
//        结果集
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()){
//                如果栈为空。那么就把现在遍历的元素的下标存进去。
//                为什么要存的是下标，因为存的下标可以用来计算距离，而且值可以通过 temperatures[i] 计算出来
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
//                根据要求进行弹栈
                int pop = stack.pop();
                res[pop] = i-pop;
            }
//            小于或者等于 或者前面的元素全部取出 将该位置的元素放进去
            stack.push(i);
        }
        return res;
    }
}
