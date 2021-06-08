package com.xiongxinqiang.leetcode.array.easy;

/**
 * @author xiongxinqiang
 * @version 1.0
 * @date 2021/6/2 9:53 上午
 *
 * 167. 两数之和 II - 输入有序数组
 *
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 *
 * 示例1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * 示例2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 *
 * 示例3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 *
 *
 * 提示：
 * 2 <= numbers.length <= 3 * 104
 * -1000 <= numbers[i] <= 1000
 * numbers 按 递增顺序 排列
 * -1000 <= target <= 1000
 * 仅存在一个有效答案
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _167ii_SortArrayTwoSum {


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 10;
        for (int i : twoSum1(arr, target)) {
            System.out.println(i);
        }
    }

    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        /*
         * 分别定义2个指针对应索引第一位和最后一位
         * 相加后判断：
         *          1. 大于：如果大于目标值则右指针向左偏移(因为数组升序数组)
         *          2. 小于：小于目标值则左指针向右偏移
         *          3. 等于 直接返回
         * 举例：[2,7,11,12],target=18
         * 第一次遍历：index1=2,index2=12 相加后小于目标值，则index1向右偏移
         * 第二次遍历：index1=7,index2=12 相加大于目标值,则index2向左偏移
         * 第三次遍历：index1=7,index2=11 相等返回
         */
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            int val = numbers[left] + numbers[right];
            if (val == target) {
                return new int[]{left + 1, right + 1};
            } else if (val > target) {
                --right;
            } else {
                ++left;
            }
        }
        return new int[]{-1, -1};
    }


    /**
     * 官方：二分
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }




}
