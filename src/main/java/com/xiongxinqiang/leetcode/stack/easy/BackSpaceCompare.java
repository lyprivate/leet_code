package com.xiongxinqiang.leetcode.stack.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/17 5:28 下午
 *
 * 844. 比较含退格的字符串
 *
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 *
 * 示例1：
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 *
 * 示例2：
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 *
 * 示例3：
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * 示例4：
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 *
 * 提示：
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BackSpaceCompare {

    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
//        String S = "y#fo##f", T = "y#f#o##f";


        System.out.println(backspaceCompare(S, T));

    }


    /**
     * 1ms,击败87.60%
     * 36.4MB,击败97.24%
     * 方法2：StringBuilder
     *
     * @return
     */
    public static boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }


    private static String build(String str) {
        StringBuilder ret = new StringBuilder();
        int top = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ('#' != chars[i]) {
                ret.append(chars[i]);
                top++;
            } else if (ret.length() > 0) {
                ret.delete(top - 1, top);
                --top;
            }
        }
        return ret.toString();
    }


}
