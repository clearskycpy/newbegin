package stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列 实现栈
 * 用链表代替列队 栈只有压栈和弹栈那么如何达到
 * 列队的先进先出后进后厨的效果
 * queueHelp 负责保存在弹栈过程中前面所有的元素，然后再将元素拷回去
 */
public class MyStack {
    Queue<Integer> queueHelp; // 处理进队
    Queue<Integer> queue; // 处理出队
    public MyStack() {
        queue = new LinkedList<>();
        queueHelp = new LinkedList<>();
    }
    /**
     * 压栈
     * @param x
     */
    public void push(int x) {
        queueHelp.offer(x);  // 通过这样转移一下 。 最后面的元素在辅助队列的最前面
                            // 然后将其他元素也放入辅助队列中，最后交换这两个队列。达到了后进先出的作用，也就是栈
        while (!queue.isEmpty()){
            queueHelp.offer(queue.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue;
        queue = queueHelp;
        queueHelp = queueTemp;
    }

    /**
     * 因为已经调整好了元素的位置，所以可以直接用链表中的方法进行元素的弹栈或者是查看
     * @return
     */
    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
