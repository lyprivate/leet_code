package com.xiongxinqiang.leetcode.stack.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/10 3:03 下午
 *
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * 意思就是getMin这个函数的时间复杂度是 O(1)
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 * 该提与 面试题03.02、剑指Offer 30 类型一致。
 * 示例：
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 提示：
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {

    /*
     * 与面试题03.02、剑指offer 30 类型一致
     * 执行用时：6 ms, 在所有 Java 提交中击败了97.34%的用户
     * 内存消耗：39.7 MB, 在所有 Java 提交中击败了99.02%的用户
     *
     * 思路：
     * 1. 自定义Node节点，val维护正常值，min维护最小值，next为下一个节点
     * 2. push时，比较当前值是否小于下一个节点的最小值。
     */

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(100);
        minStack.push(1000);
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }


    private Node node;


    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int val) {
        //初始化
        if (node == null) {
            node = new Node(val, val, null);
            return;
        }
        //栈的特点，先进后出
        node = new Node(Math.min(node.min, val), val, node);
    }

    public void pop() {
        //模拟弹栈操作,指针往后移动(把我变成我的下一个)
        node = node.next;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }

    static class Node {
        int min;
        int val;
        Node next;


        public Node(int min, int val, Node node) {
            this.min = min;
            this.val = val;
            this.next = node;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

    }


}
