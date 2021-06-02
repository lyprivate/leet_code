package com.xiongxinqiang.topic.common;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/4/9 5:29 下午
 * <p>
 * 367. 有效的完全平方数
 * <p>
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * 进阶：不要 使用任何内置的库函数，如 sqrt 。
 * <p>
 * 示例
 * 输入：num = 16
 * 输出：true
 * 输入：num = 14
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sqrt {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(14));


    }

    /**
     * 牛顿迭代法
     *
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        //平方数一定是比 num / 2 要小,缩短循环过程
        long x = num / 2;
        /**
         * 9举例
         *  x = 9 / 2 = 4.5
         *   x * x > 9  => 4.5 * 4.5 > 9
         *  x = (4.5 + 9 / 4.5) / 2
         *  x= 3.25   3.25 * 3.25 > 9
         *  一直循环计算
         *  最后 x * x == num  判断是否是平方数
         */
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }

    /**
     * 代码超时 硬算
     *
     * @param num
     * @return
     */
    public static boolean isPerfectSquare1(int num) {
        if (num == 1) {
            return true;
        }
        int num1 = 2;
        while (num > num1) {
            int num2 = num1 * num1;
            if (num == num2) {
                return true;
            }
            num1++;
        }
        return false;
    }

}
