package com.xiongxinqiang.topic.common;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2020/12/25 5:22 下午
 */

import org.junit.Test;

/**
 * 编号：01
 * 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
 * <p>
 * 输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
 * <p>
 * <p>
 * 输入：guess = [1,2,3], answer = [1,2,3]
 * 输出：3
 * 解释：小A 每次都猜对了
 * <p>
 * <p>
 * 输入：guess = [2,2,3], answer = [3,2,1]
 * 输出：1
 * 解释：小A 只猜对了第二次。
 * <p>
 * <p>
 * <p>
 * guess的长度 = 3
 * answer的长度 = 3
 * guess的元素取值为 {1, 2, 3} 之一。
 * answer的元素取值为 {1, 2, 3} 之一。
 */
public class CaiShuZi {

    @Test
    public void test1() {
        long st = System.currentTimeMillis();
        int[] guess = new int[]{2, 2, 3};
        int[] answer = new int[]{3, 2, 1};
        System.out.println("结果：" + game1(guess, answer));
        long et = System.currentTimeMillis();
        System.out.println(et - st);
    }


    /**
     * 内存消耗34M,只有垃圾才会这样写(我就是)
     *
     * @param guess  小A猜测的
     * @param answer 小B选择的
     * @return
     */
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < guess.length; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (i == j) {
                    if (guess[i] == answer[j]) {
                        ++count;
                    }
                }
            }
        }
        return count;
    }


    /**
     * 内存消耗6.7M写法
     *
     * @param guess
     * @param answer
     * @return
     */
    public int game1(int[] guess, int[] answer) {
        return (guess[0] == answer[0] ? 1 : 0) + (guess[1] == answer[1] ? 1 : 0) + (guess[2] == answer[2] ? 1 : 0);

    }


}
