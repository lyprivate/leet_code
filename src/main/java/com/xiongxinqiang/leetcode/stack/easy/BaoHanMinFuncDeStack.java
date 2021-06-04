package com.xiongxinqiang.leetcode.stack.easy;

import java.util.Stack;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/4/25 2:32 下午
 * <p>
 * 剑指 Offer 30. 包含min函数的栈
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 示例：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * <p>
 * <p>
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BaoHanMinFuncDeStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.min());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());
    }

    public static class MinStack {

        /*
         * A栈正常push元素，B栈只push最小的元素，保证最小的元素始终在B栈的头部
         * pop方法弹出A栈元素时，判断当前元素是否小于等于B栈最顶部的元素，如果是也一并弹出
         * top方法返回A栈最顶部元素
         * min方法返回B栈最顶部元素,保证时间复杂度O(1)
         */
        Stack<Integer> stackA;
        Stack<Integer> stackB;


        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }


        public void push(int x) {
            stackA.push(x);
            if (stackB.isEmpty() || stackB.peek() >= x) {
                stackB.push(x);
            }
        }

        public void pop() {
            Integer pop = stackA.pop();
            if (pop <= stackB.peek()) {
                stackB.pop();
            }
        }

        public int top() {
            return stackA.peek();
        }

        public int min() {
            return stackB.peek();
        }

    }

}

