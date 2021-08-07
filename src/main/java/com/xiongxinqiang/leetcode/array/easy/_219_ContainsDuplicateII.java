package com.xiongxinqiang.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author X.xq
 * @version 1.0
 * @date 2021/8/7 9:05 下午
 * <p>
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * <p>
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 */
public class _219_ContainsDuplicateII {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(nums, 1));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> table = new HashMap(nums.length);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (table.containsKey(nums[i])) {
                if (Math.abs(i - table.get(nums[i])) <= k) {
                    return true;
                }
            }
            table.put(nums[i], i);
        }
        return false;
    }


}
