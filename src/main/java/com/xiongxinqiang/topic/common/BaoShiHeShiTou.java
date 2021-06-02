package com.xiongxinqiang.topic.common;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/3/4 5:04 下午
 *
 *
 * * 771. 宝石与石头
 *  * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *  * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 *  *
 *  * 示例
 *  * 输入: J = "aA", S = "aAAbbbb"
 *  * 输出: 3
 *  *
 *  * 输入: J = "z", S = "ZZ"
 *  * 输出: 0
 *  *
 *  * 注意
 *  * S 和 J 最多含有50个字母。
 *  * J 中的字符不重复。
 */
public class BaoShiHeShiTou {



    public static void main(String[] args) {
        long st = System.currentTimeMillis();
        String s = "aAAbbbb";
        String j = "aA";
        System.out.println(numJewelsInStones(s, j));
        long et = System.currentTimeMillis();
        System.out.println(et - st);
    }

    /**
     * 暴力遍历
     * @param jewels
     * @param stones
     * @return
     */
    public static int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    ++count;
                    break;
                }
            }
        }
        return count;
    }
}
