package com.xiongxinqiang.topic.common;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/4/6 6:37 下午
 * 796. 旋转字符串
 * <p>
 * 给定两个字符串, A和B。
 * <p>
 * A的旋转操作就是将A 最左边的字符移动到最右边。例如, 若A = 'abcde'，在移动一次之后结果就是'bcdea'。如果在若干次旋转操作之后，A能变成B，那么返回True。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateString {


    /**
     * 评论大佬写法
     * 思路：只需比较一下两个字符串的长度，然后判断A + A中是否存在B就ok，因为A + A中已经包含了所有可能的移动情况
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean rotateString1(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    /**
     * 鄙人所写
     * 思路：一个个比较，就硬比
     *
     * @param A
     * @param B
     * @return
     */
    public static boolean rotateString(String A, String B) {
        if (B.length() != A.length()) {
            return false;
        }
        if ("".equals(A) && "".equals(B)) {
            return true;
        }
        String temp = A;
        while (true) {
            char[] chars = A.toCharArray();
            String str = "";
            for (int i = 0; i < chars.length; i++) {
                if (i != 0) {
                    str = str + chars[i];
                }
            }
            str = str + chars[0];
            if (str.equals(B)) {
                return true;
            }
            if (temp.equals(str)) {
                return false;
            }
            A = str;
        }
    }

}
