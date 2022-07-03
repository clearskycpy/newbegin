package stack_and_queue;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> staIn;
    Stack<Integer> staOut;

    /**
     * 初始化两个栈
     * 一个负责列队出 staOut
     * 一个负责列队入 staIn
     */
    public MyQueue() {
        staIn = new Stack<>();
        staOut = new Stack<>();
    }

    public void push(int x) {
        staIn.push(x);
    }

    public int pop() throws EmptyException {
        dumpstackIn();
//        异常处理
        if (staOut.empty()){
            throw new EmptyException("Queue is empty");
        }return staOut.pop();
    }


    public int peek() throws EmptyException {
        dumpstackIn();
        // 异常处理
        if (staOut.empty()) {
            throw new EmptyException("Queue is empty");
        }
        return staOut.peek();
    }

    public boolean empty() {
        return staOut.empty() && staIn.empty();
    }

    private void dumpstackIn() {
        if (staOut.empty()){
            // 为空的时候，将in里面的元素移动到out里面
            while (!staIn.empty()){
                staOut.push(staIn.pop());
            }
        }
    }
}

