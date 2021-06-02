package com.xiongxinqiang.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/10 2:08 下午
 * <p>
 * 面试题 03.02. 栈的最小值
 * <p>
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 * <p>
 * 该提示例、解法都与 剑指offer 30题一致
 * 注意：该题意是设计一个栈，双栈有点违规。不过把栈换成一个节点或者其他数据结构也是一样的，就不多话时间了，直接下一题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MianShiTi_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(100);
        minStack.push(1000);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

    static class MinStack {

        //双栈
        Deque<Integer> A;
        Deque<Integer> B;

        /**
         * 跟剑指offer 30题一致
         */

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            A = new LinkedList<>();
            B = new LinkedList<>();
        }

        public void push(int x) {
            //A栈正常维护元素，B栈只存放最小的元素
            A.push(x);
            if (B.isEmpty() || B.peek() >= x) {
                B.push(x);
            }
        }

        public void pop() {
            //当前弹出的元素小于等于B栈顶部元素
            if (A.pop() <= B.peek()) {
                B.pop();
            }
        }

        public int top() {
            return A.peek();
        }

        public int getMin() {
            return B.peek();
        }
    }


}

