package com.xiongxinqiang.leetcode.stack.easy;

import java.util.Stack;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/14 9:16 上午
 *
 * 682. 棒球比赛
 *
 * 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。
 *
 * 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：
 *
 * 整数 x - 表示本回合新获得分数 x
 * "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 * "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 * 请你返回记录中所有得分的总和。
 *
 * 示例1：
 * 输入：ops = ["5","2","C","D","+"]
 * 输出：30
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "2" - 记录加 2 ，记录现在是 [5, 2]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5].
 * "D" - 记录加 2 * 5 = 10 ，记录现在是 [5, 10].
 * "+" - 记录加 5 + 10 = 15 ，记录现在是 [5, 10, 15].
 * 所有得分的总和 5 + 10 + 15 = 30
 *
 *
 * 示例2：
 * 输入：ops = ["5","-2","4","C","D","9","+","+"]
 * 输出：27
 * 解释：
 * "5" - 记录加 5 ，记录现在是 [5]
 * "-2" - 记录加 -2 ，记录现在是 [5, -2]
 * "4" - 记录加 4 ，记录现在是 [5, -2, 4]
 * "C" - 使前一次得分的记录无效并将其移除，记录现在是 [5, -2]
 * "D" - 记录加 2 * -2 = -4 ，记录现在是 [5, -2, -4]
 * "9" - 记录加 9 ，记录现在是 [5, -2, -4, 9]
 * "+" - 记录加 -4 + 9 = 5 ，记录现在是 [5, -2, -4, 9, 5]
 * "+" - 记录加 9 + 5 = 14 ，记录现在是 [5, -2, -4, 9, 5, 14]
 * 所有得分的总和 5 + -2 + -4 + 9 + 5 + 14 = 27
 *
 *
 * 提示：
 * 1 <= ops.length <= 1000
 * ops[i] 为 "C"、"D"、"+"，或者一个表示整数的字符串。整数范围是 [-3 * 104, 3 * 104]
 * 对于 "+" 操作，题目数据保证记录此操作时前面总是存在两个有效的分数
 * 对于 "C" 和 "D" 操作，题目数据保证记录此操作时前面总是存在一个有效的分数
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/baseball-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BaseBallGame {


    public static void main(String[] args) {
        //C = 作废上一次得分
        //D = 上一次得分的2倍
        //+ = 前2次得分的总和
        //String[] strs = new String[]{"5", "2", "C", "D", "+"};
        String[] strs = new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(calPoints(strs));
        System.out.println(calPoints1(strs));
    }


    /**
     * 数组,近乎双百
     * 用时：1ms,击败100%
     * 内存：36.1MB,击败99.76
     *
     * @param ops
     * @return
     */
    public static int calPoints1(String[] ops) {
        //长度为1直接返回
        if (ops.length == 1) {
            return Integer.parseInt(ops[0]);
        }
        //定义一个新数组
        int[] arr = new int[ops.length];
        //指针
        int top = 0;
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    arr[top - 1] = 0;
                    --top;
                    break;
                case "D":
                    arr[top] = arr[top - 1] << 1;
                    ++top;
                    break;
                case "+":
                    arr[top] = arr[top - 1] + arr[top - 2];
                    ++top;
                    break;
                default:
                    arr[top] = Integer.parseInt(ops[i]);
                    ++top;
            }
        }
        int num = 0;
        for (int i : arr) {
            num += i;
        }
        return num;
    }


    /**
     * 栈操作
     * 用时：3ms,击败84.69%
     * 内存：38.1MB,击败5.09%
     *
     * @param ops
     * @return
     */
    public static int calPoints(String[] ops) {
        if (ops.length == 1) {
            return Integer.parseInt(ops[0]);
        }
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() << 1);
                    break;
                case "+":
                    Integer firstPop = stack.pop();
                    Integer secondPop = stack.pop();
                    stack.push(secondPop);
                    //第一个弹出来的元素最后在push进去，保证原有的顺序
                    stack.push(firstPop);
                    stack.push(firstPop + secondPop);
                    break;
                default:
                    stack.push(Integer.parseInt(ops[i]));
            }
        }
        while (!stack.isEmpty()) {
            num += stack.pop();
        }
        return num;
    }
}
