package com.xiongxinqiang.leetcode.array;

import java.util.TreeSet;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/3 1:48 下午
 *
 * 414. 第三大的数
 *
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 *
 * 示例1：
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 *
 * 示例2：
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 *
 * 示例3：
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *
 * 进阶：
 * 你能设计一个时间复杂度 O(n) 的解决方案吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DiSanMaxNumber {



    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 5, 3, 5};
        System.out.println(thirdMax(nums));
    }

    /**
     * 使用三个变量记录第一大、第二大、第三大的值
     * 1ms  92.77%
     *
     * @param nums
     * @return
     */
    public static int thirdMax1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        long min = Long.MIN_VALUE;
        int one = nums[0];
        long two = min;
        long three = min;
        for (int i = 0; i < nums.length; i++) {
            //如果是重复的值跳过
            if (nums[i] == one || nums[i] == two || nums[i] == three) {
                continue;
            }
            //当前值大于最大的值
            if (nums[i] > one) {
                //顺位移动
                three = two;
                two = one;
                one = nums[i];
            } else if (nums[i] > two) {
                three = two;
                two = nums[i];
            } else if (nums[i] > three) {
                three = nums[i];
            }
        }
        if (three == min) {
            return one;
        }
        return (int) three;
    }


    /**
     * 5ms,30%
     * 利用TreeSet的数据结构(自动升序)
     * 维持set的长度始终不大于3
     *
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length < 3) {
            return Math.max(nums[0], nums[1]);
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.pollFirst();
            }
        }
        return set.size() >= 3 ? set.pollFirst() : set.pollLast();
    }

}
