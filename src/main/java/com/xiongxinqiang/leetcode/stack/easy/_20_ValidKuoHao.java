package com.xiongxinqiang.leetcode.stack.easy;

import java.util.Stack;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/4/29 5:41 下午
 *<p>
 * 20. 有效的括号
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 示例1
 * 输入：s = "()"
 * 输出：true
 *
 * 示例2
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例3
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例4
 * 输入：s = "([)]"
 * 输出：false
 *
 * 示例5
 * 输入：s = "{[]}"
 * 输出：true
 *
 * 提示
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 */
public class _20_ValidKuoHao {



    public static void main(String[] args) {
        String s = "({[]})";
        System.out.println(isValid(s));
    }


    /**
     * 解题思路
     * 1. 字符串为空返回true
     * 2. 只有偶数才有可能匹配成功，所以如果是奇数直接返回false
     * 3. 遍历字符串,将所有的左括号添加到栈中，如果是右括号，找到当前对应的左括号，
     * 比较栈中第一个左括号(前提不为空),匹配成功将当前左括号弹出，否则返回false，最后栈为空则完全匹配成功
     *
     * @param s
     * @return boolean
     */
    public static boolean isValid(String s) {
        //为空返回true
        if (null == s || "".equals(s)) {
            return true;
        }
        //偶数才有可能完全匹配
        if (s.length() % 2 == 1) {
            return false;
        }
        //将左括号全部放入栈中
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char mchar = s.charAt(i);
            if (mchar == '(' || mchar == '[' || mchar == '{') {
                stack.push(mchar);
                continue;
            }
            //右括号进行匹配
            Character hit = null;
            switch (mchar) {
                case ')':
                    hit = '(';
                    break;
                case ']':
                    hit = '[';
                    break;
                case '}':
                    hit = '{';
                    break;
            }
            if (!stack.isEmpty() && stack.peek().equals(hit)) {
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }
}
