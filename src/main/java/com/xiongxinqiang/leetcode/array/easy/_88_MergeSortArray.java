package com.xiongxinqiang.leetcode.array.easy;

import java.util.Arrays;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/7/6 10:28 上午
 *
 * 88. 合并两个有序数组
 * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
 *
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 示例 2：
 *
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 *
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[i] <= 109
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _88_MergeSortArray {


    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 5, 6, 0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3};
        int m = 3, n = 3;
        merge1(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.println(i);
        }
    }


    /**
     * 方法2
     * 后续遍历，双指针解法
     * 时间复杂度：O(m+n)
     * 空间复杂度：O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int posM = m - 1, posN = n - 1;
        int possTail = m + n - 1;
        int cur;
        while (posM >= 0 || posN >= 0) {
            if (posM == -1) {
                cur = nums2[posN--];
            } else if (posN == -1) {
                cur = nums1[posM--];
            } else if (nums1[posM] > nums2[posN]) {
                cur = nums1[posM--];
            } else {
                cur = nums2[posN--];
            }
            nums1[possTail--] = cur;
        }
    }

    //方法1：先合并，在排序
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }


}
