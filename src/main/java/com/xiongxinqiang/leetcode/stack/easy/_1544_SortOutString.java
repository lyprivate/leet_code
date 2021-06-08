package com.xiongxinqiang.leetcode.stack.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/11 9:34 上午
 *
 * 1544. 整理字符串
 * 给你一个由大小写英文字母组成的字符串 s 。
 *
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 *
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 *
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 *
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 *
 * 示例：
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 *
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 *
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/make-the-string-great
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1544_SortOutString {



    public static void main(String[] args) {
        System.out.println(makeGood("leEeetcode"));

    }

    /**
     * 使用StringBuilder作为容器
     *
     * @param s
     * @return
     */
    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = -1;
        while (len != sb.length()) {
            //如果遍历前和遍历后len = sb.length()那么说明已经整理完毕
            len = sb.length();
            for (int i = 0; i < sb.length() - 1; i++) {
                //位运算,'a' - 'A' 的尾差等于32(同理'b' - 'B' 也一样)
                if ((sb.charAt(i) ^ sb.charAt(i + 1)) == 32) {
                    //找到就删除这2个字符
                    sb.delete(i, i + 2);
                }
               /* if (Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == 32) {
                    sb.delete(i, i + 2);
                }*/
            }
        }
        return sb.toString();
    }

    /**
     * 官方思路：
     * 从左到右扫描字符串 s 的每个字符。扫描过程中，维护当前整理好的字符串，记为 ret。当扫描到字符 ch 时，有两种情况：
     * 字符 ch 与字符串 ret 的最后一个字符互为同一个字母的大小写：根据题意，两个字符都要在整理过程中被删除，因此要弹出 ret 的最后一个字符；
     * 否则：两个字符都需要被保留，因此要将字符 ch 附加在字符串 ret 的后面。
     *
     * @param s
     * @return
     */
    public static String makeGood1(String s) {
        StringBuilder ret = new StringBuilder();
        int retIndex = -1;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (ret.length() > 0 && Math.abs(ret.charAt(retIndex) - ch) == 32) {
                ret.deleteCharAt(retIndex);
                retIndex--;
            } else {
                ret.append(ch);
                retIndex++;
            }
        }
        return ret.toString();
    }



}
