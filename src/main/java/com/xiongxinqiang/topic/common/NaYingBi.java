package com.xiongxinqiang.topic.common;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2020/12/25 5:55 下午
 */

import org.junit.Test;

/**
 * 编码：06
 * <p>
 * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
 * <p>
 * 输入：[4,2,1]
 * <p>
 * 输出：4
 * <p>
 * 解释：第一堆力扣币最少需要拿 2 次，第二堆最少需要拿 1 次，第三堆最少需要拿 1 次，总共 4 次即可拿完。
 * <p>
 * <p>
 * 输入：[2,3,10]
 * <p>
 * 输出：8
 * <p>
 * <p>
 * 1 <= n <= 4
 * 1 <= coins[i] <= 10
 */
public class NaYingBi {


    @Test
    public void test22() {
        int[] oi = {2, 3, 10};
        System.out.println(minCount(oi));
    }

    /**
     * 记录我自己的垃圾写法,没脑子 转不过来,写成这个B样
     *
     * @param coins 每堆所含的数量,coins 长度小于等于10
     * @return
     */
    public int minCount(int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] % 2 == 0) {
                count += coins[i] / 2;
            } else {
                int var = coins[i] / 2;
                count += (coins[i] - (var * 2)) + var;

                //count += (coins[i] + 1) / 2; 连这种都没想到,是真傻逼
            }
        }
        return count;
    }


    /**
     * 别人的,比较正常的写法
     *
     * @param coins
     * @return
     */
    public int minCount1(int[] coins) {
        int sum = 0;
        for (int i = 0; i < coins.length; i++) {
            sum += (coins[i] + 1) / 2;

        }
        return sum;
    }
}
