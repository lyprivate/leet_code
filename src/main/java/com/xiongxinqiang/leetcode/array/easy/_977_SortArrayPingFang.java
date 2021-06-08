package com.xiongxinqiang.leetcode.array.easy;

import java.util.Arrays;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/8 11:43 上午
 *
 * 977. 有序数组的平方
 *
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 示例1：
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 *
 * 示例2：
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 * 提示：
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 * 进阶：
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _977_SortArrayPingFang {

    public static void main(String[] args) {
        int[] arr = new int[]{-4, -1, 0, 3, 10};
        for (int i : sortedSquares2(arr)) {
            System.out.println(i);
        }
    }


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {
        //遍历过程中排序
        int len = nums.length;
        int[] ret = new int[len];
        int i = 0, j = len - 1, pos = len - 1;
        while (i <= j) {
            //值大的放后面
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                //指针i的值 大于指针j的值
                ret[pos] = nums[i] * nums[i];
                i++;
            } else {
                ret[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return ret;
    }


    /**
     * 时间复杂度O(2/n log n)
     * 执行用时：3 ms, 在所有 Java 提交中击败了24.98%的用户
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares1(int[] nums) {
        int[] ret = new int[nums.length];
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            ret[i] = nums[i] * nums[i];
            if (i == j) {
                continue;
            }
            ret[j] = nums[j] * nums[j];
        }
        Arrays.sort(ret);
        return ret;
    }

    /**
     * 时间复杂度(On log n)
     * 执行用时：4 ms, 在所有 Java 提交中击败了 11.64% 的用户
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[i] * nums[i];
        }
        Arrays.sort(ret);
        return ret;
    }

}
