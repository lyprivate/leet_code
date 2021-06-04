package com.xiongxinqiang.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/4 4:38 下午
 *
 * 1748. 唯一元素的和
 *
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 *
 * 请你返回 nums 中唯一元素的 和 。
 *
 * 示例1：
 * 输入：nums = [1,2,3,2]
 * 输出：4
 * 解释：唯一元素为 [1,3] ，和为 4 。
 *
 * 示例2：
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：没有唯一元素，和为 0 。
 *
 * 示例3：
 * 输入：nums = [1,2,3,4,5]
 * 输出：15
 * 解释：唯一元素为 [1,2,3,4,5] ，和为 15 。
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 *
 * 链接：https://leetcode-cn.com/problems/sum-of-unique-elements/
 * 来源：力扣（LeetCode）
 *
 */
public class WeYiElementSum {



    public static void main(String[] args) {
        int[] nums = new int[]{10, 6, 9, 6, 9, 6, 8, 7};
//        int[] nums = new int[]{1, 2};
        System.out.println(sumOfUnique1(nums));
    }

    /**
     * 时间复杂度O(n * 2)
     * 哈希表
     *
     * @param nums
     * @return
     */
    public static int sumOfUnique(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> hashTable = new HashMap<>(nums.length);
        for (int num : nums) {
            hashTable.put(num, hashTable.getOrDefault(num, 0) + 1);
        }
        int ret = 0;
        for (Map.Entry<Integer, Integer> entry : hashTable.entrySet()) {
            if (entry.getValue() == 1) {
                ret += entry.getKey();
            }
        }
        return ret;
    }


    /**
     * 排序法 O(n)
     *
     * @param nums
     * @return
     */
    public static int sumOfUnique1(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        int ret = 0, i = 0;
        while (i < n) {
            if (n - 1 == i) {
                //最后一位,判断当前和上一个是否相同
                if (nums[i] != nums[i - 1]) {
                    ret += nums[i];
                }
                break;
            }
            //第一个元素，判断当前和下一个是否相同
            if (i == 0) {
                if (nums[i] != nums[i + 1]) {
                    ret += nums[i];
                }
            } else {
                //判断当前和 上、下是否相同
                if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                    ret += nums[i];
                }
            }

            ++i;
        }
        return ret;
    }


}
