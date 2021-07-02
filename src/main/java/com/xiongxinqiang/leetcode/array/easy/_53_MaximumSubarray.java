package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/7/1 5:00 下午
 *
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _53_MaximumSubarray {


    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray1(nums));

    }

    public static int maxSubArray1(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }


    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int max = nums[0], sum = 0;
        for (int num : nums) {
            //上一次相加的结果大于0，则继续相加
            if (sum > 0) {
                sum += num;
            } else {
                //小于0则赋值当前结果
                sum = num;
            }
            //相加完之后的值大于max
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
