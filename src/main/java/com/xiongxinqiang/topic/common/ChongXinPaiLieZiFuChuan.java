package com.xiongxinqiang.topic.common;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/3/12 2:06 下午
 *
 *
 *  * <p>
 *  * <p>
 *  * 1528. 重新排列字符串
 *  * <p>
 *  * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 *  * <p>
 *  * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 *  * <p>
 *  * 返回重新排列后的字符串。
 *  * <p>
 *  * <p>
 *  * 示例：
 *  * 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 *  * 输出："leetcode"
 *  * 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 *  * <p>
 *  * 输入：s = "abc", indices = [0,1,2]
 *  * 输出："abc"
 *  * 解释：重新排列后，每个字符都还留在原来的位置上。
 *  * <p>
 *  * 提示
 *  * s.length == indices.length == n
 *  * 1 <= n <= 100
 *  * s 仅包含小写英文字母。
 *  * 0 <= indices[i] < n
 *  * indices 的所有的值都是唯一的（也就是说，indices 是整数 0 到 n - 1 形成的一组排列）。
 *  * <p>
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/shuffle-string
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ChongXinPaiLieZiFuChuan {


    public static void main(String[] args) {
        String s = "codeleet";
        int[] arr = new int[]{4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(restoreString(s, arr));
    }


    /**
     * 重新排序字符串
     *
     * @param s
     * @param indices
     * @return
     */
    public static String restoreString(String s, int[] indices) {
        if (null == s || "".equals(s)) {
            return "";
        }
        char[] chars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }
        return new String(chars);
    }


}
