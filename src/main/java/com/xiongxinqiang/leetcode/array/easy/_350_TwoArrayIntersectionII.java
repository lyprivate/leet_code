package com.xiongxinqiang.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author X.xq
 * @version 1.0
 * @date 2021/12/9 10:21 上午
 *
 * 350. 两个数组的交集 II
 *
 * 给你两个整数数组nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 *
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *
 * 提示：
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * 进阶：
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果nums1的大小比nums2 小，哪种方法更优？
 * 如果nums2的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _350_TwoArrayIntersectionII {




    /**
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     * <p>
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     */
    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        for (int i : intersect1(nums1, nums2)) {
            System.out.println(i);
        }
    }


    /**
     * 方法二. 排序+双指针
     * 如果两个数组是有序的，则可以使用双指针的方法得到两个数组的交集。
     * 首先对两个数组进行排序，然后使用两个指针遍历两个数组。
     * 初始时，两个指针分别指向两个数组的头部。每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，
     * 则将指向较小数字的指针右移一位，如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。当至少有一个指针超出数组范围时，遍历结束。
     *
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int idx1 = 0, idx2 = 0,idx = 0;
        int[] ret = new int[Math.min(length1, length2)];
        while (idx1 < length1 && idx2 < length2) {
            if (nums1[idx1] < nums2[idx2]) {
                ++idx1;
            } else if (nums1[idx1] > nums2[idx2]) {
                ++idx2;
            }else {
                ret[idx++] = nums1[idx1];
                ++idx1;
                ++idx2;
            }
        }
        return Arrays.copyOfRange(ret, 0, idx);
    }

    /**
     * 一. 哈希表
     * 由于同一个数字在两个数组中都可能出现多次，因此需要用哈希表存储每个数字出现的次数。对于一个数字，其在交集中出现的次数等于该数字在两个数组中出现次数的最小值。
     * 首先遍历第一个数组，并在哈希表中记录第一个数组中的每个数字以及对应出现的次数，然后遍历第二个数组，
     * 对于第二个数组中的每个数字，如果在哈希表中存在这个数字，则将该数字添加到答案，并减少哈希表中该数字出现的次数。
     * 为了降低空间复杂度，首先遍历较短的数组并在哈希表中记录每个数字以及对应出现的次数，然后遍历较长的数组得到交集。
     *
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> table = new HashMap<>(16);
        for (int i : nums1) {
            table.put(i, table.getOrDefault(i, 0) + 1);
        }
        int[] ret = new int[nums1.length];
        int idx = 0;
        for (int i : nums2) {
            if (table.containsKey(i)) {
                ret[idx++] = i;
                int count = table.get(i) - 1;
                if (count > 0) {
                    table.put(i, count);
                } else {
                    table.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(ret, 0, idx);
    }



}
