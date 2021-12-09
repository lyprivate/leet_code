package com.xiongxinqiang.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author X.xq
 * @version 1.0
 * @date 2021/10/13 4:52 下午
 * <p>
 * 349. 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * <p>
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _349_TwoArrayIntersection {


    /**
     * 349
     * 2个数组，计算交集
     * 示例1
     * nums1 = [1,2,2,1],nums2 = [2,2]
     * 输出[2]
     * <p>
     * 示例2
     * nums1 = [4,9,5],nums2 = [9,4,9,8,4]
     * 输出[9,4]
     * <p>
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     */

    public static void main(String[] args) {
        //[4,9,5]
        //[9,4,9,8,4]
        int[] nums1 = new int[]{4, 9, 5}, nums2 = new int[]{9, 4, 9, 8, 4};
        for (int i : intersection1(nums1, nums2)) {
            System.out.println(i);
        }
    }

    /**
     * 排序，双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int left = 0, right = 0, pos = 0;
        int len1 = nums1.length, len2 = nums2.length;
        int[] ans = new int[len1 + len2];
        while (left <= len1 - 1 && right <= len2 - 1) {
            if (nums1[left] == nums2[right]) {
                if (pos == 0 || nums1[left] != ans[pos - 1]) {
                    ans[pos++] = nums1[left];
                }
                ++left;
                ++right;
            } else if (nums1[left] < nums2[right]) {
                ++left;
            } else if (nums1[left] > nums2[right]) {
                ++right;
            }
        }
        return Arrays.copyOfRange(ans, 0, pos);
    }


    /**
     * 哈希表,set记录
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hashTable = new HashSet<>(), results = new HashSet<>();
        for (int i : nums1) {
            hashTable.add(i);
        }
        for (int i : nums2) {
            if (hashTable.contains(i)) {
                results.add(i);
            }
        }
        int[] ret = new int[results.size()];
        int i = 0;
        for (int integer : results) {
            ret[i] = integer;
            ++i;
        }
        return ret;
    }


}
