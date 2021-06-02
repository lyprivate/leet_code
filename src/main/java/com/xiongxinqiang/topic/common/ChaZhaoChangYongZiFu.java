package com.xiongxinqiang.topic.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/3/4 4:12 下午
 */

/**
 * 1002
 * 给定仅有小写字母组成的字符串数组
 * A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例
 * 输入：["bella","label","roerll"]
 * 输出：["e","l","l"]
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 */
public class ChaZhaoChangYongZiFu {
    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        String[] str = new String[]{"bella", "label", "roller"};
        System.out.println(commonChars(str));
        long et = System.currentTimeMillis();
        System.out.println(et - st);
    }

    public static List<String> commonChars(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }


}
