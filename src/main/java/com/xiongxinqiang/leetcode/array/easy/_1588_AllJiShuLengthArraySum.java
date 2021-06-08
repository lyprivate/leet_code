package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/8 10:42 上午
 *
 * 1588. 所有奇数长度子数组的和
 *
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr中 所有奇数长度子数组的和 。
 *
 * 示例1：
 * 输入：arr = [1,4,2,5,3]
 * 输出：58
 * 解释：所有奇数长度子数组和它们的和为：
 * [1] = 1
 * [4] = 4
 * [2] = 2
 * [5] = 5
 * [3] = 3
 * [1,4,2] = 7
 * [4,2,5] = 11
 * [2,5,3] = 10
 * [1,4,2,5,3] = 15
 * 我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
 *
 * 示例2：
 * 输入：arr = [1,2]
 * 输出：3
 * 解释：总共只有 2 个长度为奇数的子数组，[1] 和 [2]。它们的和为 3 。
 *
 * 示例3：
 * 输入：arr = [10,11,12]
 * 输出：66
 *
 * 提示：
 * 1 <= arr.length <= 100
 * 1 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-all-odd-length-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _1588_AllJiShuLengthArraySum {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 5, 3};
        System.out.println(sumOddLengthSubarrays(arr));
    }

    //举例：{1,2,3,4,5}
    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int len = arr.length;
        for (int i = 0; i < arr.length; i++) {
            //当i = 2时候，arr[2] = 3,左边有2个元素1，2，
            //需要保证连续，则取元素方式如下:
            //取0个:{3}
            //取1个:只取一个元素2.则{2,3}
            //取2个:取2个元素1和2,则{1,2,3}
            //所以有3种情况就是2+1种情况，也就是i+1种情况
            int left = i + 1;
            //右边元素个数为：len-(i+1)个
            //同理可得
            int right = len - (i + 1) + 1;
            //左边取的元素个数0,1,2；则只有1为奇数，可得左边取奇数个元素的方式：
            int left_odd = left / 2;
            //左边取的元素个数0,1,2；则偶数为0个或者2个，可得左边取偶数个元素的方式：
            int left_even = (left + 1) / 2;
            //同上，右边取奇数个元素的方式
            int right_odd = right / 2;
            //同上，右边取偶数个元素的方式
            int right_even = (right + 1) / 2;
            //左边取任意奇数个同时右边取任意奇数个加上自身，一共奇数个。任意组合所以是乘法。
            //左边取任意偶数个同时右边取任意偶数个加上自身，一共奇数个。
            //注意包含左右各取0个。
            sum += arr[i] * (left_odd * right_odd + left_even * right_even);
        }
        return sum;

    }



}
