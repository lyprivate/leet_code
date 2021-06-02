package com.xiongxinqiang.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/12 4:56 下午
 *
 * 1441. 用栈操作构建数组
 *
 * 给你一个目标数组 target 和一个整数 n。每次迭代，需要从 list = {1,2,3..., n} 中依序读取一个数字。
 *
 * 请使用下述操作来构建目标数组 target ：
 *
 * Push：从 list 中读取一个新元素， 并将其推入数组中。
 * Pop：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 *
 * 请返回构建目标数组所用的操作序列。
 *
 * 题目数据保证答案是唯一的。
 *
 * 示例1：
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 *
 * 示例2：
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 *
 * 示例3：
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 *
 * 示例4：
 * 输入：target = [2,3,4], n = 4
 * 输出：["Push","Pop","Push","Push","Push"]
 *
 * 提示：
 * 1 <= target.length <= 100
 * 1 <= target[i] <= 100
 * 1 <= n <= 100
 * target 是严格递增的
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/build-an-array-with-stack-operations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StackBuildArray {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3,4};
        int n = 4;
        System.out.println(buildArray(arr, n));
    }


    public static List<String> buildArray(int[] target, int n) {
        //记录操作步骤
        List<String> record = new ArrayList<>();
        //定义保存数字的栈
        Stack<Integer> stack = new Stack<>();
        //i=1(从1开始),j=0(索引从0开始)
        for (int i = 1,j = 0; i <= n && j < target.length; i++) {
            //将数字入栈
            stack.push(i);
            //记录push操作
            record.add("Push");
            //如果数字栈的顶部元素值 等于 target目标数组的最后一个元素值，则可以直接返回
            if (stack.peek() == target[target.length - 1]) {
                return record;
            }
            //不相同,弹出栈，记录Pop操作
            if (i != target[j]) {
                stack.pop();
                record.add("Pop");
            } else {
                //匹配上了，指针移动
                j++;
            }
        }
        return record;
    }
}
