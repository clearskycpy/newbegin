package one_question_a_day.july;

import java.util.*;

public class C7_13星星碰撞 {
    /*
    输入：asteroids = [5,10,-5]
    输出：[5,10]
    解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
    输入：
    [-2,-1,1,2]
    输出：
    [-1,1,2]
    预期结果：
    [-2,-1,1,2]*/
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0) stack.add(asteroids[i]); // 如果大于零的话就直接入栈
            if (asteroids[i] < 0){
                int temp = -asteroids[i];
                boolean isOk = true;
                while (!stack.isEmpty() && isOk){
                    int top = stack.removeLast();  // 拿出顶部的元素进行比较
                    if (top < 0){
                        stack.add(top);
                        break;
                    }
                    if (top == temp){
//                        发生碰撞了
                        isOk = false;
                        break;
                    }
                    if (top > temp){
//                        说明这一个负数行星撞过来炸了
                        stack.add(top);
                        isOk = false;
                        break;
                    }
                }
                if (isOk) stack.add(asteroids[i]);
            }
        }
        int[] res = new int[stack.size()];
        int index = 0;
        for (Integer i : stack) {
            res[index] = i;
            index++;
        }
        return res;
    }
}
