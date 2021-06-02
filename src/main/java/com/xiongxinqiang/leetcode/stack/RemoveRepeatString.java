package com.xiongxinqiang.leetcode.stack;

import java.util.Stack;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/5/8 9:28 上午
 * <p>
 * 1047. 删除字符串中的所有相邻重复项
 * <p>
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * <p>
 * 提示：
 * 1. 1 <= S.length <= 20000
 * 2. S 仅由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </P>
 */
public class RemoveRepeatString {



    public static void main(String[] args) {
        String a = "abbaca";
        System.out.println(removeDuplicates3(a));
    }


    /**
     * 执行用时：9 ms, 在所有 Java 提交中击败了86.50%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了85.01%的用户
     * <p>
     * 思路：
     * 也是利用栈的数据结构，不过当前方法使用StringBuilder作为栈，自定义指针，思路与方法1相同
     *
     * @param S
     * @return
     */
    public static String removeDuplicates3(String S) {
        if (S.length() == 0) {
            return "";
        }
        //用StringBuilder 作为栈
        StringBuilder stack = new StringBuilder();
        //定义指针
        int top = -1;
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            /*
             * top >= 0 表示stack已被初始化(有元素),且顶部字符等于当前遍历的字符
             * 相同则抹除，且指针往后移动
             */
            if (top >= 0 && stack.charAt(top) == chars[i]) {
                stack.deleteCharAt(top);
                --top;
            } else {
                /*
                 * 将字符添加到顶部，指针往前移动
                 */
                stack.append(chars[i]);
                ++top;
            }
        }
        return stack.toString();
    }


    /**
     * 评论区大佬：
     * 执行用时：4 ms, 在所有 Java 提交中击败了99.39%的用户
     * 内存消耗：38.8 MB, 在所有 Java 提交中击败了86.34%的用户
     * <p>
     * 思路：自定义栈
     *
     * @param S
     * @return
     */
    public static String removeDuplicates2(String S) {
        int n = S.length();
        char[] ss = S.toCharArray();//转为字符数组
        char[] stack = new char[n];//定义栈
        int top = -1; //定义栈指针
        //以下for循环将不重复的字符存放在栈里
        for (int j = 0; j < n; j++) {
            if (top > -1 && stack[top] == ss[j]) {
                top--;//栈针移动，代替真是出栈
            } else {
                stack[++top] = ss[j];//根据栈针移动直接覆盖重复的值
            }
        }
        //以下打印栈内不重复的字符
        char[] ans = new char[top + 1];
        for (int i = 0; i < top + 1; i++) {
            ans[i] = stack[i];
        }
        //通过有参构造传递字符数组，直接创建字符串对象
        String str = new String(ans);
        return str;
    }


    /**
     * 执行用时：237 ms, 在所有 Java 提交中击败了7.51%的用户
     * 内存消耗：40.7 MB, 在所有 Java 提交中击败了5.00%的用户
     * 思路：
     * 利用栈，遍历将字符压栈后匹配，匹配成功则弹栈(移除),最后返回栈中的字符
     *
     * @param S
     * @return
     */
    public static String removeDuplicates1(String S) {
        if (S.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack();

        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char mychar = chars[i];
            if (!stack.isEmpty() && stack.peek().equals(mychar)) {
                stack.pop();
            } else {
                stack.push(mychar);
            }
        }
        String res = "";
        for (Character character : stack) {
            res += character;
        }
        return res;
    }
}
