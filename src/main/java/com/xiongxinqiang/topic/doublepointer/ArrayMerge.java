package com.xiongxinqiang.topic.doublepointer;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2020/11/27 3:47 下午
 */

import java.util.Arrays;

/**
 * 力扣编号：88
 */
public class ArrayMerge {




    public static void main(String[] args) {
        int[] var1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] var2 = new int[]{2, 5, 6};

        merge3(var1, 3, var2, 3);
    }

    /**
     * 最朴素的解法就是将两个数组合并之后再排序。该算法只需要一行(Java是2行)，
     * 时间复杂度较差，为O((n + m)\log(n + m))O((n+m)log(n+m))。这是由于这种方法没有利用两个数组本身已经有序这一点。
     * 熊某评论：新手入门级(我也能想到)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        for (int i : nums1) {
            System.out.println("i = " + i);
        }
    }

    /**
     * 方法二 : 双指针 / 从前往后
     * 直觉
     * <p>
     * 一般而言，对于有序数组可以通过 双指针法 达到O(n + m)O(n+m)的时间复杂度。
     * <p>
     * 最直接的算法实现是将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
     * <p>
     * 由于 nums1 是用于输出的数组，需要将nums1中的前m个元素放在其他地方，也就需要 O(m)O(m) 的空间复杂度。
     * <p>
     * 熊某评论：（看得懂，想不到）
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);

        for (int i : nums1) {
            System.out.println("i = " + i);
        }
    }


    /**
     * 方法二已经取得了最优的时间复杂度O(n + m)O(n+m)，但需要使用额外空间。这是由于在从头改变nums1的值时，需要把nums1中的元素存放在其他位置。
     * 熊某评论：（害）
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);

        for (int i : nums1) {
            System.out.println("i = " + i);
        }
    }


}
