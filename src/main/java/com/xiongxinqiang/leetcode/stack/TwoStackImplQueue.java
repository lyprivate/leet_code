package com.xiongxinqiang.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/4/21 10:09 上午
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * 示例1.
 * 输入：["CQueue","appendTail","deleteHead","deleteHead"](操作步骤)
 * [[],[3],[],[]] (对应的参数)
 * 输出：[null,null,3,-1]
 * <p>
 * 示例2.
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class TwoStackImplQueue {


    public static void main(String[] args) {
        CQueue queue = new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }


}


/**
 * 官方建议：双队列
 * 思路和算法
 *
 * 维护两个栈，第一个栈支持插入操作，第二个栈支持删除操作。
 *
 * 根据栈先进后出的特性，我们每次往第一个栈里插入元素后，第一个栈的底部元素是最后插入的元素，第一个栈的顶部元素是下一个待删除的元素。
 * 为了维护队列先进先出的特性，我们引入第二个栈，用第二个栈维护待删除的元素，在执行删除操作的时候我们首先看下第二个栈是否为空。
 * 如果为空，我们将第一个栈里的元素一个个弹出插入到第二个栈里，这样第二个栈里元素的顺序就是待删除的元素的顺序，要执行删除操作的时候我们直接弹出第二个栈的元素返回即可。
 */
class CQueue {

    Deque<Integer> queue1;
    Deque<Integer> queue2;

    public CQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        queue1.push(value);

    }


    public int deleteHead() {
        if (queue2.isEmpty()) {
            if (queue1.isEmpty()) {
                return -1;
            }
            while (!queue1.isEmpty()) {
                queue2.push(queue1.pop());
            }
        }
        return queue2.pop();

    }
}

/*
 * 单队列
 * 用时：42 ms  击败了 99.45%的用户，97.07% 内存：46.2 MB
 */
/*class CQueue {

    Queue<Integer> queue;

    public CQueue() {
        queue = new LinkedList();

    }

    public void appendTail(int value) {
        queue.add(value);
    }

    public int deleteHead() {
        Integer poll = queue.poll();
        return poll == null ? -1 : poll;
    }
}*/
