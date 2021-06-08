package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/4 10:05 上午
 *
 * 495. 提莫攻击
 *
 * 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 *
 * 你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 *
 * 示例1：
 * 输入: [1,4], 2
 * 输出: 4
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 第 4 秒初，提莫再次攻击艾希，使得艾希获得另外 2 秒中毒时间。
 * 所以最终输出 4 秒。
 *
 * 示例2：
 * 输入: [1,2], 2
 * 输出: 3
 * 原因: 第 1 秒初，提莫开始对艾希进行攻击并使其立即中毒。中毒状态会维持 2 秒钟，直到第 2 秒末结束。
 * 但是第 2 秒初，提莫再次攻击了已经处于中毒状态的艾希。
 * 由于中毒状态不可叠加，提莫在第 2 秒初的这次攻击会在第 3 秒末结束。
 * 所以最终输出 3 。
 *
 * 提示：
 * 1. 你可以假定时间序列数组的总长度不超过 10000。
 * 2. 你可以假定提莫攻击时间序列中的数字和提莫攻击的中毒持续时间都是非负整数，并且不超过 10,000,000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/teemo-attacking
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _495_LoLTiMoGongJi {



    public static void main(String[] args) {
        int[] timeSeries = new int[]{1, 2};
        int duration = 2;
        System.out.println(findPoisonedDuration(timeSeries, duration));
    }


    /**
     * 遍历计算
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 1) {
            return duration;
        }
        //长度大于1的话 一定会有一次中毒
        int ret = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            //当前这一次攻击的时间 - 上一次攻击的时间 是否大于 中毒时间，大于的话就加一个完整的中毒时间，不大于就是他们中间间隔的时间
            ret += (timeSeries[i] - timeSeries[i - 1] >= duration) ? duration : timeSeries[i] - timeSeries[i - 1];
        }
        return ret;
    }


    /**
     * 官方题解
     * <p>
     * 方法一：单次扫描
     * 我们只需要对数组进行一次扫描就可以计算出总的中毒持续时间。
     * <p>
     * 考虑相邻两个攻击时间点 A[i] 和 A[i + 1] 以及中毒持续时间 t，
     * 如果 A[i] + t <= A[i + 1]，那么在第 i + 1 次攻击时，第 i 次攻击造成的中毒的持续时间已经结束，
     * 即持续时间为 t；如果 A[i] + t > A[i + 1]，那么在第 i + 1 次攻击时，
     * 第 i 次攻击的中毒仍然在持续，由于中毒状态不可叠加，因此持续时间为 A[i + 1] - A[i]。
     *
     * @param timeSeries
     * @param duration
     * @return
     */
    public int findPoisonedDuration1(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0) return 0;

        int total = 0;
        for (int i = 0; i < n - 1; ++i) {
            total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
        }
        return total + duration;
    }
}
