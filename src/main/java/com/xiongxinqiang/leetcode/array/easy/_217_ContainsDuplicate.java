package com.xiongxinqiang.leetcode.array.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author X.xq
 * @version 1.0
 * @date 2021/7/30 6:09 下午
 * <p>
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class _217_ContainsDuplicate {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));
    }


    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> hashTable = new HashSet();
        for (int x : nums) {
            if (hashTable.contains(x)) {
                return true;
            } else {
                hashTable.add(x);
            }
        }
        return false;
    }

}
