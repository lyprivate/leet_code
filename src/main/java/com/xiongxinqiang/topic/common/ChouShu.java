package com.xiongxinqiang.topic.common;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/3/5 9:51 上午
 *
 *
 * 263. 丑数
 *
 * 编写一个程序判断给定的数是否为丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例1
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 *
 * 示例2
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 *
 * 示例3
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 *
 * 说明
 *
 *  1 是丑数。
 * 输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
 */
public class ChouShu {

    public static void main(String[] args) {
        int a = 8;
        System.out.println(isUgly(a));
    }


    public static boolean isUgly(int num) {
        //写成变量是因为一直提示我有魔法值
        int num2 = 2;
        int num3 = 3;
        int num5 = 5;
        if (num < 1) {
            return false;
        }
        while (num % num2 == 0) {
            num /= num2;
        }
        while (num % num3 == 0) {
            num /= num3;
        }
        while (num % num5 == 0) {
            num /= num5;
        }
        return num == 1;
    }
}
