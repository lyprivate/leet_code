package com.xiongxinqiang.leetcode.stack.medium;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/9 9:14 上午
 *
 * 921. 使括号有效的最少添加
 *
 * 给定一个由'('和')'括号组成的字符串 S，我们需要添加最少的括号（ '('或是')'，可以在任何位置），以使得到的括号字符串有效。
 *
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 *
 * 它是一个空字符串，或者
 * 它可以被写成AB（A与B连接）, 其中A 和B都是有效字符串，或者
 * 它可以被写作(A)，其中A是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 *
 *
 * 示例1：
 * 输入："())"
 * 输出：1
 *
 * 示例2：
 * 输入："((("
 * 输出：3
 *
 * 示例3：
 * 输入："()"
 * 输出：0
 *
 * 示例4：
 * 输入："()))(("
 * 输出：4
 *
 * 提示：
 * S.length <= 1000
 * S 只包含 '(' 和 ')' 字符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-add-to-make-parentheses-valid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class _921_ShiKuoHaoYouXiaoTianJia {



    public static void main(String[] args) {
        String s = "((((";
        System.out.println(minAddToMakeValid(s));
    }


    public static int minAddToMakeValid(String s) {
        //计数
        int ans = 0, bal = 0;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            //左括号加1，右括号加-1，(),最后会抵消重新变为0
            bal += aChar == '(' ? 1 : -1;
            //如果等于-1说明第一个就是右括号，记录一个
            if (bal == -1) {
                ans++;
                bal++;
            }
        }
        //如果全是左括号的话bal一直为0，相减就等于需要多少个右括号补齐
        return ans + bal;
    }


}
