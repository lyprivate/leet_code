package com.xiongxinqiang.leetcode.array.easy;

import java.util.Arrays;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/7/13 9:20 上午
 *
 * 136. 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 * 输入: [2,2,1]
 * 输出: 1
 *
 * 示例 2:
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class _136_SingleNumber {


    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber1(nums));
    }

    public static int singleNumber1(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }


    /**
     * 排序、遍历
     * 达不到要求，线性时间复杂度
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            } else if (i == len - 1) {
                if (nums[i] != nums[i - 1]) {
                    return nums[i];
                }
            } else {
                if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
        }
        return -1;
    }

}
