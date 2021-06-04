package com.xiongxinqiang.leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/2 11:02 上午
 *
 * 1. 两数之和
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 示例2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *
 * 示例3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayTwoSum {


    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int target = 22;
        for (int i : twoSum1(arr, target)) {
            System.out.println(i);
        }
    }


    /**
     * 进阶
     * 方法二：哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> hashTable = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{hashTable.get(target - nums[i]), i};
            }
            hashTable.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }


    /**
     * 方法1：暴力
     * 空间复杂度O(1),只用了常量级别
     * 时间复杂度O(n^2) 需要遍历n的2次方，效率极低
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
                j++;
            }
        }
        return new int[]{-1, -1};
    }


}
