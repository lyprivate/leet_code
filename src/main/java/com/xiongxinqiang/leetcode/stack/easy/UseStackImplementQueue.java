package com.xiongxinqiang.leetcode.stack.easy;

import java.util.Stack;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/12 10:02 上午
 *
 * 面试题 03.04. 化栈为队 && 232. 用栈实现队列  (不同体相同解法)
 * 实现一个MyQueue类，该类用两个栈来实现一个队列。
 *
 * 示例：
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 说明：
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 * (就是只能用pop、peek 等基本方法)
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UseStackImplementQueue {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());

    }

    /*
     * 思路：
     * 队列的特性是 FIFO（先入先出），而栈的特性是 FILO（先入后出）。

知道两者特性之后，我们需要用两个栈来模拟队列的特性，一个栈为入队栈，一个栈为出对栈。

当出队栈存在内容时，出队栈的栈顶，即为第一个出队的元素。

若出队栈无元素，我们的需求又是出队的话，我们就需要将入队栈的内容反序导入出队栈，然后弹出栈顶即可。

注意：根据栈的的特性，我们仅能使用 push 和 pop 操作。
     */

    static class MyQueue {

        //入栈
        Stack<Integer> stackA;
        //出栈
        Stack<Integer> stackB;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stackA.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            peek();
            return stackB.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (stackB.isEmpty()) {
                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop());
                }
            }
            return stackB.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stackA.isEmpty() && stackB.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


}
